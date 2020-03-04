-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 23, 2020 at 04:10 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `palmhrdb`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `createBranch` (IN `bcd` VARCHAR(50), IN `bnm` VARCHAR(50), IN `btask` VARCHAR(100), IN `actor` VARCHAR(50))  NO SQL
INSERT INTO branch_t(BCD,BNAME,BTASKS,CREATEBY) 
VALUES (bcd,bnm,btask,actor)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createHRDepartment` (IN `dptName` VARCHAR(50), IN `dptDesc` VARCHAR(50), IN `Manager` VARCHAR(50), IN `Actor` VARCHAR(50))  NO SQL
INSERT INTO `palmhrdb`.`hr_dept_t` (`DEPTNME`, `DEPTDESC`, `MANAGER`, `CREATEBY`) 

VALUES (dptName,dptDesc,Manager,Actor)

ON DUPLICATE KEY UPDATE DEPTNME=dptName, UPDATEBY=Actor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createHREmployee` (IN `EmpNme` VARCHAR(50), IN `EmpNO` VARCHAR(50), IN `Email` VARCHAR(50), IN `EmpNssfNO` VARCHAR(50), IN `EmpTin` VARCHAR(50), IN `MobPhone` VARCHAR(50), IN `Address` VARCHAR(50), IN `DateOBirth` VARCHAR(50), IN `Nationalty` VARCHAR(50), IN `MartStatus` VARCHAR(50), IN `EmpGender` VARCHAR(50), IN `NxtOfKin` VARCHAR(50), IN `NxtKinContact` VARCHAR(50), IN `NxtKinRelation` VARCHAR(50), IN `Branch` VARCHAR(50), IN `Depart` VARCHAR(50), IN `Positn` VARCHAR(50), IN `ReptTO` VARCHAR(50), IN `DateJoin` VARCHAR(50), IN `EmpTyp` VARCHAR(50), IN `WkPhone` VARCHAR(50), IN `LevRate` VARCHAR(50), IN `WkStartDt` VARCHAR(50), IN `WkEndDt` VARCHAR(50), IN `ModeOfPay` VARCHAR(50), IN `MOMPhone` VARCHAR(50), IN `BnkName` VARCHAR(50), IN `BnkBranch` VARCHAR(50), IN `BnkActNO` VARCHAR(50), IN `Actor` VARCHAR(50))  INSERT INTO `palmhrdb`.`hr_emp_t` (`EPNME`, `EPNO`, `EPEMAIL`, `NSSFNO`, `ETIN`, `MBPHONE`, `EADDRESS`, `DOB`, `NATIONALITY`, 
`MSTATUS`, `GENDER`, `NXTKIN`, `NXTKINCONTCT`, `NXTKINRELATN`, `BRANCH`, `DEPT`, `POSTN`, `REPORTTO`, `DATEOFJOIN`, `ETYP`, 
`WRKPHONE`, LEAVERATE, `WRKSTARTDT`, `WRKENDDT`, `PAYMODE`, `MMPHONE`, `BNKNME`, `BNKBRANCH`, `BNKACTNO`, `CREATEBY`) 

VALUES (EmpNme,EmpNO,Email,EmpNssfNO,EmpTin,MobPhone,Address,DateOBirth,Nationalty,MartStatus,EmpGender,NxtOfKin,
NxtKinContact,NxtKinRelation,Branch,Depart,Positn,ReptTO,DateJoin,EmpTyp,WkPhone,LevRate,WkStartDt,WkEndDt, ModeOfPay, 
MOMPhone,BnkName,BnkBranch,BnkActNO,Actor)

ON DUPLICATE KEY UPDATE UPDATEBY = Actor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createHREmployeeType` (IN `TypeNme` VARCHAR(50), IN `Actor` VARCHAR(50))  NO SQL
INSERT INTO `palmhrdb`.`hr_emptyp_t` (`ETYPNME`, `CREATEBY`) VALUES (TypeNme,Actor)

ON DUPLICATE KEY UPDATE UPDATEBY = Actor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createHREmpPosition` (IN `PName` VARCHAR(50), IN `Actor` VARCHAR(50))  INSERT INTO `palmhrdb`.`hr_postn_t` (`POSTNME`, `CREATEBY`) 

VALUES (PName, Actor)

ON DUPLICATE KEY UPDATE UPDATEBY = Actor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createHREmpSalary` (IN `EmpNumber` VARCHAR(50), IN `PayHName` VARCHAR(50), IN `Debit` VARCHAR(50), IN `Credit` VARCHAR(50), IN `frequency` VARCHAR(50), IN `Actor` VARCHAR(50))  INSERT INTO `hr_empsalry_t` (`EMPNO`, `PAYHNME`, `DR`, `CR`, FREQNCY, `CREATEBY`) VALUES
(EmpNumber, PayHName, Debit, Credit, frequency, Actor)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createHRLeave` (IN `EmpNumber` VARCHAR(50), IN `LeaveTypeNme` VARCHAR(50), IN `StartDate` VARCHAR(50), IN `EndDate` VARCHAR(50), IN `NumDays` VARCHAR(50), IN `Remark` VARCHAR(50), IN `Actor` VARCHAR(50))  INSERT INTO `palmhrdb`.`hr_leave_t` (`EMPNO`, `TYPMNE`, `STARTDT`, `ENDDT`, `NODAYS`, `REMARKS`,
`CREATEBY`) 
VALUES (EmpNumber, LeaveTypeNme, StartDate, EndDate, NumDays, Remark, Actor)
ON DUPLICATE KEY UPDATE UPDATEBY = Actor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createHRLeaveType` (IN `TypeName` VARCHAR(50), IN `Actor` VARCHAR(50))  INSERT INTO `hr_leavetyp_t` (`LTYPNME`, `CREATEBY`) VALUES
(TypeName, Actor) ON DUPLICATE KEY UPDATE `UPDATEBY` = Actor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createHRPayHeadDtls` (IN `PayHName` VARCHAR(50), IN `TypeCode` VARCHAR(50), IN `SubTypeCode` VARCHAR(50), IN `Variant` VARCHAR(50), IN `Actor` VARCHAR(50))  INSERT INTO `palmhrdb`.`hr_payhdtls_t` (`PAYHNME`, `PAYHTYPCD`, `PAYHSUBTYPCD`, `VARIANT`, `CREATEBY`) 

VALUES (PayHName, TypeCode, SubTypeCode, Variant, Actor)

