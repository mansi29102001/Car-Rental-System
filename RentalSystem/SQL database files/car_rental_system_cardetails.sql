-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: car_rental_system
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `cardetails`
--

DROP TABLE IF EXISTS `cardetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cardetails` (
  `ownerName` varchar(255) NOT NULL,
  `model` varchar(45) DEFAULT NULL,
  `carNumber` varchar(45) NOT NULL,
  `fuelType` varchar(45) DEFAULT NULL,
  `mileage` varchar(45) DEFAULT NULL,
  `no_of_passenger` int DEFAULT NULL,
  `cost_per_hour` int DEFAULT NULL,
  `cost_per_day` int DEFAULT NULL,
  PRIMARY KEY (`carNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardetails`
--

LOCK TABLES `cardetails` WRITE;
/*!40000 ALTER TABLE `cardetails` DISABLE KEYS */;
INSERT INTO `cardetails` VALUES ('Harshat sharma','Wagnor','AB 4568','CNG','56km/hr',4,80,990),('Mansi Bhondave','Alto 800','AX 89N6789','Petrol','',3,100,1000),('XYZ','Alto','BV5678e34','Petrol','34km/hr',3,50,700),('Jatin','Wagnor','CV6732y1','CNG','67km/hr',4,40,999);
/*!40000 ALTER TABLE `cardetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-13  2:35:07
