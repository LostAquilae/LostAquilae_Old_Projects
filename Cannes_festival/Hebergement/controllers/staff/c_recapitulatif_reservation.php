<?php

require_once(PATH_MODELS.'ReservationDAO.php');

$reservationDAO = new ReservationDAO(DEBUG);
$reservation = $reservationDAO->getReservation($_GET['vip'], $_GET['hebergement']);
$vip = $reservation->getVip();
$hebergement = $reservation->getHebergement();
if($vip->getFilm())
  $reservCollegues = $reservationDAO->getColleguesReservations($reservation);

require_once(PATH_VIEWS_STAFF.'recapitulatif_reservation.php');
?>
