<?php
//isoler ici dans des constantes les textes affichés sur le site
define('LOGO', 'Logo de la compagnie'); // Affiché si image non trouvée

define('TITRE_PAGE_ACCUEIL_TOUS', '');
define('MENU_ACCUEIL_STAFF','Accueil Staff');
define('MENU_ACCUEIL_GERANT','Accueil Gerant');
define('CONNEXION_MENU', 'Connexion');
define('DECONNEXION_MENU', 'Déconnexion');

define('TITRE_CONNEXION', 'Connexion');
define('ID_CONNEXION', 'Identifiant');
define('PASSWORD_CONNEXION', 'Mot de passe');
define('CONNECT_CONNEXION', 'Se connecter');
define('NO_ID_ALERT_CONNEXION', 'Cet identifiant est inconnu !');
define('NO_PASSWORD_ALERT_CONNEXION', 'Mot de passe incorrect !');
define('CONNECTED_CONNEXION', 'Vous êtes connecté(e).');

define('TEXTE_PAGE_404','Oops, la page demandée n\'existe pas !');
define('MESSAGE_ERREUR',"Une erreur s'est produite");

define('TITRE', 'Festival de Cannes');


// Staff
define('STAFF_AJOUTER_RESERVATION', 'Ajouter une réservation');
define('STAFF_LISTE_RESERVATION', 'Liste des réservations');

define('STAFF_TITRE_AJOUTER_RESERVATION', 'Liste des VIPs non assignés');
define('STAFF_AJOUTER_RESERVATION_TEXTE', 'Ajouter une réservation pour ce VIP');
define('STAFF_AJOUTER_RESERVATION_INVITE', 'Invité');
define('STAFF_AJOUTER_RESERVATION_JURY', 'Jury');
define('STAFF_RECAPITULATIF_FILM', 'Film');

define('STAFF_TITRE_LISTE_RESERVATION', 'Liste des Reservations');
define('STAFF_TITRE_LISTE_JURY', 'Jurys');
define('STAFF_TITRE_LISTE_EQUIPE_FILM', 'Equipe film');
define('STAFF_TITRE_LISTE_AUTRE', 'Autres');
define('STAFF_LISTE_RECAPITULATIF', 'Afficher un récapitulatif de la réservation');
define('STAFF_LISTE_SUPPRIMER', 'Supprimer la réservation de ce VIP');
define('STAFF_JOUR_DEBUT', 'Du ');
define('STAFF_JOUR_FIN', ' au ');
define('STAFF_MAI', ' Mai 2019');
define('STAFF_LISTE_SUPPRIMER_SUCCESS', 'La réservation a bien été supprimée');
define('STAFF_LISTE_SUPPRIMER_ERROR', 'Erreur lors de la suppression de la réservation');
define('STAFF_LISTE_CREATED_SUCCESS', 'La réservation a bien été créée');
define('STAFF_LISTE_CREATED_ERROR', 'Erreur lors de la création de la réservation');
define('STAFF_LISTE_NB_PERSONNE', ' personne(s)');
define('STAFF_LISTE_VIP', 'Liste de tous les VIPs');

define('STAFF_CREATION_DATE', 'Choisissez la date du séjour');
define('STAFF_CREATION_SUBMIT', 'Rechercher un hebergement');
define('STAFF_CREATION_SERVICES', 'Services nécessaires au VIP');
define('STAFF_CREATION_PERSONNES', 'Nombre de personnes dans la réservation');
define('STAFF_CREATION_TABLEAU', 'Festival de Cannes : Mai 2019');
define('LUNDI', 'Lundi');
define('MARDI', 'Mardi');
define('MERCREDI', 'Mercredi');
define('JEUDI', 'Jeudi');
define('VENDREDI', 'Vendredi');
define('SAMEDI', 'Samedi');
define('DIMANCHE', 'Dimanche');

define('STAFF_TITRE_RECHERCHE_PLUS', 'Hebergements recommandés');
define('STAFF_TITRE_RECHERCHE_MOYEN', 'Hebergements correspondants à la recherche');
define('STAFF_TITRE_RECHERCHE_MOINS', 'Hebergements avec une correspondance médiocre');
define('STAFF_ETABLISSEMENT_LISTE_SERVICE', 'Liste des services de l\'établissement');
define('STAFF_ETABLISSEMENT_VALIDER', 'Réserver les places dans cet établissement');
define('STAFF_ETABLISSEMENT_NB_PLACE', 'Nombre de places restantes : ');

