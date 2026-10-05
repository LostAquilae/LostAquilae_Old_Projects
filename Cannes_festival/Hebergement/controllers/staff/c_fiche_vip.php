<?php
require_once(PATH_MODELS.'CompetitionDAO.php');
$competitionDAO = new CompetitionDAO(DEBUG);
$competitionVide = new Competition(0, '');
$competitions = array_merge(array($competitionVide), $competitionDAO->getCompetitions());


require_once(PATH_MODELS.'FilmDAO.php');
$filmDAO = new FilmDAO(DEBUG);
$filmVide = new Film(0, '', 0, '', 0);
$films = array_merge(array($filmVide), $filmDAO->getFilms());

require_once(PATH_MODELS.'VIPDAO.php');
$vipDAO = new VIPDAO(DEBUG);

if(isset($_POST['nom']))
{
  if($_POST['nom'] == "" || $_POST['prenom'] == "")
  {
    $alert['messageAlert'] = GERANT_ERREUR_REMPLISSAGE;
  }
  else
  {
    if($_POST['film'] == 0)
      $_POST['film'] = null;
    if($_POST['competition'] == 0)
      $_POST['competition'] = null;

    if(!isset($_GET['id']))
    {
      $res = $vipDAO->createVIP($_POST['nom'], $_POST['prenom'], $_POST['competition'], $_POST['film']);

      if($res == 0)
        header('Location: index.php?page=fiche_vip&!created');
      else
        header('Location: index.php?page=fiche_vip&id='.$res.'&created');
    }
    else
    {
      $res = $vipDAO->updateVIP($_GET['id'], $_POST['nom'], $_POST['prenom'], $_POST['competition'], $_POST['film']);
      if($res)
      {
        $alert['classAlert'] = 'success';
        $alert['messageAlert'] = STAFF_UPDATE_SUCCESS;
      }
      else
      {
        $alert['messageAlert'] = STAFF_UPDATE_ERROR;
      }
    }
  }
}

if(isset($_GET['id']))
{
  $vip = $vipDAO->getVIP($_GET['id']);
  if(!$vip->getCompetition())
    $vip->setCompetition($competitionVide);
  if(!$vip->getFilm())
    $vip->setFilm($filmVide);
}

if(isset($_GET['created']))
{
  $alert['classAlert'] = 'success';
  $alert['messageAlert'] = STAFF_CREATION_VIP_SUCCESS;
}
else if(isset($_GET['!created']))
{
  $alert['messageAlert'] = STAFF_CREATION_VIP_ERROR;
}

require_once(PATH_VIEWS_STAFF.'fiche_vip.php');
?>
