<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->
<h1><?=TITRE_PAGE_ACCUEIL_TOUS?></h1>

<h2><?=STAFF_TITRE_AJOUTER_RESERVATION?></h2>

<ul class="viplist">
<?php
foreach($vipList as $vip)
{
?>
  <li>
    <i class="fas fa-user fa-8x"></i>
    <p>
      <?=$vip->getPrenom().' '.$vip->getNom()?> </br>
      <?=$vip->getCompetition() ? $vip->getCompetition()->getLibelle() : STAFF_AJOUTER_RESERVATION_INVITE?> </br>
      <?=$vip->getCompetition() ? ($vip->getFilm() ? $vip->getFilm()->getTitre() : STAFF_AJOUTER_RESERVATION_JURY) : '</br>' ?>
    </p>
    <a href='index.php?page=creation_reservation&id=<?=$vip->getId()?>'><?=STAFF_AJOUTER_RESERVATION_TEXTE?></a>
  </li>
<?php
}
?>
</ul>

<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php');?>
