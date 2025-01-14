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

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `uzerId` int NOT NULL,
  `orderNumber` int NOT NULL,
  `itemId` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`orderID`),
  KEY `uzerId` (`uzerId`),
  KEY `itemId` (`itemId`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uzerId`) REFERENCES `usertable` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`itemId`) REFERENCES `example_product` (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (33,29,1,23,1),(34,29,2,27,1),(35,29,3,22,1),(36,28,18,30,1),(37,28,19,22,2);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_order_details`
--

DROP TABLE IF EXISTS `user_order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_order_details` (
  `orderDetailId` int NOT NULL AUTO_INCREMENT,
  `orderHistoryId` int NOT NULL,
  `usherId` int NOT NULL,
  `itemId` int NOT NULL,
  `quantity` int NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`orderDetailId`),
  KEY `itemId` (`itemId`),
  KEY `user_order_details_ibfk_1` (`orderHistoryId`,`usherId`),
  CONSTRAINT `user_order_details_ibfk_1` FOREIGN KEY (`orderHistoryId`, `usherId`) REFERENCES `user_order_history` (`orderHistoryId`, `usherId`),
  CONSTRAINT `user_order_details_ibfk_2` FOREIGN KEY (`itemId`) REFERENCES `example_product` (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_order_details`
--

LOCK TABLES `user_order_details` WRITE;
/*!40000 ALTER TABLE `user_order_details` DISABLE KEYS */;
INSERT INTO `user_order_details` VALUES (1,1,28,23,1,50.00),(2,1,28,27,3,5.00),(3,1,29,23,1,50.00),(4,1,29,27,1,5.00),(5,2,28,27,3,5.00),(6,2,28,29,1,500.00);
/*!40000 ALTER TABLE `user_order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_order_history`
--

DROP TABLE IF EXISTS `user_order_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_order_history` (
  `orderHistoryId` int NOT NULL,
  `usherId` int NOT NULL,
  `totalAmount` decimal(10,2) NOT NULL,
  PRIMARY KEY (`orderHistoryId`,`usherId`),
  KEY `usherId` (`usherId`),
  CONSTRAINT `user_order_history_ibfk_1` FOREIGN KEY (`usherId`) REFERENCES `usertable` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_order_history`
--

LOCK TABLES `user_order_history` WRITE;
/*!40000 ALTER TABLE `user_order_history` DISABLE KEYS */;
INSERT INTO `user_order_history` VALUES (1,28,65.00),(1,29,55.00),(2,28,515.00);
/*!40000 ALTER TABLE `user_order_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertable`
--

DROP TABLE IF EXISTS `usertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usertable` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `contactnum` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertable`
--

LOCK TABLES `usertable` WRITE;
/*!40000 ALTER TABLE `usertable` DISABLE KEYS */;
INSERT INTO `usertable` VALUES (1,'Seller','Seller','adminSeller',NULL,NULL),(24,'ed','dsf','sdf','sdf','df'),(25,'Riyle','riyle','riylePass','130','45455'),(26,'Riyle','123','123','123','123'),(27,'dfgdfg','gfdfg','dgdfg','dfgg','dfgdfg'),(28,'gdfgdfg','s','s','grgfg','sdfsf'),(29,'ian','ian1234','raven','adobong st','12345678');
/*!40000 ALTER TABLE `usertable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-15  0:10:11
