<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->
<h1><?=TITRE_PAGE_ACCUEIL_TOUS?></h1>

<h2><?=TITRE_STAFF_FICHE_VIP?></h2>

<form method="post" action="">
  <label for="nom_vip"><?=STAFF_NOM_VIP?></label>
  <input type="text" name="nom" id="nom_vip" value="<?php if(isset($vip)) echo $vip->getNom()?>"/> </br>
  <label for="prenom_vip"><?=STAFF_PRENOM_VIP?></label>
  <input type="text" name="prenom", id="prenom_vip" value="<?php if(isset($vip)) echo $vip->getPrenom()?>"/> </br>
  <label for="competition"><?=STAFF_COMPETITION_VIP?></label>
  <select name="competition" id="competition">
    <?php
      foreach($competitions as $competition)
      { ?>
        <option value="<?=$competition->getId()?>"
          <?php
            if(isset($vip) && $vip->getCompetition()->getLibelle() == $competition->getLibelle())
            {
              echo "selected";
            }
          ?>><?=$competition->getLibelle()?></option>
      <?php
      }
     ?>
   </select> </br>
   <label for="film"><?=STAFF_FILM_VIP?></label>
   <select name="film" id="film">
     <?php
        foreach($films as $film)
        { ?>
          <option value="<?=$film->getId()?>"
            <?php
              if(isset($vip) && $vip->getFilm()->getTitre() == $film->getTitre())
              {
                echo "selected";
              }
            ?>><?=$film->getTitre()?></option>
        <?php
        }
      ?>
   </select> </br>
   <input type="submit" value="Valider" />
</form>

<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php');?>
