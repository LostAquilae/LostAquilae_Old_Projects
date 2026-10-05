<?php

class VIP
{
  private $_id = null;
  private $_nom = null;
  private $_prenom = null;
  private $_competition = null;
  private $_film = null;

  public function __construct($id, $nom, $prenom, $competition, $film)
  {
    $this->_id = $id;
    $this->_nom = $nom;
    $this->_prenom = $prenom;
    $this->_competition = $competition;
    $this->_film = $film;
  }

  public function getId()
  { return $this->_id; }

  public function getNom()
  { return $this->_nom; }

  public function getPrenom()
  { return $this->_prenom; }

  public function getCompetition()
  { return $this->_competition; }

  public function setCompetition($competition)
  { $this->_competition = $competition; }

  public function getFilm()
  { return $this->_film; }

  public function setFilm($film)
  { $this->_film = $film; }
}

?>
