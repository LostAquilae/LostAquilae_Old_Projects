<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->
<h1><?=TITRE_PAGE_ACCUEIL_TOUS?></h1>

<h2><?=$hebergement->getType().' \''.$hebergement->getNom().'\''?></h2>
<h3><?=$hebergement->getAdresse()?></h3>
<h3><?=STAFF_ETABLISSEMENT_LISTE_SERVICE?></h3>

<ul class='nopoint'>
<?php
foreach($services as $service)
{?>
  <li><h4><input type="checkbox" checked disabled /> <?=$service?></h4></li>
<?php } ?>
</ul>

<h3><?=STAFF_ETABLISSEMENT_NB_PLACE.$hebergement->getPlace()?></h3>

<h3><a href="index.php?page=reserver&idHebergement=<?=$_GET['id']?>"><?=STAFF_ETABLISSEMENT_VALIDER?></a></h3>

<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php');?>
