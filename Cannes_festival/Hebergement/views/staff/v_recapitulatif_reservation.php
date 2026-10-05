<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->
<h1><?=TITRE_PAGE_ACCUEIL_TOUS?></h1>

<table class='datetab recap'>
  <caption><h2><?=STAFF_TITRE_RECAPITULATIF?></h2></caption>
  <thead>
    <tr>
      <td rowspan="<?=$vip->getFilm() ? 3 : 2?>"><?=STAFF_RECAPITULATIF_VIP?></td>
      <td><?=STAFF_RECAPITULATIF_NOM?></td>
      <td><?=$vip->getNom()?></td>
    </tr>
    <tr>
      <td><?=STAFF_RECAPITULATIF_PRENOM?></td>
      <td><?=$vip->getPrenom()?></td>
    </tr>
    <?php if($vip->getFilm()) { ?>
      <tr>
        <td><?=STAFF_RECAPITULATIF_FILM?></td>
        <td><?=$vip->getFilm()->getTitre()?></td>
      </tr>
    <?php } ?>
    <tr>
      <td rowspan="3"><?=STAFF_RECAPITULATIF_HEBERGERGEMENT?></td>
      <td><?=STAFF_RECAPITULATIF_NOM_HEBERGEMENT?></td>
      <td><?=$hebergement->getNom()?></td>
    </tr>
    <tr>
      <td><?=STAFF_RECAPITULATIF_ADRESSE?></td>
      <td><?=$hebergement->getAdresse()?></td>
    </tr>
    <tr>
      <td><?=STAFF_RECAPITULATIF_DATE?></td>
      <td><?=STAFF_JOUR_DEBUT.$reservation->getJourDebut().STAFF_JOUR_FIN.$reservation->getJourFin().STAFF_MAI?></td>
    </tr>
    <?php
    if($vip->getFilm())
    {
      for($i = 0; $i < Count($reservCollegues); $i+=1)
      { $collegue = $reservCollegues[$i]->getVip();?>
      <tr>
        <?= $i == 0 ? '<td rowspan="'.Count($reservCollegues).'">'.STAFF_RECAPITULATIF_COLLEGUES_TITRE.'</td>' : '' ?>
        <td><?=STAFF_RECAPITULATIF_COLLEGUES.($i+1)?></td>
        <td><?=$collegue->getNom().' '.$collegue->getPrenom().'<br>'.STAFF_JOUR_DEBUT.$reservCollegues[$i]->getJourDebut().STAFF_JOUR_FIN.$reservCollegues[$i]->getJourFin().STAFF_MAI?></td>
      </tr>
    <?php }
    } ?>
  </thead>
</table>


<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php');?>