ON DUPLICATE KEY UPDATE UPDATEBY = Actor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createHRPayHeadSubType` (IN `SubTypCode` VARCHAR(50), IN `SubTypName` VARCHAR(50), IN `TypCode` VARCHAR(50), IN `Actor` VARCHAR(50))  INSERT INTO `palmhrdb`.`hr_payhsubtyp_t` (`PAYHSUBTYPCD`, `PAYHSUBTYPNME`, `PAYHTYPCD`, `CREATEBY`) 

VALUES (SubTypCode, SubTypName, TypCode, Actor)
ON DUPLICATE KEY UPDATE UPDATEBY = Actor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createHRPayHeadType` (IN `PayHCode` VARCHAR(50), IN `PayHName` VARCHAR(50), IN `Actor` VARCHAR(50))  INSERT INTO `palmhrdb`.`hr_payhtyp_t` (`PAYHTYPCD`, `PAYHTYPNME`, `CREATEBY`)

VALUES (PayHCode, PayHName,Actor)

ON DUPLICATE KEY UPDATE UPDATEBY = Actor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createHRPayRoll` (IN `ProllCode` VARCHAR(50), IN `PayHFreqncy` VARCHAR(50), IN `StartDate` VARCHAR(50), IN `EndDate` VARCHAR(50), IN `EmployCount` VARCHAR(50), IN `Amount` VARCHAR(50), IN `TransDate` VARCHAR(50), IN `Actor` VARCHAR(50))  INSERT INTO `palmhrdb`.`hr_payroll_t` (`PROLLCD`, PAYHFREQ, `STARTDT`, `ENDDT`, EMPCOUNT, `AMOUNT`, `TRANSDT`, `CREATEBY`) VALUES (ProllCode, PayHFreqncy, StartDate, EndDate, EmployCount, Amount, TransDate, Actor) ON DUPLICATE KEY UPDATE 
`UPDATEBY` = Actor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createHRPaySlip` (IN `RefNO` VARCHAR(50), IN `Descriptn` VARCHAR(50), IN `DateFrom` DATE, IN `DateTo` DATE, IN `Amount` VARCHAR(50), IN `PayRollCode` VARCHAR(50), IN `EmployID` VARCHAR(50), IN `Actor` VARCHAR(50))  INSERT INTO `palmhrdb`.`hr_pyslip_t` (`PCD`, `PDESC`, `DATEFRM`, `DATETO`, `AMT`, PROLLCD, `EMPID`, `CREATEBY`) 

VALUES (RefNO,Descriptn,DateFrom,DateTo,Amount,PayRollCode,EmployID,Actor)

ON DUPLICATE KEY UPDATE UPDATEBY = Actor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `createHRPaySlipDtls` (IN `RefNO` VARCHAR(50), IN `PayHeadNme` VARCHAR(50), IN `PayHCode` VARCHAR(50), IN `PayHTypCode` VARCHAR(50), IN `Amount` VARCHAR(50), IN `Quanlity` VARCHAR(50), IN `Actor` VARCHAR(50))  INSERT INTO `palmhrdb`.`hr_pyslip_dtls_t` (`PCD`, `PAYHNME`, `PAYHCODE`, `PAYHTYPCD`, `AMT`, `QTY`, `CREATEBY`) 

VALUES (RefNO, PayHeadNme, PayHCode, PayHTypCode, Amount, Quanlity, Actor)

ON DUPLICATE KEY UPDATE UPDATEBY = Actor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getBranch` ()  NO SQL
SELECT *
FROM branch_t b$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getHRDepartment` ()  SELECT * FROM hr_dept_t$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getHREmployees` ()  SELECT * FROM hr_emp_t$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getHREmployeeType` ()  SELECT * FROM hr_emptyp_t$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getHREmpPosition` ()  SELECT * FROM `hr_postn_t`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getHREmpSalary` (IN `EmpNumber` VARCHAR(50))  BEGIN

if(LENGTH(EmpNumber)>0)
THEN

SELECT e.*, p.PAYHTYPCD, em.EPNME FROM `hr_empsalry_t` e, hr_payhdtls_t p, hr_emp_t em
WHERE e.PAYHNME = p.PAYHNME
AND e.EMPNO = EmpNumber 
AND e.ISACTIVE <> 'N'
AND em.ISACTIVE <> 'N'
AND e.EMPNO = em.EPNO
ORDER BY e.EMPNO;


END IF;

if(LENGTH(EmpNumber)=0)
THEN

SELECT e.*, p.PAYHTYPCD, em.EPNME FROM `hr_empsalry_t` e, hr_payhdtls_t p, hr_emp_t em
WHERE e.PAYHNME = p.PAYHNME
AND e.ISACTIVE <> 'N'
AND em.ISACTIVE <> 'N'
AND e.EMPNO = em.EPNO
ORDER BY e.EMPNO;

END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getHRLeave` ()  SELECT l.*, e.EPNME, e.EPEMAIL, e.POSTN, e.DATEOFJOIN, e.WRKPHONE, e.LEAVERATE
FROM `hr_leave_t` l, hr_emp_t e
WHERE l.EMPNO = e.EPNO$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getHRLeaveType` ()  SELECT * FROM hr_leavetyp_t$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getHRLeaveUtility` ()  SELECT e.DEPT, e.EPNO, e.EPNME, (MONTH(CURDATE()) -  MONTH(e.DATEOFJOIN)) * e.LEAVERATE AS LEAVEEARNED,
COALESCE(SUM(l.NODAYS),0) AS LEAVETAKEN
FROM hr_emp_t e LEFT OUTER JOIN hr_leave_t l 
ON e.EPNO = l.EMPNO
WHERE l.TYPMNE = 'Annual'
GROUP BY e.EPNME, e.EPNO
ORDER BY e.DEPT ASC$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getHRPayHeadDtls` ()  SELECT d.*, t.PAYHTYPNME, st.PAYHSUBTYPNME 
FROM `hr_payhdtls_t` d, hr_payhtyp_t t, hr_payhsubtyp_t st
WHERE d.PAYHTYPCD = t.PAYHTYPCD
AND d.PAYHSUBTYPCD = st.PAYHSUBTYPCD$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getHRPayHeadSubType` ()  SELECT * FROM `hr_payhsubtyp_t`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getHRPayHeadType` ()  SELECT * FROM `hr_payhtyp_t`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getHRPayroll` ()  SELECT * FROM `hr_payroll_t`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getHRPaySlip` (IN `PayRollCd` VARCHAR(50))  SELECT p.*, e.EPNME FROM `hr_pyslip_t` p, hr_emp_t e
WHERE p.PROLLCD = PayRollCd 
AND p.EMPID = e.EPNO$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getHRPaySlipDtls` (IN `PaySlipCode` VARCHAR(50))  SELECT * FROM `hr_pyslip_dtls_t`
WHERE PCD = PaySlipCode$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getSeqNo` (IN `cd` VARCHAR(3), IN `yr` VARCHAR(4))  NO SQL
BEGIN

