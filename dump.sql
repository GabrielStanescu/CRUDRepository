-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `id` int NOT NULL,
  `iban` varchar(255) DEFAULT NULL,
  `balance` double NOT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnjuop33mo69pd79ctplkck40n` (`user_id`),
  CONSTRAINT `FKnjuop33mo69pd79ctplkck40n` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'DB09079714855445',0,'RON',1);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `age` smallint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,21,'email','Gabriel','ln','pass'),(2,71,'dignissim.pharetra@aol.com','Dominic','Cade','HFU23JWM7VY'),(3,30,'at@protonmail.ca','Guy','Henry','OGU78MJU0GS'),(4,31,'scelerisque.neque.sed@protonmail.couk','Laurel','Jared','BWC11OYX0WW'),(5,44,'cras.vehicula.aliquet@google.ca','Prescott','Regina','KQB58MNI3YP'),(6,36,'euismod@aol.com','Gareth','Kenneth','OVM56HBI5GY'),(7,47,'amet.consectetuer.adipiscing@yahoo.couk','Asher','Plato','ICJ52XNY1PH'),(8,50,'consequat.lectus@google.org','Jamalia','Brendan','GHJ22MQV7YT'),(9,56,'mauris@hotmail.net','Ina','Willa','FBT48RAT8NR'),(10,52,'hendrerit@hotmail.ca','Neil','Trevor','LBD81CMJ6BK'),(11,38,'interdum.ligula@icloud.ca','Kylie','Carl','RLU45MWU7XR'),(12,39,'turpis@outlook.net','Dexter','Indigo','WJH42QIM7BX'),(13,69,'faucibus.ut@gmail.com','Harrison','Dane','CDW27QJX7HK'),(14,20,'vestibulum.mauris@google.com','Jenette','Brock','DMZ36HHD1FL'),(15,47,'primis.in@icloud.edu','Elmo','Julian','OJQ21VDI3EJ'),(16,46,'purus.ac.tellus@protonmail.couk','Herrod','Nevada','LEL15SLV2WW'),(17,58,'laoreet.libero.et@hotmail.org','Orson','Rogan','VVJ38QON8RC'),(18,42,'vel.venenatis@gmail.org','Orli','Olivia','RUT65RTE1TO'),(19,35,'libero.dui@protonmail.couk','Rhea','Baker','LBG76RFE7LU'),(20,35,'augue.malesuada@protonmail.net','Paul','Dawn','SSY78SBX3JS'),(21,23,'ac.sem.ut@icloud.net','Stacey','Holly','TFR57CIM3GF'),(22,32,'sed@google.ca','William','Maryam','ZKP12HNP2OC'),(23,61,'orci.quis@yahoo.edu','Felicia','Roanna','RFT73RMN0MV'),(24,20,'tincidunt@hotmail.couk','Raja','Howard','NIX87ZYT6LH'),(25,48,'lorem.lorem.luctus@google.edu','Sylvia','Lareina','FGJ15IKJ5JF'),(26,39,'lacus.pede@google.couk','Dolan','Vivian','HMC55IGG5TZ'),(27,64,'duis.dignissim.tempor@google.edu','Graham','Garrison','GGN18KRB0UU'),(28,61,'consequat.lectus@google.edu','Renee','Steel','TJN45FLW7IT'),(29,47,'arcu@outlook.couk','Nissim','Amy','TFB46KPW4EV'),(30,48,'nam.ac.nulla@google.couk','Marsden','Wing','BGL23LLM7SM'),(31,70,'malesuada.vel.convallis@yahoo.org','Branden','Cheyenne','VNO55TVH7EO'),(32,23,'turpis.non.enim@google.net','Oprah','Nola','JEN43MMI3QH'),(33,57,'vitae.sodales@icloud.org','Kenneth','Andrew','YTB13QDP2GD'),(34,47,'vehicula.pellentesque@google.net','Grant','Amos','XLQ65RND3TU'),(35,77,'velit.quisque.varius@outlook.ca','Kylie','Igor','JZP81ICF3RJ'),(36,34,'dignissim.maecenas@icloud.edu','Dalton','Hiram','TXX13KOL6BG'),(37,46,'arcu.ac@google.net','Deanna','Velma','CHT71QOM3EY'),(38,53,'sagittis.nullam.vitae@google.org','Lynn','Olympia','OVD71GRQ0QI'),(39,36,'magnis@aol.ca','Nathan','Wilma','HCE81AIJ7ER'),(40,27,'nec.euismod@aol.org','Laith','Stuart','PVP23GJN3DD'),(41,78,'est@icloud.com','Abel','Lillith','YSL56WHX9KY'),(42,60,'justo.proin@outlook.net','Gray','Amelia','WQK35RCR4XW'),(43,74,'montes.nascetur.ridiculus@icloud.edu','Russell','Honorato','LRK21HXM9QJ'),(44,79,'et.magnis.dis@aol.ca','Rudyard','Clayton','RTD76GGI5NW'),(45,61,'phasellus.ornare@outlook.net','Warren','Evan','MYJ53IEB5RC'),(46,46,'dui.suspendisse@aol.ca','Yael','Upton','UWQ15AEL9UY'),(47,24,'dictum.sapien@hotmail.edu','Lacey','Ella','WID92LGK6AT'),(48,78,'tincidunt.vehicula@hotmail.com','Raphael','Colleen','EJI73VQS1QD'),(49,28,'phasellus.libero@hotmail.org','Jolene','Colleen','QNO36NYO7LM'),(50,80,'dapibus.id@protonmail.org','Arden','Karleigh','QSF44SYB7AH'),(51,35,'elit.nulla@icloud.edu','Prescott','Sandra','BXP03ZCY8WI'),(52,80,'mi.duis.risus@outlook.edu','Kaseem','Channing','RPY15LYB5YW'),(53,39,'maecenas.libero.est@icloud.org','Belle','Pearl','EXW73EHV7UN'),(54,39,'lorem@yahoo.org','Nadine','Abdul','VCL66RSY7CO'),(55,75,'lacus.vestibulum@aol.com','Reece','Pascale','ETK63LWP4RF'),(56,33,'justo.nec@icloud.couk','Chase','Tyrone','CRQ14OGS0MY'),(57,49,'sed.eu.eros@icloud.ca','Samson','Yetta','UIA83BCP8LB'),(58,60,'in.felis@google.edu','Michael','Felix','FLT13ZQS1HL'),(59,5,'cum.sociis@protonmail.ca','Cameron','Molly','LGE72KLA2GS'),(60,59,'turpis@aol.couk','Arden','Maryam','XTE08KQJ1EG'),(61,25,'et.tristique@google.net','Amelia','Susan','WHY82TWM6ZH'),(62,29,'ornare@yahoo.net','Erich','Adrienne','CWG86EBW9VQ'),(63,13,'lorem.sit.amet@icloud.com','Burke','Wade','LXH63LCG5NW'),(64,35,'vel.nisl.quisque@outlook.com','Charity','Yasir','OCM28QFK5WB'),(65,45,'lectus.nullam@outlook.com','Martena','Hadassah','KPO24OKB3XN'),(66,64,'conubia.nostra@yahoo.org','Alden','Ruby','AEE84ZXX1VF'),(67,35,'aliquam.nisl@aol.edu','Murphy','Amaya','HFO67EAA8PL'),(68,44,'penatibus.et.magnis@google.org','Marshall','Holmes','TMK82GPN3MQ'),(69,5,'orci@hotmail.org','Kitra','Genevieve','BHD52UPH5OU'),(70,57,'nullam.vitae@hotmail.com','Lee','Amery','KZS97NSR4PU'),(71,53,'purus.accumsan@aol.couk','Joseph','Scarlet','JNU23ZRP1WQ'),(72,4,'tristique.ac@icloud.net','Inez','Vladimir','WIN82TYD8MK'),(73,61,'semper@outlook.com','Jack','Lysandra','NFM88FHP2ED'),(74,59,'ut@yahoo.net','Grant','Alika','DBT35HKI1EB'),(75,2,'penatibus.et@icloud.edu','Nigel','Dominique','VEL88NBQ5CY'),(76,75,'sed.turpis@outlook.edu','Dillon','Kennedy','BQO21DDZ6UY'),(77,47,'donec.tincidunt.donec@yahoo.org','Lydia','Jackson','VEK72HBH8JM'),(78,56,'dictum.placerat@outlook.ca','Gabriel','Allen','RUQ20YRV4AK'),(79,0,'orci.in.consequat@google.net','Holly','Anika','ENP44WVP0MJ'),(80,48,'aliquam@yahoo.com','Ignatius','Marshall','JGJ72UKB0FJ'),(81,44,'ut.sagittis.lobortis@yahoo.org','Ferdinand','Savannah','ELV18XJF7TO'),(82,41,'elit.pretium@google.ca','Dexter','Iliana','MLC81UNK6IA'),(83,19,'ac.urna@yahoo.ca','Gisela','Christian','FCB56MHP8HO'),(84,50,'vitae.semper@aol.couk','Cheryl','Abbot','EVC75FXC3HR'),(85,33,'gravida.sagittis.duis@icloud.net','Ainsley','Audrey','LKF96OWF1MH'),(86,43,'luctus.et.ultrices@aol.edu','Jerome','Drake','ONV89AVN4ZI'),(87,46,'ipsum.ac.mi@protonmail.org','Savannah','Chase','JSH54KTP0GX'),(88,38,'elit@outlook.com','Timothy','Rashad','URX37DGA6VX'),(89,46,'arcu.nunc.mauris@icloud.edu','Demetrius','Jonas','URW23ECU0WK'),(90,28,'eget@aol.edu','Mallory','Branden','WIK30IHE6WY'),(91,48,'risus@protonmail.org','Axel','Cheyenne','UHS60LMD5NV'),(92,4,'arcu.iaculis.enim@outlook.ca','Charde','Keiko','LBN15WJZ8TC'),(93,28,'orci@outlook.ca','Deanna','Quinlan','HUD87WVF9DU'),(94,21,'a@aol.com','Cruz','Nasim','GUG15JFD7EH'),(95,40,'a@yahoo.org','Patrick','Merrill','CHO19UOP0FC'),(96,73,'orci.sem@google.net','Roth','Prescott','MWT89JYB7WE'),(97,0,'sit.amet@google.ca','Yuli','Christian','TCN80ETR5XU'),(98,45,'vitae@protonmail.couk','Sopoline','Rogan','UDK77INS4YC'),(99,31,'semper.dui@protonmail.org','Sophia','Moana','RGP52OIV5FF'),(100,15,'eu.metus@icloud.edu','Chiquita','Ginger','NXV95GQZ6JO'),(101,46,'feugiat.metus@google.ca','Sybill','Kylee','AKU29MTD2NH'),(102,22,'enim.nec@yahoo.org','Buffy','Hashim','PYW65TWF7ER'),(103,32,'vitae.diam@outlook.couk','Zane','Josephine','JAH16ZQC3FS'),(104,9,'lorem.lorem@google.com','Ira','Athena','CJE16HKJ7EO'),(105,11,'vehicula@protonmail.org','Lewis','Tasha','AOP58OCT7VS'),(106,27,'erat.vivamus.nisi@hotmail.com','Colby','Jemima','HNF59KCC6OT'),(107,74,'tincidunt@hotmail.couk','Ulric','Amaya','VJN57AJP5RH'),(108,31,'velit@protonmail.couk','Craig','Nora','MOP35YJH7EK'),(109,56,'posuere@outlook.com','Austin','Lavinia','DNB62AAJ5XT'),(110,24,'mus@google.couk','Bevis','Michelle','GZS69CBC5QQ'),(111,70,'eros.turpis@aol.org','Katell','India','YFJ64OBU2NB'),(112,78,'pretium@google.com','Joseph','Rose','BMD84GJI2JY'),(113,22,'libero.et@google.net','Madeline','Byron','HFY28NHA1OX'),(114,3,'consectetuer.cursus@google.com','Chastity','Priscilla','EVT72XXV3MY'),(115,49,'nulla.in@outlook.edu','Melvin','Rina','SNE43VHV3SE'),(116,40,'cursus.nunc@yahoo.org','Fritz','Aladdin','QYW72YUQ9ES'),(117,64,'dapibus.gravida.aliquam@protonmail.ca','Levi','Kay','LKA37XYK1YB'),(118,79,'vestibulum.ut@hotmail.org','Avram','Tashya','ELC18QXX1CG'),(119,8,'non.lorem.vitae@google.couk','Serena','Branden','MOW07YYV7XY'),(120,65,'at.fringilla@google.net','Vivien','Louis','OWH02FHG7TJ'),(121,48,'tincidunt.dui@aol.edu','Wallace','Hoyt','USE31CRW2BG'),(122,19,'eu.ultrices@icloud.couk','Mannix','Xander','DUT51JMF8HG'),(123,9,'tincidunt.congue@protonmail.org','Mara','Damon','WFB48TPR8UL'),(124,11,'netus.et@icloud.edu','Amery','Jessamine','UFV42DSC7SE'),(125,33,'augue.scelerisque@icloud.ca','Graham','Laurel','KUF37FJC6NM'),(126,49,'velit.pellentesque@protonmail.org','Marny','Vincent','DQT47RYM8JR'),(127,49,'mauris.sit@aol.net','Ruby','Valentine','DLX33UIM6OV'),(128,4,'posuere@protonmail.org','Ira','Emmanuel','VNO62TXB7GK'),(129,36,'sit@outlook.org','Vielka','Kyra','HCM61UAC6UY'),(130,32,'accumsan@aol.ca','Tad','Kim','GVE67XXG2UO'),(131,22,'enim@aol.com','Dante','Debra','NDF85UNY2HB'),(132,55,'luctus@yahoo.ca','Rana','Ulric','XAT59QGG6UJ'),(133,66,'vitae.mauris.sit@google.edu','Remedios','Kelly','CTL80JIW9HN'),(134,55,'odio.aliquam@outlook.ca','Aimee','Thaddeus','KPN21YZH4UM'),(135,49,'ligula.aliquam@aol.org','Dexter','Ashton','AJL28TSW2GD'),(136,45,'sodales.mauris@outlook.com','Ann','Latifah','XRY79PXS7XI'),(137,2,'mauris.vestibulum@outlook.net','Madonna','Aspen','NTG77RSX0KK'),(138,16,'sem.egestas.blandit@protonmail.couk','Jana','Reed','KFJ72FIK6AI'),(139,15,'condimentum.donec.at@aol.net','Ursula','Graiden','IBI44ZSB6RQ'),(140,8,'donec.est@protonmail.ca','Karina','Cassady','IUX33WWX4BQ'),(141,32,'adipiscing.elit@protonmail.com','Slade','Thor','WGU55MYA1ZB'),(142,79,'erat.etiam@protonmail.ca','Guy','Rashad','CDY76BRY6BZ'),(143,7,'ac.feugiat@yahoo.org','Amena','Alyssa','TIB81FZB5UC'),(144,33,'nulla.interdum@outlook.com','Austin','Sylvester','EXM15GKH2BD'),(145,64,'risus.quis.diam@icloud.couk','Walter','Noel','JTH23ZYQ2AP'),(146,72,'amet.ante@google.ca','Chaney','Vera','DCG09NZR8PU'),(147,69,'semper.erat@yahoo.com','Herrod','Grant','ANT48UYU7WW'),(148,67,'posuere.enim@icloud.com','Miriam','Ria','RVQ64TUE3KS'),(149,22,'ipsum.phasellus.vitae@aol.org','Malik','Dean','YZA76TJL2EN'),(150,15,'turpis.aliquam@outlook.org','Felicia','Samson','YUY17YZX2GH'),(151,31,'mail','FirstName','ln','123'),(152,31,'mail','FirstName','ln','123'),(153,31,'mail','FirstName','ln','123'),(154,31,'mail','FirstName','ln','123'),(155,31,'mail','FirstName','ln','123'),(156,31,'mail','FirstName','ln','123'),(157,31,'mail','FirstName','ln','123'),(158,31,'mail','FirstName','ln','123'),(159,31,'mail','FirstName','ln','123'),(160,31,'mail','FirstName','ln','123'),(161,31,'mail','FirstName','ln','123'),(162,31,'mail','FirstName','ln','123'),(163,31,'mail','FirstName','ln','123'),(164,31,'mail','FirstName','ln','123');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-21  2:51:38
