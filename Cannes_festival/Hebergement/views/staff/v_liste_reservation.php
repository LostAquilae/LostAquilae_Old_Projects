<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->
<h1><?=TITRE_PAGE_ACCUEIL_TOUS?></h1>

<h2><?=STAFF_TITRE_LISTE_RESERVATION?></h2>

<ul class="viplist">
<?php
foreach($reservList as $reserv)
{
?>
  <li>
    <i class="fas fa-user fa-8x"></i>
    <p>
      <?=$reserv->getVip()->getPrenom().' '.$reserv->getVip()->getNom()?> </br>
      <?=$reserv->getHebergement()->getNom()?> </br>
      <?=STAFF_JOUR_DEBUT . $reserv->getJourDebut() . STAFF_JOUR_FIN . $reserv->getJourFin()?> </br>
      <?=$reserv->getNbPersonne().STAFF_LISTE_NB_PERSONNE?>
    </p>
    <a href='index.php?page=recapitulatif_reservation&vip=<?=$reserv->getVip()->getId()?>&hebergement=<?=$reserv->getHebergement()->getId()?>'><?=STAFF_LISTE_RECAPITULATIF?></a> </br>
    <a href='index.php?page=liste_reservation&supprimer&vip=<?=$reserv->getVip()->getId()?>&hebergement=<?=$reserv->getHebergement()->getId()?>'><?=STAFF_LISTE_SUPPRIMER?></a>
  </li>
<?php
}
?>
</ul>

<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php');?>