UPDATE gen_seq_t SET NEXTSQ = (NEXTSQ + 1) WHERE CODE = cd AND YEAR = yr;

SELECT NEXTSQ FROM gen_seq_t WHERE CODE = cd;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `bank_details`
--

CREATE TABLE `bank_details` (
  `Id` int(11) NOT NULL,
  `bank_name` varchar(30) NOT NULL,
  `branch` varchar(30) NOT NULL,
  `account_name` varchar(40) NOT NULL,
  `accountNo` varchar(30) NOT NULL,
  `EmpId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `branch_t`
--

CREATE TABLE `branch_t` (
  `BID` int(11) NOT NULL,
  `BCD` varchar(50) DEFAULT NULL,
  `BNAME` varchar(50) DEFAULT NULL,
  `BTASKS` varchar(100) DEFAULT NULL,
  `ISACTIVE` varchar(1) DEFAULT 'Y',
  `CREATEDT` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATEBY` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch_t`
--

INSERT INTO `branch_t` (`BID`, `BCD`, `BNAME`, `BTASKS`, `ISACTIVE`, `CREATEDT`, `CREATEBY`) VALUES
(1, 'BJ89', 'Ntinda', 'Programming', 'Y', '2018-05-29 03:34:14', 0),
(2, 'BJ80', 'Bombo Road', 'Marketing', 'Y', '2018-05-30 05:23:42', 0),
(3, 'BJ81', 'Nairobi', 'Programming and marketing', 'Y', '2018-06-02 06:47:08', 0);

-- --------------------------------------------------------

--
-- Table structure for table `children`
--

CREATE TABLE `children` (
  `Id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dependant` varchar(20) NOT NULL,
  `EmpId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `education`
--

CREATE TABLE `education` (
  `Id` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `institution` varchar(50) NOT NULL,
  `educationLvl` varchar(50) NOT NULL,
  `courseName` varchar(50) NOT NULL,
  `verrified` varchar(10) NOT NULL,
  `EmpId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `empreferences`
--

CREATE TABLE `empreferences` (
  `Id` int(11) NOT NULL,
  `names` varchar(50) NOT NULL,
  `jobPostion` varchar(40) NOT NULL,
  `employer` varchar(40) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `EmpId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `emp_bio_data`
--

CREATE TABLE `emp_bio_data` (
  `Id` int(11) NOT NULL,
  `EmpId` varchar(20) NOT NULL,
  `AppointmentDt` date NOT NULL,
  `Surname` varchar(30) NOT NULL,
  `Fname` varchar(30) NOT NULL,
  `Othername` varchar(30) NOT NULL,
  `DOB` date NOT NULL,
  `Gender` varchar(15) NOT NULL,
  `Mstatus` varchar(20) NOT NULL,
  `PostalAddress` varchar(50) NOT NULL,
  `PersonalEmail` varchar(50) NOT NULL,
  `TelNo1` varchar(20) NOT NULL,
  `TelNo2` varchar(20) NOT NULL,
  `ResidentialAddress` varchar(50) NOT NULL,
  `HomeDistrict` varchar(50) NOT NULL,
  `Disability` varchar(10) NOT NULL,
  `BloodGrp` varchar(20) NOT NULL,
  `Allergies` varchar(30) NOT NULL,
  `NssfNo` varchar(30) NOT NULL,
  `TinNo` varchar(30) NOT NULL,
  `jobId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emp_bio_data`
--

INSERT INTO `emp_bio_data` (`Id`, `EmpId`, `AppointmentDt`, `Surname`, `Fname`, `Othername`, `DOB`, `Gender`, `Mstatus`, `PostalAddress`, `PersonalEmail`, `TelNo1`, `TelNo2`, `ResidentialAddress`, `HomeDistrict`, `Disability`, `BloodGrp`, `Allergies`, `NssfNo`, `TinNo`, `jobId`) VALUES
(1, '78', '2019-01-01', 'Ssebbaale', 'Paul', '', '1995-07-30', 'Male', 'Single', '', 'paulsseb@hotmail.com', '0756528176', '', 'Makerere, Kavule', 'Wakiso', 'None', 'O', 'Meat', '2215886421', '0125548864', 1578);

-- --------------------------------------------------------

--
-- Table structure for table `gen_seq_t`
--

CREATE TABLE `gen_seq_t` (
  `MYID` int(11) NOT NULL,
  `CODE` varchar(3) NOT NULL,
  `YEAR` varchar(4) NOT NULL,
  `NEXTSQ` int(10) NOT NULL DEFAULT '0',
  `UPDATEDT` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gen_seq_t`
--

INSERT INTO `gen_seq_t` (`MYID`, `CODE`, `YEAR`, `NEXTSQ`, `UPDATEDT`) VALUES
(1, 'SLI', '2018', 8, '2018-06-29 07:50:42'),
(2, 'ROL', '2018', 5, '2018-06-29 07:50:42');

-- --------------------------------------------------------

--
-- Table structure for table `hr_dept_t`
--

CREATE TABLE `hr_dept_t` (
  `DEPTCD` int(11) NOT NULL,
  `DEPTNME` varchar(50) DEFAULT NULL,
  `DEPTDESC` varchar(100) DEFAULT NULL,
  `MANAGER` varchar(50) DEFAULT NULL,
  `ISACTIVE` varchar(1) DEFAULT 'Y',
  `CREATEDT` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATEBY` int(11) DEFAULT NULL,
  `UPDATEDT` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATEBY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_dept_t`
--

INSERT INTO `hr_dept_t` (`DEPTCD`, `DEPTNME`, `DEPTDESC`, `MANAGER`, `ISACTIVE`, `CREATEDT`, `CREATEBY`, `UPDATEDT`, `UPDATEBY`) VALUES
(1, 'IT', 'Handles company IT solution', 'IT', 'Y', '2018-05-28 04:33:51', 0, '2018-05-28 05:21:18', 0),
(2, 'Human Resource Management', 'Handles company HR needs', 'Human Resource Management', 'Y', '2018-05-28 07:20:35', 0, NULL, NULL),
(3, 'ED', 'Handles company Managerial needs', 'ED', 'Y', '2018-05-28 07:24:35', 0, NULL, NULL),
(4, 'Marketing', 'Handles company marketing needs', 'Marketing', 'Y', '2018-05-30 05:22:39', 0, NULL, NULL),
(5, 'Procurement ', 'Handles company procurement needs', 'Procurement ', 'Y', '2018-06-02 06:45:59', 0, NULL, NULL),
(7, 'Leisure', 'Handles company fun', 'Tony Odele', 'Y', '2018-06-28 08:48:46', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hr_empsalry_t`
--

CREATE TABLE `hr_empsalry_t` (
  `MYID` int(11) NOT NULL,
  `EMPNO` varchar(50) DEFAULT NULL,
  `PAYHNME` varchar(50) DEFAULT NULL,
  `DR` decimal(10,3) DEFAULT '0.000',
  `CR` decimal(10,3) DEFAULT '0.000',
  `FREQNCY` varchar(50) DEFAULT NULL,
  `ISACTIVE` varchar(1) NOT NULL DEFAULT 'Y',
  `CREATEDT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATEBY` int(11) DEFAULT NULL,
  `UPDATEDT` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATEBY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_empsalry_t`
--

INSERT INTO `hr_empsalry_t` (`MYID`, `EMPNO`, `PAYHNME`, `DR`, `CR`, `FREQNCY`, `ISACTIVE`, `CREATEDT`, `CREATEBY`, `UPDATEDT`, `UPDATEBY`) VALUES
(1, 'emp3', 'Transport Allowance', '0.000', '10000.000', 'Daily', 'Y', '2018-05-31 01:57:11', 1, '2018-06-26 08:48:07', 0),
(2, 'emp3', 'Salary', '0.000', '2500000.000', 'Monthly', 'Y', '2018-05-31 01:57:28', 1, '2018-06-26 08:48:43', NULL),
(3, 'emp2', 'Salary', '0.000', '300000.000', 'Monthly', 'Y', '2018-05-31 01:57:55', 1, '2018-06-02 01:19:17', NULL),
(4, 'emp3', 'Sacco Loans', '134000.000', '0.000', 'Monthly', '', '2018-05-31 04:25:44', 12, '2018-06-26 08:48:43', 9),
(5, 'emp3', 'fun allowance', '0.000', '500000.000', 'Monthly', 'Y', '2018-06-01 06:36:59', 0, '2018-06-26 08:48:43', 0),
(20, 'emp3', 'Medical Allowance', '0.000', '100000.000', 'Daily', 'Y', '2018-06-02 05:38:16', 12, '2018-06-26 08:48:43', 8),
(21, 'emp3', 'Food allowance', '0.000', '900000.000', 'Annually', 'Y', '2018-06-02 06:33:06', 8, '2018-06-26 08:48:43', 9),
(22, 'emp4', 'Transport Allowance', '0.000', '500000.000', 'Weekly', 'Y', '2018-06-08 04:10:27', 8, '2018-06-26 08:48:55', NULL),
(23, 'emp3', 'Tithe', '1000000.000', '0.000', 'Monthly', 'Y', '2018-06-08 04:36:41', 8, '2018-06-26 08:48:43', NULL),
(25, 'emp1', 'Transport Allowance', '0.000', '200000.000', 'Monthly', 'Y', '2018-06-28 08:17:29', 8, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hr_emptyp_t`
--

CREATE TABLE `hr_emptyp_t` (
  `MYID` int(11) NOT NULL,
  `ETYPNME` varchar(50) DEFAULT NULL,
  `CREATEDT` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATEBY` int(11) DEFAULT NULL,
  `UPDATEDT` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATEBY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_emptyp_t`
--

INSERT INTO `hr_emptyp_t` (`MYID`, `ETYPNME`, `CREATEDT`, `CREATEBY`, `UPDATEDT`, `UPDATEBY`) VALUES
(1, 'Casaul', '2018-05-28 08:48:56', 0, NULL, NULL),
(2, 'Permanent', '2018-05-28 09:04:50', 0, NULL, NULL),
(3, 'Contract', '2018-05-30 05:22:54', 0, NULL, NULL),
(4, 'Part time', '2018-06-02 06:46:14', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hr_emp_t`
--

CREATE TABLE `hr_emp_t` (
  `EPID` int(11) NOT NULL,
  `EPNME` varchar(50) DEFAULT NULL,
  `EPNO` varchar(50) DEFAULT NULL,
  `EPEMAIL` varchar(50) DEFAULT NULL,
  `NSSFNO` varchar(50) DEFAULT NULL,
  `ETIN` varchar(10) DEFAULT NULL,
  `MBPHONE` varchar(50) DEFAULT NULL,
  `EADDRESS` varchar(50) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `NATIONALITY` varchar(50) DEFAULT NULL,
  `MSTATUS` varchar(50) DEFAULT NULL,
  `GENDER` varchar(10) DEFAULT NULL,
  `NXTKIN` varchar(50) DEFAULT NULL,
  `NXTKINCONTCT` varchar(50) DEFAULT NULL,
  `NXTKINRELATN` varchar(50) DEFAULT NULL,
  `BRANCH` varchar(50) DEFAULT NULL,
  `DEPT` varchar(50) DEFAULT NULL,
  `POSTN` varchar(50) DEFAULT NULL,
  `REPORTTO` varchar(50) DEFAULT NULL,
  `DATEOFJOIN` date DEFAULT NULL,
  `ISACTIVE` varchar(1) NOT NULL DEFAULT 'Y',
  `ETYP` varchar(50) DEFAULT NULL,
  `WRKPHONE` varchar(50) DEFAULT NULL,
  `LEAVERATE` varchar(50) DEFAULT NULL,
  `WRKSTARTDT` date DEFAULT NULL,
  `WRKENDDT` date DEFAULT NULL,
  `PAYMODE` varchar(50) DEFAULT NULL,
  `MMPHONE` varchar(10) DEFAULT NULL,
  `BNKNME` varchar(50) DEFAULT NULL,
  `BNKBRANCH` varchar(50) DEFAULT NULL,
  `BNKACTNO` varchar(50) DEFAULT NULL,
  `CREATEDT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATEBY` int(11) DEFAULT NULL,
  `UPDATEDT` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATEBY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_emp_t`
--

INSERT INTO `hr_emp_t` (`EPID`, `EPNME`, `EPNO`, `EPEMAIL`, `NSSFNO`, `ETIN`, `MBPHONE`, `EADDRESS`, `DOB`, `NATIONALITY`, `MSTATUS`, `GENDER`, `NXTKIN`, `NXTKINCONTCT`, `NXTKINRELATN`, `BRANCH`, `DEPT`, `POSTN`, `REPORTTO`, `DATEOFJOIN`, `ISACTIVE`, `ETYP`, `WRKPHONE`, `LEAVERATE`, `WRKSTARTDT`, `WRKENDDT`, `PAYMODE`, `MMPHONE`, `BNKNME`, `BNKBRANCH`, `BNKACTNO`, `CREATEDT`, `CREATEBY`, `UPDATEDT`, `UPDATEBY`) VALUES
(1, 'Nyivuru Resper', 'emp1', 'respernyivuru@gmail.com', '234567', '123456789', '0757828896', 'Kyebando - kisalosalo', '2018-01-13', 'Uganda', 'Single', 'Female', 'Onega Santino', '0757828896', 'Father', 'AL', 'Human Resource Manager', 'Human Resource Manager', 'AL', '2018-06-13', 'Y', 'AK', '0757828896', '2.5', '2019-01-13', '2030-01-13', 'bank', '0757828896', 'World Bank', 'USA', '290908373837383', '2018-05-24 22:58:48', 0, '2018-06-21 21:54:19', NULL),
(2, 'Tony Odele', 'emp2', 'tonydreak@gmail.com', '2344', '123456789', '0757828896', 'Ntinda', '2018-01-13', 'Uganda', 'Single', 'Male', 'Yasmine', '0757828800', 'Girl Friend', 'AK', 'IT', 'Software Developer', 'AL', '2018-05-13', 'Y', 'AK', '0757838896', '2.5', '2018-12-13', '2030-01-13', 'bank', '123344455', 'World Bank', 'USA', '334445555', '2018-05-25 01:55:59', 0, '2018-06-22 00:39:49', NULL),
(3, 'Mugisha steven', 'emp3', 'mugisha@gmail.com', '122222', '123456789', '0757828896', 'Mityana', '2018-12-13', 'Ugandan', 'Single', 'Male', 'Harient', '0757828896', 'Friend', 'Ntinda', 'IT', 'Software Developer', 'AK', '2018-06-13', 'Y', 'Permanent', '0757828896', '2.5', '2018-01-13', '2018-01-13', 'cash', '', '', '', '', '2018-05-28 22:11:16', 0, '2018-06-25 06:59:50', NULL),
(4, 'Temba Augustine', 'emp4', 'temba@palm.com', '12333333', '1000089665', '0702234567', 'Namugongo', '2018-01-13', 'Uganda', 'Married', 'Male', 'Ozil Temb', '073345627', 'Brother', 'Ntinda', 'Human Resource Management', 'Human Resource Manager', 'AK', '2018-05-13', 'Y', 'Permanent', '08888', '2.5', '2018-01-13', '2018-01-13', 'cash', '', '', '', '', '2018-05-29 21:45:10', 0, '2018-06-25 06:59:58', NULL),
(6, 'Ssebale Paul', 'emp5', 'paul@gmail.com', '123456789', '123456789', '0757828896', 'Makerere', '1997-01-01', 'Ugandan', 'Single', 'Male', 'Andrew', '0757828896', 'Friend', 'Ntinda', 'IT', 'Software Developer', 'Temba Augustine', '2018-05-21', 'Y', 'Casaul', '0757828896', '2.5', '2018-05-21', '2018-08-01', 'cash', '', '', '', '', '2018-06-27 10:25:48', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hr_leavetyp_t`
--

CREATE TABLE `hr_leavetyp_t` (
  `MYID` int(11) NOT NULL,
  `LTYPNME` varchar(50) DEFAULT NULL,
  `CREATEDT` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATEBY` int(11) DEFAULT NULL,
  `UPDATEDT` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATEBY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_leavetyp_t`
--

INSERT INTO `hr_leavetyp_t` (`MYID`, `LTYPNME`, `CREATEDT`, `CREATEBY`, `UPDATEDT`, `UPDATEBY`) VALUES
(1, 'Annual', '2018-06-20 06:17:18', 0, NULL, NULL),
(2, 'Paternity', '2018-06-20 06:23:46', 0, '2018-06-20 09:55:07', NULL),
(3, 'Sick', '2018-06-28 08:49:24', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hr_leave_t`
--

CREATE TABLE `hr_leave_t` (
  `MYID` int(11) NOT NULL,
  `EMPNO` varchar(50) DEFAULT NULL,
  `TYPMNE` varchar(50) DEFAULT NULL,
  `STARTDT` date DEFAULT NULL,
  `ENDDT` date DEFAULT NULL,
  `NODAYS` int(50) DEFAULT NULL,
  `REMARKS` varchar(50) DEFAULT NULL,
  `STATUS` varchar(50) NOT NULL DEFAULT 'APPROVED',
  `CREATEDT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATEBY` int(11) DEFAULT NULL,
  `UPDATEDT` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATEBY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_leave_t`
--

INSERT INTO `hr_leave_t` (`MYID`, `EMPNO`, `TYPMNE`, `STARTDT`, `ENDDT`, `NODAYS`, `REMARKS`, `STATUS`, `CREATEDT`, `CREATEBY`, `UPDATEDT`, `UPDATEBY`) VALUES
(1, 'emp2', 'Paternity', '2018-06-22', '2018-06-23', 1, '', 'APPROVED', '2018-06-22 04:38:49', NULL, NULL, NULL),
(2, 'emp2', 'Annual', '2018-06-22', '2018-06-23', 1, '', 'APPROVED', '2018-06-22 06:41:32', NULL, NULL, NULL),
(3, 'emp4', 'Annual', '2018-06-22', '2018-06-23', 1, '', 'APPROVED', '2018-06-22 06:41:32', NULL, '2018-06-26 08:52:06', NULL),
(4, 'emp4', 'Annual', '2018-06-27', '2018-06-27', 1, '', 'APPROVED', '2018-06-27 13:10:43', NULL, NULL, NULL),
(5, 'emp5', 'Annual', '2018-06-27', '2018-06-28', 1, '', 'APPROVED', '2018-06-27 13:23:08', NULL, NULL, NULL),
(6, 'emp1', 'Paternity', '2018-06-27', '2018-06-30', 3, 'ok', 'APPROVED', '2018-06-27 13:34:45', NULL, NULL, NULL),
(7, 'emp2', 'Annual', '2018-06-27', '2018-06-29', 1, 'ok', 'APPROVED', '2018-06-27 13:36:31', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hr_payhdtls_t`
--

CREATE TABLE `hr_payhdtls_t` (
  `MYID` int(11) NOT NULL,
  `PAYHNME` varchar(50) DEFAULT NULL,
  `PAYHTYPCD` varchar(50) DEFAULT NULL,
  `PAYHSUBTYPCD` varchar(50) DEFAULT NULL,
  `VARIANT` varchar(50) DEFAULT NULL,
  `CREATEDT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATEBY` int(11) DEFAULT NULL,
  `UPDATEDT` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATEBY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_payhdtls_t`
--

INSERT INTO `hr_payhdtls_t` (`MYID`, `PAYHNME`, `PAYHTYPCD`, `PAYHSUBTYPCD`, `VARIANT`, `CREATEDT`, `CREATEBY`, `UPDATEDT`, `UPDATEBY`) VALUES
(1, 'Transport Allowance', '1', '12', 'Fixed', '2018-05-29 06:00:41', 0, '2018-05-30 02:33:43', NULL),
(2, 'Food allowance', '1', '11', 'Fixed', '2018-05-30 00:07:01', 0, '2018-05-30 02:33:48', NULL),
(3, 'Sacco Loans', '2', '22', 'Variable', '2018-05-30 00:33:33', 0, '2018-05-30 02:33:52', NULL),
(4, 'Salary', '1', '13', 'Fixed', '2018-05-30 02:32:38', 0, '2018-05-30 02:33:57', NULL),
(5, 'Medical Allowance', '1', '11', 'Fixed', '2018-06-01 05:04:18', 0, '2018-06-02 02:47:13', NULL),
(6, 'Fun Allowance', '1', '11', 'Fixed', '2018-06-01 05:04:18', 0, '2018-06-02 02:47:13', NULL),
(7, 'Tithe', '2', '21', 'Variable', '2018-06-02 03:14:50', 0, NULL, NULL),
(8, 'Over time', '1', '14', 'Variable', '2018-06-02 03:48:54', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hr_payhsubtyp_t`
--

CREATE TABLE `hr_payhsubtyp_t` (
  `MYID` int(11) NOT NULL,
  `PAYHSUBTYPCD` int(11) NOT NULL,
  `PAYHSUBTYPNME` varchar(50) DEFAULT NULL,
  `PAYHTYPCD` varchar(50) NOT NULL,
  `CREATEDT` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATEBY` int(11) DEFAULT NULL,
  `UPDATEDT` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATEBY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_payhsubtyp_t`
--

INSERT INTO `hr_payhsubtyp_t` (`MYID`, `PAYHSUBTYPCD`, `PAYHSUBTYPNME`, `PAYHTYPCD`, `CREATEDT`, `CREATEBY`, `UPDATEDT`, `UPDATEBY`) VALUES
(1, 11, 'Holiday Allowance', '1', '2018-05-29 10:29:15', 0, NULL, NULL),
(2, 12, 'Medical Allowance', '1', '2018-05-29 10:30:14', 0, NULL, NULL),
(3, 21, 'Taxes', '2', '2018-05-29 10:30:45', 0, NULL, NULL),
(4, 22, 'Other taxes', '2', '2018-05-29 10:31:11', 0, NULL, NULL),
(5, 13, 'Basic Pay', '1', '2018-05-30 05:24:02', 0, NULL, NULL),
(6, 14, 'Bonus', '1', '2018-06-02 06:48:14', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hr_payhtyp_t`
--

CREATE TABLE `hr_payhtyp_t` (
  `PAYHTYPCD` int(11) NOT NULL,
  `PAYHTYPNME` varchar(50) DEFAULT NULL,
  `CREATEDT` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATEBY` int(11) DEFAULT NULL,
  `UPDATEDT` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATEBY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_payhtyp_t`
--

INSERT INTO `hr_payhtyp_t` (`PAYHTYPCD`, `PAYHTYPNME`, `CREATEDT`, `CREATEBY`, `UPDATEDT`, `UPDATEBY`) VALUES
(1, 'Earnings', '2018-05-29 06:17:26', NULL, '2018-05-29 06:17:51', NULL),
(2, 'Deductions', '2018-05-29 06:17:43', NULL, '2018-05-29 06:17:57', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hr_payroll_t`
--

CREATE TABLE `hr_payroll_t` (
  `PROLLCD` varchar(50) NOT NULL,
  `PAYHFREQ` varchar(10) DEFAULT NULL,
  `STARTDT` date DEFAULT NULL,
  `ENDDT` date DEFAULT NULL,
  `EMPCOUNT` int(11) DEFAULT NULL,
  `AMOUNT` varchar(50) DEFAULT NULL,
  `TRANSDT` date DEFAULT NULL,
  `CREATEDT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATEBY` int(11) NOT NULL,
  `UPDATEDT` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATEBY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_payroll_t`
--

INSERT INTO `hr_payroll_t` (`PROLLCD`, `PAYHFREQ`, `STARTDT`, `ENDDT`, `EMPCOUNT`, `AMOUNT`, `TRANSDT`, `CREATEDT`, `CREATEBY`, `UPDATEDT`, `UPDATEBY`) VALUES
('PAYROLL/003', 'Daily', '2018-06-29', '2018-06-30', 1, '220000', '2018-06-29', '2018-06-29 07:01:16', 0, NULL, NULL),
('PAYROLL/004', 'Daily', '2018-06-30', '2018-07-01', 1, '220000', '2018-06-29', '2018-06-29 07:24:15', 0, NULL, NULL),
('PAYROLL/005', 'Monthly', '2018-06-01', '2018-06-30', 3, '2366000', '2018-06-29', '2018-06-29 07:50:42', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hr_postn_t`
--

CREATE TABLE `hr_postn_t` (
  `POSTNCD` int(11) NOT NULL,
  `POSTNME` varchar(50) DEFAULT NULL,
  `CREATEDT` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATEBY` int(11) DEFAULT NULL,
  `UPDATEDT` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATEBY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_postn_t`
--

INSERT INTO `hr_postn_t` (`POSTNCD`, `POSTNME`, `CREATEDT`, `CREATEBY`, `UPDATEDT`, `UPDATEBY`) VALUES
(1, 'Software Developer', '2018-05-28 09:21:16', 0, NULL, NULL),
(2, 'Accountant', '2018-05-30 02:54:41', 0, NULL, NULL),
(3, 'Marketier', '2018-05-30 05:23:16', 0, NULL, NULL),
(4, 'Human Resource Manager', '2018-06-02 06:46:35', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hr_pyslip_dtls_t`
--

CREATE TABLE `hr_pyslip_dtls_t` (
  `MYID` int(11) NOT NULL,
  `PCD` varchar(50) NOT NULL,
  `PAYHNME` varchar(50) DEFAULT NULL,
  `PAYHCODE` varchar(50) DEFAULT NULL,
  `PAYHTYPCD` varchar(50) DEFAULT NULL,
  `AMT` varchar(50) DEFAULT NULL,
  `QTY` varchar(50) DEFAULT NULL,
  `CREATEDT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATEBY` int(11) DEFAULT NULL,
  `UPDATEDT` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATEBY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_pyslip_dtls_t`
--

INSERT INTO `hr_pyslip_dtls_t` (`MYID`, `PCD`, `PAYHNME`, `PAYHCODE`, `PAYHTYPCD`, `AMT`, `QTY`, `CREATEDT`, `CREATEBY`, `UPDATEDT`, `UPDATEBY`) VALUES
(1, 'SLIP/004', 'Medical Allowance', '', '1', '100000', '1', '2018-06-29 07:01:16', 0, NULL, NULL),
(2, 'SLIP/004', 'Transport Allowance', '', '1', '10000', '1', '2018-06-29 07:01:16', 0, NULL, NULL),
(3, 'SLIP/005', 'Medical Allowance', '', '1', '100000', '1', '2018-06-29 07:24:15', 0, NULL, NULL),
(4, 'SLIP/005', 'Transport Allowance', '', '1', '10000', '1', '2018-06-29 07:24:15', 0, NULL, NULL),
(5, 'SLIP/006', 'Transport Allowance', '', '1', '200000', '1', '2018-06-29 07:50:42', 0, NULL, NULL),
(6, 'SLIP/007', 'Salary', '', '1', '300000', '1', '2018-06-29 07:50:42', 0, NULL, NULL),
(7, 'SLIP/008', 'Sacco Loans', '', '2', '-134000', '1', '2018-06-29 07:50:42', 0, NULL, NULL),
(8, 'SLIP/008', 'fun allowance', '', '1', '500000', '1', '2018-06-29 07:50:42', 0, NULL, NULL),
(9, 'SLIP/008', 'Tithe', '', '2', '-1000000', '1', '2018-06-29 07:50:42', 0, NULL, NULL),
(10, 'SLIP/008', 'Salary', '', '1', '2500000', '1', '2018-06-29 07:50:42', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hr_pyslip_t`
--

CREATE TABLE `hr_pyslip_t` (
  `PCD` varchar(50) NOT NULL,
  `PDESC` varchar(50) DEFAULT NULL,
  `DATEFRM` date DEFAULT NULL,
  `DATETO` date DEFAULT NULL,
  `AMT` varchar(50) DEFAULT NULL,
  `PROLLCD` varchar(50) DEFAULT NULL,
  `EMPID` varchar(50) DEFAULT NULL,
  `CREATEDT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATEBY` int(11) DEFAULT NULL,
  `UPDATEDT` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATEBY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_pyslip_t`
--

INSERT INTO `hr_pyslip_t` (`PCD`, `PDESC`, `DATEFRM`, `DATETO`, `AMT`, `PROLLCD`, `EMPID`, `CREATEDT`, `CREATEBY`, `UPDATEDT`, `UPDATEBY`) VALUES
('SLIP/004', 'Salary Information', '2018-06-29', '2018-06-30', '110000', 'PAYROLL/003', 'emp3', '2018-06-29 07:01:16', 0, NULL, NULL),
('SLIP/005', 'Salary Information', '2018-06-30', '2018-07-01', '110000', 'PAYROLL/004', 'emp3', '2018-06-29 07:24:15', 0, NULL, NULL),
('SLIP/006', 'Salary Information', '2018-06-01', '2018-06-30', '200000', 'PAYROLL/005', 'emp1', '2018-06-29 07:50:42', 0, NULL, NULL),
('SLIP/007', 'Salary Information', '2018-06-01', '2018-06-30', '300000', 'PAYROLL/005', 'emp2', '2018-06-29 07:50:42', 0, NULL, NULL),
('SLIP/008', 'Salary Information', '2018-06-01', '2018-06-30', '1866000', 'PAYROLL/005', 'emp3', '2018-06-29 07:50:42', 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `job_details`
--

CREATE TABLE `job_details` (
  `jobId` int(11) NOT NULL,
  `job_title` varchar(20) NOT NULL,
  `jobcategory` varchar(20) NOT NULL,
  `Emp_type` varchar(15) NOT NULL,
  `job_grade` varchar(15) NOT NULL,
  `department` varchar(30) NOT NULL,
  `duty_station` varchar(30) NOT NULL,
  `salary` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `national_ids`
--

CREATE TABLE `national_ids` (
  `Id` int(11) NOT NULL,
  `NIN` varchar(30) NOT NULL,
  `expiryDt` date NOT NULL,
  `EmpId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `nxtokin`
--

CREATE TABLE `nxtokin` (
  `Id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `relationship` varchar(20) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `placeOfwork` varchar(30) NOT NULL,
  `physicalAddress` varchar(30) NOT NULL,
  `EmpId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `otherdependant`
--

CREATE TABLE `otherdependant` (
  `Id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(15) NOT NULL,
  `relationship` varchar(20) NOT NULL,
  `EmpId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `passport_no`
--

CREATE TABLE `passport_no` (
  `Id` int(11) NOT NULL,
  `passport_no` varchar(40) NOT NULL,
  `expiryDt` date NOT NULL,
  `EmpId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `probodymembership`
--

CREATE TABLE `probodymembership` (
  `Id` int(11) NOT NULL,
  `nameOassociation` varchar(40) NOT NULL,
  `typeOmembership` varchar(30) NOT NULL,
  `EmpId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `spouse_info`
--

CREATE TABLE `spouse_info` (
  `Id` int(11) NOT NULL,
  `FullName` varchar(40) NOT NULL,
  `dob` date NOT NULL,
  `nationality` varchar(40) NOT NULL,
  `placeOwork` varchar(40) NOT NULL,
  `telephone` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `EmpId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `workexperience`
--

CREATE TABLE `workexperience` (
  `Id` int(11) NOT NULL,
  `organisation` varchar(40) NOT NULL,
  `lastPostionHeld` varchar(40) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `exitReason` varchar(50) NOT NULL,
  `clearanceLetter` varchar(10) NOT NULL,
  `EmpId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `work_permit_no`
--

CREATE TABLE `work_permit_no` (
  `Id` int(11) NOT NULL,
  `workPNo` varchar(40) NOT NULL,
  `expiryDt` date NOT NULL,
  `EmpId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank_details`
--
ALTER TABLE `bank_details`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `EmpId` (`EmpId`);

--
-- Indexes for table `branch_t`
--
ALTER TABLE `branch_t`
  ADD PRIMARY KEY (`BID`);

--
-- Indexes for table `children`
--
ALTER TABLE `children`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `EmpId` (`EmpId`);

--
-- Indexes for table `education`
--
ALTER TABLE `education`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `EmpId` (`EmpId`);

--
-- Indexes for table `empreferences`
--
ALTER TABLE `empreferences`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `EmpId` (`EmpId`);

--
-- Indexes for table `emp_bio_data`
--
ALTER TABLE `emp_bio_data`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `jobId` (`jobId`),
  ADD UNIQUE KEY `EmpId` (`EmpId`);

--
-- Indexes for table `gen_seq_t`
--
ALTER TABLE `gen_seq_t`
  ADD PRIMARY KEY (`MYID`),
  ADD UNIQUE KEY `CODE` (`CODE`);

--
-- Indexes for table `hr_dept_t`
--
ALTER TABLE `hr_dept_t`
  ADD PRIMARY KEY (`DEPTCD`);

--
-- Indexes for table `hr_empsalry_t`
--
ALTER TABLE `hr_empsalry_t`
  ADD PRIMARY KEY (`MYID`);

--
-- Indexes for table `hr_emptyp_t`
--
ALTER TABLE `hr_emptyp_t`
  ADD PRIMARY KEY (`MYID`);

--
-- Indexes for table `hr_emp_t`
--
ALTER TABLE `hr_emp_t`
  ADD PRIMARY KEY (`EPID`),
  ADD UNIQUE KEY `EPNO` (`EPNO`);

--
-- Indexes for table `hr_leavetyp_t`
--
ALTER TABLE `hr_leavetyp_t`
  ADD PRIMARY KEY (`MYID`);

--
-- Indexes for table `hr_leave_t`
--
ALTER TABLE `hr_leave_t`
  ADD PRIMARY KEY (`MYID`);

--
-- Indexes for table `hr_payhdtls_t`
--
ALTER TABLE `hr_payhdtls_t`
  ADD PRIMARY KEY (`MYID`);

--
-- Indexes for table `hr_payhsubtyp_t`
--
ALTER TABLE `hr_payhsubtyp_t`
  ADD PRIMARY KEY (`MYID`);

--
-- Indexes for table `hr_payhtyp_t`
--
ALTER TABLE `hr_payhtyp_t`
  ADD PRIMARY KEY (`PAYHTYPCD`);

--
-- Indexes for table `hr_payroll_t`
--
ALTER TABLE `hr_payroll_t`
  ADD PRIMARY KEY (`PROLLCD`);

--
-- Indexes for table `hr_postn_t`
--
ALTER TABLE `hr_postn_t`
  ADD PRIMARY KEY (`POSTNCD`);

--
-- Indexes for table `hr_pyslip_dtls_t`
--
ALTER TABLE `hr_pyslip_dtls_t`
  ADD PRIMARY KEY (`MYID`);

--
-- Indexes for table `hr_pyslip_t`
--
ALTER TABLE `hr_pyslip_t`
  ADD PRIMARY KEY (`PCD`);

--
-- Indexes for table `job_details`
--
ALTER TABLE `job_details`
  ADD PRIMARY KEY (`jobId`);

--
-- Indexes for table `national_ids`
--
ALTER TABLE `national_ids`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `EmpId` (`EmpId`);

--
-- Indexes for table `nxtokin`
--
ALTER TABLE `nxtokin`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `EmpId` (`EmpId`);

--
-- Indexes for table `otherdependant`
--
ALTER TABLE `otherdependant`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `EmpId` (`EmpId`);

--
-- Indexes for table `passport_no`
--
ALTER TABLE `passport_no`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `EmpId` (`EmpId`);

--
-- Indexes for table `probodymembership`
--
ALTER TABLE `probodymembership`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `EmpId` (`EmpId`);

--
-- Indexes for table `spouse_info`
--
ALTER TABLE `spouse_info`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `EmpId` (`EmpId`);

--
-- Indexes for table `workexperience`
--
ALTER TABLE `workexperience`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `EmpId` (`EmpId`);

--
-- Indexes for table `work_permit_no`
--
ALTER TABLE `work_permit_no`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `EmpId` (`EmpId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bank_details`
--
ALTER TABLE `bank_details`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `branch_t`
--
ALTER TABLE `branch_t`
  MODIFY `BID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `children`
--
ALTER TABLE `children`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `education`
--
ALTER TABLE `education`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `empreferences`
--
ALTER TABLE `empreferences`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `emp_bio_data`
--
ALTER TABLE `emp_bio_data`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `gen_seq_t`
--
ALTER TABLE `gen_seq_t`
  MODIFY `MYID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `hr_dept_t`
--
ALTER TABLE `hr_dept_t`
  MODIFY `DEPTCD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `hr_empsalry_t`
--
ALTER TABLE `hr_empsalry_t`
  MODIFY `MYID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `hr_emptyp_t`
--
ALTER TABLE `hr_emptyp_t`
  MODIFY `MYID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `hr_emp_t`
--
ALTER TABLE `hr_emp_t`
  MODIFY `EPID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `hr_leavetyp_t`
--
ALTER TABLE `hr_leavetyp_t`
  MODIFY `MYID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `hr_leave_t`
--
ALTER TABLE `hr_leave_t`
  MODIFY `MYID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `hr_payhdtls_t`
--
ALTER TABLE `hr_payhdtls_t`
  MODIFY `MYID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `hr_payhsubtyp_t`
--
ALTER TABLE `hr_payhsubtyp_t`
  MODIFY `MYID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `hr_payhtyp_t`
--
ALTER TABLE `hr_payhtyp_t`
  MODIFY `PAYHTYPCD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `hr_postn_t`
--
ALTER TABLE `hr_postn_t`
  MODIFY `POSTNCD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `hr_pyslip_dtls_t`
--
ALTER TABLE `hr_pyslip_dtls_t`
  MODIFY `MYID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `job_details`
--
ALTER TABLE `job_details`
  MODIFY `jobId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `national_ids`
--
ALTER TABLE `national_ids`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nxtokin`
--
ALTER TABLE `nxtokin`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `otherdependant`
--
ALTER TABLE `otherdependant`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `passport_no`
--
ALTER TABLE `passport_no`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `probodymembership`
--
ALTER TABLE `probodymembership`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `spouse_info`
--
ALTER TABLE `spouse_info`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `workexperience`
--
ALTER TABLE `workexperience`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `work_permit_no`
--
ALTER TABLE `work_permit_no`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
