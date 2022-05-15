-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2022 at 03:29 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `electricityborad`
--

-- --------------------------------------------------------

--
-- Table structure for table `customerservice`
--

CREATE TABLE IF NOT EXISTS `customerservice` (
  `cID` int(6) NOT NULL AUTO_INCREMENT,
  `cName` varchar(200) NOT NULL,
  `cAddress` varchar(200) NOT NULL,
  `cNic` varchar(200) NOT NULL,
  `cGen` varchar(200) NOT NULL,
  `cEmail` varchar(200) NOT NULL,
  `cCNo` varchar(200) NOT NULL,
  PRIMARY KEY (`cID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `employeeservice`
--

CREATE TABLE IF NOT EXISTS `employeeservice` (
  `eID` int(6) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) NOT NULL,
  `Address` int(200) NOT NULL,
  `Nic` varchar(200) NOT NULL,
  `PhoneNo` varchar(200) NOT NULL,
  PRIMARY KEY (`eID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `inquiryservice`
--

CREATE TABLE IF NOT EXISTS `inquiryservice` (
  `INid` int(6) NOT NULL AUTO_INCREMENT,
  `INname` varchar(200) NOT NULL,
  `INadderss` varchar(200) NOT NULL,
  `INdate` varchar(200) NOT NULL,
  `INreason` varchar(200) NOT NULL,
  PRIMARY KEY (`INid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
