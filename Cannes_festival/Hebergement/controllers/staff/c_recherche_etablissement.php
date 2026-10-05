<?php

require_once(PATH_MODELS.'HebergementDAO.php');

if(empty($_SESSION['reservID']))
  header('Location: index.php?page=404');

if(!isset($_POST['dateDeb']) || $_POST['dateDeb'] == 0 || !isset($_POST['personnes']))
  header('Location: index.php?page=creation_reservation&id='.$_SESSION['reservID']);

$_SESSION['reservPersonnes'] = $_POST['personnes'];
$_SESSION['reservDateDebut'] = $_POST['dateDeb'];
if($_POST['dateFin'] != 0)
  $_SESSION['reservDateFin'] = $_POST['dateFin'];
else
  $_SESSION['reservDateFin'] = $_POST['dateDeb'];

$hebergementDAO = new HebergementDAO(DEBUG);
$services = array();
foreach($hebergementDAO->getServices() as $service)
{
  if(isset($_POST[$service]))
    $services[] = $service;
}

require_once(PATH_MODELS.'VIPDAO.php');
$vipDAO = new VIPDAO(DEBUG);
$vip = $vipDAO->getVIP($_SESSION['reservID']);

$heberRecom = $hebergementDAO->getHeberRecom($_POST['dateDeb'], $_SESSION['reservDateFin'], $services, $_POST['personnes'], $vip);

require_once(PATH_VIEWS_STAFF.'recherche_etablissement.php');
 ?>
