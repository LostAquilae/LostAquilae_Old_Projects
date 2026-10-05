<?php

session_destroy();
$_SESSION = array();

if(ini_get("session.use_cookies"))
{
  $params = session_get_cookie_params();
  setcookie(session_name(), '', -1,
    $params["path"], $params['domain'],
    $params["secure"], $params["httponly"]
  );
}

header("Location: index.php");

 ?>
