/*
Navicat MySQL Data Transfer

Source Server         : connect1
Source Server Version : 50533
Source Host           : localhost:3309
Source Database       : hellodb

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2016-08-19 14:16:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for doc_storage_map
-- ----------------------------
DROP TABLE IF EXISTS `doc_storage_map`;
CREATE TABLE `doc_storage_map` (
  `id` int(10) NOT NULL,
  `storage_id` int(10) DEFAULT NULL,
  `api_id` int(10) DEFAULT NULL,
  `param_name_list` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doc_storage_map
-- ----------------------------
INSERT INTO `doc_storage_map` VALUES ('1', '8', '1', 'purchase_id,\r\ncontract_no,\r\ntransport_service_code,\r\ntransport_order_id,\r\nremark,\r\nexpect_arrival_time,\r\nowner_id,\r\nowner_name,\r\nsupplier_id,\r\norder_items,\r\nsku_id,\r\nproduct_no,\r\nbarcode,\r\ngoods_name,\r\nsku_name,\r\nqty,\r\norigin_country,\r\ncode_ts,\r\nweight,\r\nhs_code,');
INSERT INTO `doc_storage_map` VALUES ('2', '25', '1', 'purchase_id,\r\ncontract_no,\r\ntransport_service_code,\r\ntransport_order_id,\r\nremark,\r\nexpect_arrival_time,\r\nowner_id,\r\nowner_name,\r\nsupplier_id,\r\norder_items,\r\nsku_id,\r\nproduct_no,\r\nbarcode,\r\ngoods_name,\r\nsku_name,\r\nqty,\r\norigin_country,\r\ncode_ts,\r\nweight,\r\nhs_code,');
INSERT INTO `doc_storage_map` VALUES ('3', '8', '2', 'order_id,\r\norder_create_time,\r\nshop_id,\r\ntransport_service_code,\r\ntransport_order_id,\r\nreceiver_zip,\r\nreceiver_province,\r\nreceiver_city,\r\nreceiver_county,\r\nreceiver_address,\r\nreceiver_name,\r\nreceiver_mobile,\r\nreceiver_phone,\r\nlogistic_mark,\r\nchannel_id,\r\nneutral_package,\r\nremark,\r\ncustoms_release_method,\r\norder_items,\r\nsku_id,\r\nqty,\r\nunit_price,\r\naliases,\r\nunit_price_aliases,\r\ncode_ts,\r\norigin_country,\r\nhs_code,\r\nunit,\r\npay_info,\r\npayment_id,\r\npayment_company_name,\r\nplatform_domain,\r\nplatform_id,\r\nplatform_name,\r\npay_amount,\r\npay_currency_code,\r\npay_rmb_amount,');
INSERT INTO `doc_storage_map` VALUES ('4', '35', '2', 'order_id,\r\norder_create_time,\r\nshop_id,\r\ntransport_service_code,\r\ntransport_order_id,\r\nreceiver_zip,\r\nreceiver_province,\r\nreceiver_city,\r\nreceiver_county,\r\nreceiver_address,\r\nreceiver_name,\r\nreceiver_mobile,\r\nreceiver_phone,\r\nlogistic_mark,\r\nchannel_id,\r\nneutral_package,\r\nremark,\r\ncustoms_release_method,\r\norder_items,\r\nsku_id,\r\nqty,\r\nunit_price,\r\naliases,\r\nunit_price_aliases,\r\ncode_ts,\r\norigin_country,\r\nhs_code,\r\nunit,\r\npay_info,\r\npayment_id,\r\npayment_company_name,\r\nplatform_domain,\r\nplatform_id,\r\nplatform_name,\r\npay_amount,\r\npay_currency_code,\r\npay_rmb_amount,');
