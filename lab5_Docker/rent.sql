-- MySQL dump 10.18  Distrib 10.3.27-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: rent_CARS
-- ------------------------------------------------------
-- Server version	10.3.27-MariaDB-0+deb10u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `rent_CARS`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `rent_CARS` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `rent_CARS`;

--
-- Table structure for table `Car_Hold`
--

DROP TABLE IF EXISTS `Car_Hold`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Car_Hold` (
  `carid` varchar(20),
  `username` varchar(50) DEFAULT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`carid`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Car_Hold`
--

LOCK TABLES `Car_Hold` WRITE;
/*!40000 ALTER TABLE `Car_Hold` DISABLE KEYS */;
/*!40000 ALTER TABLE `Car_Hold` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_Car_Rent`
--

DROP TABLE IF EXISTS `User_Car_Rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_Car_Rent (
  `carid` VARCHAR(20),
  `username` varchar(50) DEFAULT NULL,
  `borrowDate` date NOT NULL,
  PRIMARY KEY (`carid`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_Car_Rent`
--

LOCK TABLES `User_Car_Rent` WRITE;
/*!40000 ALTER TABLE `User_Car_Rent` DISABLE KEYS */;
INSERT INTO `User_Car_Rent` VALUES ('223344','KazumaK','2021-04-15'), ('334455','GoroGoro','2021-04-15');
/*!40000 ALTER TABLE `User_Car_Rent` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-05  1:05:33
