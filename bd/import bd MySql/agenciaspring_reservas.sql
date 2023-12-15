CREATE DATABASE  IF NOT EXISTS `agenciaspring` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `agenciaspring`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: agenciaspring
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `pagamento` varchar(80) NOT NULL,
  `preco_total` decimal(38,2) NOT NULL,
  `qtd_reservada` int NOT NULL,
  `status_pedido` varchar(80) DEFAULT NULL,
  `clientes_id_fk` bigint DEFAULT NULL,
  `destinos_id_fk` bigint DEFAULT NULL,
  `promocao_id_fk` bigint DEFAULT NULL,
  KEY `clientes_id_fk_idx` (`clientes_id_fk`),
  KEY `destinos_id_fk_idx` (`destinos_id_fk`) /*!80000 INVISIBLE */,
  KEY `idx_reservas_id` (`id`),
  KEY `FKodwhxg54dr114ff5mgk8ao3v6` (`promocao_id_fk`),
  CONSTRAINT `FKihe6b89pwtxak1iuc28k39gxy` FOREIGN KEY (`clientes_id_fk`) REFERENCES `clientes` (`id`),
  CONSTRAINT `FKodwhxg54dr114ff5mgk8ao3v6` FOREIGN KEY (`promocao_id_fk`) REFERENCES `promocao` (`id`),
  CONSTRAINT `FKrq0lawk5fb2264sa2fbuqs34y` FOREIGN KEY (`destinos_id_fk`) REFERENCES `destinos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (2,'A Vista',600.00,1,'APROVADO',1,1,NULL),(3,'Cartao A Vista',700.00,1,'EM ANALISE',2,3,NULL),(4,'A Vista',600.00,2,'APROVADO',2,4,NULL),(5,'A Vista',700.00,1,'APROVADO',1,2,NULL),(6,'A Vista',1200.00,2,'APROVADO',1,1,NULL),(7,'A Vista',300.00,1,'APROVADO',1,4,NULL),(8,'A Vista',344.00,1,'APROVADO',1,NULL,2);
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-13 23:33:51
