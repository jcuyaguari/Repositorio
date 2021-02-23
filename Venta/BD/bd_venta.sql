CREATE DATABASE  IF NOT EXISTS `bd_venta` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bd_venta`;
-- MySQL dump 10.13  Distrib 5.5.49, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: bd_venta
-- ------------------------------------------------------
-- Server version	5.5.49-0ubuntu0.14.04.1

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
-- Table structure for table `detalle_venta`
--

DROP TABLE IF EXISTS `detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_venta` (
  `dv_id` int(11) NOT NULL AUTO_INCREMENT,
  `dv_producto` int(11) NOT NULL,
  `dv_cantidad` int(11) DEFAULT NULL,
  `dv_precioart` decimal(8,2) DEFAULT NULL,
  `dv_total` decimal(8,2) DEFAULT NULL,
  `dv_venta` int(11) NOT NULL,
  PRIMARY KEY (`dv_id`),
  KEY `dv_producto` (`dv_producto`),
  KEY `dv_venta` (`dv_venta`),
  CONSTRAINT `dv_producto` FOREIGN KEY (`dv_producto`) REFERENCES `producto` (`prod_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `dv_venta` FOREIGN KEY (`dv_venta`) REFERENCES `venta` (`ven_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_venta`
--

LOCK TABLES `detalle_venta` WRITE;
/*!40000 ALTER TABLE `detalle_venta` DISABLE KEYS */;
INSERT INTO `detalle_venta` VALUES (1,1,5,1.34,6.70,1),(2,5,4,1.89,7.56,1),(3,7,6,2.84,17.04,1),(4,2,5,1.28,6.40,2),(5,5,6,1.89,11.34,2),(6,4,3,1.42,4.26,3),(7,7,2,2.84,5.68,3),(8,5,6,1.89,11.34,3),(9,2,4,1.28,5.12,4),(10,5,12,1.89,22.68,4),(11,8,4,1.52,6.08,4),(12,2,5,1.28,6.40,5),(13,7,10,2.84,28.40,5);
/*!40000 ALTER TABLE `detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `prod_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_nombre` varchar(100) DEFAULT NULL,
  `prod_cant` int(11) DEFAULT NULL,
  `prod_precio` double(8,2) DEFAULT NULL,
  PRIMARY KEY (`prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'NARANJAS',240,1.34),(2,'MANZANAS',335,1.28),(3,'SANDIA',265,1.69),(4,'DURAZNO',432,1.42),(5,'FRESA',525,1.89),(6,'PLANTANO',415,2.52),(7,'UVAS',325,2.84),(8,'MANGO',453,1.52),(9,'MELON',261,1.73);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `us_id` int(11) NOT NULL AUTO_INCREMENT,
  `us_login` varchar(15) DEFAULT NULL,
  `us_password` varchar(15) DEFAULT NULL,
  `us_nombres` varchar(45) DEFAULT NULL,
  `us_codvendedor` varchar(10) DEFAULT NULL,
  `us_anexo` varchar(6) DEFAULT NULL,
  `us_perfil` varchar(15) DEFAULT NULL,
  `us_estado` int(11) DEFAULT NULL,
  `us_activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`us_id`),
  KEY `fk_ryg_usuarios_ryg_perfil1_idx` (`us_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'jlopez','jotha123','JONATHAN LOPEZ','SIN_CODIGO','801001','VENDEDOR',1,1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `ven_id` int(11) NOT NULL AUTO_INCREMENT,
  `ven_fecha` datetime DEFAULT NULL,
  `ven_monto` decimal(8,2) DEFAULT NULL,
  `ven_usuario` int(11) NOT NULL,
  PRIMARY KEY (`ven_id`),
  KEY `venta_usuario` (`ven_usuario`),
  CONSTRAINT `venta_usuario` FOREIGN KEY (`ven_usuario`) REFERENCES `usuarios` (`us_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,'2016-07-07 17:43:42',31.30,1),(2,'2016-07-07 17:45:39',17.74,1),(3,'2016-07-07 17:46:16',21.28,1),(4,'2016-07-07 21:32:03',33.88,1),(5,'2016-07-08 15:48:12',34.80,1);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-24 18:36:27
