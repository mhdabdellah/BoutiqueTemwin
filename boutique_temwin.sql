-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 07 mars 2022 à 01:27
-- Version du serveur : 10.4.19-MariaDB
-- Version de PHP : 7.4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `boutique_temwin`
--

-- --------------------------------------------------------

--
-- Structure de la table `boutique`
--

CREATE TABLE `boutique` (
  `id` int(11) NOT NULL,
  `emplacemnt` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `vendeur` int(11) NOT NULL,
  `moughataa` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `boutique`
--

INSERT INTO `boutique` (`id`, `emplacemnt`, `vendeur`, `moughataa`) VALUES
(1, 'dfd', 1, 'Ujdk'),
(2, 'soukou', 1, 'tvz'),
(3, 'ara', 2, 'arafat');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `lastname` varchar(250) NOT NULL,
  `nni` varchar(250) NOT NULL,
  `qrcode` int(11) NOT NULL,
  `idvendeur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `username`, `lastname`, `nni`, `qrcode`, `idvendeur`) VALUES
(1, 'mohamed', 'sidi', '55484654778', 54458888, 1),
(2, 'sidi', 'mahmoud', '58878545', 554787845, 5);

-- --------------------------------------------------------

--
-- Structure de la table `magazin`
--

CREATE TABLE `magazin` (
  `id` int(10) NOT NULL,
  `idmagazinieur` int(10) NOT NULL,
  `lieu` varchar(250) NOT NULL,
  `moughataa` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `magazin`
--

INSERT INTO `magazin` (`id`, `idmagazinieur`, `lieu`, `moughataa`) VALUES
(1, 1, 'gh', 'erf');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `code_produit` varchar(20) NOT NULL,
  `deseignation` varchar(52) NOT NULL,
  `quantite_pour_client` int(11) DEFAULT NULL,
  `fournisseur` varchar(56) DEFAULT NULL,
  `remise` int(11) NOT NULL,
  `prix` int(11) NOT NULL,
  `quantite` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `code_produit`, `deseignation`, `quantite_pour_client`, `fournisseur`, `remise`, `prix`, `quantite`) VALUES
(1, '4458', 'deluire', 55, 'alibaba', 47, 58, 9998),
(2, '2252512', 'ris', 2, 'alibaba', 22, 254, 999);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `username`, `password`, `email`, `type`) VALUES
(1, 'Abdellahi', 'sidi1212', 'abdellahi@gmail.com', 'admin'),
(3, 'sidi', '123456', 'sidi@gmail.com', 'vendeure'),
(5, 'mohamed', 'sidi1212', 'mohamed@gmail.com', 'magasinier'),
(7, 'hacen', 'admin', 'hacen@gmail.com', 'admin'),
(8, 'mouhamedouFi', 'admin', 'mouhamedouFi@gmail.com', 'admin'),
(9, 'mohamed abdellahi', 'sidi1212', 'mhdabdellahi0@gmail.com', 'vendeur'),
(10, 'ahmed', '1234', 'ahmed@gmail.com', 'magasinier'),
(12, 'Anjnjmn', 'sidi1212', 'abdellahi@gmail.com', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `ventes`
--

CREATE TABLE `ventes` (
  `id` int(11) NOT NULL,
  `idclient` int(11) NOT NULL,
  `idvendeur` int(11) NOT NULL,
  `quantite_vendues` int(11) NOT NULL,
  `produit` varchar(250) NOT NULL,
  `datevente` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ventes`
--

INSERT INTO `ventes` (`id`, `idclient`, `idvendeur`, `quantite_vendues`, `produit`, `datevente`) VALUES
(2, 2, 1, 56, 'deluire', '22/02/2220'),
(3, 2, 8, 25, 'rise', '22/2/2221');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `boutique`
--
ALTER TABLE `boutique`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`,`nni`),
  ADD KEY `idvendeur` (`idvendeur`);

--
-- Index pour la table `magazin`
--
ALTER TABLE `magazin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`,`deseignation`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ventes`
--
ALTER TABLE `ventes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idclient` (`idclient`),
  ADD KEY `idvendeur` (`idvendeur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `boutique`
--
ALTER TABLE `boutique`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `magazin`
--
ALTER TABLE `magazin`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `ventes`
--
ALTER TABLE `ventes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`idvendeur`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `ventes`
--
ALTER TABLE `ventes`
  ADD CONSTRAINT `ventes_ibfk_1` FOREIGN KEY (`idclient`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `ventes_ibfk_2` FOREIGN KEY (`idvendeur`) REFERENCES `utilisateur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
