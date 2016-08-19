/*
Navicat MySQL Data Transfer

Source Server         : connect1
Source Server Version : 50533
Source Host           : localhost:3309
Source Database       : hellodb

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2016-08-19 14:16:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for doc_param
-- ----------------------------
DROP TABLE IF EXISTS `doc_param`;
CREATE TABLE `doc_param` (
  `id` int(10) NOT NULL,
  `doc_api_id` int(10) NOT NULL,
  `param_name` varchar(30) DEFAULT NULL,
  `param_type` varchar(10) DEFAULT NULL,
  `param_demo` varchar(255) DEFAULT NULL,
  `param_descripe` varchar(500) DEFAULT NULL,
  `parent_id` int(10) DEFAULT NULL,
  `has_child` tinyint(4) DEFAULT NULL,
  `order_no` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doc_param
-- ----------------------------
INSERT INTO `doc_param` VALUES ('1', '1', 'purchase_id', 'String', 'purchase_id', '采购单号', '0', '0', '10');
INSERT INTO `doc_param` VALUES ('2', '1', 'contract_no', 'String', 'contract_no', '采购单对应合同编号', '0', '0', '20');
INSERT INTO `doc_param` VALUES ('3', '1', 'transport_service_code', 'String', 'ems', '物流供应商代号，非必填', '0', '0', '30');
INSERT INTO `doc_param` VALUES ('4', '1', 'transport_order_id', 'String', 'qaws12345', '物流单号，非必填', '0', '0', '40');
INSERT INTO `doc_param` VALUES ('5', '1', 'remark', 'String', '集装箱号xxx，司机电话xxx', null, '0', '0', '50');
INSERT INTO `doc_param` VALUES ('6', '1', 'expect_arrival_time', 'String', '2014-11-06 16:16:20', '预期抵达时间，非必填', '0', '0', '60');
INSERT INTO `doc_param` VALUES ('7', '1', 'owner_id', 'String', '1001', '货主ID ', '0', '0', '70');
INSERT INTO `doc_param` VALUES ('8', '1', 'owner_name', 'String', '网易考拉', '货主名称', '0', '0', '80');
INSERT INTO `doc_param` VALUES ('9', '1', 'supplier_id', 'int', '23546', null, '0', '0', '90');
INSERT INTO `doc_param` VALUES ('10', '1', 'order_items', 'List', null, '物品列表', '0', '1', '100');
INSERT INTO `doc_param` VALUES ('11', '1', 'sku_id', 'String', 'sku_id', 'sku_id', '10', '0', '110');
INSERT INTO `doc_param` VALUES ('12', '1', 'product_no', 'String', '12345', '自定义商品序列号 与sku一一对应,可打印成条形码 ', '10', '0', '120');
INSERT INTO `doc_param` VALUES ('13', '1', 'barcode', 'String', '12345', '商品原生条形码', '10', '0', '130');
INSERT INTO `doc_param` VALUES ('14', '1', 'goods_name', 'String', '飞利浦电饭煲', '商品名', '10', '0', '140');
INSERT INTO `doc_param` VALUES ('15', '1', 'sku_name', 'String', '飞利浦电饭煲（白金内胆）', ' 规格名称', '10', '0', '150');
INSERT INTO `doc_param` VALUES ('16', '1', 'qty', 'String', '1000', '数量', '10', '0', '160');
INSERT INTO `doc_param` VALUES ('17', '1', 'origin_country', 'String', '原产国编码', '原产国编码', '10', '0', '170');
INSERT INTO `doc_param` VALUES ('18', '1', 'code_ts', 'String', '行邮税号', '行邮税号', '10', '0', '180');
INSERT INTO `doc_param` VALUES ('19', '1', 'weight', 'String', '重量', '重量（KG）', '10', '0', '190');
INSERT INTO `doc_param` VALUES ('20', '1', 'hs_code', 'String', '海关编码', '海关编码', '10', '0', '200');
INSERT INTO `doc_param` VALUES ('21', '2', 'order_id', 'String', 'OrderId', '订单号', '0', '0', '10');
INSERT INTO `doc_param` VALUES ('22', '2', 'order_create_time', 'String', '2014-11-06 16:16:20', '支付时间', '0', '0', '20');
INSERT INTO `doc_param` VALUES ('23', '2', 'shop_id', 'String', '8080', '店铺id，非必填', '0', '0', '30');
INSERT INTO `doc_param` VALUES ('24', '2', 'transport_service_code', 'String', 'EMS', '物流供应商代号，列表见附件', '0', '0', '40');
INSERT INTO `doc_param` VALUES ('25', '2', 'transport_order_id', 'String', 'qaws12345', '物流单号,注:国内仓库不需要传这个字段.', '0', '0', '50');
INSERT INTO `doc_param` VALUES ('26', '2', 'receiver_zip', 'String', '311251', '非必填', '0', '0', '60');
INSERT INTO `doc_param` VALUES ('27', '2', 'receiver_province', 'String', '浙江', null, '0', '0', '70');
INSERT INTO `doc_param` VALUES ('28', '2', 'receiver_city', 'String', '杭州', null, '0', '0', '80');
INSERT INTO `doc_param` VALUES ('29', '2', 'receiver_county', 'String', '滨江区', null, '0', '0', '90');
INSERT INTO `doc_param` VALUES ('30', '2', 'receiver_address', 'String', '网商路599号网易', null, '0', '0', '100');
INSERT INTO `doc_param` VALUES ('31', '2', 'receiver_name', 'String', '阿基米德', null, '0', '0', '110');
INSERT INTO `doc_param` VALUES ('32', '2', 'receiver_mobile', 'String', '13777387619', null, '0', '0', '120');
INSERT INTO `doc_param` VALUES ('33', '2', 'receiver_phone', 'String', '0571-12345678', null, '0', '0', '130');
INSERT INTO `doc_param` VALUES ('34', '2', 'logistic_mark', 'String', '北京转杭州', '非必填', '0', '0', '140');
INSERT INTO `doc_param` VALUES ('35', '2', 'channel_id', 'String', '10086', '渠道ID 网易考拉定义', '0', '0', '150');
INSERT INTO `doc_param` VALUES ('36', '2', 'neutral_package', 'int', '0', '包装类型 非必填；  0或者没有该字段或者字段为空代表考拉包装 1代表中性包装', '0', '0', '160');
INSERT INTO `doc_param` VALUES ('37', '2', 'remark', 'String', '备注', '订单备注 保留字段目前未使用', '0', '0', '170');
INSERT INTO `doc_param` VALUES ('38', '2', 'customs_release_method', 'String', '51', '杭州电子口岸保税特有字段 String类型\r\n可能的值,  “51”,  “52”,  “53”,  “other” 各指含义:  \r\n“51” - 流水线自动放行  “52” -手工放行 ”53” -直接放行 “other” –是海关漏发回执给我们，我们自己去打口岸电话查到已放行或者去口岸官网查到已放行的，这种订单是手动置成已出关了，但回执表里没有回执，所以不知道放行的具体方式，只能发个other给仓库了.\r\n', '0', '0', '180');
INSERT INTO `doc_param` VALUES ('39', '2', 'order_items', 'List', null, null, '0', '1', '190');
INSERT INTO `doc_param` VALUES ('40', '2', 'sku_id', 'String', 'sku_id', 'sku_id', '39', '0', '200');
INSERT INTO `doc_param` VALUES ('41', '2', 'qty', 'int', '1000', '数量', '39', '0', '210');
INSERT INTO `doc_param` VALUES ('42', '2', 'unit_price', 'int', '100', '单价（单位:元） 香港仓需要传递该字段 ', '39', '0', '220');
INSERT INTO `doc_param` VALUES ('43', '2', 'aliases', 'String', '通关别名', '通关别名,选填，海淘商品需要（如果该字段不为空则包裹面单上写该名称，如果为空则写真实货物名称）', '39', '0', '230');
INSERT INTO `doc_param` VALUES ('44', '2', 'unit_price_aliases', '', '100', '单价（单位:元）选填，海淘商品需要（如果该字段不为空则包裹面单上写该价格，如果为空则写货物真实价格）', '39', '0', '240');
INSERT INTO `doc_param` VALUES ('45', '2', 'code_ts', 'String', '00000001', '行邮税号', '39', '0', '250');
INSERT INTO `doc_param` VALUES ('46', '2', 'origin_country', 'String', '715', '原产国代码', '39', '0', '260');
INSERT INTO `doc_param` VALUES ('47', '2', 'hs_code', 'String', 'HZ00098', '海关HS编码', '39', '0', '270');
INSERT INTO `doc_param` VALUES ('48', '2', 'unit', 'String', '001', '商品的申报计量单位', '39', '0', '280');
INSERT INTO `doc_param` VALUES ('49', '2', 'pay_info', 'Items', null, '支付信息,个人物品清关必填', '0', '1', '290');
INSERT INTO `doc_param` VALUES ('50', '2', 'payment_id', 'String', '1231231231231231231231231231', '支付交易号,支付公司提供', '49', '0', '300');
INSERT INTO `doc_param` VALUES ('51', '2', 'payment_company_name', 'String', '支付宝（中国）网络技术有限公司', '支付企业名称', '49', '0', '310');
INSERT INTO `doc_param` VALUES ('52', '2', 'platform_domain', 'String', 'kaola.com', '电商平台域名', '49', '0', '320');
INSERT INTO `doc_param` VALUES ('53', '2', 'platform_id', 'String', null, '电商平台编号', '49', '0', '330');
INSERT INTO `doc_param` VALUES ('54', '2', 'platform_name', '', '考拉海购', '电商商户名称', '49', '0', '340');
INSERT INTO `doc_param` VALUES ('55', '2', 'pay_amount', null, '100.26', '支付金额，数值类型，可能有小数 单位元', '49', '0', '350');
INSERT INTO `doc_param` VALUES ('56', '2', 'pay_currency_code', 'String', 'CNY', '支付币制代码', '49', '0', '360');
INSERT INTO `doc_param` VALUES ('57', '2', 'pay_rmb_amount', null, '100.26', '人民币金额，数值类型，可能有小数 单位元', '49', '0', '370');
