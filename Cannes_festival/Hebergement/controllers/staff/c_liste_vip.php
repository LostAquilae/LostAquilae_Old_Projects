<?php

require_once(PATH_MODELS.'VIPDAO.php');

$vipDAO = new VIPDAO(DEBUG);

if(isset($_GET['supprId']))
{
  if($vipDAO->SupprVIP($_GET['supprId']))
  {
    $alert['classAlert'] = 'success';
    $alert['messageAlert'] = STAFF_LISTE_VIP_SUPPRIMER_SUCCESS;
  }
  else
  {
    $alert['messageAlert'] = STAFF_LISTE_VIP_SUPPRIMER_ERROR;
  }
}

$vips = $vipDAO->getVIPs();

require_once(PATH_VIEWS_STAFF.'liste_vip.php');
?>
