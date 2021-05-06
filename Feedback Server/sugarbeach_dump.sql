-- MySQL dump 10.13  Distrib 8.0.24, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: sugar_beach
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `question_id` int DEFAULT NULL,
  `answer` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` (`id`, `question_id`, `answer`) VALUES (34,1,'Social Media'),(35,1,'Friends or Family'),(36,1,'Advertisement'),(37,16,'First time'),(38,16,'Once a week'),(39,16,'Once a month'),(40,17,'Pizza'),(41,17,'Sea Foods'),(42,17,'Burgers'),(43,18,'Sri Lanka Style'),(44,18,'Indian Style'),(45,18,'American'),(46,19,'Yes'),(47,19,'No'),(48,19,'May be'),(49,20,'Yes'),(50,20,'No'),(51,20,'Yes, But not enough'),(52,21,'Satisfied'),(53,21,'Unsatisfied'),(54,21,'Need to imporve service');
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(200) DEFAULT NULL,
  `answer_id` int DEFAULT NULL,
  `received_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` (`id`, `customer_name`, `answer_id`, `received_date`) VALUES (1,'lakitha',34,'2021-05-01 14:22:35'),(2,'prabudh',35,NULL),(3,'m a',35,NULL),(4,'pawan',36,'2021-05-02 17:33:34'),(5,'lakitha',34,'2021-05-03 21:17:36'),(6,'lakitha',39,'2021-05-03 21:17:36'),(7,'lakitha',41,'2021-05-03 21:17:36'),(8,'lakitha',45,'2021-05-03 21:17:36'),(9,'lakitha',47,'2021-05-03 21:17:36'),(10,'lakitha',51,'2021-05-03 21:17:36'),(11,'lakitha',53,'2021-05-03 21:17:36'),(12,'q',35,'2021-05-04 22:21:23'),(13,'q',39,'2021-05-04 22:21:23'),(14,'q',41,'2021-05-04 22:21:23'),(15,'q',43,'2021-05-04 22:21:23'),(16,'q',48,'2021-05-04 22:21:23'),(17,'q',51,'2021-05-04 22:21:23'),(18,'q',53,'2021-05-04 22:21:23'),(19,'lakitha',34,'2021-05-06 10:42:10'),(20,'lakitha',38,'2021-05-06 10:42:10'),(21,'lakitha',41,'2021-05-06 10:42:10'),(22,'lakitha',44,'2021-05-06 10:42:10'),(23,'lakitha',48,'2021-05-06 10:42:10'),(24,'lakitha',51,'2021-05-06 10:42:10'),(25,'lakitha',53,'2021-05-06 10:42:10'),(26,'lakitha',34,'2021-05-06 11:13:15'),(27,'lakitha',38,'2021-05-06 11:13:15'),(28,'lakitha',41,'2021-05-06 11:13:15'),(29,'lakitha',43,'2021-05-06 11:13:15'),(30,'lakitha',46,'2021-05-06 11:13:15'),(31,'lakitha',50,'2021-05-06 11:13:15'),(32,'lakitha',53,'2021-05-06 11:13:15');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `question` varchar(200) DEFAULT NULL,
  `type` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` (`id`, `question`, `type`) VALUES (1,'How did you hear about us?','check_box'),(16,'How often do you visit our restaurant?','check_box'),(17,'What did you like about the menu?','check_box'),(18,'Which type of pizza do you prefer?','check_box'),(19,'Was the preparation of your meal satisfactory?','check_box'),(20,'Was the service welcoming and friendly?','check_box'),(21,'How did you feel about the speed of service?','check_box');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `role` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `role`) VALUES (1,'lakitha','$2a$10$OMsGKUTLZzAR6c6p9sdoXe4IU2VSFJMhllpCIu/i.Q8DhraZmu55C','ADMIN');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-06 17:42:39
