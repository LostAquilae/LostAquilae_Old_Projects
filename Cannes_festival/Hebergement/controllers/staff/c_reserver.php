<?php

if(empty($_SESSION['reservID']) || empty($_SESSION['reservPersonnes']) || empty($_GET['idHebergement']) || empty($_SESSION['reservDateDebut']) || empty($_SESSION['reservDateFin']))
  header('Location: index.php?page=404');

require_once(PATH_MODELS.'ReservationDAO.php');
$reservationDAO = new ReservationDAO(DEBUG);

if($reservationDAO->createReservation($_SESSION['reservID'], $_GET['idHebergement'], $_SESSION['reservDateDebut'], $_SESSION['reservDateFin'], $_SESSION['reservPersonnes']))
  header('Location: index.php?page=liste_reservation&created');
else
  header('Location: index.php?page=liste_reservation&!created');

 ?>
