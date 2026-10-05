<?php

class Utilisateur
{
  private $_id = null;
  private $_login = null;
  private $_password = null;
  private $_estGerant = null;

	public function __construct($id, $login, $password, $estGerant)
  {
    $this->_id = $id;
    $this->_login = $login;
    $this->_password = $password;
    $this->_estGerant = $estGerant;
  }

  public function getId()
  { return $this->_id; }

  public function getLogin()
  { return $this->_login; }

  public function getPassword()
  { return $this->_password; }

  public function estGerant()
  { return $this->_estGerant == 1; }
}

?>
