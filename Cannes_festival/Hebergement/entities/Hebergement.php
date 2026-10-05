<?php

class Hebergement
{
  private $_id = null;
  private $_nom = null;
  private $_type = null;
  private $_servicesSup = null;
  private $_adresse = null;
  private $_services = array();
  private $_jour = null;
  private $_place = null;

  public function __construct($id, $nom, $adresse)
  {
    $this->_id = $id;
    $this->_nom = $nom;
    $this->_adresse = $adresse;
  }

  public function getId()
  { return $this->_id; }

  public function getNom()
  { return $this->_nom; }

  public function setNom($nom)
  { $this->_nom = $nom; }

  public function getType()
  { return $this->_type; }

  public function setType($type)
  { $this->_type = $type; }

  public function getServicesSup()
  { return $this->_servicesSup; }

  public function setServicesSup($servicesSup)
  { $this->_servicesSup = $servicesSup; }

  public function getAdresse()
  { return $this->_adresse; }

  public function setAdresse($adresse)
  { $this->_adresse = $adresse; }

  public function getServices()
  { return $this->_services; }

  public function setServices($services)
  { $this->_services = $services; }

  public function getJour()
  { return $this->_jour; }

  public function setJour($jour)
  { $this->_jour = $jour; }

  public function getPlace()
  { return $this->_place; }

  public function setPlace($place)
  { $this->_place = $place; }
}

?>
