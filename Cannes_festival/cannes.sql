-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 21 jan. 2019 à 11:25
-- Version du serveur :  5.7.23
-- Version de PHP :  7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cannes`
--

-- --------------------------------------------------------

--
-- Structure de la table `competition`
--

DROP TABLE IF EXISTS `competition`;
CREATE TABLE IF NOT EXISTS `competition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `competition`
--

INSERT INTO `competition` (`id`, `libelle`) VALUES
(1, 'Longs Métrages'),
(2, 'Un Certain Regard'),
(3, 'Courts Métrages'),
(4, 'Caméra d\'Or');

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

DROP TABLE IF EXISTS `film`;
CREATE TABLE IF NOT EXISTS `film` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  `duree` int(11) NOT NULL,
  `pays` varchar(255) NOT NULL,
  `idRealisateur` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_realisateur_film` (`idRealisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `film`
--

INSERT INTO `film` (`id`, `titre`, `duree`, `pays`, `idRealisateur`) VALUES
(4, 'Pulp Fiction', 149, 'Américain', 29),
(5, 'Les Evadés', 140, 'Américain', 21),
(6, 'Fight Club', 139, 'Américain', 5),
(7, 'Interstellar', 169, 'Américain', 18),
(8, 'Whiplash', 107, 'Américain', 8),
(9, 'Seven', 130, 'Américain', 23),
(10, 'Le bon, la brute et le truand', 180, 'Italien', 20),
(11, 'Inception', 148, 'Américain', 19),
(12, 'Il était une fois dans l\'Ouest', 175, 'Italien', 3),
(13, 'American History X', 119, 'Anglais', 15),
(14, 'The Greatest Showman', 104, 'Américain', 14),
(15, 'Le Prestige', 130, 'Américain', 13),
(16, 'Le dictateur', 126, 'Anglais', 7),
(17, 'Retour vers le futur', 116, 'Américain', 4),
(18, 'Zootopie', 108, 'Américain', 6),
(19, 'Reservoir Dogs', 99, 'Américain', 1),
(20, 'Rush', 123, 'Américain', 30);

-- --------------------------------------------------------

--
-- Structure de la table `hebergement`
--

