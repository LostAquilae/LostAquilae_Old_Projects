<?php

require_once(PATH_MODELS.'DAO.php');
require_once(PATH_ENTITY.'Competition.php');

class CompetitionDAO extends DAO
{
  public function getCompetitions()
  {
    $res = $this->queryAll('SELECT * FROM Competition');

    if($res)
    {
      foreach($res as $line)
      {
        $competitions[] = new Competition($line['id'], $line['libelle']);
      }
      return $competitions;
    }
    else return array();
  }

  public function getCompetition($id)
  {
    $res = $this->queryRow('SELECT * FROM Competition WHERE id = ?', array($id));

    if($res)
    {
      return new Competition($res['id'], $res['libelle']);
    }
    else return null;
  }
}

 ?>
