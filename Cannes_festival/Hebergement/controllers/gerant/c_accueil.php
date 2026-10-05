<?php

require_once(PATH_MODELS.'HebergementDAO.php');

$hebergementDAO = new HebergementDAO(DEBUG);

if(isset($_GET['idsuppr']))
{
  if($hebergementDAO->deleteHebergement($_GET['idsuppr']))
  {
    $alert['classAlert'] = 'success';
    $alert['messageAlert'] = GERANT_SUCCESS_SUPPRESSION;
  }
  else
  {
    $alert['messageAlert'] = GERANT_ERROR_SUPPRESSION;
  }
}

$hebergements = $hebergementDAO->getHebergements($_SESSION['gerant']);

require_once(PATH_VIEWS_GERANT.$page.'.php');

?>
