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
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `example_product`
--

LOCK TABLES `example_product` WRITE;
/*!40000 ALTER TABLE `example_product` DISABLE KEYS */;
INSERT INTO `example_product` VALUES (34,'Blush',100.00,'Makeup',3,NULL,1,99,100),(35,'Eyeshadow',100.00,'Makeup',1,NULL,1,19,20),(36,'Pants',50.00,'Clothes',2,NULL,NULL,NULL,300),(37,'Spatula',10.00,'Kitchen',3,NULL,2,0,2);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `before_insert_order` BEFORE INSERT ON `orders` FOR EACH ROW BEGIN
    DECLARE maxOrderNumber INT;

   
    SELECT COALESCE(MAX(orderNumber), 0) INTO maxOrderNumber
    FROM orders
    WHERE uzerId = NEW.uzerId;

    
    SET NEW.orderNumber = maxOrderNumber + 1;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_order_details`
--

LOCK TABLES `user_order_details` WRITE;
/*!40000 ALTER TABLE `user_order_details` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertable`
--

LOCK TABLES `usertable` WRITE;
/*!40000 ALTER TABLE `usertable` DISABLE KEYS */;
INSERT INTO `usertable` VALUES (1,'Seller','Seller','adminSeller',NULL,NULL);
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

-- Dump completed on 2025-01-16  3:59:01
