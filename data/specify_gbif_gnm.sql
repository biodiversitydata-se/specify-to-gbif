CREATE DATABASE  IF NOT EXISTS `specify_gbif_gnm` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `specify_gbif_gnm`;
-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: specify_gbif_gnm
-- ------------------------------------------------------
-- Server version	5.7.22

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
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` datetime NOT NULL,
  `totalRecords` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `simpleDwcNrm`
--

DROP TABLE IF EXISTS `simpleDwcNrm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `simpleDwcNrm` (
  `id` varchar(128) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  `license` text,
  `rightsHolder` varchar(45) DEFAULT NULL,
  `accessRights` text,
  `bibliographicCitation` varchar(45) DEFAULT NULL,
  `references` varchar(45) DEFAULT NULL,
  `institutionID` varchar(128) DEFAULT NULL,
  `collectionID` varchar(45) DEFAULT NULL,
  `datasetID` varchar(45) DEFAULT NULL,
  `institutionCode` varchar(64) DEFAULT NULL,
  `collectionCode` varchar(50) DEFAULT NULL,
  `datasetName` text,
  `ownerInstitutionCode` varchar(45) DEFAULT NULL,
  `basisOfRecord` varchar(32) DEFAULT NULL,
  `informationWithheld` varchar(45) DEFAULT NULL,
  `dataGeneralizations` varchar(45) DEFAULT NULL,
  `dynamicProperties` varchar(45) DEFAULT NULL,
  `occurrenceID` varchar(45) DEFAULT NULL,
  `catalogNumber` varchar(32) DEFAULT NULL,
  `recordNumber` varchar(45) DEFAULT NULL,
  `recordedBy` varchar(255) DEFAULT NULL,
  `individualCount` int(11) DEFAULT NULL,
  `organismQuantity` varchar(45) DEFAULT NULL,
  `organismQuantityType` varchar(45) DEFAULT NULL,
  `sex` text,
  `lifeStage` varchar(50) DEFAULT NULL,
  `reproductiveCondition` varchar(45) DEFAULT NULL,
  `behavior` varchar(45) DEFAULT NULL,
  `establishmentMeans` varchar(45) DEFAULT NULL,
  `occurrenceStatus` varchar(45) DEFAULT NULL,
  `preparations` varchar(64) DEFAULT NULL,
  `disposition` varchar(45) DEFAULT NULL,
  `associatedMedia` varchar(45) DEFAULT NULL,
  `associatedReferences` varchar(45) DEFAULT NULL,
  `associatedSequences` varchar(45) DEFAULT NULL,
  `associatedTaxa` varchar(45) DEFAULT NULL,
  `otherCatalogNumbers` varchar(64) DEFAULT NULL,
  `occurrenceRemarks` text,
  `organismID` varchar(45) DEFAULT NULL,
  `organismName` varchar(45) DEFAULT NULL,
  `organismScope` varchar(45) DEFAULT NULL,
  `associatedOccurrences` varchar(45) DEFAULT NULL,
  `associatedOrganisms` varchar(45) DEFAULT NULL,
  `previousIdentifications` varchar(45) DEFAULT NULL,
  `organismRemarks` varchar(45) DEFAULT NULL,
  `materialSampleID` varchar(45) DEFAULT NULL,
  `eventID` varchar(45) DEFAULT NULL,
  `parentEventID` varchar(45) DEFAULT NULL,
  `fieldNumber` varchar(50) DEFAULT NULL,
  `eventDate` date DEFAULT NULL,
  `eventTime` smallint(6) DEFAULT NULL,
  `startDayOfYear` varchar(45) DEFAULT NULL,
  `endDayOfYear` varchar(45) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `day` int(11) DEFAULT NULL,
  `verbatimEventDate` varchar(50) DEFAULT NULL,
  `eventRemarks` text,
  `habitat` varchar(50) DEFAULT NULL,
  `samplingProtocol` varchar(45) DEFAULT NULL,
  `sampleSizeValue` varchar(45) DEFAULT NULL,
  `sampleSizeUnit` varchar(45) DEFAULT NULL,
  `samplingEffort` varchar(45) DEFAULT NULL,
  `fieldNotes` varchar(45) DEFAULT NULL,
  `locationID` varchar(45) DEFAULT NULL,
  `higherGeographyID` varchar(45) DEFAULT NULL,
  `higherGeography` varchar(255) DEFAULT NULL,
  `continent` varchar(64) DEFAULT NULL,
  `waterBody` varchar(64) DEFAULT NULL,
  `islandGroup` varchar(64) DEFAULT NULL,
  `island` varchar(64) DEFAULT NULL,
  `country` varchar(64) DEFAULT NULL,
  `countryCode` varchar(45) DEFAULT NULL,
  `stateProvince` varchar(64) DEFAULT NULL,
  `county` varchar(64) DEFAULT NULL,
  `municipality` varchar(45) DEFAULT NULL,
  `locality` varchar(255) DEFAULT NULL,
  `verbatimLocality` text,
  `minimumElevationInMeters` double DEFAULT NULL,
  `maximumElevationInMeters` double DEFAULT NULL,
  `verbatimElevation` varchar(50) DEFAULT NULL,
  `minimumDepthInMeters` text,
  `maximumDepthInMeters` text,
  `verbatimDepth` varchar(45) DEFAULT NULL,
  `minimumDistanceAboveSurfaceInMeters` varchar(45) DEFAULT NULL,
  `maximumDistanceAboveSurfaceInMeters` varchar(45) DEFAULT NULL,
  `locationAccordingTo` varchar(45) DEFAULT NULL,
  `locationRemarks` text,
  `decimalLatitude` decimal(12,10) DEFAULT NULL,
  `decimalLongitude` decimal(12,10) DEFAULT NULL,
  `geodeticDatum` varchar(50) DEFAULT NULL,
  `coordinateUncertaintyInMeters` double DEFAULT NULL,
  `coordinatePrecision` varchar(45) DEFAULT NULL,
  `pointRadiusSpatialFit` varchar(45) DEFAULT NULL,
  `verbatimCoordinates` varchar(45) DEFAULT NULL,
  `verbatimLatitude` varchar(45) DEFAULT NULL,
  `verbatimLongitude` varchar(45) DEFAULT NULL,
  `verbatimCoordinateSystem` varchar(45) DEFAULT NULL,
  `verbatimSRS` varchar(45) DEFAULT NULL,
  `footprintWKT` varchar(45) DEFAULT NULL,
  `footprintSRS` varchar(45) DEFAULT NULL,
  `footprintSpatialFit` varchar(45) DEFAULT NULL,
  `georeferencedBy` varchar(255) DEFAULT NULL,
  `georeferencedDate` datetime DEFAULT NULL,
  `georeferenceProtocol` varchar(64) DEFAULT NULL,
  `georeferenceSources` varchar(64) DEFAULT NULL,
  `georeferenceVerificationStatus` varchar(50) DEFAULT NULL,
  `georeferenceRemarks` text,
  `geologicalContextID` varchar(45) DEFAULT NULL,
  `earliestEonOrLowestEonothem` varchar(45) DEFAULT NULL,
  `latestEonOrHighestEonothem` varchar(45) DEFAULT NULL,
  `earliestEraOrLowestErathem` varchar(45) DEFAULT NULL,
  `latestEraOrHighestErathem` varchar(45) DEFAULT NULL,
  `earliestPeriodOrLowestSystem` varchar(45) DEFAULT NULL,
  `latestPeriodOrHighestSystem` varchar(45) DEFAULT NULL,
  `earliestEpochOrLowestSeries` varchar(45) DEFAULT NULL,
  `latestEpochOrHighestSeries` varchar(45) DEFAULT NULL,
  `earliestAgeOrLowestStage` varchar(45) DEFAULT NULL,
  `latestAgeOrHighestStage` varchar(45) DEFAULT NULL,
  `lowestBiostratigraphicZone` varchar(45) DEFAULT NULL,
  `highestBiostratigraphicZone` varchar(45) DEFAULT NULL,
  `lithostratigraphicTerms` varchar(45) DEFAULT NULL,
  `group` varchar(45) DEFAULT NULL,
  `formation` varchar(45) DEFAULT NULL,
  `member` varchar(45) DEFAULT NULL,
  `bed` varchar(45) DEFAULT NULL,
  `identificationID` varchar(45) DEFAULT NULL,
  `identificationQualifier` varchar(16) DEFAULT NULL,
  `typeStatus` varchar(50) DEFAULT NULL,
  `identifiedBy` varchar(225) DEFAULT NULL,
  `dateIdentified` date DEFAULT NULL,
  `identificationReferences` varchar(45) DEFAULT NULL,
  `identificationVerificationStatus` varchar(45) DEFAULT NULL,
  `identificationRemarks` text,
  `taxonID` varchar(45) DEFAULT NULL,
  `scientificNameID` varchar(45) DEFAULT NULL,
  `acceptedNameUsageID` varchar(45) DEFAULT NULL,
  `parentNameUsageID` varchar(45) DEFAULT NULL,
  `originalNameUsageID` varchar(45) DEFAULT NULL,
  `nameAccordingToID` varchar(45) DEFAULT NULL,
  `namePublishedInID` varchar(45) DEFAULT NULL,
  `taxonConceptID` varchar(45) DEFAULT NULL,
  `scientificName` varchar(255) DEFAULT NULL,
  `acceptedNameUsage` varchar(45) DEFAULT NULL,
  `parentNameUsage` varchar(45) DEFAULT NULL,
  `originalNameUsage` varchar(45) DEFAULT NULL,
  `nameAccordingTo` varchar(45) DEFAULT NULL,
  `namePublishedIn` varchar(45) DEFAULT NULL,
  `namePublishedInYear` varchar(45) DEFAULT NULL,
  `higherClassification` varchar(45) DEFAULT NULL,
  `kingdom` varchar(255) DEFAULT NULL,
  `phylum` varchar(255) DEFAULT NULL,
  `class` varchar(255) DEFAULT NULL,
  `order` varchar(255) DEFAULT NULL,
  `family` varchar(255) DEFAULT NULL,
  `genus` varchar(255) DEFAULT NULL,
  `subgenus` varchar(255) DEFAULT NULL,
  `specificEpithet` varchar(255) DEFAULT NULL,
  `infraspecificEpithet` varchar(255) DEFAULT NULL,
  `taxonRank` varchar(45) DEFAULT NULL,
  `verbatimTaxonRank` varchar(45) DEFAULT NULL,
  `scientificNameAuthorship` varchar(45) DEFAULT NULL,
  `vernacularName` varchar(255) DEFAULT NULL,
  `nomenclaturalCode` varchar(45) DEFAULT NULL,
  `taxonomicStatus` varchar(45) DEFAULT NULL,
  `nomenclaturalStatus` varchar(45) DEFAULT NULL,
  `taxonRemarks` text,
  `guid` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-18  7:14:42
