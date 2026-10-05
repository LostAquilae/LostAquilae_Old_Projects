<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->
<h1><?=TITRE_PAGE_ACCUEIL_TOUS?></h1>

<h2><?=STAFF_CREATION_DATE?></h2>

<table class='datetab' id="date">
  <caption><?=STAFF_CREATION_TABLEAU?> <a href='index.php?page=creation_reservation&id=<?=$_GET['id']?>'>(reset)</a></caption>
  <thead>
    <tr>
      <td><?=LUNDI?></td>
      <td><?=MARDI?></td>
      <td><?=MERCREDI?></td>
      <td><?=JEUDI?></td>
      <td><?=VENDREDI?></td>
      <td><?=SAMEDI?></td>
      <td><?=DIMANCHE?></td>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td class='disabled'>29</td>
      <td class='disabled'>30</td>
      <?php
      for($i = 1; $i < 32; $i+=1)
      {
        if(in_array($i, array(6, 13, 20, 27)))
        {
          echo "</tr><tr>";
        }
        echo '<td';
        if(isset($_GET['deb']) && ((isset($_GET['fin']) && $i <= $_GET['fin'] && $i >= $_GET['deb']) || $_GET['deb'] == $i))
        {
          echo ' class="colorized"';
        }
        echo '><a href="index.php?page=creation_reservation&id='.$_GET['id'];
        if(!isset($_GET['deb']))
        {
          echo '&deb='.$i;
        }
        else if(!isset($_GET['fin']))
        {
          if($_GET['deb'] < $i)
            echo '&deb='.$_GET['deb'].'&fin='.$i;
          else
            echo '&deb='.$i.'&fin='.$_GET['deb'];
        }
        else
        {
          if($i - $_GET['deb'] < $_GET['fin'] - $i)
            echo '&deb='.$i.'&fin='.$_GET['fin'];
          else
            echo '&deb='.$_GET['deb'].'&fin='.$i;
        }
        echo '#date"><div>'.$i.'</div></a></td>';
      }
      ?>
      <td class='disabled'>1</td>
      <td class='disabled'>2</td>
    </tr>
  </tbody>
</table>

<form method="post" action="index.php?page=recherche_etablissement">
  <h3><label for='services'><?=STAFF_CREATION_SERVICES?></label></h3>
  <ul class="nopoint" id="services">
    <?php
    foreach($services as $service)
    {?>
      <li>
        <input type="checkbox" name="<?=$service?>" id="<?=$service?>" />
        <label for="<?=$service?>"><?=$service?></label>
      </li>
    <?php } ?>
  </ul>

  <input type="hidden" name="dateDeb" value="<?=isset($_GET['deb']) ? $_GET['deb'] : 0?>" />
  <input type="hidden" name="dateFin" value="<?=isset($_GET['fin']) ? $_GET['fin'] : 0?>" />

  <h4><label for="personnes"><?=STAFF_CREATION_PERSONNES?></label></h4>
  <input type="number" min=1 value=1 name="personnes" id="personnes" /> </br>
  <h5><input type="submit" value="<?=STAFF_CREATION_SUBMIT?>"></h5>
</form>

<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php');?>
