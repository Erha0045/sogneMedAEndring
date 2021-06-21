DROP TABLE IF EXISTS `kommune`;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kommune` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `navn` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kommune`
--

LOCK TABLES `kommune` WRITE;
/*!40000 ALTER TABLE `kommune` DISABLE KEYS */;
INSERT INTO `kommune` VALUES (1,'ballerup'),(2,'herlev');
/*!40000 ALTER TABLE `kommune` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sogne`
--

DROP TABLE IF EXISTS `sogne`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sogne` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `navn` varchar(255) DEFAULT NULL,
                         `nedlukning_start` datetime(6) DEFAULT NULL,
                         `smittetryk` double NOT NULL,
                         `sognekode` int NOT NULL,
                         `kommune_id` int NOT NULL,
                         PRIMARY KEY (`id`),
                         KEY `FKm00yad5mm2889ypdkb11dj47s` (`kommune_id`),
                         CONSTRAINT `FKm00yad5mm2889ypdkb11dj47s` FOREIGN KEY (`kommune_id`) REFERENCES `kommune` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sogne`
--

LOCK TABLES `sogne` WRITE;
/*!40000 ALTER TABLE `sogne` DISABLE KEYS */;
INSERT INTO `sogne` VALUES (1,'sogn1','2021-06-02 02:00:00.000000',1,1,1),(2,'sogn1','2021-07-02 02:00:00.000000',1,1,1),(3,'sogn2','2021-06-23 02:00:00.000000',3,2,1),(4,'sogn3','2021-06-24 02:00:00.000000',5,4,2);
/*!40000 ALTER TABLE `sogne` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-10 20:49:53