/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50155
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50155
File Encoding         : 65001

Date: 2019-10-15 14:26:38
*/

SET FOREIGN_KEY_CHECKS=0;

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
  KEY `index_username` (`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='职业表';

-- ----------------------------
-- Records of t_profession
-- ----------------------------
INSERT INTO `t_profession` VALUES ('1', '0', '人物', null, null, null);
INSERT INTO `t_profession` VALUES ('2', '1', '娱乐明星', null, null, null);
INSERT INTO `t_profession` VALUES ('3', '1', '电影导演', null, null, null);
INSERT INTO `t_profession` VALUES ('4', '1', '作家', null, null, null);
INSERT INTO `t_profession` VALUES ('5', '1', '艺术家', null, null, null);
INSERT INTO `t_profession` VALUES ('6', '1', '体育人物', null, null, null);
INSERT INTO `t_profession` VALUES ('7', '1', '设计师', null, null, null);
INSERT INTO `t_profession` VALUES ('8', '1', '其他文艺行业从业者', null, null, null);
INSERT INTO `t_profession` VALUES ('9', '1', '政治人物', null, null, null);
INSERT INTO `t_profession` VALUES ('10', '2', '演员', null, null, null);
INSERT INTO `t_profession` VALUES ('11', '2', '歌手', null, null, null);
INSERT INTO `t_profession` VALUES ('12', '2', '偶像团体成员', null, null, null);
INSERT INTO `t_profession` VALUES ('13', '2', '综合演艺从业者', null, null, null);
INSERT INTO `t_profession` VALUES ('14', '4', '剧作家', null, null, null);
INSERT INTO `t_profession` VALUES ('15', '5', '雕塑家', null, null, null);
INSERT INTO `t_profession` VALUES ('16', '5', '画家', null, null, null);
INSERT INTO `t_profession` VALUES ('17', '5', '音乐家', null, null, null);
INSERT INTO `t_profession` VALUES ('18', '5', '漫画家', null, null, null);
