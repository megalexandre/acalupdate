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
-- Temporary table structure for view `socios_carne_view`
--

DROP TABLE IF EXISTS `socios_carne_view`;
/*!50001 DROP VIEW IF EXISTS `socios_carne_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `socios_carne_view` (
  `id` int(11),
  `nome` varchar(511),
  `CarneDiferenciado` bit(1)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `fucionarionomeview`
--

DROP TABLE IF EXISTS `fucionarionomeview`;
/*!50001 DROP VIEW IF EXISTS `fucionarionomeview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `fucionarionomeview` (
  `nome` varchar(511)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `geracaocontas`
--

DROP TABLE IF EXISTS `geracaocontas`;
/*!50001 DROP VIEW IF EXISTS `geracaocontas`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `geracaocontas` (
  `id` int(11),
  `nome` varchar(255),
  `sobrenome` varchar(255),
  `numerosocio` int(11),
  `SocioExclusivo` bit(1),
  `cpf` varchar(255),
  `numero` varchar(45),
  `valor` decimal(19,2),
  `categoria` varchar(255),
  `inativo` bit(1),
  `endereco` varchar(511)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `rc_caixa`
--

DROP TABLE IF EXISTS `rc_caixa`;
/*!50001 DROP VIEW IF EXISTS `rc_caixa`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `rc_caixa` (
  `numeroconta` int(11),
  `data` datetime,
  `pagamento` datetime,
  `vencimento` datetime,
  `SocioExclusivo` bit(1),
  `socio` varchar(511),
  `endereco` varchar(511),
  `numero` varchar(45),
  `numeroSocio` int(11),
  `categoriaSocio` varchar(255),
  `taxaSocio` decimal(10,2),
  `consumo` double,
  `excessoLTd` double,
  `excessoValor` double,
  `taxas` decimal(23,0),
  `totalconta` double
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `socios_view`
--

DROP TABLE IF EXISTS `socios_view`;
/*!50001 DROP VIEW IF EXISTS `socios_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `socios_view` (
  `id` int(11),
  `nome` varchar(511),
  `SocioExclusivo` bit(1)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `endereco_view`
--

DROP TABLE IF EXISTS `endereco_view`;
/*!50001 DROP VIEW IF EXISTS `endereco_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `endereco_view` (
  `id` int(11),
  `nome` varchar(511)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `rc_conta`
--

DROP TABLE IF EXISTS `rc_conta`;
/*!50001 DROP VIEW IF EXISTS `rc_conta`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `rc_conta` (
  `numeroconta` int(11),
  `data` datetime,
  `pagamento` datetime,
  `vencimento` datetime,
  `socio` varchar(511),
  `endereco` varchar(511),
  `numero` varchar(45),
  `numeroSocio` int(11),
  `categoriaSocio` varchar(255),
  `taxaSocio` decimal(19,2),
  `consumo` double,
  `excessoLTd` double,
  `excessoValor` double,
  `taxas` int(1),
  `totalconta` decimal(10,2)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `socios_carne_view`
--

/*!50001 DROP TABLE IF EXISTS `socios_carne_view`*/;
/*!50001 DROP VIEW IF EXISTS `socios_carne_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `socios_carne_view` AS select distinct `p`.`id` AS `id`,concat(`p`.`nome`,' ',`p`.`sobrenome`) AS `nome`,`s`.`carneDiferenciado` AS `CarneDiferenciado` from (`pessoa` `p` join `socio` `s` on((`p`.`id` = `s`.`idPessoa`))) order by `p`.`nome`,`p`.`sobrenome` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `fucionarionomeview`
--

/*!50001 DROP TABLE IF EXISTS `fucionarionomeview`*/;
/*!50001 DROP VIEW IF EXISTS `fucionarionomeview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `fucionarionomeview` AS select concat(`p`.`nome`,' ',`p`.`sobrenome`) AS `nome` from (`funcionario` `f` join `pessoa` `p` on((`p`.`id` = `f`.`idPessoa`))) order by `p`.`nome`,`p`.`sobrenome` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `geracaocontas`
--

/*!50001 DROP TABLE IF EXISTS `geracaocontas`*/;
/*!50001 DROP VIEW IF EXISTS `geracaocontas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `geracaocontas` AS select `e`.`id` AS `id`,`p`.`nome` AS `nome`,`p`.`sobrenome` AS `sobrenome`,`s`.`numeroSocio` AS `numerosocio`,`s`.`SocioExclusivo` AS `SocioExclusivo`,`p`.`cpf` AS `cpf`,`e`.`Numero` AS `numero`,`t`.`valor` AS `valor`,`cs`.`nome` AS `categoria`,`e`.`inativo` AS `inativo`,concat(`en`.`tipo`,' ',`en`.`nome`) AS `endereco` from (((((`enderecopessoa` `e` join `pessoa` `p` on((`e`.`idPessoa` = `p`.`id`))) join `socio` `s` on((`s`.`idPessoa` = `p`.`id`))) join `categoriasocio` `cs` on((`e`.`idCategoriaSocio` = `cs`.`id`))) join `taxa` `t` on((`cs`.`taxasId` = `t`.`id`))) join `endereco` `en` on((`en`.`id` = `e`.`idEndereco`))) where ((`p`.`status` = 1) and (`e`.`inativo` = 0)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rc_caixa`
--

/*!50001 DROP TABLE IF EXISTS `rc_caixa`*/;
/*!50001 DROP VIEW IF EXISTS `rc_caixa`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rc_caixa` AS select `c`.`id` AS `numeroconta`,`c`.`dataGerada` AS `data`,`c`.`dataPag` AS `pagamento`,`c`.`dataVence` AS `vencimento`,`c`.`SocioExclusivo` AS `SocioExclusivo`,concat(`p`.`nome`,' ',`p`.`sobrenome`) AS `socio`,concat(`e`.`tipo`,' ',`e`.`nome`) AS `endereco`,`ep`.`Numero` AS `numero`,`s`.`numeroSocio` AS `numeroSocio`,`cs`.`nome` AS `categoriaSocio`,`c`.`ValorTaxa` AS `taxaSocio`,coalesce(`h`.`Consumo`,0) AS `consumo`,coalesce((case when ((`h`.`Consumo` - 15000) < 0) then 0 else (`h`.`Consumo` - 15000) end),0) AS `excessoLTd`,coalesce((case when ((`h`.`Consumo` - 15000) < 0) then 0 else (((`h`.`Consumo` - 15000) * (select `taxa`.`valor` from `taxa` where (`taxa`.`id` = 20))) / 10) end),0) AS `excessoValor`,coalesce(sum(0),0) AS `taxas`,((`c`.`ValorTaxa` + coalesce((case when ((`h`.`Consumo` - 15000) < 0) then 0 else (((`h`.`Consumo` - 15000) * (select `taxa`.`valor` from `taxa` where (`taxa`.`id` = 20))) / 10) end),0)) + coalesce(sum(0),0)) AS `totalconta` from (((((((((`conta` `c` join `enderecopessoa` `ep` on((`ep`.`id` = `c`.`idEnderecoPessoa`))) join `pessoa` `p` on((`p`.`id` = `ep`.`idPessoa`))) join `endereco` `e` on((`e`.`id` = `ep`.`idEndereco`))) join `socio` `s` on((`p`.`id` = `s`.`idPessoa`))) join `categoriasocio` `cs` on((`cs`.`id` = `ep`.`idCategoriaSocio`))) join `taxa` `t` on((`t`.`id` = `cs`.`taxasId`))) left join `hidrometro` `h` on((`c`.`id` = `h`.`idconta`))) left join `taxasconta` `tc` on((`c`.`id` = `tc`.`contaid`))) left join `taxa` `t2` on((`t2`.`id` = `tc`.`taxaid`))) group by `c`.`id` order by `p`.`nome`,`p`.`sobrenome` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `socios_view`
--

/*!50001 DROP TABLE IF EXISTS `socios_view`*/;
/*!50001 DROP VIEW IF EXISTS `socios_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `socios_view` AS select distinct `p`.`id` AS `id`,concat(`p`.`nome`,' ',`p`.`sobrenome`) AS `nome`,`s`.`SocioExclusivo` AS `SocioExclusivo` from (`pessoa` `p` join `socio` `s` on((`p`.`id` = `s`.`idPessoa`))) order by `p`.`nome`,`p`.`sobrenome` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `endereco_view`
--

/*!50001 DROP TABLE IF EXISTS `endereco_view`*/;
/*!50001 DROP VIEW IF EXISTS `endereco_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `endereco_view` AS select `e`.`id` AS `id`,concat(`e`.`tipo`,' ',`e`.`nome`) AS `nome` from `endereco` `e` order by `e`.`tipo`,`e`.`nome` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rc_conta`
--

/*!50001 DROP TABLE IF EXISTS `rc_conta`*/;
/*!50001 DROP VIEW IF EXISTS `rc_conta`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rc_conta` AS select `c`.`id` AS `numeroconta`,`c`.`dataGerada` AS `data`,`c`.`dataPag` AS `pagamento`,`c`.`dataVence` AS `vencimento`,concat(`p`.`nome`,' ',`p`.`sobrenome`) AS `socio`,concat(`e`.`tipo`,' ',`e`.`nome`) AS `endereco`,`ep`.`Numero` AS `numero`,`s`.`numeroSocio` AS `numeroSocio`,`cs`.`nome` AS `categoriaSocio`,`t`.`valor` AS `taxaSocio`,coalesce(`h`.`Consumo`,0) AS `consumo`,coalesce((case when ((`h`.`Consumo` - 15000) < 0) then 0 else (`h`.`Consumo` - 15000) end),0) AS `excessoLTd`,coalesce((case when ((`h`.`Consumo` - 15000) < 0) then 0 else (((`h`.`Consumo` - 15000) * (select `taxa`.`valor` from `taxa` where (`taxa`.`id` = 20))) / 10) end),0) AS `excessoValor`,coalesce(0,0) AS `taxas`,`c`.`ValorTaxa` AS `totalconta` from (((((((((`conta` `c` join `enderecopessoa` `ep` on((`ep`.`id` = `c`.`idEnderecoPessoa`))) join `pessoa` `p` on((`p`.`id` = `ep`.`idPessoa`))) join `endereco` `e` on((`e`.`id` = `ep`.`idEndereco`))) join `socio` `s` on((`p`.`id` = `s`.`idPessoa`))) join `categoriasocio` `cs` on((`cs`.`id` = `ep`.`idCategoriaSocio`))) join `taxa` `t` on((`t`.`id` = `cs`.`taxasId`))) left join `hidrometro` `h` on((`c`.`id` = `h`.`idconta`))) left join `taxasconta` `tc` on((`c`.`id` = `tc`.`contaid`))) left join `taxa` `t2` on((`t2`.`id` = `tc`.`taxaid`))) where (`c`.`dataPag` is not null) group by `c`.`id` order by `c`.`dataPag` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Dumping events for database 'acal'
--

--
-- Dumping routines for database 'acal'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-20 18:11:36
