<?php

require_once(PATH_MODELS.'VIPDAO.php');

$vipDAO = new VIPDAO(DEBUG);
$vipList = $vipDAO->getVIPsNoReserv();

require_once(PATH_VIEWS_STAFF.'ajouter_reservation.php');
 ?>
