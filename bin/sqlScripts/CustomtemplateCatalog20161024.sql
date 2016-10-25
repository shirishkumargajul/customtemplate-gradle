/*
SQLyog Community v12.07 (64 bit)
MySQL - 5.7.14-log : Database - customtemplatecatalog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`customtemplatecatalog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `customtemplatecatalog`;

/*Table structure for table `catalog` */

DROP TABLE IF EXISTS `catalog`;

CREATE TABLE `catalog` (
  `CatalogId` int(20) NOT NULL AUTO_INCREMENT,
  `ApplicationType` varchar(60) DEFAULT NULL,
  `ApplicationName` varchar(60) DEFAULT NULL,
  `CatalogFile` blob,
  PRIMARY KEY (`CatalogId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `catalog` */

/*Table structure for table `macoperator` */

DROP TABLE IF EXISTS `macoperator`;

CREATE TABLE `macoperator` (
  `MacoperatorId` int(20) NOT NULL AUTO_INCREMENT,
  `ApplicationType` varchar(60) DEFAULT NULL,
  `ApplicationName` varchar(60) DEFAULT NULL,
  `ARIId` int(20) NOT NULL,
  `Macoperator` blob NOT NULL,
  PRIMARY KEY (`MacoperatorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `macoperator` */

/*Table structure for table `userprofile` */

DROP TABLE IF EXISTS `userprofile`;

CREATE TABLE `userprofile` (
  `userProfileID` int(8) NOT NULL,
  `userId` int(20) DEFAULT NULL,
  `ApplicationId` int(8) NOT NULL,
  `UserExpertiseRating` int(2) DEFAULT '2',
  `rangeDistance` int(2) DEFAULT NULL,
  `AriId` int(20) DEFAULT NULL,
  PRIMARY KEY (`userProfileID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userprofile` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userId` int(8) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(20) DEFAULT NULL,
  `LastName` varchar(20) DEFAULT NULL,
  `emailId` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  `phone` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
