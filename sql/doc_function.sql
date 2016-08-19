/*
Navicat MySQL Data Transfer

Source Server         : connect1
Source Server Version : 50533
Source Host           : localhost:3309
Source Database       : hellodb

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2016-08-19 14:16:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for doc_function
-- ----------------------------
DROP TABLE IF EXISTS `doc_function`;
CREATE TABLE `doc_function` (
  `id` int(10) NOT NULL,
  `descripe` varchar(200) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doc_function
-- ----------------------------
INSERT INTO `doc_function` VALUES ('1', '采购单功能点描述', '采购单功能点');
