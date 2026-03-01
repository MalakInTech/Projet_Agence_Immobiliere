-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 01 mars 2026 à 14:57
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `agence_immo`
--

-- --------------------------------------------------------

--
-- Structure de la table `bien`
--

CREATE TABLE `bien` (
  `id` int(11) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `ville` varchar(100) DEFAULT NULL,
  `surface` double DEFAULT NULL,
  `prixMensuel` double DEFAULT NULL,
  `proprietaire_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `bien`
--

INSERT INTO `bien` (`id`, `type`, `ville`, `surface`, `prixMensuel`, `proprietaire_id`) VALUES
(31, 'Appartement', 'Marrakech', 80, 3000, 10),
(32, 'Villa', 'Marrakech', 250, 4000, 11),
(33, 'Studio', 'Casablanca', 60, 4000, 12),
(34, 'Maison', 'El kelaa des sraghna', 180, 5000, 13),
(35, 'Appartement', 'Ben guerir', 95, 3200, 14),
(36, 'Villa', 'Tanger', 300, 8000, 15),
(37, 'Studio', 'Safi', 55, 2200, 16),
(38, 'Maison', 'Oujda', 160, 4500, 17),
(39, 'Appartement', 'Casablanca', 100, 2800, 18),
(40, 'Villa', 'Oujda', 270, 7000, 19),
(41, 'Studio', 'Tanger', 50, 5000, 20),
(42, 'Appartement', 'Safi', 110, 3500, 21),
(43, 'Maison', 'Chemaia', 170, 4800, 22);

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `bien_id` int(11) DEFAULT NULL,
  `dateDebut` date DEFAULT NULL,
  `dateFin` date DEFAULT NULL,
  `loyer` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `location`
--

INSERT INTO `location` (`id`, `bien_id`, `dateDebut`, `dateFin`, `loyer`) VALUES
(1, 31, '2025-01-01', '2025-06-01', 3000),
(3, 32, '2026-01-01', '2026-06-30', 2500),
(4, 33, '2025-02-01', '2025-08-01', 2500),
(5, 34, '2025-03-01', '2025-09-01', 5000),
(6, 35, '2025-04-01', '2025-10-01', 3200),
(7, 36, '2025-05-01', '2025-11-01', 8000),
(8, 37, '2025-06-01', '2025-12-01', 2200),
(9, 38, '2025-07-01', '2026-01-01', 4500),
(10, 39, '2025-08-01', '2026-02-01', 2800),
(11, 40, '2025-09-01', '2026-03-01', 7000),
(12, 41, '2025-10-01', '2026-04-01', 2000),
(13, 42, '2025-11-01', '2026-05-01', 3500),
(14, 43, '2025-12-01', '2026-06-01', 4800);

-- --------------------------------------------------------

--
-- Structure de la table `proprietaire`
--

CREATE TABLE `proprietaire` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `proprietaire`
--

INSERT INTO `proprietaire` (`id`, `nom`, `contact`, `adresse`) VALUES
(10, 'Ahmed', '0600000000', 'Marrakech'),
(11, 'Khadija', '0609876543', 'El Kelaa des sraghna'),
(12, 'Ali ', '0600000065', 'Casablanca'),
(13, 'Youssef', '0612345678', 'Rabat'),
(14, 'Sara', '0623456789', 'Fes'),
(15, 'Omar', '0634567890', 'Tanger'),
(16, 'Nadia', '0645678901', 'Agadir'),
(17, 'Hamza', '0656789012', 'Kenitra'),
(18, 'Salma', '0667890123', 'Oujda'),
(19, 'Imane', '0678901234', 'El kelaa des sraghna'),
(20, 'Malak', '0689012345', 'Rabat'),
(21, 'Rachid', '0690123456', 'Ben guerir'),
(22, 'Najia', '0601234567', 'Camaia');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `login` varchar(50) DEFAULT NULL,
  `passwordHash` varchar(255) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `login`, `passwordHash`, `email`) VALUES
(4, 'admin', 'Dw28dNneO13KBM7xHjVn4A==$fog7Ude/fqO6r4i0DKyVcJpGjJtszJsBoRPlnH+Y/Ck=', 'khadijaaziz670@gmail.com');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `bien`
--
ALTER TABLE `bien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `proprietaire_id` (`proprietaire_id`);

--
-- Index pour la table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bien_id` (`bien_id`);

--
-- Index pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `bien`
--
ALTER TABLE `bien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT pour la table `location`
--
ALTER TABLE `location`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `bien`
--
ALTER TABLE `bien`
  ADD CONSTRAINT `bien_ibfk_1` FOREIGN KEY (`proprietaire_id`) REFERENCES `proprietaire` (`id`);

--
-- Contraintes pour la table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `location_ibfk_1` FOREIGN KEY (`bien_id`) REFERENCES `bien` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
