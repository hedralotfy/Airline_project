-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 07, 2025 at 09:10 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airlinedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

CREATE TABLE `flight` (
  `id` varchar(255) NOT NULL,
  `flightName` varchar(255) NOT NULL,
  `source` varchar(255) NOT NULL,
  `depart` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `depTime` varchar(255) NOT NULL,
  `arrTime` varchar(255) NOT NULL,
  `flightCharge` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`id`, `flightName`, `source`, `depart`, `date`, `depTime`, `arrTime`, `flightCharge`) VALUES
('FO001', 'KMTFlight', 'Egypt', 'Germany', '2024-05-22', '8:00AM', '12:00PM', '12000'),
('FO002', 'Hedra', 'Germany', 'Egypt', '2024-05-30', '9:00AM', '1:00PM', '1500'),
('FO003', 'HeroFlight', 'Germany', 'Egypt', '2024-05-29', '9:00AM', '1:00PM', '15000');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(22) NOT NULL,
  `password` varchar(245) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sign up`
--

CREATE TABLE `sign up` (
  `cid` varchar(255) NOT NULL,
  `fName` varchar(256) NOT NULL,
  `lName` varchar(256) NOT NULL,
  `username` varchar(256) NOT NULL,
  `phone` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL,
  `nic` varchar(256) NOT NULL,
  `gender` varchar(256) NOT NULL,
  `age` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sign up`
--

INSERT INTO `sign up` (`cid`, `fName`, `lName`, `username`, `phone`, `password`, `nic`, `gender`, `age`) VALUES
('CS001', 'Hedra', 'Lotfy', 'HeroFoty', '01278152658', 'sektum', '3030f', 'male', 20),
('CS002', 'Johnathan', 'Fayez', 'JohnFayez', '01222856354', 'mldl', '3080f', 'male', 21),
('CS003', 'Omneya', 'Ahmed', 'OmneyaAhmed', '2132423423', 'fffg', '2021f', 'female', 22),
('CS004', 'Abdullah', 'Adly', 'AbdoAdly', '01017383982', 'survy', '2090f', 'male', 34);

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `id` varchar(255) NOT NULL,
  `flightid` varchar(255) NOT NULL,
  `custid` varchar(255) NOT NULL,
  `class` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `seats` int(11) NOT NULL,
  `date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`id`, `flightid`, `custid`, `class`, `price`, `seats`, `date`) VALUES
('TO001', 'FO001', 'CS001', 'Economy', 24000, 2, '2024-05-22'),
('TO002', 'FO001', 'CS003', 'Business', 12000, 1, '2024-05-31');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
