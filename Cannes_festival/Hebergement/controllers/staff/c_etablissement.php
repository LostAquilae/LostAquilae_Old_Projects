<?php

if(empty($_SESSION['reservID']) || empty($_GET['id']) || empty($_SESSION['reservPersonnes']) || empty($_SESSION['reservDateDebut']) || empty($_SESSION['reservDateFin']))
  header('Location: index.php?page=404');

require_once(PATH_MODELS.'HebergementDAO.php');

$hebergementDAO = new HebergementDAO(DEBUG);
$hebergement = $hebergementDAO->getHebergementDate($_GET['id'], $_SESSION['reservDateDebut'], $_SESSION['reservDateFin']);

if($hebergement->getServicesSup() != "")
  $services = array_merge($hebergement->getServices(), explode(',', $hebergement->getServicesSup()));
else
  $services = $hebergement->getServices();

require_once(PATH_VIEWS_STAFF.'etablissement.php');
 ?>
