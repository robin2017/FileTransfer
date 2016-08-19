/*
Navicat MySQL Data Transfer

Source Server         : connect1
Source Server Version : 50533
Source Host           : localhost:3309
Source Database       : hellodb

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2016-08-19 14:16:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for doc_api
-- ----------------------------
DROP TABLE IF EXISTS `doc_api`;
CREATE TABLE `doc_api` (
  `id` int(10) NOT NULL,
  `notify_type` int(10) DEFAULT NULL,
  `push_callback_type` int(10) DEFAULT NULL,
  `name` varchar(200) NOT NULL,
  `doc_function_id` int(10) NOT NULL,
  `application_scemarios` varchar(200) DEFAULT NULL,
  `interation_flow` varchar(200) DEFAULT NULL,
  `return_result` varchar(200) DEFAULT NULL,
  `return_explain` varchar(200) DEFAULT NULL,
  `specification` varchar(500) DEFAULT NULL,
  `example` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doc_api
-- ----------------------------
INSERT INTO `doc_api` VALUES ('1', '23', '1', '采购单推送接口', '1', '网易发起采购流程，将采购详情以采购单形式通知仓库', '网易调用wms接口', '{\"success\":true/false,  //bool类型\"error_code\":wms返回的错误码}', '此处的［失败原因］请第三方wms结合自身系统及仓库实操作提供网易一份列表', '1、若采购单中的sku还未注册，新建sku对象 2、约定一张采购单的货物倒库后，wms方返回一张入库回调', null);
INSERT INTO `doc_api` VALUES ('2', '34', '1', '订单推送接口', '1', '用户在网易商城下单，网易通知仓库根据订单发货', '网易调用wms接口', '{\"success\":true/false,  //bool类型\"error_code\":wms返回的错误码}', '此处的［失败原因］请第三方wms结合自身系统及仓库实操作提供网易一份列表', '1、订单下单时若sku已经库存不足，wms返回true 2、发现推送同一个订单，返回首次的返回值', null);
