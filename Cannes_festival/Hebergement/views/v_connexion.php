<?php require_once(PATH_VIEWS.'header.php');?>

<!--  Zone message d'alerte -->
<?php require_once(PATH_VIEWS.'alert.php');?>

<!--  Début de la page -->

<?php if($_SESSION['logged'] == 0) { ?>
  <h1><?= TITRE_CONNEXION ?></h1>

  <form action="" method="post">
    <label for="login"><?= ID_CONNEXION ?></label>
      <input type="username" name="login" id="login" />
    <label for="password"><?= PASSWORD_CONNEXION ?></label>
      <input type="password" name="password" id="password" />
    <input type="submit" value="<?= CONNECT_CONNEXION ?>" />
  </form>
<?php } ?>

<!--  Pied de page -->
<?php require_once(PATH_VIEWS.'footer.php');?>
