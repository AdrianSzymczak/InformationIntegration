-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: infointegration
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `Id` int(11) DEFAULT NULL,
  `ISO` text,
  `Country` text,
  `Incoming Group` text,
  `Region` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'ATG','Antigua and Barbuda','null','null'),(0,'BLR','Belarus','null','null'),(0,'KGZ','Kyrgyz Republic','null','null'),(0,'FSM','Micronesia','null','null'),(0,'KSV','Kosovo','null','null'),(0,'TKM','Turkmenistan','null','null'),(0,'MAR','Morocco','null','null'),(0,'PRI','Puerto Rico',' ',' '),(0,'DZA','Algeria','Upper middle income','Middle East comma North Africa comma and Pakistan'),(0,'GIN','Guinea','null','null'),(0,'NPL','Nepal','null','null'),(0,'MCO','Monaco','null','null'),(0,'SLB','Solomon Islands','null','null'),(0,'GNQ','Equatorial Guinea','null','null'),(0,'TCD','Chad','null','null'),(0,'PNG','Papua New Guinea','null','null'),(0,'TON','Tonga','null','null'),(0,'VUT','Vanuatu','null','null'),(0,'ADO','Andorra','null','null'),(0,'THA','Thailand','Upper middle income','Emerging and Developing Asia'),(0,'UKR','Ukraine','Lower middle income','Commonwealth of Independent States'),(0,'TLS','Timor minus sign Leste','Lower middle income','Emerging and Developing Asia'),(0,'LIE','Liechtenstein','null','null'),(0,'URY','Uruguay','High income colon nonOECD','Latin America and the Caribbean'),(0,'DJI','Djibouti','null','null'),(0,'IMY','Isle of Man','null','null'),(0,'KOR','Korea comma Rep period ','High income colon OECD','Advanced economies'),(0,'MUS','Mauritius','null','null'),(0,'ROM','Romania','null','null'),(0,'BEN','Benin','null','null'),(0,'LTU','Lithuania','High income colon nonOECD','Emerging and Developing Europe'),(0,'GNB','Guinea minus sign Bissau','null','null'),(0,'HKG','Hong Kong SAR','High income colon nonOECD','Advanced economies'),(0,'ARE','United Arab Emirates','null','null'),(0,'BEL','Belgium','High income colon OECD','Advanced economies'),(0,'MDV','Maldives','null','null'),(0,'AFG','Afghanistan','null','null'),(0,'SEN','Senegal','null','null'),(0,'LAO','Lao PDR','Lower middle income','Emerging and Developing Asia'),(0,'MDA','Moldova','Lower middle income','Commonwealth of Independent States'),(0,'TWN','Taiwan comma China',' ','Advanced economies'),(0,'TUR','Turkey','null','null'),(0,'BIH','Bosnia and Herzegovina','Upper middle income','Emerging and Developing Europe'),(0,'KHM','Cambodia','null','null'),(0,'SGP','Singapore','High income colon nonOECD','Advanced economies'),(0,'TGO','Togo','null','null'),(0,'IRN','Iran comma Islamic Rep period ','null','null'),(0,'KEN','Kenya','Low income','Sub minus sign Saharan Africa'),(0,'MMR','Myanmar','null','null'),(0,'COL','Colombia','Upper middle income','Latin America and the Caribbean'),(0,'AUT','Austria','High income colon OECD','Advanced economies'),(0,'PAK','Pakistan','Lower middle income','Middle East comma North Africa comma and Pakistan'),(0,'TZA','Tanzania','null','null'),(0,'FRO','Faeroe Islands','null','null'),(0,'GRC','Greece','null','null'),(0,'BHS','The Bahamas','null','null'),(0,'UZB','Uzbekistan','null','null'),(0,'MHL','Marshall Islands','null','null'),(0,'OMN','Oman','null','null'),(0,'TUN','Tunisia','Upper middle income','Middle East comma North Africa comma and Pakistan'),(0,'ARG','Argentina','Upper middle income','Latin America and the Caribbean'),(0,'GHA','Ghana','Lower middle income','Sub minus sign Saharan Africa'),(0,'FRA','France','High income colon OECD','Advanced economies'),(0,'ZWE','Zimbabwe','Low income','Sub minus sign Saharan Africa'),(0,'WSM','Samoa','null','null'),(0,'CYP','Cyprus','null','null'),(0,'NOR','Norway','null','null'),(0,'SUR','Suriname','null','null'),(0,'HUN','Hungary','Upper middle income','Emerging and Developing Europe'),(0,'USA','United States','High income colon OECD','Advanced economies'),(0,'FJI','Fiji','null','null'),(0,'BFA','Burkina Faso','Low income','Sub minus sign Saharan Africa'),(0,'SSD','South Sudan','null','null'),(0,'SWE','Sweden','null','null'),(0,'CRI','Costa Rica','Upper middle income','Latin America and the Caribbean'),(0,'COD','Democratic Republic of the Congo','null','null'),(0,'POL','Poland','null','null'),(0,'VEN','Venezuela','null','null'),(0,'FIN','Finland','High income colon OECD','Advanced economies'),(0,'NER','Niger','null','null'),(0,'LCA','St period Lucia','null','null'),(0,'COM','Comoros','null','null'),(0,'RWA','Rwanda','null','null'),(0,'GAB','Gabon','null','null'),(0,'GMB','Gambia comma The','Low income','Sub minus sign Saharan Africa'),(0,'GTM','Guatemala','null','null'),(0,'SAU','Saudi Arabia','High income colon nonOECD','Middle East comma North Africa comma and Pakistan'),(0,'LBY','Libya','null','null'),(0,'LBR','Liberia','Low income','Sub minus sign Saharan Africa'),(0,'SYR','Syria','null','null'),(0,'ALB','Albania','Upper middle income','Emerging and Developing Europe'),(0,'JPN','Japan','High income colon OECD','Advanced economies'),(0,'SVN','Slovenia','High income colon OECD','Advanced economies'),(0,'MRT','Mauritania','null','null'),(0,'BWA','Botswana','Upper middle income','Sub minus sign Saharan Africa'),(0,'MOZ','Mozambique','null','null'),(0,'SLV','El Salvador','Lower middle income','Latin America and the Caribbean'),(0,'GBR','United Kingdom','null','null'),(0,'BRN','Brunei Darussalam','High income colon nonOECD','Emerging and Developing Asia'),(0,'CAF','Central African Republic','null','null'),(0,'LUX','Luxembourg','null','null'),(0,'BRA','Brazil','Upper middle income','Latin America and the Caribbean'),(0,'UGA','Uganda','Low income','Sub minus sign Saharan Africa'),(0,'ISR','Israel','null','null'),(0,'ITA','Italy','null','null'),(0,'KNA','St period Kitts and Nevis','null','null'),(0,'DOM','Dominican Republic','Upper middle income','Latin America and the Caribbean'),(0,'TJK','Tajikistan','Low income','Commonwealth of Independent States'),(0,'NIC','Nicaragua','null','null'),(0,'PLW','Palau','null','null'),(0,'GRL','Greenland','null','null'),(0,'QAT','Qatar','High income colon nonOECD','Middle East comma North Africa comma and Pakistan'),(0,'IRQ','Iraq','null','null'),(0,'VNM','Vietnam','null','null'),(0,'IRL','Ireland','null','null'),(0,'SMR','San Marino','null','null'),(0,'BGD','Bangladesh','Low income','Emerging and Developing Asia'),(0,'EGY','Egypt','Lower middle income','Middle East comma North Africa comma and Pakistan'),(0,'AUS','Australia','null','null'),(0,'ESP','Spain','null','null'),(0,'MYS','Malaysia','Upper middle income','Emerging and Developing Asia'),(0,'MLT','Malta','null','null'),(0,'BLZ','Belize','null','null'),(0,'IDN','Indonesia','Lower middle income','Emerging and Developing Asia'),(0,'SLE','Sierra Leone','null','null'),(0,'CZE','Czech Republic','High income colon OECD','Advanced economies'),(0,'JOR','Jordan','null','null'),(0,'ETH','Ethiopia','Low income','Sub minus sign Saharan Africa'),(0,'DMA','Dominica','null','null'),(0,'CIV','Ivory Coast','Lower middle income','Sub minus sign Saharan Africa'),(0,'AGO','Angola','null','null'),(0,'LBN','Lebanon','Upper middle income','Middle East comma North Africa comma and Pakistan'),(0,'SRB','Serbia','Upper middle income','Emerging and Developing Europe'),(0,'CMR','Cameroon','Lower middle income','Sub minus sign Saharan Africa'),(0,'HTI','Haiti','Low income','Latin America and the Caribbean'),(0,'CHL','Chile','High income colon OECD','Latin America and the Caribbean'),(0,'DNK','Denmark','null','null'),(0,'HND','Honduras','null','null'),(0,'KWT','Kuwait','null','null'),(0,'EST','Estonia','null','null'),(0,'KAZ','Kazakhstan','Upper middle income','Commonwealth of Independent States'),(0,'MEX','Mexico','Upper middle income','Latin America and the Caribbean'),(0,'MNG','Mongolia','Lower middle income','Emerging and Developing Asia'),(0,'MKD','Macedonia comma FYR','Upper middle income','Emerging and Developing Europe'),(0,'ARM','Armenia','null','null'),(0,'NAM','Namibia','null','null'),(0,'CHE','Switzerland','null','null'),(0,'PRT','Portugal','High income colon OECD','Advanced economies'),(0,'MDG','Madagascar','Low income','Sub minus sign Saharan Africa'),(0,'ZMB','Zambia','Lower middle income','Sub minus sign Saharan Africa'),(0,'BDI','Burundi','Low income','Sub minus sign Saharan Africa'),(0,'CPV','Cape Verde','Lower middle income','Sub minus sign Saharan Africa'),(0,'MLI','Mali','Low income','Sub minus sign Saharan Africa'),(0,'NZL','New Zealand','null','null'),(0,'VCT','St period Vincent and the Grenadines','null','null'),(0,'IND','India','Lower middle income','Emerging and Developing Asia'),(0,'YEM','Yemen','null','null'),(0,'MWI','Malawi','Low income','Sub minus sign Saharan Africa'),(0,'BGR','Bulgaria','null','null'),(0,'STP','S o Tom and Pr ncipe','null','null'),(0,'CAN','Canada','null','null'),(0,'PHL','Philippines','Lower middle income','Emerging and Developing Asia'),(0,'RUS','Russian Federation','High income colon nonOECD','Commonwealth of Independent States'),(0,'BTN','Bhutan','Lower middle income','Emerging and Developing Asia'),(0,'BOL','Bolivia','null','null'),(0,'COG','Republic of Congo','null','null'),(0,'LKA','Sri Lanka','Lower middle income','Emerging and Developing Asia'),(0,'PRY','Paraguay','Lower middle income','Latin America and the Caribbean'),(0,'LVA','Latvia','null','null'),(0,'PAN','Panama','Upper middle income','Latin America and the Caribbean'),(0,'SYC','Seychelles','null','null'),(0,'NGA','Nigeria','null','null'),(0,'GEO','Georgia','null','null'),(0,'SDN','Sudan','null','null'),(0,'BHR','Bahrain','High income colon nonOECD','Middle East comma North Africa comma and Pakistan'),(0,'GUY','Guyana','Lower middle income','Latin America and the Caribbean'),(0,'ISL','Iceland','High income colon OECD','Advanced economies'),(0,'CHI','Channel Islands','null','null'),(0,'ERI','Eritrea','null','null'),(0,'ZAF','South Africa','null','null'),(0,'TTO','Trinidad and Tobago','null','null'),(0,'MNE','Montenegro','Upper middle income','Emerging and Developing Europe'),(0,'AZE','Azerbaijan','Upper middle income','Commonwealth of Independent States'),(0,'HRV','Croatia','High income colon nonOECD','Emerging and Developing Europe'),(0,'JAM','Jamaica','null','null'),(0,'SVK','Slovak Republic','null','null'),(0,'PER','Peru','Upper middle income','Latin America and the Caribbean'),(0,'NLD','Netherlands','null','null'),(0,'KIR','Kiribati','null','null'),(0,'BRB','Barbados','High income colon nonOECD','Latin America and the Caribbean'),(0,'ECU','Ecuador','Upper middle income','Latin America and the Caribbean'),(0,'SWZ','Swaziland','Lower middle income','Sub minus sign Saharan Africa'),(0,'LSO','Lesotho','null','null'),(0,'TUV','Tuvalu','null','null'),(0,'GRD','Grenada','null','null'),(0,'CHN','China','null','null'),(0,'DEU','Germany','High income colon OECD','Advanced economies'),(0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-12 16:25:31
