<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->
<h1><?=TITRE_PAGE_ACCUEIL_TOUS?></h1>

<h2><?=GERANT_TITRE_ACCUEIL?></h2>

<ul class="etablist">
<?php
foreach($hebergements as $hebergement)
{
?>
    <li>
      <a class="cross" href='index.php?idsuppr=<?=$hebergement->getId()?>'><i class="far fa-times-circle fa-4x"></i></a>
      <a href='index.php?page=etablissement&id=<?=$hebergement->getId()?>'>
          <h2><?= $hebergement->getNom() ?></h2>
          <h3><?= $hebergement->getAdresse() ?></h3>
      </a>
    </li>
<?php
}
?>
</ul>

<h2><a href="index?page=etablissement"><?=GERANT_AJOUT_ETABLISEEMENT?></a></h2>

<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php');?>
