-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 25 jan. 2019 à 02:16
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
-- Base de données :  `fouleck`
--

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ingredient`
--

INSERT INTO `ingredient` (`id`, `nom`) VALUES
(1, 'poulet'),
(2, 'tomates'),
(3, 'poivrons'),
(4, 'champignons'),
(5, 'fromage'),
(6, 'crème'),
(7, 'jambon'),
(8, 'oignons'),
(9, 'lardons'),
(10, 'miel'),
(11, 'curry'),
(12, 'ananas');

-- --------------------------------------------------------

--
-- Structure de la table `ingredient_pizza`
--

DROP TABLE IF EXISTS `ingredient_pizza`;
CREATE TABLE IF NOT EXISTS `ingredient_pizza` (
  `idPizza` int(11) NOT NULL,
  `idIngredient` int(11) NOT NULL,
  PRIMARY KEY (`idPizza`,`idIngredient`),
  KEY `fk_pizza_ingredient` (`idIngredient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ingredient_pizza`
--

INSERT INTO `ingredient_pizza` (`idPizza`, `idIngredient`) VALUES
(1, 1),
(2, 1),
(1, 2),
(10, 2),
(1, 3),
(9, 4),
(1, 5),
(2, 5),
(10, 5),
(2, 6),
(9, 7),
(1, 8),
(2, 8),
(2, 10),
(9, 10),
(2, 11);

-- --------------------------------------------------------

--
-- Structure de la table `pizza`
--

DROP TABLE IF EXISTS `pizza`;
CREATE TABLE IF NOT EXISTS `pizza` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `img` varchar(255) NOT NULL,
  `prix` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pizza`
--

INSERT INTO `pizza` (`id`, `nom`, `description`, `img`, `prix`) VALUES
(1, 'La Fouleck', 'La Fouleck est la meilleure pizza.', 'assets/img/7.png', 10),
(2, 'L\'indienne', 'L\'indienne est ma pizza préféré.', 'assets/img/5.png', 12),
(9, 'dedf', '', 'assets/img/2.png', 5),
(10, 'gfh', '', 'assets/img/2.png', 1);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `login`, `password`) VALUES
(1, 'max', 'password'),
(2, 'coline', 'password'),
(3, 'ulysse', 'password');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `ingredient_pizza`
--
ALTER TABLE `ingredient_pizza`
  ADD CONSTRAINT `fk_ingredient_pizza` FOREIGN KEY (`idPizza`) REFERENCES `pizza` (`id`),
  ADD CONSTRAINT `fk_pizza_ingredient` FOREIGN KEY (`idIngredient`) REFERENCES `ingredient` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
