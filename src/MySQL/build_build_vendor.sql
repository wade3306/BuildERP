CREATE DATABASE  IF NOT EXISTS `build` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `build`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: build
-- ------------------------------------------------------
-- Server version	5.7.31-log

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
-- Table structure for table `build_vendor`
--

DROP TABLE IF EXISTS `build_vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `build_vendor` (
  `build_B_id` int(11) NOT NULL AUTO_INCREMENT,
  `build_B_name` varchar(45) DEFAULT NULL,
  `build_B_editor` varchar(45) DEFAULT NULL,
  `build_B_date` longtext,
  `build_B_service` varchar(45) DEFAULT NULL,
  `build_B_unitprice` double DEFAULT NULL,
  `build_B_quantity` double DEFAULT NULL,
  `build_B_discount` double DEFAULT NULL,
  `build_B_sum` double DEFAULT NULL,
  `build_B_cooperation` varchar(45) DEFAULT NULL,
  `build_B_arrears` varchar(45) DEFAULT NULL,
  `build_B_remind` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`build_B_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `build_vendor`
--

LOCK TABLES `build_vendor` WRITE;
/*!40000 ALTER TABLE `build_vendor` DISABLE KEYS */;
INSERT INTO `build_vendor` VALUES (1,'新綠主義','647513','0109-05-20','水電',500,100,0.9,45000,'竹城甲子園','1','近期進場'),(2,'興富發','26642','0109-01-07','結構',2000,50,0.9,90000,'最上城','0','無'),(3,'綠能楊泰','64821','2020-11-18','綠能發電',400,100,0.8,32000,'甲子園','1','老闆跑路'),(4,'WNBA','264895','2020-10-30','籃球',50,100,0,0,'America','0','女籃'),(5,'國強防水','6493517','2020-10-27','防水',500,500,0.99,247500,'新光三越','0','無');
/*!40000 ALTER TABLE `build_vendor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-13 13:51:15
