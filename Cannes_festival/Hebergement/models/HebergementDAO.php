<?php
require_once(PATH_MODELS.'DAO.php');
require_once(PATH_ENTITY.'Hebergement.php');

class HebergementDAO extends DAO
{
  public function getHebergements($idGerant)
  {
    $res = $this->queryAll('SELECT * FROM Hebergement WHERE idGerant = ?', array($idGerant));
  	if($res)
  	{
      foreach($res as $line)
      {
        $hebergements[] = new Hebergement($line['id'], $line['nom'], $line['adresse']);
      }
      return $hebergements;
  	}
    else return array();
  }

  public function getHeberRecom($dateDeb, $dateFin, $services, $personnes, $vip)
  {
    $heberRecom = array(array(), array(), array());

    $res = $this->queryAll('SELECT id, nom, adresse, MIN(nbPlace) AS nb FROM Hebergement AS H, Places AS P WHERE H.id = P.idHebergement
      AND P.numJour >= ? AND P.numJour <= ? GROUP BY id HAVING nb >= ?', array($dateDeb, $dateFin, $personnes));

    if($res)
    {
      require_once(PATH_MODELS.'ReservationDAO.php');
      $reservationDAO = new ReservationDAO(DEBUG);

      foreach($res as $line)
      {
        $suite = 0;
        $corres = 0;

        if($vip->getFilm() != null) // EquipeFilm
        {
          if($this->queryAll('SELECT * FROM Reservation AS R, VIP AS V WHERE R.idHebergement = ? AND V.id = R.idVip AND V.idCompetition = ? AND V.idFilm IS NULL
          AND ((R.jourDebut <= ? AND R.jourFin >= ?) OR (R.jourDebut <= ? AND R.jourFin >= ?))',
          array($line['id'], $vip->getCompetition()->getId(), $dateDeb, $dateDeb, $dateFin, $dateFin)))
            $suite = -1;
          else if($this->queryAll('SELECT * FROM Reservation AS R, VIP AS V WHERE R.idHebergement = ? AND V.id = R.idVip AND V.idFilm = ?
          AND ((R.jourDebut <= ? AND R.jourFin >= ?) OR (R.jourDebut <= ? AND R.jourFin >= ?))',
          array($line['id'], $vip->getFilm()->getId(), $dateDeb, $dateDeb, $dateFin, $dateFin)))
            $suite = 2;
        }
        else if($vip->getCompetition() != null) // Jury
        {
          if($this->queryAll('SELECT * FROM Reservation AS R, VIP AS V WHERE R.idHebergement = ? AND V.id = R.idVip AND V.idCompetition = ? AND V.idFilm IS NOT NULL
          AND ((R.jourDebut <= ? AND R.jourFin >= ?) OR (R.jourDebut <= ? AND R.jourFin >= ?))',
          array($line['id'], $vip->getCompetition()->getId(), $dateDeb, $dateDeb, $dateFin, $dateFin)))
            $suite = -1;
          else if($this->queryAll('SELECT * FROM Reservation AS R, VIP AS V WHERE R.idHebergement = ? AND V.id = R.idVip AND V.idCompetition = ? AND V.idFilm IS NULL
          AND ((R.jourDebut <= ? AND R.jourFin >= ?) OR (R.jourDebut <= ? AND R.jourFin >= ?))',
          array($line['id'], $vip->getCompetition()->getId(), $dateDeb, $dateDeb, $dateFin, $dateFin)))
            $suite = 2;
        }

        if($suite != -1)
        {
          $resServ = $this->queryAll('SELECT nom FROM Service AS S, Hebergement_Service AS HS WHERE HS.idHebergement = ? AND HS.idService = S.id', array($line['id']));

          $servs = array();
          foreach($resServ as $serv)
          {
            $servs[] = $serv[0];
          }

          foreach($services as $serv)
          {
            if(!in_array($serv, $servs))
            {
              $corres += 1;
            }
          }

          $heber = new Hebergement($line['id'], $line['nom'], $line['adresse']);
          $heber->setPlace($line['nb']);

          if($suite == 2)
            $heberRecom[0][] = $heber;
          else if($corres < 3)
            $heberRecom[1][] = $heber;
          else
            $heberRecom[2][] = $heber;
        }
      }
    }

    return $heberRecom;
  }

  public function getHebergement($idHebergement, $numJour = 1)
  {
    $res = $this->queryAll('SELECT H.id, H.nom, TH.nom, S.nom, H.servicesSup, H.adresse, P.nbPlace, P.numJour FROM Hebergement AS H, TypeHebergement AS TH, hebergement_service AS HS, service AS S, places as P
                            WHERE H.id = ? and H.idType = TH.id and HS.idHebergement = H.id and HS.idService = S.id and P.idHebergement = H.id and P.numJour = ?', array($idHebergement, $numJour));
  	if($res)
  	{
      foreach($res as $ligne)
      {
        $services[] = $ligne[3]; // Service.nom
      }
  	}
  	else
    {
      $res = $this->queryAll('SELECT H.id, H.nom, TH.nom, H.servicesSup, H.adresse, P.nbPlace, P.numJour FROM Hebergement AS H, TypeHebergement AS TH, places as P
                            WHERE H.id = ? and H.idType = TH.id and P.idHebergement = H.id and P.numJour = ?', array($idHebergement, $numJour));

      $services = array();
    }

    if($res)
    {
      $ligne = $res[0];
      $hebergement = new Hebergement($ligne['id'], $ligne[1], $ligne['adresse']); // Hebergement.nom
      $hebergement->setType($ligne[2]); // TypeHebergement.nom
      $hebergement->setServicesSup($ligne['servicesSup']);
      $hebergement->setJour($ligne['numJour']);
      $hebergement->setPlace($ligne['nbPlace']);
      $hebergement->setServices($services);
      return $hebergement;
    }
    else return null;
  }

  public function getHebergementDate($idHebergement, $dateDeb, $dateFin)
  {
    $res = $this->queryAll('SELECT H.id, H.nom, TH.nom, S.nom, H.servicesSup, H.adresse, MIN(P.nbPlace) AS nbP FROM Hebergement AS H, TypeHebergement AS TH, hebergement_service AS HS, service AS S, places as P
                            WHERE H.id = ? and H.idType = TH.id and HS.idHebergement = H.id and HS.idService = S.id and P.idHebergement = H.id and P.numJour >= ? and P.numJour <= ?', array($idHebergement, $dateDeb, $dateFin));
  	if($res)
  	{
      foreach($res as $ligne)
      {
        $services[] = $ligne[3]; // Service.nom
      }
  	}
  	else
    {
      $res = $this->queryAll('SELECT H.id, H.nom, TH.nom, H.servicesSup, H.adresse, MIN(P.nbPlace) AS nbP FROM Hebergement AS H, TypeHebergement AS TH, places as P
                            WHERE H.id = ? and H.idType = TH.id and P.idHebergement = H.id and P.numJour >= ? and P.numJour <= ?', array($idHebergement, $dateDeb, $dateFin));

      $services = array();
    }

    if($res)
    {
      $ligne = $res[0];
      $hebergement = new Hebergement($ligne['id'], $ligne[1], $ligne['adresse']); // Hebergement.nom
      $hebergement->setType($ligne[2]); // TypeHebergement.nom
      $hebergement->setServicesSup($ligne['servicesSup']);
      $hebergement->setPlace($ligne['nbP']);
      $hebergement->setServices($services);
      return $hebergement;
    }
    else return null;
  }

  public function createHebergement($hebergement)
  {
    if(!$this->queryBdd('INSERT INTO hebergement VALUES ( ? , ? , ? , (SELECT id FROM typehebergement WHERE nom = ?) , ? , ? )',
    array($hebergement->getId(), $hebergement->getNom(), $_SESSION['gerant'], $hebergement->getType(), $hebergement->getServicesSup(), $hebergement->getAdresse())))
      return 0;

    $idHebergement = $this->insertId();

    foreach($hebergement->getServices() as $service)
    {
      if(!$this->queryBdd('INSERT INTO hebergement_service VALUES ( ? , (SELECT id FROM Service WHERE nom = ?) )', array($idHebergement, $service)))
        return 0;
    }

    for($i = 1 ; $i < 32 ; $i++)
    {
      if(!$this->queryBdd('INSERT INTO Places VALUES ( ? , ? , ? ) ', array($i, $idHebergement, 0)))
        return 0;
    }

    return $idHebergement;
  }

  public function updateHebergement($hebergement)
  {
    if(!$this->queryBdd('UPDATE Hebergement AS H INNER JOIN TypeHebergement AS TH ON TH.nom = ? SET H.nom = ?, H.idType = TH.id, H.servicesSup = ?, H.adresse = ? WHERE H.id = ?',
    array($hebergement->getType(), $hebergement->getNom(), $hebergement->getServicesSup(), $hebergement->getAdresse(), $hebergement->getId())))
      return false;

    if(!$this->queryBdd('DELETE FROM hebergement_service WHERE idHebergement = ?', array($hebergement->getId())))
      return false;
    foreach($hebergement->getServices() as $service)
    {
      if(!$this->queryBdd('INSERT INTO hebergement_service VALUES ( ? , ( SELECT id FROM Service WHERE nom = ? ) )', array($hebergement->getId(), $service)))
        return false;
    }

    if(!$this->queryBdd('UPDATE Places SET nbPlace = ? WHERE idHebergement = ? AND numJour = ?', array($hebergement->getPlace(), $hebergement->getId(), $hebergement->getJour())))
      return false;

    return true;
  }

  public function deleteHebergement($idHebergement)
  {
    if(!$this->queryBdd('DELETE FROM hebergement_service WHERE idHebergement = ?', array($idHebergement)))
      return false;

    if(!$this->queryBdd('DELETE FROM places WHERE idHebergement = ?', array($idHebergement)))
      return false;

    if(!$this->queryBdd('DELETE FROM hebergement WHERE id = ?', array($idHebergement)))
      return false;

    return true;
  }

  public function getTypes()
  {
    $res = $this->queryAll('SELECT nom FROM typehebergement');
    if($res)
    {
        foreach($res as $line)
        {
          $types[] = $line['nom'];
        }
        return $types;
    }
    else return array();
  }

  public function getServices()
  {
    $res = $this->queryALL('SELECT nom FROM service');
    if($res)
    {
      foreach($res as $line)
      {
        $services[] = $line['nom'];
      }
      return $services;
    }
    else
    {
      return array();
    }
  }
}

?>
