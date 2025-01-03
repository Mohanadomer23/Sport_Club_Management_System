-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 03, 2025 at 09:44 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `attendance_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `events_id` int(11) NOT NULL,
  `attendance_state` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `coaches`
--

CREATE TABLE `coaches` (
  `coach_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `specialty` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `coaches`
--

INSERT INTO `coaches` (`coach_id`, `name`, `specialty`, `email`) VALUES
(1, 'kjfsd', '1', '1'),
(2, 'klad', 'gym', 'yosef@gmail.com'),
(9, 'Khalid', 'fitnesss', 'khalid@gmailcom'),
(10, 'mostafa', 'gym', 'mostafa@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `coaches_phone`
--

CREATE TABLE `coaches_phone` (
  `phone` varchar(15) NOT NULL,
  `coach_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `eventId` int(11) NOT NULL,
  `eventName` varchar(255) NOT NULL,
  `eventDate` varchar(30) NOT NULL,
  `eventLocation` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`eventId`, `eventName`, `eventDate`, `eventLocation`) VALUES
(1, 'festival', '10/2/2005', 'aswan'),
(2, 'mefl', '445465', 'sadasda');

-- --------------------------------------------------------

--
-- Table structure for table `expenses`
--

CREATE TABLE `expenses` (
  `expense_id` int(11) NOT NULL,
  `expense_type` varchar(255) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `expense_date` date NOT NULL,
  `team_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `facilities`
--

CREATE TABLE `facilities` (
  `facility_id` int(11) NOT NULL,
  `facility_name` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `maintenance_schedule` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `managers`
--

CREATE TABLE `managers` (
  `manager_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `department` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `managers`
--

INSERT INTO `managers` (`manager_id`, `name`, `department`, `email`) VALUES
(2, 'hamed', 'management', 'msf@kldjsa.com'),
(3, 'fsdf', 'dfs', 'fsddsf'),
(4, 'kamil', 'ajd', 'dsfas'),
(5, 'kjlk', 'm', 'klk'),
(6, 'aya', 'hr', 'gggg');

-- --------------------------------------------------------

--
-- Table structure for table `managers_phone`
--

CREATE TABLE `managers_phone` (
  `phone` varchar(15) NOT NULL,
  `manager_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `member_id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `join_date` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sub_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`member_id`, `email`, `join_date`, `name`, `sub_id`) VALUES
(1, 'anasx', '10/8/2010', 'anas@gmail.com', 1),
(2, 'anasx', '10/8/2010', 'anas@gmail.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `membership_benefits`
--

CREATE TABLE `membership_benefits` (
  `benefit_id` int(11) NOT NULL,
  `benefit_description` text NOT NULL,
  `member_ship_type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `member_phone`
--

CREATE TABLE `member_phone` (
  `phone` varchar(15) NOT NULL,
  `member_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `part_of`
--

CREATE TABLE `part_of` (
  `member_id` int(11) NOT NULL,
  `team_member_id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `share`
--

CREATE TABLE `share` (
  `team_id` int(11) NOT NULL,
  `events_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sponsorship`
--

CREATE TABLE `sponsorship` (
  `sponsorship_id` int(11) NOT NULL,
  `sponsor_name` varchar(255) NOT NULL,
  `amount_provided` decimal(10,2) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `team_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `subscription`
--

CREATE TABLE `subscription` (
  `subscriptionId` int(11) NOT NULL,
  `subscriptionPlanType` varchar(255) NOT NULL,
  `subscriptionStartDate` varchar(30) NOT NULL,
  `subscriptionEndDate` varchar(30) NOT NULL,
  `subscriptionAmount` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `subscription`
--

INSERT INTO `subscription` (`subscriptionId`, `subscriptionPlanType`, `subscriptionStartDate`, `subscriptionEndDate`, `subscriptionAmount`) VALUES
(1, 'monthly', '10/10/2010', '10/10/2020', 500),
(2, 'yearn', '2005', '2210', 200),
(3, 'hbjh', 'nk', 'kjn', 200);

-- --------------------------------------------------------

--
-- Table structure for table `tasks`
--

CREATE TABLE `tasks` (
  `task_id` int(11) NOT NULL,
  `task_description` text NOT NULL,
  `due_date` date NOT NULL,
  `status` varchar(50) NOT NULL,
  `manager_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `teams`
--

CREATE TABLE `teams` (
  `team_id` int(11) NOT NULL,
  `team_name` varchar(255) NOT NULL,
  `sport_type` varchar(255) NOT NULL,
  `coach_id` int(11) NOT NULL,
  `manager_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `teams`
--

INSERT INTO `teams` (`team_id`, `team_name`, `sport_type`, `coach_id`, `manager_id`) VALUES
(1, 'first team', 'football', 2, 2),
(2, 'U19', 'volleyBall', 2, 3),
(3, 'bhj', 'jhgjh', 2, 3),
(4, 'jhgjh', 'hgjh', 2, 3),
(5, 'sdfsdf', '', 2, 3),
(6, 'fs', 'fsdf', 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `team_members`
--

CREATE TABLE `team_members` (
  `team_member_id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `training_session`
--

CREATE TABLE `training_session` (
  `session_id` int(11) NOT NULL,
  `session_date` varchar(30) NOT NULL,
  `duration` float NOT NULL,
  `notes` text NOT NULL,
  `team_id` int(11) NOT NULL,
  `coach_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `training_session`
--

INSERT INTO `training_session` (`session_id`, `session_date`, `duration`, `notes`, `team_id`, `coach_id`) VALUES
(1, 'nk', 894, 'vhg', 2, 1),
(2, '21', 21, 'da', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(40) NOT NULL,
  `pass` varchar(40) NOT NULL,
  `fname` varchar(20) DEFAULT NULL,
  `Lname` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `pass`, `fname`, `Lname`) VALUES
('ahmed', '888', 'ahmed', 'omer'),
('anas', '000', 'anas', 'ahmed'),
('Enter your email', 'fdsf', 'fasdffdsfa', 'fdf'),
('kaled', '1515', 'khaled', 'omer'),
('khOmer', '0440', 'Khaled', 'Omer'),
('lll', '111', 'mohanad', 'Omer'),
('mohand', '777', 'mohanad', 'omer'),
('moj', '123', 'ghg', 'gj'),
('mosaab', '5555', 'Mosaab', 'Ahmed'),
('mosaal', '1234', 'Mosaab', 'Ahmed'),
('nmsdnmsndfmsn', 'Enter your password', 'jnmsn', 'jnmsnm');

-- --------------------------------------------------------

--
-- Table structure for table `use_facilities`
--

CREATE TABLE `use_facilities` (
  `team_id` int(11) NOT NULL,
  `facility_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`attendance_id`),
  ADD KEY `member_id` (`member_id`),
  ADD KEY `events_id` (`events_id`);

--
-- Indexes for table `coaches`
--
ALTER TABLE `coaches`
  ADD PRIMARY KEY (`coach_id`);

--
-- Indexes for table `coaches_phone`
--
ALTER TABLE `coaches_phone`
  ADD PRIMARY KEY (`phone`,`coach_id`),
  ADD KEY `coach_id` (`coach_id`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`eventId`);

--
-- Indexes for table `expenses`
--
ALTER TABLE `expenses`
  ADD PRIMARY KEY (`expense_id`),
  ADD KEY `team_id` (`team_id`);

--
-- Indexes for table `facilities`
--
ALTER TABLE `facilities`
  ADD PRIMARY KEY (`facility_id`);

--
-- Indexes for table `managers`
--
ALTER TABLE `managers`
  ADD PRIMARY KEY (`manager_id`);

--
-- Indexes for table `managers_phone`
--
ALTER TABLE `managers_phone`
  ADD PRIMARY KEY (`phone`,`manager_id`),
  ADD KEY `manager_id` (`manager_id`);

--
-- Indexes for table `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`member_id`),
  ADD KEY `sub_id` (`sub_id`);

--
-- Indexes for table `membership_benefits`
--
ALTER TABLE `membership_benefits`
  ADD PRIMARY KEY (`benefit_id`),
  ADD KEY `member_ship_type_id` (`member_ship_type_id`);

--
-- Indexes for table `member_phone`
--
ALTER TABLE `member_phone`
  ADD PRIMARY KEY (`phone`,`member_id`),
  ADD KEY `member_id` (`member_id`);

--
-- Indexes for table `part_of`
--
ALTER TABLE `part_of`
  ADD PRIMARY KEY (`member_id`,`team_member_id`,`team_id`),
  ADD KEY `team_member_id` (`team_member_id`,`team_id`);

--
-- Indexes for table `share`
--
ALTER TABLE `share`
  ADD PRIMARY KEY (`team_id`,`events_id`),
  ADD KEY `events_id` (`events_id`);

--
-- Indexes for table `sponsorship`
--
ALTER TABLE `sponsorship`
  ADD PRIMARY KEY (`sponsorship_id`),
  ADD KEY `team_id` (`team_id`);

--
-- Indexes for table `subscription`
--
ALTER TABLE `subscription`
  ADD PRIMARY KEY (`subscriptionId`);

--
-- Indexes for table `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`task_id`),
  ADD KEY `manager_id` (`manager_id`);

--
-- Indexes for table `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`team_id`),
  ADD KEY `coach_id` (`coach_id`),
  ADD KEY `manager_id` (`manager_id`);

--
-- Indexes for table `team_members`
--
ALTER TABLE `team_members`
  ADD PRIMARY KEY (`team_member_id`,`team_id`),
  ADD KEY `team_id` (`team_id`);

--
-- Indexes for table `training_session`
--
ALTER TABLE `training_session`
  ADD PRIMARY KEY (`session_id`),
  ADD KEY `team_id` (`team_id`),
  ADD KEY `coach_id` (`coach_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `use_facilities`
--
ALTER TABLE `use_facilities`
  ADD PRIMARY KEY (`team_id`,`facility_id`),
  ADD KEY `facility_id` (`facility_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `attendance_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `coaches`
--
ALTER TABLE `coaches`
  MODIFY `coach_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `eventId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `expenses`
--
ALTER TABLE `expenses`
  MODIFY `expense_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `facilities`
--
ALTER TABLE `facilities`
  MODIFY `facility_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `managers`
--
ALTER TABLE `managers`
  MODIFY `manager_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `members`
--
ALTER TABLE `members`
  MODIFY `member_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `membership_benefits`
--
ALTER TABLE `membership_benefits`
  MODIFY `benefit_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sponsorship`
--
ALTER TABLE `sponsorship`
  MODIFY `sponsorship_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `subscription`
--
ALTER TABLE `subscription`
  MODIFY `subscriptionId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tasks`
--
ALTER TABLE `tasks`
  MODIFY `task_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `teams`
--
ALTER TABLE `teams`
  MODIFY `team_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `team_members`
--
ALTER TABLE `team_members`
  MODIFY `team_member_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `training_session`
--
ALTER TABLE `training_session`
  MODIFY `session_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`),
  ADD CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`events_id`) REFERENCES `events` (`eventId`);

--
-- Constraints for table `coaches_phone`
--
ALTER TABLE `coaches_phone`
  ADD CONSTRAINT `coaches_phone_ibfk_1` FOREIGN KEY (`coach_id`) REFERENCES `coaches` (`coach_id`);

--
-- Constraints for table `expenses`
--
ALTER TABLE `expenses`
  ADD CONSTRAINT `expenses_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `teams` (`team_id`);

--
-- Constraints for table `managers_phone`
--
ALTER TABLE `managers_phone`
  ADD CONSTRAINT `managers_phone_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `managers` (`manager_id`);

--
-- Constraints for table `members`
--
ALTER TABLE `members`
  ADD CONSTRAINT `members_ibfk_2` FOREIGN KEY (`sub_id`) REFERENCES `subscription` (`subscriptionId`);

--
-- Constraints for table `membership_benefits`
--
ALTER TABLE `membership_benefits`
  ADD CONSTRAINT `membership_benefits_ibfk_1` FOREIGN KEY (`member_ship_type_id`) REFERENCES `membership_types` (`member_ship_type_id`);

--
-- Constraints for table `member_phone`
--
ALTER TABLE `member_phone`
  ADD CONSTRAINT `member_phone_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`);

--
-- Constraints for table `part_of`
--
ALTER TABLE `part_of`
  ADD CONSTRAINT `part_of_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`),
  ADD CONSTRAINT `part_of_ibfk_2` FOREIGN KEY (`team_member_id`,`team_id`) REFERENCES `team_members` (`team_member_id`, `team_id`);

--
-- Constraints for table `share`
--
ALTER TABLE `share`
  ADD CONSTRAINT `share_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `teams` (`team_id`),
  ADD CONSTRAINT `share_ibfk_2` FOREIGN KEY (`events_id`) REFERENCES `events` (`eventId`);

--
-- Constraints for table `sponsorship`
--
ALTER TABLE `sponsorship`
  ADD CONSTRAINT `sponsorship_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `teams` (`team_id`);

--
-- Constraints for table `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `tasks_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `managers` (`manager_id`);

--
-- Constraints for table `teams`
--
ALTER TABLE `teams`
  ADD CONSTRAINT `teams_ibfk_1` FOREIGN KEY (`coach_id`) REFERENCES `coaches` (`coach_id`),
  ADD CONSTRAINT `teams_ibfk_2` FOREIGN KEY (`manager_id`) REFERENCES `managers` (`manager_id`);

--
-- Constraints for table `team_members`
--
ALTER TABLE `team_members`
  ADD CONSTRAINT `team_members_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `teams` (`team_id`);

--
-- Constraints for table `training_session`
--
ALTER TABLE `training_session`
  ADD CONSTRAINT `training_session_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `teams` (`team_id`),
  ADD CONSTRAINT `training_session_ibfk_2` FOREIGN KEY (`coach_id`) REFERENCES `coaches` (`coach_id`);

--
-- Constraints for table `use_facilities`
--
ALTER TABLE `use_facilities`
  ADD CONSTRAINT `use_facilities_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `teams` (`team_id`),
  ADD CONSTRAINT `use_facilities_ibfk_2` FOREIGN KEY (`facility_id`) REFERENCES `facilities` (`facility_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
