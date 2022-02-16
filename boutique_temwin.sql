-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 16 fév. 2022 à 13:22
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
(7, '2252512', 'ris', 2, 'alibaba', 22, 254, 999);

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

--
-- Index pour les tables déchargées
--

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
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
