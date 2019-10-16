/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50155
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50155
File Encoding         : 65001

Date: 2019-10-16 22:50:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_area
-- ----------------------------
DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL,
  `area_name` varchar(255) DEFAULT NULL,
  `area_code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_parent_id` (`parent_id`) USING BTREE,
  KEY `index_area_code` (`area_code`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='区域表';

-- ----------------------------
-- Records of t_area
-- ----------------------------

-- ----------------------------
-- Table structure for t_cultural_famous_ht
-- ----------------------------
DROP TABLE IF EXISTS `t_cultural_famous_ht`;
CREATE TABLE `t_cultural_famous_ht` (
  `id` int(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `area_code` varchar(32) DEFAULT NULL COMMENT '区域code',
  `sex` tinyint(1) DEFAULT NULL COMMENT '0男1女',
  `age` tinyint(2) DEFAULT NULL,
  `profession_code` varchar(255) DEFAULT NULL COMMENT '职业code',
  `representative_works` varchar(255) DEFAULT NULL COMMENT '代表作品',
  `resume` varchar(1000) DEFAULT NULL COMMENT '简介',
  `lifetime` varchar(1000) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL COMMENT '职务',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='沪台文化名人';

-- ----------------------------
-- Records of t_cultural_famous_ht
-- ----------------------------

-- ----------------------------
-- Table structure for t_cultural_people_tw
-- ----------------------------
DROP TABLE IF EXISTS `t_cultural_people_tw`;
CREATE TABLE `t_cultural_people_tw` (
  `id` int(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `area_code` varchar(32) DEFAULT NULL COMMENT '区域code',
  `sex` tinyint(1) DEFAULT NULL COMMENT '0男1女',
  `age` tinyint(2) DEFAULT NULL,
  `profession_code` varchar(255) DEFAULT NULL COMMENT '职业code',
  `representative_works` varchar(255) DEFAULT NULL COMMENT '代表作品',
  `resume` varchar(1000) DEFAULT NULL COMMENT '简介',
  `lifetime` varchar(1000) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL COMMENT '职务',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='台湾文化人士';

-- ----------------------------
-- Records of t_cultural_people_tw
-- ----------------------------

-- ----------------------------
-- Table structure for t_cultural_specialist_sh
-- ----------------------------
DROP TABLE IF EXISTS `t_cultural_specialist_sh`;
CREATE TABLE `t_cultural_specialist_sh` (
  `id` int(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `area_code` varchar(32) DEFAULT NULL COMMENT '区域code',
  `sex` tinyint(1) DEFAULT NULL COMMENT '0男1女',
  `age` tinyint(2) DEFAULT NULL,
  `profession_code` varchar(255) DEFAULT NULL COMMENT '职业code',
  `representative_works` varchar(255) DEFAULT NULL COMMENT '代表作品',
  `resume` varchar(1000) DEFAULT NULL COMMENT '简介',
  `lifetime` varchar(1000) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL COMMENT '职务',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='上海文化专家';

-- ----------------------------
-- Records of t_cultural_specialist_sh
-- ----------------------------

-- ----------------------------
-- Table structure for t_profession
-- ----------------------------
DROP TABLE IF EXISTS `t_profession`;
CREATE TABLE `t_profession` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL,
  `profession_name` varchar(255) NOT NULL,
  `profession_code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_profession_code` (`profession_code`) USING BTREE,
  KEY `index_parent_id` (`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='职业表';

-- ----------------------------
-- Records of t_profession
-- ----------------------------
INSERT INTO `t_profession` VALUES ('1', '0', '人物', '10000', null, null);
INSERT INTO `t_profession` VALUES ('2', '1', '娱乐明星', '10010', null, null);
INSERT INTO `t_profession` VALUES ('3', '1', '电影导演', '10020', null, null);
INSERT INTO `t_profession` VALUES ('4', '1', '作家', '10030', null, null);
INSERT INTO `t_profession` VALUES ('5', '1', '艺术家', '10040', null, null);
INSERT INTO `t_profession` VALUES ('6', '1', '体育人物', '10050', null, null);
INSERT INTO `t_profession` VALUES ('7', '1', '设计师', '10060', null, null);
INSERT INTO `t_profession` VALUES ('8', '1', '其他文艺行业从业者', '10070', null, null);
INSERT INTO `t_profession` VALUES ('9', '1', '政治人物', '10080', null, null);
INSERT INTO `t_profession` VALUES ('10', '2', '演员', '10011', null, null);
INSERT INTO `t_profession` VALUES ('11', '2', '歌手', '10012', null, null);
INSERT INTO `t_profession` VALUES ('12', '2', '偶像团体成员', '10013', null, null);
INSERT INTO `t_profession` VALUES ('13', '2', '综合演艺从业者', '10014', null, null);
INSERT INTO `t_profession` VALUES ('14', '4', '剧作家', '10031', null, null);
INSERT INTO `t_profession` VALUES ('15', '5', '雕塑家', '10041', null, null);
INSERT INTO `t_profession` VALUES ('16', '5', '画家', '10042', null, null);
INSERT INTO `t_profession` VALUES ('17', '5', '音乐家', '10043', null, null);
INSERT INTO `t_profession` VALUES ('18', '5', '漫画家', '10044', null, null);
INSERT INTO `t_profession` VALUES ('19', '8', '主持人', '10071', null, null);
INSERT INTO `t_profession` VALUES ('20', '8', '电影剪辑', '10072', null, null);

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
INSERT INTO `t_user` VALUES ('1', 'yunfei', '5e75d0de843c3a9871ffd3b063f0003e', null, null, null, '2019-10-12 18:01:55', '83a644435dd24578ab00dede9f36f6ad', null, null, null);

-- ----------------------------
-- Procedure structure for comment_task
-- ----------------------------
DROP PROCEDURE IF EXISTS `comment_task`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `comment_task`()
BEGIN
	DECLARE orderIdParam varchar(50) DEFAULT NULL; 
	DECLARE num INT DEFAULT 0;
	DECLARE order_list CURSOR FOR select orderId from tb_comment t where t.createTime is null and t.orderId is not null GROUP BY t.orderId;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET num = 1 ; 
	OPEN order_list ;
		REPEAT FETCH order_list INTO orderIdParam;
			IF NOT num THEN
				update tb_comment set createTime = (
					select createTime from tb_shop_order where orderId = orderIdParam limit 1
				) where orderId = orderIdParam;
			END IF ; 
		UNTIL num END REPEAT ; 
	CLOSE order_list ;
END
;;
DELIMITER ;
