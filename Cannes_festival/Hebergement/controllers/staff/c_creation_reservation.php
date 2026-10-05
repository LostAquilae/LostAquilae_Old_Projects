<?php

if(empty($_GET['id']))
  header('Location: index.php?page=404');

$_SESSION['reservID'] = $_GET['id'];

require_once(PATH_MODELS.'HebergementDAO.php');

$hebergementDAO = new HebergementDAO(DEBUG);
$services = $hebergementDAO->getServices();

require_once(PATH_VIEWS_STAFF.'creation_reservation.php');
 ?>
