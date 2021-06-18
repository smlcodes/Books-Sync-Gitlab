-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.11-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for cricards
DROP DATABASE IF EXISTS `cricards`;
CREATE DATABASE IF NOT EXISTS `cricards` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `cricards`;

-- Dumping structure for table cricards.odistats
DROP TABLE IF EXISTS `odistats`;
CREATE TABLE IF NOT EXISTS `odistats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL,
  `country` varchar(500) DEFAULT NULL,
  `matches` int(11) unsigned zerofill NOT NULL,
  `batInngs` int(11) unsigned zerofill NOT NULL,
  `notouts` int(11) unsigned zerofill NOT NULL,
  `runs` int(11) unsigned zerofill NOT NULL,
  `fifties` int(11) unsigned zerofill NOT NULL,
  `hundreads` int(11) unsigned zerofill NOT NULL,
  `batBest` int(11) unsigned zerofill NOT NULL,
  `batAvg` float unsigned zerofill NOT NULL,
  `batStr` float unsigned zerofill NOT NULL,
  `bowInngs` int(11) unsigned zerofill NOT NULL,
  `wickets` int(11) unsigned zerofill NOT NULL,
  `fourWik` int(11) unsigned zerofill NOT NULL,
  `fiveWik` int(11) unsigned zerofill NOT NULL,
  `bowBest` varchar(10) NOT NULL DEFAULT '0-0',
  `bowAvg` float unsigned zerofill NOT NULL,
  `bowStr` float unsigned zerofill NOT NULL,
  `econ` float unsigned zerofill NOT NULL,
  `profId` int(11) DEFAULT NULL,
  `picUrl` longtext DEFAULT NULL,
  `picImg` blob DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `profId` (`profId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
