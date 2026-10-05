<?php

require_once(PATH_MODELS.'HebergementDAO.php');
$hebergementDAO = new HebergementDAO(DEBUG);
$types = $hebergementDAO->getTypes();
$services = $hebergementDAO->getServices();

$jour = 1;
if(isset($_GET['jour']))
{
  if($_GET['jour'] > 31)
  {
    $jour = 31;
  }
  else if($_GET['jour'] < 1)
  {
    $jour = 1;
  }
  else
  {
    $jour = $_GET['jour'];
  }
}

if(isset($_GET['id']))
{
  if(isset($_GET['jour']))
  {
    $hebergement = $hebergementDAO->getHebergement($_GET['id'], $jour);
  }
  else
  {
    $hebergement = $hebergementDAO->getHebergement($_GET['id']);
  }
}

if(isset($_POST['nomEtab']))
{
  if($_POST['nomEtab'] == "" || $_POST['adresse'] == "" || (isset($_GET['id']) && $_POST['nbPlaces'] == ""))
  {
    $alert['messageAlert'] = GERANT_ERREUR_REMPLISSAGE;
  }
  else
  {
    if(!isset($_GET['id']))
      $hebergement = new Hebergement(0, $_POST['nomEtab'], $_POST['adresse']);

    $hebergement->setType($_POST['type']);
    $hebergement->setServicesSup($_POST['autrServ']);

    $services = $hebergementDAO->getServices();
    $i = 0;
    $serv = array();
    foreach($services as $service)
    {
      if(isset($_POST[$service]))
        $serv[] = $service;
      $i += 1;
      $hebergement->setServices($serv);
    }

    if(isset($_GET['id']))
    {
      $hebergement->setNom($_POST['nomEtab']);
      $hebergement->setAdresse($_POST['adresse']);
      $hebergement->setJour($_POST['jour']);
      $hebergement->setPlace($_POST['nbPlaces']);

      if($hebergementDAO->updateHebergement($hebergement))
      {
        $alert['classAlert'] = 'success';
        $alert['messageAlert'] = GERANT_SUCCESS_MISE_A_JOUR;
      }
      else
      {
        $alert['messageAlert'] = GERANT_ERROR_MISE_A_JOUR;
      }
    }
    else
    {
      $idHebergement = $hebergementDAO->createHebergement($hebergement);
      if($idHebergement == 0)
        header('Location: index.php?page=etablissement&!create');
      else
        header('Location: index.php?page=etablissement&id='.$idHebergement.'&create');
    }
  }
}

if(isset($_GET['create']))
{
  $alert['classAlert'] = 'success';
  $alert['messageAlert'] = GERANT_SUCCESS_CREATION;
}
else if(isset($_GET['!create']))
{
  $alert['messageAlert'] = GERANT_ERROR_CREATION;
}

require_once(PATH_VIEWS_GERANT.'etablissement.php');

?>
