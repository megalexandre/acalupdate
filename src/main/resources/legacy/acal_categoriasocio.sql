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
-- Table structure for table `categoriasocio`
--

DROP TABLE IF EXISTS `categoriasocio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoriasocio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `descricao` text,
  `taxasId` int(11) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK271F6B9AA011B865` (`taxasId`),
  KEY `FKbhtsh2dou8s17lpwx7b1784x0` (`group_id`),
  CONSTRAINT `FK271F6B9AA011B865` FOREIGN KEY (`taxasId`) REFERENCES `taxa` (`id`),
  CONSTRAINT `FKbhtsh2dou8s17lpwx7b1784x0` FOREIGN KEY (`group_id`) REFERENCES `grupo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoriasocio`
--

LOCK TABLES `categoriasocio` WRITE;
/*!40000 ALTER TABLE `categoriasocio` DISABLE KEYS */;
INSERT INTO `categoriasocio` VALUES (1,'Sócio Contribuinte Temporário','São aqueles que contribuem, regularmente com o pagamento \nda taxa  do sistema de abastecimento de agua de lages, \ndesde que comprovem, com documento, que soa propietarios \nde imovel em que residem ou inquilinios que tenham contrato de alguel\n, devidamenteo autenticados em cartorio.',1,3),(2,'Sócio Contribuinte efetivo','São aqueles que estiverem devidamente casdastrados\nna acal e que estejam cumprindo seus deveres na forma\ndesse estatuto.',2,2),(3,'Sócio Fundador','',30,1),(4,'Sócio Contribuinte Efetivo (Hidrômetro) A','Categoria dos Hidrometros',5,2),(5,'Sócio Contribuinte Temporario (Hidrômetro)','Hidrometros ativo paga taxa de R$ 20,00',6,3),(6,'Hidrômetro Associado Desligado','Hidrometros Associado Desligado',7,3),(7,' Contribuinte Temporario','fazenda umbaumba',8,3),(8,'(Contribuinte Efetivo (dupla residencia))...','Socios que possuirem dupla residencia',10,2),(10,'Dupla Residencia Socio Temporário','',11,3),(11,'Socio Não Residente','Contribuiente efetivo, São aqueles que estiverem devidamente cadastrado na Acal e que estejam cumprindo os seus deveres na forma deste Estatuto.',12,2),(13,'Contribuinte efetivo ','',9,2),(14,'Restaurante','',16,3),(15,'(Sócio Contribuinte efetivo)','São aqueles que estiverem devidamente cadastrado na ACAL e que estejam cumprindo os seus deveres na forma deste estatuto.',12,2),(16,'((CONTRIBUINTE EFETIVO)','',9,2),(17,'FAZENDA','',22,3),(18,'Prefeitura','Categoria para cadastro dos predios da prefeitura',23,3),(19,'Sócio Contribuinte Efetivo (hidrometro) B','fazenda de socio contribuinte efetivo.',13,2),(20,'Hidrômetro temporario ','',1,3),(21,'Hidrômetro taxa minina 12','',24,3),(22,'sitio ...','',25,3),(23,'sitio....','',26,3),(24,'Contribuiente Temporario..','',27,3),(25,'categoria Exclusiva','',1,3),(26,'Contribuinte temporario','',28,3),(27,'Hidrômetro - Prefeitura ','',23,3),(28,'Socio abril a dezembro 2013','',29,3),(29,'SÓCIO CONTRIBUINTE EFETIVO (Hidrômetro) C','',5,2),(30,'SÓCIO TEMPORARIO (Hidrômetro)','',32,3),(31,'SÓCIO EFETIVO(Hidrômetro comercial)','',33,2),(32,'Socio Temporario (Comercio)','',16,NULL);
/*!40000 ALTER TABLE `categoriasocio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-20 18:11:28
