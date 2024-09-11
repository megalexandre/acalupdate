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
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `descricao` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'Rua','Alegria',''),(2,'Travessa','Alegria',''),(3,'Rua','ACM',''),(4,'Travessa','ACM',''),(5,'Rua','Bom Sucesso',''),(6,'Travessa','Bom Sucesso',''),(7,'Rua','Coronel S. Nogueira',''),(8,'Rua','Edivaldo Nunes de Carvalho',''),(10,'Avenida','Fernando Daltro',''),(11,'Travessa','Fernando Daltro',''),(12,'Avenida','Flavio Mesquita',''),(13,'Travessa','Flavio Mesquita',''),(14,'Rua','Flores',''),(15,'Travessa','Flores',''),(16,'Rua','Gilberto Miranda',''),(17,'Rua','Jose Facho',''),(18,'Rua','João Neres',''),(19,'Rua','Primeiro de Janeiro',''),(20,'Travessa','Primeiro de Janeiro',''),(21,'Praça','João Carneiro',''),(22,'Rua','Liberdade',''),(23,'Rua','Manoel C. de Souza',''),(24,'Rua','Manoel Novaes',''),(25,'Travessa','Manoel Novaes',''),(26,'Rua','Morro do Chapéu',''),(27,'Travessa','Morro do Chapéu',''),(28,'Rua','Nova',''),(29,'Rua','Padre Alfredo',''),(30,'Travessa','Padre Alfredo',''),(31,'Praça','Sé',''),(32,'Rua','Quintino Alves',''),(33,'Travessa','Quintino Alves',''),(34,'Praça','Rinaldo Magalhães',''),(35,'Rodovia','Assent. Alagoinhas',''),(36,'Rua','Saudade',''),(37,'Travessa','Saudade',''),(38,'Rua','Senhor do Bomfim',''),(39,'Rua','São José',''),(40,'Rua','Sete de Setembro',''),(41,'Rua','Santo Antonio',''),(42,'Rua','Usina',''),(43,'Rua','Direita',''),(44,'Travessa','Florisvaldo M. de Freitas',''),(45,'Rua','Flavio Mesquita',''),(46,'Fazenda','Cajueiro',''),(47,'Fazenda','Gonçalves',''),(48,'Fazenda','Poços',''),(49,'Fazenda','Bela Vista',''),(51,'Fazenda','Eliege e Geraldo',''),(52,'Fazenda','Água Nova',''),(53,'Fazenda','Lages do Contorno',''),(54,'Fazenda','Caratiu',''),(55,'Fazenda','2 Irmãos',''),(56,'Fazenda','Halane',''),(57,'Fazenda','Umbaumba -Tombador',''),(58,'Fazenda','Bom sossego',''),(59,'Fazenda',' Saco',''),(60,'Rua','Humildes Jacobina-BA',''),(62,'Rua','Conj. Hab. Jacobina3',''),(63,'Rua','Lot. Pedro H. Ferreira',''),(64,'Fazenda','Edvaldo Nunes',''),(66,'Fazenda',' Água Nova',''),(67,'Rua','Roberto Maia',''),(68,'Fazenda','Brauna',''),(69,'Fazenda','Sitio J Padre Cícero',''),(70,'Rodovia','Tombador/Lages do Batata',''),(71,'Avenida','Givaldo Avelino da Mota Av 4 Bairro Pedro Henrique Ferreira',''),(72,'Rua','Ana Pinto Barbosa Rua 12 Bairro Pedro Henrique Ferreira',''),(73,'Rua','Antonio Batista de Carvalho Rua 13 Bairro Pedro Henrique Ferreira','(Mao Aberta)'),(74,'Avenida','Dilson Barbosa Av Nº 6 Bairro Pedro Henriqe Ferreira',''),(75,'Rua','Francisco Fidélix da Silva, Rua 22 Bairro Pedro Henrique Ferreira','Chico Mariano'),(76,'Rua','Francisco Matos Rua 7 do Bairro Pedro Henrique Ferreira ','(Chico do Bode)'),(77,'Rua','Hostilo  Quintino Alves Rua Nº 16 Bairro Pedro Henrique Ferreira',''),(78,'Rua','José Carneiro da Silva, Rua 10 Bairro Pedro Henrique Ferreira',''),(80,'Rua','José Moura de Souza Rua 19 do Bairro Pedro Henrique Ferreira','(Zeca Pedro)'),(82,'Rua','José Severino Neto Rua 15 Bairro Pedro Henrique Ferreira','(Zé Macedo)'),(83,'Rua','Manoel Nogueira da Silva Rua 23 Bairro Pedro Henrique Ferreira',''),(84,'Avenida',' Mário Alves de Amorim, Av Nº 5  Bairro Pedro Henrique Ferreira','(Sr. Zulego'),(85,'Rua','São Francisco Rua 21 Bairro Pedro Henrique Ferreira',''),(86,'Avenida','Genézio José de Miranda Av 3 Bairro Loteamento Pedro Henrique','(Sr. Dinho)'),(87,'Rua','Medeiros- Bairro Vila Pamponet','Primeira Rua do Vila Bairro Pamponet'),(88,'Rua','Cravo- Bairro Vila Pamponet','Segunda Rua do Bairro Vila Pamponet. '),(89,'Rua','dos Evangelicos - Bairro Vila Pamponet','Terceira Rua do Bairro Vila Pamponet'),(90,'Rua','Otaciana Benícia de Jesus Rua Nº 20 Bairro Pedro Henrique Ferreira','Dona Baia'),(91,'Avenida','Raul Mangabeira  Av 2 Bairro Pedro Henrique Ferreira',''),(92,'Rua','Maria Brito de Souza Rua 18 Bairro Loteamento Pedro Henrique','(Dona Zainha)'),(93,'Rua','Terezinha Soares da Silva Rua 16 Bairro Pedro Henrique Ferreira','(Tereza)'),(94,'Rua','José  Correia da Silva Rua 11 Bairro Loteamento Pedro Henrique Ferreira',''),(95,'Rua','José Ferreira Filho Rua 17 Bairro Pedro Henrique Ferreira',''),(96,'Fazenda','Água Nova -Sitio Terra Prometida - zona rural',''),(97,'Fazenda','Água Nova -Sítio Morada dos Pássaros - zona rural',''),(98,'Fazenda','São José',''),(99,'Fazenda',' Riacho das Flores',''),(100,'Fazenda','Santo Antônio','Cadastro de atualização da antiga fazenda Cajueiro de Maria Neusa');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-20 18:11:02
