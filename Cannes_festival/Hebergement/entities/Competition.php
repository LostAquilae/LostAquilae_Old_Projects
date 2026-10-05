<?php

class Competition
{
  private $_id = null;
  private $_libelle = null;

  public function __construct($id, $libelle)
  {
    $this->_id = $id;
    $this->_libelle = $libelle;
  }

  public function getId()
  { return $this->_id; }

  public function getLibelle()
  { return $this->_libelle; }
}

 ?>
