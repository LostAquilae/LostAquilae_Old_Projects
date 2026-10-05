<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->
<h1><?=TITRE_PAGE_ACCUEIL_TOUS?></h1>

<h2><?=STAFF_VIP_TITRE?></h2>

<ul class="viplist">
<?php
foreach($vips as $vip)
{
?>
  <li>
    <i class="fas fa-user fa-8x"></i>
    <p>
      <?=$vip->getPrenom().' '.$vip->getNom()?> </br>
      <?=$vip->getCompetition() ? $vip->getCompetition()->getLibelle() : ''?> </br>
      <?=$vip->getFilm() ? $vip->getFilm()->getTitre() : ''?>
    </p>
    <a href='index.php?page=fiche_vip&id=<?=$vip->getId()?>'><?=STAFF_MODIFICATION_VIP?></a> </br>
    <a href='index.php?page=liste_vip&supprId=<?=$vip->getId()?>'><?=STAFF_VIP_SUPPRESSION?></a>
  </li>
<?php
}
?>
</ul>

<h2><a href='index.php?page=fiche_vip'><?=STAFF_AJOUT_VIP?></a></h2>




<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php');?>
