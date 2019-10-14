/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50155
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50155
File Encoding         : 65001

Date: 2019-10-14 09:53:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `head_url` varchar(255) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL COMMENT '0男1女',
  PRIMARY KEY (`id`),
  KEY `index_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '前端开发01', '1', null, null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('2', '前端开发02', '2', null, null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('3', '后端开发01', '10002', null, null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('4', '销售一组员1', '20001', null, null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('5', '行政组01', '30001', null, null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('6', 'yunfei', '5e75d0de843c3a9871ffd3b063f0003e', null, null, null, '2019-10-12 18:01:55', '83a644435dd24578ab00dede9f36f6ad', null, null, null);
