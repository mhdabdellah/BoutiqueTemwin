-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 08, 2022 at 11:10 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `boutique_temwin`
--

-- --------------------------------------------------------

--
-- Table structure for table `boutique`
--

CREATE TABLE `boutique` (
  `id` int(11) NOT NULL,
  `emplacemnt` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `vendeur` int(11) NOT NULL,
  `moughataa` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `boutique`
--

INSERT INTO `boutique` (`id`, `emplacemnt`, `vendeur`, `moughataa`) VALUES
(1, 'dfd', 1, 'Ujdk'),
(2, 'soukou', 1, 'tvz'),
(3, 'ara', 2, 'arafat');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `lastname` varchar(250) NOT NULL,
  `nni` varchar(250) NOT NULL,
  `qrcode` varchar(255) NOT NULL,
  `qrimage` varchar(5000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id`, `username`, `lastname`, `nni`, `qrcode`, `qrimage`) VALUES
(1, 'mohamed', 'sidi', '55484654778', '54458888', 'C:/javafx-sdk/mysqlConnector/jhklk.png'),
(2, 'sidi', 'mahmoud', '58878545', '554787845', 'file:/C:/javafx-sdk/mysqlConnector/58878545.png'),
(3, 'sidi', 'mahmoud', '656566656', '554787845', 'file:/C:/javafx-sdk/mysqlConnector/656566656.png'),
(4, 'Bouh ', 'Ahmed', '4898549859', '48985', 'file:/C:/javafx-sdk/mysqlConnector/4898549859.png'),
(5, 'Ma', 'df', '945948594', '495', 'file:/C:/javafx-sdk/mysqlConnector/945948594.png'),
(6, 'le7rach', 'arrate', '45894859', 'gygh', 'file:/C:/javafx-sdk/mysqlConnector/45894859.png'),
(7, 'yghg', '76767', '7676', 'hgh', 'file:/C:/javafx-sdk/mysqlConnector/7676.png'),
(8, 'Sidi', 'abdullahi', '8347834784', '8347834784', 'file:/C:/javafx-sdk/mysqlConnector/8347834784.png'),
(9, 'Ehmada', 'Abdi', '8347387487', '8347387487', 'file:/C:/javafx-sdk/mysqlConnector/8347387487.png'),
(10, 'sidi', 'mahmoud', '58878545', '58878545', 'file:/C:/javafx-sdk/mysqlConnector/58878545.png'),
(15, 'Ricardo', 'Marti', '8748374444', '8748374', 'file:/C:/javafx-sdk/mysqlConnector/8748374444.png'),
(16, 'Ahmed', 'Mohamed', '7584754949', '7584754949', 'file:/C:/javafx-sdk/mysqlConnector/7584754949.png'),
(17, 'sidi', 'mahmoud', '656566656', '656566656', 'file:/C:/javafx-sdk/mysqlConnector/656566656.png'),
(18, 'Bouh ', 'Ahmed', '4898549859', '4898549859', 'file:/C:/javafx-sdk/mysqlConnector/4898549859.png'),
(19, 'le7rach', 'arrate', '45894859', '45894859', 'file:/C:/javafx-sdk/mysqlConnector/45894859.png');

-- --------------------------------------------------------

--
-- Table structure for table `produit`
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
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`id`, `code_produit`, `deseignation`, `quantite_pour_client`, `fournisseur`, `remise`, `prix`, `quantite`) VALUES
(1, '4458', 'deluire', 55, 'alibaba', 47, 58, 9998),
(2, '2252512', 'ris', 2, 'alibaba', 22, 254, 999),
(7, '2252512', 'ris', 2, 'alibaba', 22, 254, 999);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `username`, `password`, `email`, `type`) VALUES
(1, 'Abdellahi', 'sidi1212', 'abdellahi@gmail.com', 'admin'),
(3, 'sidi', '123456', 'sidi@gmail.com', 'vendeure'),
(5, 'mohamed', 'sidi1212', 'mohamed@gmail.com', 'magasinier'),
(7, 'hacen', 'admin', 'hacen@gmail.com', 'admin'),
(8, 'mouhamedouFi', 'admin', 'mouhamedouFi@gmail.com', 'admin'),
(9, 'mohamed abdellahi', 'sidi1212', 'mhdabdellahi0@gmail.com', 'vendeur'),
(10, 'ahmed', '1234', 'ahmed@gmail.com', 'magasinier'),
(12, 'Anjnjmn', 'sidi1212', 'abdellahi@gmail.com', 'admin'),
(14, 'mouhamedouFi', 'admin', 'mouhamedouFi@gmail.com', 'admin'),
(16, 'Ahmedou', 'zebra123456', 'ahmedou@gmil.com', 'vendeur'),
(17, 'fi', '1111', 'fi@fi.fi', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `ventes`
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
-- Dumping data for table `ventes`
--

INSERT INTO `ventes` (`id`, `idclient`, `idvendeur`, `quantite_vendues`, `produit`, `datevente`) VALUES
(2, 2, 1, 56, 'deluire', '22/02/2220'),
(3, 2, 8, 25, 'rise', '22/2/2221');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `boutique`
--
ALTER TABLE `boutique`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `boutique`
--
ALTER TABLE `boutique`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
