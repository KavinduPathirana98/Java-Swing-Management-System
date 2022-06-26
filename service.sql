-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 12, 2020 at 04:19 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `service`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill_item`
--

CREATE TABLE `bill_item` (
  `Bill_no` int(100) NOT NULL,
  `Item_ID` varchar(100) NOT NULL,
  `price` int(100) NOT NULL,
  `Quantity` int(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill_item`
--

INSERT INTO `bill_item` (`Bill_no`, `Item_ID`, `price`, `Quantity`) VALUES
(2, '9', 0, 4),
(1, '1', 0, 22),
(1, '2', 0, 12),
(2, '2', 0, 3),
(2, '3', 0, 3),
(2, '3', 0, 3),
(2, '2', 0, 2),
(2, '1', 0, 1),
(3, '1', 0, 3),
(4, '2', 0, 3),
(5, '3', 0, 3),
(6, '3', 0, 2),
(6, '2', 9800, 3),
(6, '4', 1520, 2),
(6, '8', 3700, 2),
(6, '3', 9800, 2),
(7, '1', 11100, 3),
(8, '3', 4900, 1),
(9, '2', 5000, 1),
(10, '3', 4900, 1),
(11, '10', 800, 1),
(12, '4', 760, 1),
(13, '1', 7400, 2),
(14, '3', 9800, 2),
(15, '3', 9800, 2),
(16, '3', 14700, 3),
(17, '3', 14700, 3),
(17, '2', 15000, 3),
(18, '3', 4900, 1),
(19, '3', 24500, 5),
(19, '1', 14800, 4),
(19, '9', 1700, 2),
(19, '10', 1600, 2),
(19, '13', 2100, 3),
(19, '11', 3000, 3),
(20, '4', 1520, 2),
(20, '7', 6000, 4),
(20, '9', 2550, 3),
(20, '12', 1900, 2),
(20, '6', 1500, 1),
(20, '9', 4250, 5),
(20, '2', 20000, 4),
(21, '1', 3700, 1),
(21, '6', 1500, 1),
(21, '7', 1500, 1),
(21, '5', 11000, 5),
(21, '8', 3700, 2),
(21, '5', 2200, 1),
(21, '4', 760, 1),
(21, '5', 11000, 5),
(21, '7', 1500, 1),
(21, '3', 9800, 2),
(21, '10', 2400, 3),
(21, '13', 700, 1),
(21, '7', 6000, 4),
(21, '9', 850, 1),
(21, '6', 1500, 1),
(22, '4', 3800, 5),
(22, '9', 850, 1),
(22, '5', 4400, 2),
(22, '9', 3400, 4),
(22, '8', 1850, 1),
(22, '7', 4500, 3),
(23, '2', 5000, 1),
(23, '5', 2200, 1),
(24, '3', 9800, 2),
(24, '6', 6000, 4),
(24, '10', 2400, 3),
(24, '8', 3700, 2),
(24, '4', 760, 1),
(24, '5', 4400, 2),
(24, '8', 5550, 3),
(24, '12', 3800, 4),
(24, '13', 3500, 5);

-- --------------------------------------------------------

--
-- Table structure for table `bill_service`
--

