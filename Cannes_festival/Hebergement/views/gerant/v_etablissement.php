<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->
<h1><?=TITRE_PAGE_ACCUEIL_TOUS?></h1>

<form method="post" action="">
    <label for="nom_etab"><?=GERANT_NOM_ETABLISSEMENT?></label>
    <input type="text" name="nomEtab" id="nom_etab" value="<?php if(isset($hebergement)) echo $hebergement->getNom();?>"/>
    <br>
    <label for="adresse"><?=GERANT_ADRESSE_ETABLISSEMENT?></label>
    <input type="text" name="adresse" id="adresse" value="<?php if(isset($hebergement)) echo $hebergement->getAdresse();?>"/>
    <br>
    <label for="type"><?=GERANT_TYPE_HEBERGEMENT?></label>
    <select name="type" id="type">
        <?php foreach($types as $type)
        {?>
          <option value="<?=$type?>"
          <?php
            if(isset($hebergement) && $hebergement->getType() == $type)
            {
              echo "selected";
            }
          ?>><?=$type?></option>
        <?php
        } ?>
    </select>
    <h3><?=GERANT_SERVICES_ETABLISSEMENT?></h3>
    <?php $i = 0;
    foreach($services as $service)
    { ?>
      <input type="checkbox" name="<?=$service?>" id="<?=$service?>"
      <?php
        if(isset($hebergement) && in_array($service, $hebergement->getServices()))
        {
          echo "checked";
        }
      ?>/> <label for="<?=$service?>"><?=$service?></label> <br>
    <?php $i += 1; } ?>
    <label for="autre"><?=GERANT_AUTRE_SERVICES?></label>
    <input type="text" name="autrServ" id="autre" value="<?php if(isset($hebergement)) echo $hebergement->getServicesSup();?>"/>
    <p><?=GERANT_PRECISION_AUTRES_SERVICES?></p>
    <?php
    if(isset($_GET['id']))
    { ?>
      <h3><?=GERANT_JOUR?></h3>
      <h2>
        <?php if($jour > 1)
        { ?>
          <a class="jour" href="index?page=etablissement<?php if(isset($_GET['id'])) echo '&id='.$_GET['id'];?>&jour=<?=$jour-1?>"><i class="fas fa-minus"></i></a>
          <?php } ?>
        <?= $jour ?>
          <?php if($jour < 31)
          { ?>
            <a class="jour" href="index?page=etablissement<?php if(isset($_GET['id'])) echo '&id='.$_GET['id'];?>&jour=<?=$jour+1?>"><i class="fas fa-plus"></i></a>
          <?php } ?>
        </h2>
        <label for="nbPlaces"><?=GERANT_PLACES_DISPONIBLES?></label>
        <input type="text" name="nbPlaces" id="nbPlaces" value="<?php if(isset($hebergement)) echo $hebergement->getPlace(); else echo '0';?>"/> <br>
        <input name="jour" value="<?=$jour?>" type="hidden" />
        <p><?=GERANT_PRECISION_PLACES?></p>
    <?php } ?>
    <input type="submit" value="Valider" />
</form>
<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php');?>
