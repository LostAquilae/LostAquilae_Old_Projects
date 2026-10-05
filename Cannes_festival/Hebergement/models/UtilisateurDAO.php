<?php
require_once(PATH_MODELS.'DAO.php');
require_once(PATH_ENTITY.'Utilisateur.php');

class UtilisateurDAO extends DAO
{
	public function getUser($login)
	{
		$res = $this->queryRow('SELECT * FROM Utilisateur WHERE login = ?', array($login));
		if($res)
		{
			return new Utilisateur($res['id'], $res['login'], $res['password'], $res['estGerant']);
		}
		else return null;
	}
}
?>
