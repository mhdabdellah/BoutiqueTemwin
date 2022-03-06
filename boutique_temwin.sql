-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 06 mars 2022 à 19:48
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.1.2

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
(7, '2252512', 'ris', 2, 'alibaba', 22, 254, 999),
(8, '221', 'kjdcn', 2, 'med', 252, 220, 2);

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
(1, 'baba', '1234', 'hsdkh@dd.d', 'vender'),
(3, 'sidi', '123456', 'sidi@gmail.com', 'vendeure'),
(5, 'mohamed', 'sidi1212', 'mohamed@gmail.com', 'magasinier'),
(7, 'hacen', 'admin', 'hacen@gmail.com', 'admin'),
(8, 'mouhamedouFi', 'admin', 'mouhamedouFi@gmail.com', 'admin'),
(9, 'mohamed abdellahi', 'sidi1212', 'mhdabdellahi0@gmail.com', 'vendeur'),
(10, 'ahmed', '1234', 'ahmed@gmail.com', 'magasinier'),
(12, 'Anjnjmn', 'sidi1212', 'abdellahi@gmail.com', 'admin');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `magazin`
--
ALTER TABLE `magazin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `magazin`
--
ALTER TABLE `magazin`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
