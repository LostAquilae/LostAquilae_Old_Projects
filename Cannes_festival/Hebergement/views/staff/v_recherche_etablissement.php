<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->
<h1><?=TITRE_PAGE_ACCUEIL_TOUS?></h1>

<?php
for($i = 0; $i < 3; $i+=1)
{
  while($i < 3 && count($heberRecom[$i]) == 0) $i+=1; if($i >= 3) break; ?>
  <h2><?= $i==0 ? STAFF_TITRE_RECHERCHE_PLUS : ($i==1 ? STAFF_TITRE_RECHERCHE_MOYEN : STAFF_TITRE_RECHERCHE_MOINS) ?></h2>
  <ul class="etablist">
  <?php
  foreach($heberRecom[$i] as $hebergement)
  { ?>
    <li>
      <a href='index.php?page=etablissement&id=<?=$hebergement->getId()?>'>
        <h2><?= $hebergement->getNom() ?></h2>
        <h3><?= $hebergement->getAdresse() ?></h3>
      </a>
    </li>
  <?php } ?>
  </ul>
<?php } ?>

<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php');?>