DROP TABLE IF EXISTS `hebergement`;
CREATE TABLE IF NOT EXISTS `hebergement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `idGerant` int(11) NOT NULL,
  `idType` int(11) NOT NULL,
  `servicesSup` text NOT NULL,
  `adresse` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_type_hebergement` (`idType`),
  KEY `fk_gerant_hebergement` (`idGerant`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hebergement`
--

INSERT INTO `hebergement` (`id`, `nom`, `idGerant`, `idType`, `servicesSup`, `adresse`) VALUES
(1, 'Hôtel chez Dédé !', 1, 1, 'Karting,Curling', '4 rue du brocolis'),
(2, 'Super Villa !', 1, 2, 'Patinoire', '34 rue du zouave'),
(3, 'Au canard goûtu', 1, 1, 'Super Canards,Piscine', '8 avenue du canard');

-- --------------------------------------------------------

--
-- Structure de la table `hebergement_service`
--

DROP TABLE IF EXISTS `hebergement_service`;
CREATE TABLE IF NOT EXISTS `hebergement_service` (
  `idHebergement` int(11) NOT NULL,
  `idService` int(11) NOT NULL,
  PRIMARY KEY (`idHebergement`,`idService`),
  KEY `fk_hebergement_service` (`idService`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hebergement_service`
--

INSERT INTO `hebergement_service` (`idHebergement`, `idService`) VALUES
(1, 1),
(3, 1),
(1, 2),
(3, 2),
(1, 3),
(2, 4),
(2, 6),
(2, 7),
(3, 7),
(2, 8),
(3, 8);

-- --------------------------------------------------------

--
-- Structure de la table `places`
--

DROP TABLE IF EXISTS `places`;
CREATE TABLE IF NOT EXISTS `places` (
  `numJour` int(11) NOT NULL,
  `idHebergement` int(11) NOT NULL,
  `nbPlace` int(11) NOT NULL,
  PRIMARY KEY (`numJour`,`idHebergement`),
  KEY `fk_hebergement_places` (`idHebergement`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `places`
--

INSERT INTO `places` (`numJour`, `idHebergement`, `nbPlace`) VALUES
(1, 1, 17),
(1, 2, 20),
(1, 3, 20),
(2, 1, 17),
(2, 2, 20),
(2, 3, 20),
(3, 1, 17),
(3, 2, 20),
(3, 3, 20),
(4, 1, 18),
(4, 2, 20),
(4, 3, 19),
(5, 1, 17),
(5, 2, 20),
(5, 3, 19),
(6, 1, 17),
(6, 2, 20),
(6, 3, 19),
(7, 1, 17),
(7, 2, 20),
(7, 3, 19),
(8, 1, 17),
(8, 2, 20),
(8, 3, 19),
(9, 1, 17),
(9, 2, 20),
(9, 3, 20),
(10, 1, 17),
(10, 2, 20),
(10, 3, 20),
(11, 1, 17),
(11, 2, 20),
(11, 3, 20),
(12, 1, 17),
(12, 2, 20),
(12, 3, 20),
(13, 1, 17),
(13, 2, 20),
(13, 3, 20),
(14, 1, 17),
(14, 2, 20),
(14, 3, 20),
(15, 1, 17),
(15, 2, 20),
(15, 3, 20),
(16, 1, 17),
(16, 2, 20),
(16, 3, 20),
(17, 1, 20),
(17, 2, 20),
(17, 3, 20),
(18, 1, 20),
(18, 2, 20),
(18, 3, 20),
(19, 1, 20),
(19, 2, 20),
(19, 3, 20),
(20, 1, 20),
(20, 2, 20),
(20, 3, 20),
(21, 1, 20),
(21, 2, 20),
(21, 3, 20),
(22, 1, 20),
(22, 2, 20),
(22, 3, 20),
(23, 1, 20),
(23, 2, 20),
(23, 3, 20),
(24, 1, 20),
(24, 2, 15),
(24, 3, 20),
(25, 1, 20),
(25, 2, 15),
(25, 3, 20),
(26, 1, 20),
(26, 2, 15),
(26, 3, 20),
(27, 1, 20),
(27, 2, 20),
(27, 3, 20),
(28, 1, 20),
(28, 2, 20),
(28, 3, 20),
(29, 1, 20),
(29, 2, 20),
(29, 3, 20),
(30, 1, 20),
(30, 2, 20),
(30, 3, 20);

--
-- Déclencheurs `places`
--
DROP TRIGGER IF EXISTS `NbPlacePos`;
DELIMITER $$
CREATE TRIGGER `NbPlacePos` BEFORE UPDATE ON `places` FOR EACH ROW BEGIN
    IF new.nbPlace < 0 THEN
    	SIGNAL SQLSTATE '45000'
        	SET MESSAGE_TEXT = 'Le nombre de place ne peut être négatif';
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `projection`
--

DROP TABLE IF EXISTS `projection`;
CREATE TABLE IF NOT EXISTS `projection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idFilm` int(11) NOT NULL,
  `idSalle` int(11) NOT NULL,
  `numJour` int(11) NOT NULL,
  `heure` time NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_salle_projection` (`idSalle`),
  KEY `fk_film_projection` (`idFilm`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `projection`
--

INSERT INTO `projection` (`id`, `idFilm`, `idSalle`, `numJour`, `heure`) VALUES
(32, 12, 3, 13, '12:00:00'),
(33, 5, 2, 14, '10:50:00'),
(34, 4, 4, 14, '10:10:00'),
(35, 19, 2, 15, '09:00:00'),
(36, 13, 4, 15, '10:10:00'),
(37, 10, 2, 15, '13:55:00'),
(38, 20, 3, 14, '10:20:00'),
(40, 18, 5, 13, '11:20:00'),
(42, 6, 1, 13, '11:20:00'),
(48, 17, 3, 13, '08:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `idVip` int(11) NOT NULL,
  `idHebergement` int(11) NOT NULL,
  `jourDebut` int(11) NOT NULL,
  `jourFin` int(11) NOT NULL,
  `nbPersonne` int(11) NOT NULL,
  PRIMARY KEY (`idVip`),
  KEY `fk_reservation_hebergement` (`idHebergement`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`idVip`, `idHebergement`, `jourDebut`, `jourFin`, `nbPersonne`) VALUES
(15, 3, 4, 8, 1),
(16, 1, 1, 4, 1),
(17, 1, 1, 3, 1),
(21, 2, 24, 26, 5),
(23, 1, 5, 16, 3),
(24, 1, 1, 4, 1);

--
-- Déclencheurs `reservation`
--
DROP TRIGGER IF EXISTS `nbPersonneTrigger`;
DELIMITER $$
CREATE TRIGGER `nbPersonneTrigger` BEFORE INSERT ON `reservation` FOR EACH ROW BEGIN
	IF new.nbPersonne < 1 THEN
    	SIGNAL SQLSTATE '45001'
        	SET MESSAGE_TEXT = 'Une reservation doit comporter au moins 1 personne !';
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`id`, `libelle`) VALUES
(1, 'Le Grand Théâtre Lumière'),
(2, 'La salle Debussy'),
(3, 'La salle Buñuel'),
(4, 'La salle du Soixantième'),
(5, 'La salle Bazin');

-- --------------------------------------------------------

--
-- Structure de la table `salle_competition`
--

DROP TABLE IF EXISTS `salle_competition`;
CREATE TABLE IF NOT EXISTS `salle_competition` (
  `idSalle` int(11) NOT NULL,
  `idCompetition` int(11) NOT NULL,
  PRIMARY KEY (`idSalle`,`idCompetition`),
  KEY `fk_competition_salle` (`idCompetition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salle_competition`
--

INSERT INTO `salle_competition` (`idSalle`, `idCompetition`) VALUES
(1, 1),
(4, 1),
(2, 2),
(5, 2),
(2, 3),
(3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `service`
--

INSERT INTO `service` (`id`, `nom`) VALUES
(1, 'Bar'),
(2, 'Restaurant'),
(3, 'Petit-dejeuner'),
(4, 'Sauna'),
(6, 'Coiffeur'),
(7, 'Pressing'),
(8, 'Hammam');

-- --------------------------------------------------------

--
-- Structure de la table `typehebergement`
--

DROP TABLE IF EXISTS `typehebergement`;
CREATE TABLE IF NOT EXISTS `typehebergement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `typehebergement`
--

INSERT INTO `typehebergement` (`id`, `nom`) VALUES
(1, 'Hôtel'),
(2, 'Villa');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `estGerant` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `login`, `password`, `estGerant`) VALUES
(1, 'gerant', '$2y$10$YT20Js0ykfSIcgiUxiJ.v.LGsIZD25JxBKlyccGzSASG4p2TrXbqS', 1),
(2, 'staff', '$2y$10$YT20Js0ykfSIcgiUxiJ.v.LGsIZD25JxBKlyccGzSASG4p2TrXbqS', 0);

-- --------------------------------------------------------

--
-- Structure de la table `vip`
--

DROP TABLE IF EXISTS `vip`;
CREATE TABLE IF NOT EXISTS `vip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `idCompetition` int(11) DEFAULT NULL,
  `idFilm` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_film_VIP` (`idFilm`),
  KEY `fk_concours_VIP` (`idCompetition`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vip`
--

INSERT INTO `vip` (`id`, `nom`, `prenom`, `idCompetition`, `idFilm`) VALUES
(1, 'Titherington', 'Marget', 4, 19),
(2, 'Theuff', 'Angelina', 3, NULL),
(3, 'Parrish', 'Elia', 2, 12),
(4, 'Halgarth', 'Vilhelmina', 1, 17),
(5, 'Rillatt', 'Kevan', 1, 6),
(6, 'Beamson', 'Ailyn', 1, 18),
(7, 'Monkton', 'Rachelle', 1, 16),
(8, 'Hansman', 'Berthe', 1, 8),
(9, 'Scotson', 'Roseanne', 1, 15),
(10, 'Vollam', 'Bancroft', 1, 16),
(11, 'Shewan', 'Neils', 4, 5),
(12, 'Swanston', 'Mirabella', 3, 4),
(13, 'Driffe', 'Joli', 1, 15),
(14, 'Braunds', 'Sadye', 1, 14),
(15, 'Feehily', 'Gasparo', 4, 13),
(16, 'Silcock', 'Harmonie', 3, 9),
(17, 'Hiskey', 'Mair', 2, NULL),
(18, 'Iiannone', 'Kellie', 1, 7),
(19, 'Branno', 'Yule', 1, 11),
(20, 'Corss', 'Herve', 4, 10),
(21, 'Grigorkin', 'Jackqueline', 3, 5),
(22, 'Servante', 'Roseline', 2, 12),
(23, 'Battram', 'Gilberta', 1, 9),
(24, 'Yeldon', 'Robb', 4, NULL),
(25, 'Leap', 'Deeyn', 3, 4),
(26, 'Walby', 'Fidela', 2, 19),
(27, 'Faers', 'Torry', 1, 17),
(28, 'Sansun', 'Mathilde', 4, 20),
(29, 'Boles', 'Iggy', 3, 4),
(30, 'Phalip', 'Stirling', 2, 20),
(31, 'Maximilien', 'Chaux', 2, NULL);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `fk_realisateur_film` FOREIGN KEY (`idRealisateur`) REFERENCES `vip` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `hebergement`
--
ALTER TABLE `hebergement`
  ADD CONSTRAINT `fk_gernat_hebergement` FOREIGN KEY (`idGerant`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_type_hebergement` FOREIGN KEY (`idType`) REFERENCES `typehebergement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `hebergement_service`
--
ALTER TABLE `hebergement_service`
  ADD CONSTRAINT `fk_hebergement_service` FOREIGN KEY (`idService`) REFERENCES `service` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_service_hebergement` FOREIGN KEY (`idHebergement`) REFERENCES `hebergement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `places`
--
ALTER TABLE `places`
  ADD CONSTRAINT `fk_hebergement_places` FOREIGN KEY (`idHebergement`) REFERENCES `hebergement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `projection`
--
ALTER TABLE `projection`
  ADD CONSTRAINT `fk_film_projection` FOREIGN KEY (`idFilm`) REFERENCES `film` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_salle_projection` FOREIGN KEY (`idSalle`) REFERENCES `salle` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `fk_reservation_hebergement` FOREIGN KEY (`idHebergement`) REFERENCES `hebergement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_reservation_vip` FOREIGN KEY (`idVip`) REFERENCES `vip` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `salle_competition`
--
ALTER TABLE `salle_competition`
  ADD CONSTRAINT `fk_competition_salle` FOREIGN KEY (`idCompetition`) REFERENCES `competition` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_salle_competition` FOREIGN KEY (`idSalle`) REFERENCES `salle` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `vip`
--
ALTER TABLE `vip`
  ADD CONSTRAINT `fk_concours_VIP` FOREIGN KEY (`idCompetition`) REFERENCES `competition` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_film_VIP` FOREIGN KEY (`idFilm`) REFERENCES `film` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
