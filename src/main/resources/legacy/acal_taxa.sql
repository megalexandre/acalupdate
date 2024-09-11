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
-- Table structure for table `taxa`
--

DROP TABLE IF EXISTS `taxa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taxa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `observacao` text,
  `valor` decimal(19,2) NOT NULL,
  `valor_socio` decimal(10,2) DEFAULT NULL,
  `valor_outros` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxa`
--

LOCK TABLES `taxa` WRITE;
/*!40000 ALTER TABLE `taxa` DISABLE KEYS */;
INSERT INTO `taxa` VALUES (1,'Valor do hidrometro','Taxa para nao socios',NULL,30.00,0.00,NULL),(2,'São aqueles que estiverem devidamente cadastrados\nna acal e que estejam comprindo os seus \ndeveres na forma desse estatuto.','Contribuinte efetivo',NULL,27.00,3.00,NULL),(3,'taxa para religação','Taxa de religaçao',NULL,20.00,0.00,NULL),(4,'São aqueles a instutuiram e cujos nomes constam da ata de sua fundação, registrada na forma deste Estatuto.','FUNDAOR',NULL,20.00,0.00,NULL),(5,'valor padrao para o hidrometro','Taxa Hidrometro',NULL,27.00,3.00,NULL),(6,'são usuarios que pagam a taxa minina de hidrometro\nate que o aparelho seja religado.','Hidrômetro inativo',NULL,30.00,0.00,NULL),(7,'Hidrometros Associados Desativados','Hidrometros Associados Desativados',NULL,24.00,0.00,NULL),(8,'taxa para as pessoas que moram na fazenda \rUmbaumba','taxa Umbaumba',NULL,30.00,3.00,NULL),(9,'socios contribuinte efetivo','(TaxaUmbaumba Socio)',NULL,30.00,3.00,NULL),(10,'Socio que possui dupla residencia','Dupla Residencia',NULL,54.00,6.00,NULL),(11,'','Residencia Dupla nao socio',NULL,60.00,0.00,NULL),(12,'','Taxa de sócio não residente',NULL,9.00,0.00,NULL),(13,'ASSOCIADO E QUE TEM HIDROMETRO','TAXA HIDROMETRO ASSOCIADO',NULL,43.92,4.88,NULL),(15,'parcelamento de conta atrasada para socio','Conta- parcelamento de atraso 13.00',NULL,13.00,0.00,NULL),(16,'','Restaurante...',NULL,48.80,0.00,NULL),(20,'controle de Hidrometro(Taxa para cinco Litros)','(Controle do Programa)','',0.01,0.00,NULL),(22,'é Sócio e tem um sitio ','CONTRIBUINTE EFETIVO FAZ',NULL,24.00,0.00,NULL),(23,'Taxa cobrada para predios ou servicos publicos','Predios Publicos',NULL,97.60,0.00,NULL),(24,'','Hidrometro taxa minina 12.00',NULL,30.00,0.00,NULL),(25,'sitio ','taxa sitio',NULL,48.80,0.00,NULL),(26,'Sitio....','Sitio ',NULL,48.80,0.00,NULL),(27,'','Fazenda.',NULL,39.00,0.00,NULL),(28,'','Contribuinte Temporario ',NULL,39.00,0.00,NULL),(29,'','Socio 2013',NULL,3.90,NULL,NULL),(30,'Socio Fundador','Socio fundador',NULL,30.00,0.00,NULL),(31,'Sócio Contribuinte Efetivo Com hidrometro e desconto ','Hidrometro',NULL,21.60,2.40,NULL),(32,'','SÓCIO TEMPORARIO (Hidrômetro)',NULL,48.80,0.00,NULL),(33,'','SÓCIO EFETIVO (Hidrômetro comercial)',NULL,43.92,4.88,NULL);
/*!40000 ALTER TABLE `taxa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-20 18:10:59
