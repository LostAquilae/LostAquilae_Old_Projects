<?php
require_once(PATH_MODELS.'DAO.php');
require_once(PATH_ENTITY.'VIP.php');

class VIPDAO extends DAO
{
  public function getVIPsNoReserv()
  {
    $res = $this->queryAll('SELECT idVip FROM Reservation');
    if($res == null)
      $sql = 'SELECT V.id, V.nom, V.prenom, V.idFilm, V.idCompetition FROM VIP AS V
              ORDER BY V.idFilm IS NULL, V.nom, V.prenom';
    else
      $sql = 'SELECT V.id, V.nom, V.prenom, V.idFilm, V.idCompetition FROM VIP AS V, Competition AS C, Reservation AS R
              WHERE V.id NOT IN (SELECT idVip FROM Reservation)
              GROUP BY V.id, V.nom, V.prenom, V.idFilm ORDER BY V.idFilm IS NULL, V.nom, V.prenom';

    $res = $this->queryAll($sql);

		if($res)
		{
      require_once(PATH_MODELS.'FilmDAO.php');
      $filmDAO = new FilmDAO(DEBUG);

      require_once(PATH_MODELS.'CompetitionDAO.php');
      $competitionDAO = new CompetitionDAO(DEBUG);

      foreach($res as $line)
      {
        $film = $filmDAO->getFilm($line['idFilm']);
        $competition = $competitionDAO->getCompetition($line['idCompetition']);

        $vipList[] = new VIP($line['id'], $line['nom'], $line['prenom'], $competition, $film);
      }
      return $vipList;
		}
		else return array();
  }

  public function getVIP($idVip)
  {
    $res = $this->queryRow('SELECT V.id, V.nom, V.prenom, V.idFilm, V.idCompetition FROM VIP AS V WHERE V.id = ?', array($idVip));

    if($res)
    {
      require_once(PATH_MODELS.'FilmDAO.php');
      $filmDAO = new FilmDAO(DEBUG);

      require_once(PATH_MODELS.'CompetitionDAO.php');
      $competitionDAO = new CompetitionDAO(DEBUG);

      $film = $filmDAO->getFilm($res['idFilm']);
      $competition = $competitionDAO->getCompetition($res['idCompetition']);

      return new VIP($res['id'], $res['nom'], $res['prenom'], $competition, $film);
    }
    else return null;
  }

  public function getVIPs()
  {
    $res = $this->queryAll('SELECT * FROM VIP');
    if($res)
    {
      require_once(PATH_MODELS.'FilmDAO.php');
      $filmDAO = new FilmDAO(DEBUG);

      require_once(PATH_MODELS.'CompetitionDAO.php');
      $competitionDAO = new CompetitionDAO(DEBUG);
      foreach($res as $line)
      {
        $film = $filmDAO->getFilm($line['idFilm']);
        $competition = $competitionDAO->getCompetition($line['idCompetition']);
        $VIPs[] = new VIP($line['id'], $line['nom'], $line['prenom'], $competition, $film);
      }
      return $VIPs;
    }
    else return array();
  }

  public function SupprVIP($id)
  {
    if(!$this->queryBdd('UPDATE VIP SET idFilm = null WHERE id = ?', array($id)))
      return false;
    $res = $this->queryBdd('DELETE FROM VIP WHERE id = ?', array($id));
    return $res;
  }

  public function createVIP($nom, $prenom, $idCompetition, $idFilm)
  {
    if(!$this->queryBdd('INSERT INTO VIP (nom, prenom, idCompetition, idFilm) VALUES( ? , ? , ? , ? )', array($nom, $prenom, $idCompetition, $idFilm)))
      return 0;
    return $this->insertId();
  }

  public function updateVIP($id, $nom, $prenom, $idCompetition, $idFilm)
  {
    $res = $this->queryBdd('UPDATE vip SET nom = ?, prenom = ?, idCompetition = ?, idFilm = ? WHERE id = ?', array($nom, $prenom, $idCompetition, $idFilm, $id));
    return $res;
  }
}

?>
