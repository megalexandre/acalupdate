CREATE DATABASE  IF NOT EXISTS `acal` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `acal`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: acal
-- ------------------------------------------------------
-- Server version	5.5.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `rc_caixa_completo`
--

DROP TABLE IF EXISTS `rc_caixa_completo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rc_caixa_completo` (
  `numeroconta` int(11) NOT NULL,
  `categoriaSocio` varchar(255) NOT NULL,
  `consumo` double DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `excessoLTd` double DEFAULT NULL,
  `excessoValor` double DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `numeroSocio` int(11) NOT NULL,
  `pagamento` datetime DEFAULT NULL,
  `socio` varchar(255) DEFAULT NULL,
  `taxaSocio` decimal(19,2) NOT NULL,
  `taxas` decimal(19,2) DEFAULT NULL,
  `totalconta` double DEFAULT NULL,
  `vencimento` datetime NOT NULL,
  PRIMARY KEY (`numeroconta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rc_caixa_completo`
--

LOCK TABLES `rc_caixa_completo` WRITE;
/*!40000 ALTER TABLE `rc_caixa_completo` DISABLE KEYS */;
/*!40000 ALTER TABLE `rc_caixa_completo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-20 18:11:24
