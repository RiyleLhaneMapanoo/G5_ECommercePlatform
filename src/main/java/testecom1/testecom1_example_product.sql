-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: testecom1
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `example_product`
--

DROP TABLE IF EXISTS `example_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `example_product` (
  `productID` int NOT NULL AUTO_INCREMENT,
  `productName` varchar(200) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `category` varchar(200) DEFAULT NULL,
  `ratings` int DEFAULT NULL,
  `productPhoto` blob,
  `productQuantityBought` int DEFAULT NULL,
  `productStockQuantityLeft` int DEFAULT NULL,
  `productOriginalStock` int DEFAULT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `example_product`
--

LOCK TABLES `example_product` WRITE;
/*!40000 ALTER TABLE `example_product` DISABLE KEYS */;
INSERT INTO `example_product` VALUES (22,'Cologne',300.00,'Makeup',3,NULL,NULL,NULL,3),(23,'Blush',50.00,'Makeup',3,NULL,NULL,NULL,3),(24,'Peplum Top',400.00,'Clothes',4,NULL,NULL,NULL,4),(25,'Pants',200.00,'Clothes',1,NULL,NULL,NULL,1),(26,'Utensils',250.00,'Kitchen',3,NULL,NULL,NULL,3),(27,'Pencil',5.00,'Makeup',2,NULL,NULL,NULL,2),(28,'Notebook',15.00,'School Supplies',4,NULL,NULL,NULL,4),(29,'Contour',500.00,'Makeup',2,NULL,NULL,NULL,2),(30,'vsdfsdf',1.00,'Makeup',1,NULL,NULL,NULL,1),(31,'Hat',3.00,'Makeup',1,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `example_product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-13  1:42:59
