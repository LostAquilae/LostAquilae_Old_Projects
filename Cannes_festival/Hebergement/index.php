<?php

// Initialisation des paramètres du site
require_once('./config/configuration.php');
require_once(PATH_TEXTES.LANG.'.php');

session_name('p1711637');
session_start();

//vérification de la page demandée
if(!isset($_SESSION['logged']))
{
  $_SESSION['logged'] = 0;
  $_SESSION['gerant'] = 0;
  $_SESSION['staff'] = 0;
}

$path_controller = PATH_CONTROLLERS;

if($_SESSION['logged'] == 0)
  $page = 'connexion';
else
{
  if(isset($_GET['page']))
  {
    $page = htmlspecialchars($_GET['page']);
  }
  else
  	$page = 'accueil';

  if($page != 'connexion' && $page != 'deconnexion')
  {
    if($_SESSION['gerant'] != 0)
      $path_controller = PATH_CONTROLLERS_GERANT;
    else if($_SESSION['staff'] != 0)
      $path_controller = PATH_CONTROLLERS_STAFF;
  }

  if(!is_file($path_controller.$page.'.php'))
  {
    $path_controller = PATH_CONTROLLERS;
    $page = '404';
  }
}

require_once($path_controller.$page.'.php');

?>
