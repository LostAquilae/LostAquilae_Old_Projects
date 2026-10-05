<?php

class Film
{
  private $_id = null;
  private $_titre = null;
  private $_duree = null;
  private $_pays = null;
  private $_idRealisateur = null;

  public function __construct($id, $titre, $duree, $pays, $idRealisateur)
  {
    $this->_id = $id;
    $this->_titre = $titre;
    $this->_duree = $duree;
    $this->_pays = $pays;
    $this->_idRealisateur = $idRealisateur;
  }

  public function getId()
  { return $this->_id; }

  public function getTitre()
  { return $this->_titre; }

  public function getDuree()
  { return $this->_duree; }

  public function getPays()
  { return $this->_pays; }

  public function getIdRealisateur()
  { return $this->_idRealisateur; }
}
 ?>