CREATE TABLE `bill_service` (
  `Service_id` varchar(100) NOT NULL,
  `Bill_no` varchar(100) NOT NULL,
  `Service_category` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill_service`
--

INSERT INTO `bill_service` (`Service_id`, `Bill_no`, `Service_category`) VALUES
('2', '2', 'Service'),
('1', '', 'Service'),
('4', '5', 'Service'),
('3', '6', 'Service'),
('3', '22', 'Service');

-- --------------------------------------------------------

--
-- Table structure for table `past_bills`
--

CREATE TABLE `past_bills` (
  `Bill_no` int(255) NOT NULL,
  `Date` varchar(100) NOT NULL,
  `Vehicle_no` varchar(100) NOT NULL,
  `Telephone` int(100) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Mileage` varchar(100) NOT NULL,
  `Next_service` varchar(100) NOT NULL,
  `Sub_total` int(100) NOT NULL,
  `Balance` int(100) NOT NULL,
  `Payment` int(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `past_bills`
--

INSERT INTO `past_bills` (`Bill_no`, `Date`, `Vehicle_no`, `Telephone`, `Name`, `Mileage`, `Next_service`, `Sub_total`, `Balance`, `Payment`) VALUES
(1, '01/06/2020', 'BAY-7355', 776281076, 'Kavindu Pathirana', '2300', '5300', 2500, 2500, 5000),
(2, '10/06/2020', 'Bay-2323', 718715717, 'kavindu', '2300', '5300', 600, 1400, 2000),
(3, '10/06/2020', 'WAD-1234', 788989891, 'Malinda', '2300', '5300', 400, 3000, 3400),
(4, '10/06/2020', 'Bay=1234', 776281076, 'kaviiiii', '2300', '5300', 15400, 4100, 4500),
(5, '10/06/2020', 'ASD-1234', 718715717, 'kavindu', '3000', '6000', 15700, 300, 16000),
(6, '11/06/2020', 'rts-8976', 770290456, 'Kamith', '34788', '37788', 750, 250, 1000),
(7, '11/06/2020', 'abc-8976', 770290234, 'Rex', '23346', '26346', 11500, 500, 12000),
(8, '11/06/2020', 'ABC-9209', 770290765, 'Rexy', '56784', '59784', 5300, 700, 6000),
(9, '11/06/2020', 'ADS-1212', 772245896, 'Kamith', '25000', '28000', 5400, -1400, 4000),
(10, '11/06/2020', 'ABC-8767', 770579234, 'Shan', '56000', '59000', 5300, 700, 6000),
(11, '11/06/2020', 'ABD-6789', 770290879, 'Malinda', '23000', '26000', 1200, 300, 1500),
(12, '11/06/2020', 'dds', 112233445, 'asd', '323', '3323', 1160, 1182, 2342),
(13, '11/06/2020', 'afsbdc', 778945617, 'dssdfd', '2323', '5323', 7800, 224532, 232332),
(14, '11/06/2020', 'eds', 771234567, 'dcxsd', '2323', '5323', 10200, 203013, 213213),
(15, '11/06/2020', 'asdsd', 771234567, 'xcv', '121', '3121', 10200, 20921, 21321),
(16, '11/06/2020', 'sefd', 771234567, 'vf', '23', '3023', 15100, 1732, 2132),
(17, '11/06/2020', 'ds', 771234567, 'dsfvd', '2324', '5324', 30100, -26858, 3242),
(18, '11/06/2020', '2342', 770290894, 'rte', '32342', '35342', 5300, 700, 6000),
(19, '11/06/2020', 'hfj', 770290685, 'sfsdfsdf', '433', '3433', 48100, 1900, 50000),
(20, '11/06/2020', 'ewwq', 770290684, 'weqe', '23432', '26432', 38120, 1880, 40000),
(21, '11/06/2020', 'fghfh', 779226313, 'fygfyfuf', '256156', '259156', 34150, 5850, 40000),
(22, '11/06/2020', 'fghh', 779226456, 'knyhg', '45681', '48681', 19550, 450, 20000),
(23, '11/06/2020', 'ASD-1023', 772256896, 'fghj', '12254', '15254', 7600, 400, 8000),
(24, '11/06/2020', 'tyr5676', 770290876, 'esfdf', '433243', '436243', 18410, 1590, 20000);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `ID` int(100) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Item_code` varchar(100) NOT NULL,
  `World_unique` varchar(100) NOT NULL,
  `Branch_unique` varchar(100) NOT NULL,
  `Engine_type` varchar(100) NOT NULL,
  `Pack_size` varchar(100) NOT NULL,
  `Quantity` int(100) NOT NULL,
  `Buying_price` int(11) NOT NULL,
  `Selling_price` int(11) NOT NULL,
  `Profit` int(11) NOT NULL,
  `Category` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`ID`, `Name`, `Item_code`, `World_unique`, `Branch_unique`, `Engine_type`, `Pack_size`, `Quantity`, `Buying_price`, `Selling_price`, `Profit`, `Category`) VALUES
(3, 'Mobil  Super 1000', '4567', '5634', '5678', 'Petrol', '4L', 62, 4500, 4900, 400, 'LUBRICANT'),
(2, 'Mobil Super 2000', '234', '456', '789', 'Any', '1L', 280, 4500, 5000, 500, 'LUBRICANT'),
(1, 'Mobil 1', '567', '345', '789', 'Any', '1L', 186, 3100, 3700, 600, 'LUBRICANT'),
(4, 'Hilux Oil Filter', '3546', 'C1101', 'C1122', 'Any', '1L', 138, 705, 760, 55, 'OIL FILTER'),
(5, 'Mitsubishi Fuel Filter', 'E456', 'R456', 'B4567', 'Any', '2L', 54, 1900, 2200, 300, 'FUEL FILTER'),
(6, 'Toyota Air Filter', 'E3455', 'R4567', 'B234', 'Any', '2L', 53, 1300, 1500, 200, 'AIR FILTER'),
(7, 'Honda Air Filter', 'E567', 'R3456', 'B987', 'Any', 'NO PACK SIZE', 32, 1300, 1500, 200, 'AIR FILTER'),
(8, 'Nissan Cabin Filter', 'E213', 'R876', 'B349', 'Any', 'NO PACK SIZE', 30, 1550, 1850, 300, 'AIR FILTER'),
(9, 'Rali Shampoo', 'E340', 'R567', 'B984', 'Any', '1L', 10, 700, 850, 150, 'CHEMICALS'),
(10, 'Dash Shampoo', 'E564', 'R567', 'B896', 'Any', '1L', 16, 600, 800, 200, 'CHEMICALS'),
(11, 'Korean Car Fuel Filters', 'E456', 'R913', 'E299', 'Any', 'NO PACK SIZE', 64, 900, 1000, 100, 'FUEL FILTER'),
(12, 'Subaru Oil Filter', 'E453', 'R987', 'E277', 'Any', 'NO PACK SIZE', 14, 800, 950, 150, 'OIL FILTER'),
(13, 'One Shot Glass Cleaner', 'E455', 'R899', 'B544', 'Any', '400ml', 31, 600, 700, 100, 'CHEMICALS');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `Sales_ID` int(100) NOT NULL,
  `Bill_no` varchar(100) NOT NULL,
  `Item_id` varchar(100) NOT NULL,
  `Item_Name` varchar(100) NOT NULL,
  `Sold_Quantity` int(100) NOT NULL,
  `Sales_Profit` int(50) NOT NULL,
  `Date` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`Sales_ID`, `Bill_no`, `Item_id`, `Item_Name`, `Sold_Quantity`, `Sales_Profit`, `Date`) VALUES
(77, '', 'P02', 'MOBIL', 3, 1500, '01/06/2020'),
(76, '', 'P01', 'Mac', 2, 1600, '01/06/2020'),
(85, 'B01', 'P01', 'Mac', 2, 1600, '02/06/2020'),
(82, 'B01', 'P01', 'Mac', 2, 1600, '02/06/2020'),
(83, 'B01', 'P02', 'MOBIL', 2, 1000, '02/06/2020'),
(84, 'B01', 'P01', 'Mac', 5, 4000, '02/06/2020'),
(86, 'B01', 'P01', 'Mac', 5, 4000, '02/06/2020'),
(87, 'B01', 'P01', 'Mac', 5, 4000, '02/06/2020'),
(92, 'B01', 'P01', 'Mac', 5, 5000, '05/06/2020'),
(93, 'B01', 'P01', 'Mac', 5, 5000, '05/06/2020'),
(98, 'B01', 'P01', 'Mac', 5, 5000, '06/06/2020'),
(96, 'B01', 'P02', 'MOBIL', 2, 1000, '06/06/2020'),
(97, 'B01', 'P01', 'Mac', 2, 2000, '06/06/2020'),
(99, 'B01', 'P01', 'Mac', 2, 2000, '06/06/2020'),
(100, '2', '9', 'Rali Shampoo', 4, 600, '10/06/2020'),
(101, '2', '2', 'Mobil Super 2000', 3, 1500, '10/06/2020'),
(102, '2', '3', 'Mobil  Super 1000', 3, 1200, '10/06/2020'),
(103, '2', '3', 'Mobil  Super 1000', 3, 1200, '10/06/2020'),
(104, '2', '2', 'Mobil Super 2000', 2, 1000, '10/06/2020'),
(105, '2', '1', 'Mobil 1', 1, 600, '10/06/2020'),
(106, '3', '1', 'Mobil 1', 3, 1800, '10/06/2020'),
(107, '4', '2', 'Mobil Super 2000', 3, 1500, '10/06/2020'),
(108, '5', '3', 'Mobil  Super 1000', 3, 1200, '10/06/2020'),
(109, '6', '3', 'Mobil  Super 1000', 3, 1200, '11/06/2020'),
(110, '6', '3', 'Mobil  Super 1000', 2, 800, '11/06/2020'),
(111, '6', '2', 'Mobil Super 2000', 3, 1500, '11/06/2020'),
(112, '6', '4', 'Hilux Oil Filter', 2, 110, '11/06/2020'),
(113, '6', '8', 'Nissan Cabin Filter', 2, 600, '11/06/2020'),
(114, '6', '3', 'Mobil  Super 1000', 2, 800, '11/06/2020'),
(115, '7', '1', 'Mobil 1', 3, 1800, '11/06/2020'),
(116, '8', '3', 'Mobil  Super 1000', 1, 400, '11/06/2020'),
(117, '9', '2', 'Mobil Super 2000', 1, 500, '11/06/2020'),
(118, '10', '3', 'Mobil  Super 1000', 1, 400, '11/06/2020'),
(119, '11', '10', 'Dash Shampoo', 1, 200, '11/06/2020'),
(120, '12', '4', 'Hilux Oil Filter', 1, 55, '11/06/2020'),
(121, '13', '1', 'Mobil 1', 2, 1200, '11/06/2020'),
(122, '14', '3', 'Mobil  Super 1000', 2, 800, '11/06/2020'),
(123, '15', '3', 'Mobil  Super 1000', 2, 800, '11/06/2020'),
(124, '16', '3', 'Mobil  Super 1000', 3, 1200, '11/06/2020'),
(125, '17', '3', 'Mobil  Super 1000', 3, 1200, '11/06/2020'),
(126, '17', '2', 'Mobil Super 2000', 3, 1500, '11/06/2020'),
(127, '18', '3', 'Mobil  Super 1000', 1, 400, '11/06/2020'),
(128, '19', '3', 'Mobil  Super 1000', 5, 2000, '11/06/2020'),
(129, '19', '1', 'Mobil 1', 4, 2400, '11/06/2020'),
(130, '19', '9', 'Rali Shampoo', 2, 300, '11/06/2020'),
(131, '19', '10', 'Dash Shampoo', 2, 400, '11/06/2020'),
(132, '19', '13', 'One Shot Glass Cleaner', 3, 300, '11/06/2020'),
(133, '19', '11', 'Korean Car Fuel Filters', 3, 300, '11/06/2020'),
(134, '20', '4', 'Hilux Oil Filter', 2, 110, '11/06/2020'),
(135, '20', '7', 'Honda Air Filter', 4, 800, '11/06/2020'),
(136, '20', '9', 'Rali Shampoo', 3, 450, '11/06/2020'),
(137, '20', '12', 'Subaru Oil Filter', 2, 300, '11/06/2020'),
(138, '20', '6', 'Toyota Air Filter', 1, 200, '11/06/2020'),
(139, '20', '9', 'Rali Shampoo', 5, 750, '11/06/2020'),
(140, '20', '2', 'Mobil Super 2000', 4, 2000, '11/06/2020'),
(141, '21', '1', 'Mobil 1', 1, 600, '11/06/2020'),
(142, '21', '6', 'Toyota Air Filter', 1, 200, '11/06/2020'),
(143, '21', '7', 'Honda Air Filter', 1, 200, '11/06/2020'),
(144, '21', '5', 'Mitsubishi Fuel Filter', 5, 1500, '11/06/2020'),
(145, '21', '8', 'Nissan Cabin Filter', 2, 600, '11/06/2020'),
(146, '21', '5', 'Mitsubishi Fuel Filter', 1, 300, '11/06/2020'),
(147, '21', '4', 'Hilux Oil Filter', 1, 55, '11/06/2020'),
(148, '21', '5', 'Mitsubishi Fuel Filter', 5, 1500, '11/06/2020'),
(149, '21', '7', 'Honda Air Filter', 1, 200, '11/06/2020'),
(150, '21', '3', 'Mobil  Super 1000', 2, 800, '11/06/2020'),
(151, '21', '10', 'Dash Shampoo', 3, 600, '11/06/2020'),
(152, '21', '13', 'One Shot Glass Cleaner', 1, 100, '11/06/2020'),
(153, '21', '7', 'Honda Air Filter', 4, 800, '11/06/2020'),
(154, '21', '9', 'Rali Shampoo', 1, 150, '11/06/2020'),
(155, '21', '6', 'Toyota Air Filter', 1, 200, '11/06/2020'),
(156, '22', '4', 'Hilux Oil Filter', 5, 275, '11/06/2020'),
(157, '22', '9', 'Rali Shampoo', 1, 150, '11/06/2020'),
(158, '22', '5', 'Mitsubishi Fuel Filter', 2, 600, '11/06/2020'),
(159, '22', '9', 'Rali Shampoo', 4, 600, '11/06/2020'),
(160, '22', '8', 'Nissan Cabin Filter', 1, 300, '11/06/2020'),
(161, '22', '7', 'Honda Air Filter', 3, 600, '11/06/2020'),
(162, '23', '2', 'Mobil Super 2000', 1, 500, '11/06/2020'),
(163, '23', '5', 'Mitsubishi Fuel Filter', 1, 300, '11/06/2020'),
(164, '24', '3', 'Mobil  Super 1000', 2, 800, '11/06/2020'),
(165, '24', '6', 'Toyota Air Filter', 4, 800, '11/06/2020'),
(166, '24', '10', 'Dash Shampoo', 3, 600, '11/06/2020'),
(167, '24', '8', 'Nissan Cabin Filter', 2, 600, '11/06/2020'),
(168, '24', '4', 'Hilux Oil Filter', 1, 55, '11/06/2020'),
(169, '24', '5', 'Mitsubishi Fuel Filter', 2, 600, '11/06/2020'),
(170, '24', '8', 'Nissan Cabin Filter', 3, 900, '11/06/2020'),
(171, '24', '12', 'Subaru Oil Filter', 4, 600, '11/06/2020'),
(172, '24', '13', 'One Shot Glass Cleaner', 5, 500, '11/06/2020');

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `Service_id` int(100) NOT NULL,
  `Service_name` varchar(100) NOT NULL,
  `Service_price` int(100) NOT NULL,
  `service_category` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`Service_id`, `Service_name`, `Service_price`, `service_category`) VALUES
(5, 'Bike', 250, 'Service'),
(4, 'Bus', 1000, 'Service'),
(3, 'Lorry', 750, 'Service'),
(1, 'Car', 400, 'Service'),
(2, 'Van', 600, 'Service'),
(6, 'No Service', 0, 'Service'),
(7, 'No Wash', 0, 'Wash');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `Supplier_ID` int(100) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Tel_no` int(11) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `S_Item` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`Supplier_ID`, `Name`, `Tel_no`, `Address`, `S_Item`) VALUES
(1, 'dds', 772900565, 'col', 'Mac Oil');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `Name` varchar(100) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Telephone` int(10) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Category` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Name`, `Username`, `Password`, `Address`, `Telephone`, `Email`, `Category`) VALUES
('Kavindu Pathirana', 'admin', '1234', 'Colombo', 776281076, 'kavindugimhanapathirana1998@gmail.com', 'Administrator'),
('Yasiri', 'yash', '123q', 'Piliyandala', 768720320, 'yasiridranasinghe@gmail.com', 'User'),
('Malinda', 'shan11k', '1234', 'Nittambuwa', 770290685, 'pixelmalinda@gmail.com', 'User');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `past_bills`
--
ALTER TABLE `past_bills`
  ADD PRIMARY KEY (`Bill_no`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ID`,`Name`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`Sales_ID`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`Service_id`,`service_category`,`Service_name`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Username`,`Email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `Sales_ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=173;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
