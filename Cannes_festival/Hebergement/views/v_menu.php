<!-- Menu du site -->

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <?php if($_SESSION['logged'] != 0) { ?>
				<li <?php echo ($page=='accueil' ? 'class="active"':'')?>>
					<a href="index.php">
						<?= $_SESSION['gerant'] != 0 ? MENU_ACCUEIL_GERANT : MENU_ACCUEIL_STAFF ?>
					</a>
				</li>
      <?php } ?>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <?php if($_SESSION['logged'] == 0) { ?>
        <li <?php echo ($page=='connexion' ? 'class="active"':'')?>>
          <a href="index.php?page=connexion">
            <?= CONNEXION_MENU ?>
          </a>
        </li>
      <?php } else { ?>
        <li>
          <a href="index.php?page=deconnexion">
            <?= DECONNEXION_MENU ?>
          </a>
        </li>
      <?php } ?>
  </div>
</nav>
