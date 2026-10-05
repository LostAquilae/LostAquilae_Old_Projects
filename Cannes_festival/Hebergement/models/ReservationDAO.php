<?php

require_once(PATH_MODELS.'DAO.php');
require_once(PATH_ENTITY.'Reservation.php');
require_once(PATH_MODELS.'VIPDAO.php');
require_once(PATH_MODELS.'HebergementDAO.php');

class ReservationDAO extends DAO
{
  public function getReservations()
  {
    $res = $this->queryAll('SELECT * FROM Reservation AS R, VIP AS V WHERE R.idVip = V.id ORDER BY V.idFilm IS NULL, V.idCompetition IS NULL, V.nom, V.prenom');

    if($res)
    {
      foreach($res as $line)
      {
        $vipDAO = new VIPDAO(DEBUG);
        $vip = $vipDAO->getVip($line['idVip']);

        $hebergementDAO = new HebergementDAO(DEBUG);
        $hebergement = $hebergementDAO->getHebergement($line['idHebergement']);

        $reservList[] = new Reservation($vip, $hebergement, $line['jourDebut'], $line['jourFin'], $line['nbPersonne']);
      }
      return $reservList;
    }
    else return array();
  }

  public function getReservation($idVip, $idHebergement)
  {
    $res = $this->queryRow('SELECT * FROM Reservation WHERE idVip = ? AND idHebergement = ?', array($idVip, $idHebergement));

    if($res)
    {
      $vipDAO = new VIPDAO(DEBUG);
      $vip = $vipDAO->getVip($res['idVip']);

      $hebergementDAO = new HebergementDAO(DEBUG);
      $hebergement = $hebergementDAO->getHebergement($res['idHebergement']);

      return new Reservation($vip, $hebergement, $res['jourDebut'], $res['jourFin'], $res['nbPersonne']);
    }
    else return null;
  }

  public function createReservation($idVip, $idHebergement, $dateDeb, $dateFin, $nbPersonne)
  {
    if(!$this->QueryBdd('UPDATE Places SET nbPlace = nbPlace - ? WHERE idHebergement = ? AND numJour <= ? AND numJour >= ?',
    array($nbPersonne, $idHebergement, $dateFin, $dateDeb)))
      return false;

    if(!$this->QueryBdd('INSERT INTO Reservation (idVip, idHebergement, jourDebut, jourFin, nbPersonne) VALUES ( ? , ? , ? , ? , ? )',
    array($idVip, $idHebergement, $dateDeb, $dateFin, $nbPersonne)))
      return false;

    return true;
  }

  public function deleteReservation($reserv)
  {
    if(!$this->queryBdd('UPDATE Places SET nbPlace = nbPlace + ? WHERE idHebergement = ? AND numJour >= ? AND numJour <= ?',
    array($reserv->getNbPersonne(), $reserv->getHebergement()->getId(), $reserv->getJourDebut(), $reserv->getJourFin())))
      return false;

    if(!$this->queryBdd('DELETE FROM Reservation WHERE idVip = ? AND idHebergement = ?',
    array($reserv->getVip()->getId(), $reserv->getHebergement()->getId())))
      return false;

    return true;
  }

  public function getColleguesReservations($reserv)
  {
    $res = $this->queryAll('SELECT idVip FROM vip as V, reservation as R WHERE R.idHebergement = ? and V.idFilm = ? AND R.idVip = V.id AND V.id <> ?',
            array($reserv->getHebergement()->getId(), $reserv->getVip()->getFilm()->getId(), $reserv->getVip()->getId()));

    if($res)
    {
      foreach($res as $vips)
      {
        $reservations[] = $this->getReservation($vips['idVip'], $reserv->getHebergement()->getId());
      }
      return $reservations;
    }
    else return array();
  }
}

 ?>