define('STAFF_TITRE_RECAPITULATIF', 'Recapitulatif de la reservation');
define('STAFF_RECAPITULATIF_NOM', 'Nom');
define('STAFF_RECAPITULATIF_PRENOM', 'Prenom');
define('STAFF_RECAPITULATIF_NOM_HEBERGEMENT', 'Nom hebergement');
define('STAFF_RECAPITULATIF_ADRESSE', 'Adresse');
define('STAFF_RECAPITULATIF_DATE', 'Dates');
define('STAFF_RECAPITULATIF_COLLEGUES', 'Collègue N°');
define('STAFF_RECAPITULATIF_COLLEGUES_TITRE', 'Collègues voisins');
define('STAFF_RECAPITULATIF_HEBERGERGEMENT', 'Hebergement');
define('STAFF_RECAPITULATIF_VIP', 'VIP');

define('STAFF_VIP_SUPPRESSION', 'Supprimer le VIP');
define('STAFF_LISTE_VIP_SUPPRIMER_SUCCESS', 'Le VIP à bien été supprimé');
define('STAFF_LISTE_VIP_SUPPRIMER_ERROR', 'Erreur lors de la suppression');
define('STAFF_AJOUT_VIP', 'Ajouter un vip');
define('STAFF_NOM_VIP', 'Nom');
define('STAFF_PRENOM_VIP', 'Prenom');
define('STAFF_COMPETITION_VIP', 'Compétition');
define('STAFF_FILM_VIP', 'Film');
define('TITRE_STAFF_FICHE_VIP', 'Fiche du VIP');
define('STAFF_CREATION_VIP_SUCCESS', 'La création s\'est déroulée correctement');
define('STAFF_CREATION_VIP_ERROR', 'La création à échouée');
define('STAFF_MODIFICATION_VIP', 'Modifier le VIP');
define('STAFF_UPDATE_SUCCESS', 'La mise à jour a fonctionnée');
define('STAFF_UPDATE_ERROR', 'Erreur lors de la mise à jour');
define('STAFF_VIP_TITRE', 'Liste des VIPs');


// Gerant
define('GERANT_TITRE_ACCUEIL', 'Liste des établissements');
define('GERANT_AJOUT_ETABLISEEMENT', 'Ajouter un établissement');
define('GERANT_SUCCESS_SUPPRESSION', 'Votre établissement a bien été supprimé.');
define('GERANT_ERROR_SUPPRESSION', 'Une erreur est survenue lors de la suppression de votre établissement !');

define('GERANT_SERVICES_ETABLISSEMENT', 'Liste des services disponibles');
define('GERANT_NOM_ETABLISSEMENT', 'Nom de l\'établissement');
define('GERANT_ADRESSE_ETABLISSEMENT', 'Adresse');
define('GERANT_TYPE_HEBERGEMENT', 'Type d\'hébergement');
define('GERANT_AUTRE_SERVICES', 'Autre services');
define('GERANT_JOUR', 'Jour');
define('GERANT_PLACES_DISPONIBLES', 'Nombre de places disponibles');
define('GERANT_ERREUR_REMPLISSAGE', 'Veuillez remplir tous les champs nécéssaires');
define('GERANT_SUCCESS_MISE_A_JOUR', 'Votre établissement a bien été mis à jour');
define('GERANT_ERROR_MISE_A_JOUR', 'Une erreur est survenue lors de la mise à jour de votre établissement !');
define('GERANT_SUCCESS_CREATION', 'Votre établissement a bien été créé');
define('GERANT_ERROR_CREATION', 'Une erreur est survenue lors de la crétion de votre établissement !');
define('GERANT_PRECISION_AUTRES_SERVICES', 'Veuillez écrire les autres services à la suite séparés par une virgule seulement.');
define('GERANT_PRECISION_PLACES', 'Veuillez valider pour chaque nombres de places renseignés');
?>
