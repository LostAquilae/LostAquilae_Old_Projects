<?php

require_once(PATH_MODELS.'UtilisateurDAO.php');
require_once(PATH_ENTITY.'Utilisateur.php');

$utilisateurDAO = new UtilisateurDAO(DEBUG);

if(isset($_POST['login']))
{
  if(isset($_POST['password']))
  {
    $login = htmlspecialchars($_POST['login']);
    $password = htmlspecialchars($_POST['password']);

    $utilisateur = $utilisateurDAO->getUser($login);
    if(isset($utilisateur))
    {
      if(password_verify($_POST['password'], $utilisateur->getPassword()))
      {
        $alert['classAlert'] = 'success';
        $alert['messageAlert'] = CONNECTED_CONNEXION;

        $_SESSION['logged'] = 1;
        if($utilisateur->estGerant())
        {
          $_SESSION['gerant'] = $utilisateur->getId();
          $_SESSION['staff'] = 0;
        }
        else
        {
          $_SESSION['gerant'] = 0;
          $_SESSION['staff'] = $utilisateur->getId();
        }
      }
      else
      {
        $alert['messageAlert'] = NO_PASSWORD_ALERT_CONNEXION;
      }
    }
    else
    {
      $alert['messageAlert'] = NO_ID_ALERT_CONNEXION;
    }
  }
  else
  {
    $alert['messageAlert'] = NO_PASSWORD_ALERT_CONNEXION;
  }
}

require_once(PATH_VIEWS.$page.'.php');

 ?>
