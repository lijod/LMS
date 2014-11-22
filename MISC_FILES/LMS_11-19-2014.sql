/*
SQLyog Community v9.63 
MySQL - 5.6.21-log : Database - lms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lms`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_day` varchar(255) DEFAULT NULL,
  `course_end_time` time DEFAULT NULL,
  `course_location` varchar(255) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `course_start_time` time DEFAULT NULL,
  `section_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`course_id`,`course_day`,`course_end_time`,`course_location`,`course_name`,`course_start_time`,`section_num`) values (1,'Monday','01:03:02','Shillman','CS1','01:03:02',1);
insert  into `course`(`course_id`,`course_day`,`course_end_time`,`course_location`,`course_name`,`course_start_time`,`section_num`) values (2,'Monday','01:05:53','Shillman','CS1','01:05:53',1);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_name` varchar(100) NOT NULL,
  PRIMARY KEY (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`role_name`) values ('ADMIN');
insert  into `role`(`role_name`) values ('PROFESSOR');
insert  into `role`(`role_name`) values ('STUDENT');
insert  into `role`(`role_name`) values ('TA');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`dob`,`email`,`first_name`,`last_name`,`password`,`user_name`) values (1,'2014-11-21','sam@sam.com','sam','sam1','jon','sam2');
insert  into `user`(`user_id`,`dob`,`email`,`first_name`,`last_name`,`password`,`user_name`) values (2,'2014-11-21','sam@sam.com','sam','sam1','jon','sam2');

/*Table structure for table `user_course_detail` */

DROP TABLE IF EXISTS `user_course_detail`;

CREATE TABLE `user_course_detail` (
  `user_id` int(11) NOT NULL,
  `role` varchar(255) NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role`,`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_course_detail` */

insert  into `user_course_detail`(`user_id`,`role`,`course_id`) values (1,'PROFESSOR',1);
insert  into `user_course_detail`(`user_id`,`role`,`course_id`) values (2,'PROFESSOR',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
