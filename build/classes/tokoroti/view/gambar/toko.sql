-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 29, 2024 at 03:31 PM
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
-- Database: `toko`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `img` varchar(200) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `harga` double NOT NULL,
  `komposisi` varchar(1000) NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `img`, `judul`, `harga`, `komposisi`, `stock`) VALUES
(1, '/tokoroti/view/gambar/roti.jpg', 'Roti Tebel', 15000, 'Komposisi :\r\nTepung Terigu (52,74%), Es, Air, Margarin (Mengandung Pengawet Kalium Sorbat), Pewarna Alami (Kurkumin Cl.75300 dan Ekstrak anato Cl No.75120)), Gula (Mengandung Pengawet Sulfit), Lemak Hewani, Susu Bubuk Full Cream, Ragi, Garam, Pengawet Klasium Propionat, Perlakuan Tepung (Mengandung Antioksidan Asam Askorbat), Pengemulsi Nabati.', 25),
(2, '/tokoroti/view/gambar/rotiTawar.jpg', 'Roti Tawar', 13000, 'Komposisi :\r\nTepung terigu (mengandung gluten), air, gula pasir, lemak reroti (mengandung antioksidan askorbil palmitat dan tokoferol campur pekat), premiks roti (mengandung susu lemak nabati 0.61%), pengawet kalsium propionat, antioksidan asam askorbat, ragi, garam', 25),
(3, '/tokoroti/view/gambar/rotiTawarKupas.jpg', 'Roti Tawar Kupas', 18000, 'Komposisi :\r\nTepung terigu, air, es, gula, garam, susu lemak nabati, lemak hewani, perlakuan tepung, ragi, dan pengawet kalsium propionat\r\n', 25),
(9, '/tokoroti/view/gambar/rotiTawarKupas2.jpg', 'Roti Extra Kalsium', 23000, 'Komposisi :\r\nTepung terigu, air, gula pasir, lemak reroti (mengandung antioksidan)', 25),
(10, '/tokoroti/view/gambar/rotiTawar3.jpg', 'Roti Tawar Susu', 8500, 'SARI ROTI TAWAR JUMBO MILKY SOFT.', 25),
(12, '/tokoroti/view/gambar/rotiTawarBiji.jpg', 'Roti Tawar Gandum Multiseed', 23000, 'Multi gandum sehat dan bergizi', 25),
(13, '/tokoroti/view/gambar/roti4.jpg', 'Roti Gandum', 25000, 'Roti, Ragi, dan Gandum', 25),
(22, '/tokoroti/view/gambar/roti6.jpg', 'Roti Coklat', 2500, 'Komposisi :\nTepung terigu, air, es, gula, garam, susu bubuk, lemak reroti, pengemulsi, susu bubuk cokelat, pasta cokelat, ragi, choco chips, dan pengawet kalsium propionat\n', 25),
(23, '/tokoroti/view/gambar/roti5.jpg', 'Roti Pandan', 15000, 'Komposisi : \nTepung, Gula, Beras, Margarin, Telur, Rujak, Tempe, Panda,', 25);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(20) NOT NULL,
  `user` varchar(40) NOT NULL,
  `pass` varchar(40) NOT NULL,
  `role` varchar(40) NOT NULL,
  `profilePicture` varchar(100) DEFAULT '/tokoroti/view/gambar/defaultProfile.png'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `user`, `pass`, `role`, `profilePicture`) VALUES
(1, 'admin', '123', 'owner', '/tokoroti/view/gambar/defaultProfile.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nama` (`user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
