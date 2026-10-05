<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->
<h1><?=TITRE_PAGE_ACCUEIL_TOUS?></h1>

<ul class='selectionmenu'>
  <li><a href='index.php?page=ajouter_reservation'><?= STAFF_AJOUTER_RESERVATION ?></a></li>
  <li><a href='index.php?page=liste_reservation'><?= STAFF_LISTE_RESERVATION ?></a></li>
  <li><a href='index.php?page=liste_vip'><?= STAFF_LISTE_VIP ?></a></li>
</ul>

<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php');?>
