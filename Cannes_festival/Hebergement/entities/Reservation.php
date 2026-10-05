<?php

class Reservation
{
  private $_vip = null;
  private $_hebergement = null;
  private $_jourDebut = null;
  private $_jourFin = null;
  private $_nbPersonne = null;

  public function __construct($vip, $hebergement, $jourDebut, $jourFin, $nbPersonne)
  {
    $this->_vip = $vip;
    $this->_hebergement = $hebergement;
    $this->_jourDebut = $jourDebut;
    $this->_jourFin = $jourFin;
    $this->_nbPersonne = $nbPersonne;
  }

  public function getVip()
  { return $this->_vip; }

  public function getHebergement()
  { return $this->_hebergement; }

  public function getJourDebut()
  { return $this->_jourDebut; }

  public function getJourFin()
  { return $this->_jourFin; }

  public function getNbPersonne()
  { return $this->_nbPersonne; }
}

 ?>
