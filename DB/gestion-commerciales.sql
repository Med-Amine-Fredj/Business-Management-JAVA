-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 19 jan. 2021 à 12:22
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion-commerciales`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `id` int(11) NOT NULL,
  `numrue` int(11) NOT NULL,
  `libellerue` varchar(255) NOT NULL,
  `nomville` varchar(255) NOT NULL,
  `codepostale` int(11) NOT NULL,
  `gouvernerat` varchar(255) NOT NULL,
  `pays` varchar(255) NOT NULL,
  `identreprise` int(11) NOT NULL,
  `codeclient` varchar(255) NOT NULL,
  `codefournisseur` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `cartebancaire`
--

CREATE TABLE `cartebancaire` (
  `id` int(11) NOT NULL,
  `banque` varchar(255) NOT NULL,
  `agence` text NOT NULL,
  `rib` int(11) NOT NULL,
  `identreprise` int(11) NOT NULL,
  `codeclient` varchar(255) NOT NULL,
  `codefournisseur` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `codeclient` varchar(255) NOT NULL,
  `matriculefiscale` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `cin` int(8) NOT NULL,
  `type` int(11) NOT NULL COMMENT '0 pour etat physique et 1 pour etat morale',
  `telmobile` int(8) NOT NULL,
  `telfixe` int(8) NOT NULL,
  `fax` int(8) NOT NULL,
  `email` varchar(255) NOT NULL,
  `siteweb` varchar(255) NOT NULL,
  `etatfiscale` int(11) NOT NULL COMMENT '0 pour etat assujiti et 1 pour tva'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

CREATE TABLE `entreprise` (
  `id` int(11) NOT NULL,
  `matriculefiscale` varchar(255) NOT NULL,
  `raisonsociale` int(11) NOT NULL COMMENT '0 pour etat physique et 1 pour etat morale',
  `description` text NOT NULL,
  `telfixe` int(8) NOT NULL,
  `telmobile` int(8) NOT NULL,
  `fax` int(8) NOT NULL,
  `email` varchar(255) NOT NULL,
  `siteweb` varchar(255) NOT NULL,
  `etatfiscale` int(11) NOT NULL COMMENT '0 pour etat assujiti et 1 pour tva'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `familleproduit`
--

CREATE TABLE `familleproduit` (
  `id` int(11) NOT NULL,
  `copdefp` varchar(255) NOT NULL,
  `designation` varchar(255) NOT NULL,
  `codeproduit` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `familleproduit`
--

INSERT INTO `familleproduit` (`id`, `copdefp`, `designation`, `codeproduit`) VALUES
(1, 'fredj', 'fredj', 'dfg');

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `codefournissuer` varchar(255) NOT NULL,
  `matriculefiscale` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `cin` int(8) NOT NULL,
  `type` int(11) NOT NULL,
  `telmobile` int(8) NOT NULL,
  `telfixe` int(8) NOT NULL,
  `fax` int(8) NOT NULL,
  `email` varchar(255) NOT NULL,
  `siteweb` varchar(255) NOT NULL,
  `etatfiscale` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`codefournissuer`, `matriculefiscale`, `nom`, `prenom`, `cin`, `type`, `telmobile`, `telfixe`, `fax`, `email`, `siteweb`, `etatfiscale`) VALUES
('fqsfqs', 'fqsfqs', 'fqsfs', 'fqsfs', 1, 1, 1, 1, 1, 'SDGSD', 'SDGSD', 1),
('test jcombo', 'fff', 'fff', 'fff', 12312414, 1, 31313, 131313, 1131, 'fff', 'fff', 1);

-- --------------------------------------------------------

--
-- Structure de la table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `login`
--

INSERT INTO `login` (`id`, `username`, `mdp`) VALUES
(1, 'Fredj', '123');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `reference` varchar(255) NOT NULL,
  `designation` varchar(255) NOT NULL,
  `unitedemesure` varchar(255) NOT NULL,
  `codefournisseur` varchar(255) NOT NULL,
  `codefamilleprodit` varchar(255) NOT NULL,
  `stock` int(11) NOT NULL,
  `stockminimale` int(11) NOT NULL,
  `prixhorstaxe` int(11) NOT NULL,
  `taxe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`reference`, `designation`, `unitedemesure`, `codefournisseur`, `codefamilleprodit`, `stock`, `stockminimale`, `prixhorstaxe`, `taxe`) VALUES
('qq', 'qqq', 'fqsfqs', 'India', 'dfgfd', 1, 1, 0, 0),
('qqq', 'reerterter', 'fqsfqs', 'England', 'dfgfd', 1, 1, 0, 0),
('zz', '', 'fqsfqs', 'India', 'dfgfd', 4, 3, 100, 1),
('fredj', 'aafa', 'fqsfqs', 'U.S.A', 'dfgfd', 6, 2, 0, 0),
('za', 'za', 'fqsfqs', 'India', 'dfgfd', 21, 1, 0, 0),
('med', 'fredj', 'fqsfqs', 'India', 'dfgfd', 9, 3, 0, 0),
('ddds', '', 'DOLLAR', 'fqsfqs', 'dfgfd', 3, 2, 3, 3),
('fredj', 'fre', 'POUND', 'eezae', 'gaeaz', 2, 2, 2, 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `cartebancaire`
--
ALTER TABLE `cartebancaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`codeclient`);

--
-- Index pour la table `entreprise`
--
ALTER TABLE `entreprise`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `familleproduit`
--
ALTER TABLE `familleproduit`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `adresse`
--
ALTER TABLE `adresse`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `cartebancaire`
--
ALTER TABLE `cartebancaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `entreprise`
--
ALTER TABLE `entreprise`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `familleproduit`
--
ALTER TABLE `familleproduit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
