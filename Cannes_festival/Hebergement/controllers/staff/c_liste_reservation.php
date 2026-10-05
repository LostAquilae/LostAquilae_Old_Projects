<?php

require_once(PATH_MODELS.'ReservationDAO.php');

$reservationDAO = new ReservationDAO(DEBUG);

if(isset($_GET['supprimer']) && isset($_GET['vip']) && isset($_GET['hebergement']))
{
  $reserv = $reservationDAO->getReservation($_GET['vip'], $_GET['hebergement']);

  if($reservationDAO->deleteReservation($reserv))
  {
    $alert['classAlert'] = 'success';
    $alert['messageAlert'] = STAFF_LISTE_SUPPRIMER_SUCCESS;
  }
  else
  {
    $alert['messageAlert'] = STAFF_LISTE_SUPPRIMER_ERROR;
  }
}

if(isset($_GET['created']))
{
  $alert['classAlert'] = 'success';
  $alert['messageAlert'] = STAFF_LISTE_CREATED_SUCCESS;
}
else if(isset($_GET['!created']))
{
  $alert['messageAlert'] = STAFF_LISTE_CREATED_ERROR;
}

$reservList = $reservationDAO->getReservations();

require_once(PATH_VIEWS_STAFF.'liste_reservation.php');
 ?>
