-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: horario
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `areatrabajo`
--

DROP TABLE IF EXISTS `areatrabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `areatrabajo` (
  `idareatrabajo` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idareatrabajo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areatrabajo`
--

LOCK TABLES `areatrabajo` WRITE;
/*!40000 ALTER TABLE `areatrabajo` DISABLE KEYS */;
INSERT INTO `areatrabajo` VALUES (1,'alfa'),(2,'beta'),(3,'gama');
/*!40000 ALTER TABLE `areatrabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cabecerapuesto`
--

DROP TABLE IF EXISTS `cabecerapuesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cabecerapuesto` (
  `idcabecerapuesto` int NOT NULL AUTO_INCREMENT,
  `idunidadmobil` int DEFAULT NULL,
  `puesto` int DEFAULT NULL,
  PRIMARY KEY (`idcabecerapuesto`),
  UNIQUE KEY `UK1wxuugj1edfxifej06gu02aq0` (`idunidadmobil`),
  KEY `FKcb89s05rfpuuiuxvr4i4pisxl` (`puesto`),
  CONSTRAINT `FKcb89s05rfpuuiuxvr4i4pisxl` FOREIGN KEY (`puesto`) REFERENCES `puesto` (`idpuesto`),
  CONSTRAINT `FKi921hh3uj97arbceyx67vr9uc` FOREIGN KEY (`idunidadmobil`) REFERENCES `unidadmobil` (`idunidadmobil`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cabecerapuesto`
--

LOCK TABLES `cabecerapuesto` WRITE;
/*!40000 ALTER TABLE `cabecerapuesto` DISABLE KEYS */;
INSERT INTO `cabecerapuesto` VALUES (73,1,6),(83,2,5),(84,3,NULL),(85,4,NULL),(86,5,NULL),(87,6,NULL),(91,NULL,NULL);
/*!40000 ALTER TABLE `cabecerapuesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `idcargo` int NOT NULL AUTO_INCREMENT,
  `nombrecargo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idcargo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'concutor'),(2,'operador'),(3,'sin cargo');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `idcategoria` int NOT NULL AUTO_INCREMENT,
  `descripcioncategoria` varchar(255) DEFAULT NULL,
  `nombrecategoria` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'moto','sn'),(2,'camioneta','sn'),(3,'persona','sn');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `idestado` int NOT NULL AUTO_INCREMENT,
  `nombreestado` varchar(255) DEFAULT NULL,
  `categoria` int DEFAULT NULL,
  PRIMARY KEY (`idestado`),
  KEY `FK28jrdkm4q96wqes4q6o4jy0tp` (`categoria`),
  CONSTRAINT `FK28jrdkm4q96wqes4q6o4jy0tp` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'disponible',3),(2,'franco',3),(3,'ocupado',3),(4,'uumm ocupada',NULL),(5,'uumm disponible',NULL);
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grado`
--

DROP TABLE IF EXISTS `grado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grado` (
  `idgrado` int NOT NULL AUTO_INCREMENT,
  `nombregrado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idgrado`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grado`
--

LOCK TABLES `grado` WRITE;
/*!40000 ALTER TABLE `grado` DISABLE KEYS */;
INSERT INTO `grado` VALUES (1,'S3'),(2,'S2'),(3,'S1'),(4,'ST3'),(5,'ST2');
/*!40000 ALTER TABLE `grado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pnp`
--

DROP TABLE IF EXISTS `pnp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pnp` (
  `cargo` int DEFAULT NULL,
  `grado` int DEFAULT NULL,
  `idareatrabajo` int DEFAULT NULL,
  `idcabecerapuesto` int DEFAULT NULL,
  `idestado` int DEFAULT NULL,
  `idpnp` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `cip` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idpnp`),
  KEY `FKpiabxj5y2sonymisey2hj5nuc` (`idareatrabajo`),
  KEY `FKj1jelkuvh3arpg1dgavps9qh1` (`idcabecerapuesto`),
  KEY `FKaoh38rkiqpj8j6rojx6ood1wr` (`cargo`),
  KEY `FKg7orvq1jdoetfyu4yblt528u4` (`idestado`),
  KEY `FK8u67jiujgghswha3nuf5h768r` (`grado`),
  CONSTRAINT `FK8u67jiujgghswha3nuf5h768r` FOREIGN KEY (`grado`) REFERENCES `grado` (`idgrado`),
  CONSTRAINT `FKaoh38rkiqpj8j6rojx6ood1wr` FOREIGN KEY (`cargo`) REFERENCES `cargo` (`idcargo`),
  CONSTRAINT `FKg7orvq1jdoetfyu4yblt528u4` FOREIGN KEY (`idestado`) REFERENCES `estado` (`idestado`),
  CONSTRAINT `FKj1jelkuvh3arpg1dgavps9qh1` FOREIGN KEY (`idcabecerapuesto`) REFERENCES `cabecerapuesto` (`idcabecerapuesto`),
  CONSTRAINT `FKpiabxj5y2sonymisey2hj5nuc` FOREIGN KEY (`idareatrabajo`) REFERENCES `areatrabajo` (`idareatrabajo`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pnp`
--

LOCK TABLES `pnp` WRITE;
/*!40000 ALTER TABLE `pnp` DISABLE KEYS */;
INSERT INTO `pnp` VALUES (2,2,1,NULL,1,1,'lala','3025022','lali'),(2,2,3,NULL,1,2,'Gomez','31941086','Carlos'),(1,2,2,NULL,1,3,'Rodriguez','31941087','Ana'),(2,2,2,NULL,1,4,'Lopez','31941088','Marta'),(1,3,2,NULL,1,5,'Martinez','31941089','Pedro'),(2,3,3,NULL,1,6,'Garcia','31941090','Lucia'),(2,3,3,NULL,1,8,'Fernandez','31941092','Miguel'),(2,4,2,NULL,1,10,'Sanchez','31941094','Daniela'),(1,4,1,83,3,11,'Morales','31941095','Roberto'),(2,4,1,NULL,1,12,'Torres','31941096','Elena'),(2,5,2,NULL,1,14,'Ramos','31941098','Ester'),(1,5,2,NULL,1,15,'Castillo','31941099','Francisco'),(2,5,1,NULL,1,16,'Vargas','31941100','Laura'),(2,1,1,NULL,1,22,'matu','gggg','jorge'),(1,1,2,NULL,1,24,'bautisra','vvv','jaime'),(1,1,1,83,3,25,'romeo','vvv11','roma'),(2,3,2,NULL,1,28,'suasveer','s','jorge'),(1,4,3,NULL,1,29,'Guarniz','75812785','Kiara'),(2,3,1,NULL,1,30,'poquemon','123123','picachu'),(2,1,1,NULL,1,31,'marco ','sss','aurelio'),(1,1,3,NULL,1,32,'pirco','lalito','tontin'),(1,1,2,NULL,1,33,'loa','losasl','dende'),(1,2,3,NULL,1,34,'Perez','31941001','piolin'),(2,2,2,NULL,1,43,'asas','00012','ssss'),(2,1,2,NULL,1,44,'Rodriguez','000123','simon'),(2,1,2,NULL,1,45,'caceres','000120','maria'),(2,2,2,NULL,1,46,'lusmila','000121','alajandra'),(1,1,1,83,3,48,'jaime','432345','peña'),(2,1,1,NULL,1,49,'magno','090099','carlos'),(2,1,3,NULL,1,50,'jorje','676776','mujica');
/*!40000 ALTER TABLE `pnp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puesto`
--

DROP TABLE IF EXISTS `puesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puesto` (
  `idpuesto` int NOT NULL AUTO_INCREMENT,
  `descripcionpuesto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idpuesto`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puesto`
--

LOCK TABLES `puesto` WRITE;
/*!40000 ALTER TABLE `puesto` DISABLE KEYS */;
INSERT INTO `puesto` VALUES (1,'Callao centro'),(2,'C. Bellavista'),(3,'C Pescador'),(4,'C.Sarita'),(5,'Callao centro'),(6,'Callao barracones'),(7,'Bellavista'),(8,'C. ciudad pescador'),(9,'La legua-c');
/*!40000 ALTER TABLE `puesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidadmobil`
--

DROP TABLE IF EXISTS `unidadmobil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidadmobil` (
  `categoriamobil` int DEFAULT NULL,
  `idunidadmobil` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `estadomobil` int DEFAULT NULL,
  PRIMARY KEY (`idunidadmobil`),
  KEY `FKftxmu8gqv0c6ssgp7mt5m447b` (`categoriamobil`),
  KEY `FKixrx2xp1s0s66lpdutjet1vrh` (`estadomobil`),
  CONSTRAINT `FKftxmu8gqv0c6ssgp7mt5m447b` FOREIGN KEY (`categoriamobil`) REFERENCES `categoria` (`idcategoria`),
  CONSTRAINT `FKixrx2xp1s0s66lpdutjet1vrh` FOREIGN KEY (`estadomobil`) REFERENCES `estado` (`idestado`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidadmobil`
--

LOCK TABLES `unidadmobil` WRITE;
/*!40000 ALTER TABLE `unidadmobil` DISABLE KEYS */;
INSERT INTO `unidadmobil` VALUES (2,1,'PL 19551',4),(2,2,'PL 20005',4),(2,3,'PL 20032',4),(2,4,'PL 20006',4),(2,5,'PL19552',4),(2,6,'PL 19565',4),(2,7,'PL 1111',5);
/*!40000 ALTER TABLE `unidadmobil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'horario'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-12 18:58:29
