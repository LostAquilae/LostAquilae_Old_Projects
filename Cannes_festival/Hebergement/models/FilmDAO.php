<?php
require_once(PATH_MODELS.'DAO.php');
require_once(PATH_ENTITY.'Film.php');

class FilmDAO extends DAO
{
  public function getFilm($id)
  {
    $res = $this->queryRow('SELECT * FROM Film WHERE id = ?', array($id));

    if($res)
    {
      return new Film($res['id'], $res['titre'], $res['duree'], $res['pays'], $res['idRealisateur']);
    }
    else return null;
  }

  public function getFilms()
  {
    $res = $this->queryAll('SELECT * FROM Film');

    if($res)
    {
      foreach($res as $line)
      {
        $films[] = new Film($line['id'], $line['titre'], $line['duree'], $line['pays'], $line['idRealisateur']);
      }
      return $films;
    }
    else return array();
  }
}

?>
