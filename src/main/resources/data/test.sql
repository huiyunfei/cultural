/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50155
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50155
File Encoding         : 65001

Date: 2019-10-20 19:12:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_area
-- ----------------------------
DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `area_name` varchar(255) DEFAULT NULL,
  `area_code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `layer` int(11) DEFAULT NULL COMMENT '1州2国家3中国区域4国内省市',
  PRIMARY KEY (`id`),
  KEY `index_parent_id` (`parent_id`) USING BTREE,
  KEY `index_area_code` (`area_code`)
) ENGINE=InnoDB AUTO_INCREMENT=820001 DEFAULT CHARSET=utf8 COMMENT='区域表';

-- ----------------------------
-- Records of t_area
-- ----------------------------
INSERT INTO `t_area` VALUES ('1', '301', '中国', 'CHN', null, null, '2');
INSERT INTO `t_area` VALUES ('2', '302', '阿尔巴尼亚', 'ALB', null, null, '2');
INSERT INTO `t_area` VALUES ('3', '303', '阿尔及利亚', 'DZA', null, null, '2');
INSERT INTO `t_area` VALUES ('4', '301', '阿富汗', 'AFG', null, null, '2');
INSERT INTO `t_area` VALUES ('5', '305', '阿根廷', 'ARG', null, null, '2');
INSERT INTO `t_area` VALUES ('6', '301', '阿联酋', 'ARE', null, null, '2');
INSERT INTO `t_area` VALUES ('7', '304', '阿鲁巴', 'ABW', null, null, '2');
INSERT INTO `t_area` VALUES ('8', '301', '阿曼', 'OMN', null, null, '2');
INSERT INTO `t_area` VALUES ('9', '301', '阿塞拜疆', 'AZE', null, null, '2');
INSERT INTO `t_area` VALUES ('10', null, '阿森松岛', 'ASC', null, null, '2');
INSERT INTO `t_area` VALUES ('11', '303', '埃及', 'EGY', null, null, '2');
INSERT INTO `t_area` VALUES ('12', '303', '埃塞俄比亚', 'ETH', null, null, '2');
INSERT INTO `t_area` VALUES ('13', '302', '爱尔兰', 'IRL', null, null, '2');
INSERT INTO `t_area` VALUES ('14', '302', '爱沙尼亚', 'EST', null, null, '2');
INSERT INTO `t_area` VALUES ('15', '302', '安道尔', 'AND', null, null, '2');
INSERT INTO `t_area` VALUES ('16', '303', '安哥拉', 'AGO', null, null, '2');
INSERT INTO `t_area` VALUES ('17', '304', '安圭拉', 'AIA', null, null, '2');
INSERT INTO `t_area` VALUES ('18', null, '安提瓜岛和巴布达', 'ATG', null, null, '2');
INSERT INTO `t_area` VALUES ('19', '302', '奥地利', 'AUT', null, null, '2');
INSERT INTO `t_area` VALUES ('20', '302', '奥兰群岛', 'ALA', null, null, '2');
INSERT INTO `t_area` VALUES ('21', '306', '澳大利亚', 'AUS', null, null, '2');
INSERT INTO `t_area` VALUES ('22', '304', '巴巴多斯岛', 'BRB', null, null, '2');
INSERT INTO `t_area` VALUES ('23', '306', '巴布亚新几内亚', 'PNG', null, null, '2');
INSERT INTO `t_area` VALUES ('24', '304', '巴哈马', 'BHS', null, null, '2');
INSERT INTO `t_area` VALUES ('25', '301', '巴基斯坦', 'PAK', null, null, '2');
INSERT INTO `t_area` VALUES ('26', '305', '巴拉圭', 'PRY', null, null, '2');
INSERT INTO `t_area` VALUES ('27', '301', '巴勒斯坦', 'PSE', null, null, '2');
INSERT INTO `t_area` VALUES ('28', '301', '巴林', 'BHR', null, null, '2');
INSERT INTO `t_area` VALUES ('29', '304', '巴拿马', 'PAN', null, null, '2');
INSERT INTO `t_area` VALUES ('30', '305', '巴西', 'BRA', null, null, '2');
INSERT INTO `t_area` VALUES ('31', '302', '白俄罗斯', 'BLR', null, null, '2');
INSERT INTO `t_area` VALUES ('32', '304', '百慕大', 'BMU', null, null, '2');
INSERT INTO `t_area` VALUES ('33', '302', '保加利亚', 'BGR', null, null, '2');
INSERT INTO `t_area` VALUES ('34', '306', '北马里亚纳群岛', 'MNP', null, null, '2');
INSERT INTO `t_area` VALUES ('35', '303', '贝宁', 'BEN', null, null, '2');
INSERT INTO `t_area` VALUES ('36', '302', '比利时', 'BEL', null, null, '2');
INSERT INTO `t_area` VALUES ('37', '302', '冰岛', 'ISL', null, null, '2');
INSERT INTO `t_area` VALUES ('38', '304', '波多黎各', 'PRI', null, null, '2');
INSERT INTO `t_area` VALUES ('39', '302', '波兰', 'POL', null, null, '2');
INSERT INTO `t_area` VALUES ('40', '302', '波斯尼亚和黑塞哥维那', 'BIH', null, null, '2');
INSERT INTO `t_area` VALUES ('41', '305', '玻利维亚', 'BOL', null, null, '2');
INSERT INTO `t_area` VALUES ('42', '304', '伯利兹', 'BLZ', null, null, '2');
INSERT INTO `t_area` VALUES ('43', '303', '博茨瓦纳', 'BWA', null, null, '2');
INSERT INTO `t_area` VALUES ('44', '301', '不丹', 'BTN', null, null, '2');
INSERT INTO `t_area` VALUES ('45', '303', '布基纳法索', 'BFA', null, null, '2');
INSERT INTO `t_area` VALUES ('46', '303', '布隆迪', 'BDI', null, null, '2');
INSERT INTO `t_area` VALUES ('47', null, '布韦岛', 'BVT', null, null, '2');
INSERT INTO `t_area` VALUES ('48', '301', '朝鲜', 'PRK', null, null, '2');
INSERT INTO `t_area` VALUES ('49', '302', '丹麦', 'DNK', null, null, '2');
INSERT INTO `t_area` VALUES ('50', '302', '德国', 'DEU', null, null, '2');
INSERT INTO `t_area` VALUES ('51', '301', '东帝汶', 'TLS', null, null, '2');
INSERT INTO `t_area` VALUES ('52', '303', '多哥', 'TGO', null, null, '2');
INSERT INTO `t_area` VALUES ('53', '304', '多米尼加', 'DMA', null, null, '2');
INSERT INTO `t_area` VALUES ('54', '304', '多米尼加共和国', 'DOM', null, null, '2');
INSERT INTO `t_area` VALUES ('55', '302', '俄罗斯', 'RUS', null, null, '2');
INSERT INTO `t_area` VALUES ('56', '305', '厄瓜多尔', 'ECU', null, null, '2');
INSERT INTO `t_area` VALUES ('57', '303', '厄立特里亚', 'ERI', null, null, '2');
INSERT INTO `t_area` VALUES ('58', '302', '法国', 'FRA', null, null, '2');
INSERT INTO `t_area` VALUES ('59', '302', '法罗群岛', 'FRO', null, null, '2');
INSERT INTO `t_area` VALUES ('60', '306', '法属波利尼西亚', 'PYF', null, null, '2');
INSERT INTO `t_area` VALUES ('61', '305', '法属圭亚那', 'GUF', null, null, '2');
INSERT INTO `t_area` VALUES ('62', null, '法属南部领地', 'ATF', null, null, '2');
INSERT INTO `t_area` VALUES ('63', '302', '梵蒂冈', 'VAT', null, null, '2');
INSERT INTO `t_area` VALUES ('64', '301', '菲律宾', 'PHL', null, null, '2');
INSERT INTO `t_area` VALUES ('65', '306', '斐济', 'FJI', null, null, '2');
INSERT INTO `t_area` VALUES ('66', '302', '芬兰', 'FIN', null, null, '2');
INSERT INTO `t_area` VALUES ('67', '303', '佛得角', 'CPV', null, null, '2');
INSERT INTO `t_area` VALUES ('68', null, '弗兰克群岛', 'FLK', null, null, '2');
INSERT INTO `t_area` VALUES ('69', '303', '冈比亚', 'GMB', null, null, '2');
INSERT INTO `t_area` VALUES ('70', '303', '刚果共和国', 'COG', null, null, '2');
INSERT INTO `t_area` VALUES ('71', '303', '刚果民主共和国', 'COD', null, null, '2');
INSERT INTO `t_area` VALUES ('72', '305', '哥伦比亚', 'COL', null, null, '2');
INSERT INTO `t_area` VALUES ('73', '304', '哥斯达黎加', 'CRI', null, null, '2');
INSERT INTO `t_area` VALUES ('74', null, '格恩西岛', 'GGY', null, null, '2');
INSERT INTO `t_area` VALUES ('75', '304', '格林纳达', 'GRD', null, null, '2');
INSERT INTO `t_area` VALUES ('76', '304', '格陵兰', 'GRL', null, null, '2');
INSERT INTO `t_area` VALUES ('77', '301', '格鲁吉亚', 'GEG', null, null, '2');
INSERT INTO `t_area` VALUES ('78', '304', '古巴', 'CUB', null, null, '2');
INSERT INTO `t_area` VALUES ('79', '304', '瓜德罗普', 'GLP', null, null, '2');
INSERT INTO `t_area` VALUES ('80', '306', '关岛', 'GUM', null, null, '2');
INSERT INTO `t_area` VALUES ('81', '305', '圭亚那', 'GUY', null, null, '2');
INSERT INTO `t_area` VALUES ('82', '301', '哈萨克斯坦', 'KAZ', null, null, '2');
INSERT INTO `t_area` VALUES ('83', '304', '海地', 'HTI', null, null, '2');
INSERT INTO `t_area` VALUES ('84', '301', '韩国', 'KOR', null, null, '2');
INSERT INTO `t_area` VALUES ('85', '302', '荷兰', 'NLD', null, null, '2');
INSERT INTO `t_area` VALUES ('86', null, '荷属安地列斯', 'ANT', null, null, '2');
INSERT INTO `t_area` VALUES ('87', null, '赫德和麦克唐纳群岛', 'HMD', null, null, '2');
INSERT INTO `t_area` VALUES ('88', '302', '黑山', 'MEG', null, null, '2');
INSERT INTO `t_area` VALUES ('89', '304', '洪都拉斯', 'HND', null, null, '2');
INSERT INTO `t_area` VALUES ('90', '306', '基里巴斯', 'KIR', null, null, '2');
INSERT INTO `t_area` VALUES ('91', '303', '吉布提', 'DJI', null, null, '2');
INSERT INTO `t_area` VALUES ('92', '301', '吉尔吉斯斯坦', 'KGZ', null, null, '2');
INSERT INTO `t_area` VALUES ('93', '303', '几内亚', 'GIN', null, null, '2');
INSERT INTO `t_area` VALUES ('94', '303', '几内亚比绍', 'GNB', null, null, '2');
INSERT INTO `t_area` VALUES ('95', '304', '加拿大', 'CAN', null, null, '2');
INSERT INTO `t_area` VALUES ('96', '303', '加纳', 'GHA', null, null, '2');
INSERT INTO `t_area` VALUES ('97', '303', '加蓬', 'GAB', null, null, '2');
INSERT INTO `t_area` VALUES ('98', '301', '柬埔寨', 'KHM', null, null, '2');
INSERT INTO `t_area` VALUES ('99', '302', '捷克', 'CZE', null, null, '2');
INSERT INTO `t_area` VALUES ('100', '303', '津巴布韦', 'ZWE', null, null, '2');
INSERT INTO `t_area` VALUES ('101', '303', '喀麦隆', 'CMR', null, null, '2');
INSERT INTO `t_area` VALUES ('102', '301', '卡塔尔', 'QAT', null, null, '2');
INSERT INTO `t_area` VALUES ('103', '304', '开曼群岛', 'CYM', null, null, '2');
INSERT INTO `t_area` VALUES ('104', null, '科科斯群岛', 'CCK', null, null, '2');
INSERT INTO `t_area` VALUES ('105', '303', '科摩罗', 'COM', null, null, '2');
INSERT INTO `t_area` VALUES ('106', '303', '科特迪瓦', 'CIV', null, null, '2');
INSERT INTO `t_area` VALUES ('107', '301', '科威特', 'KWT', null, null, '2');
INSERT INTO `t_area` VALUES ('108', '302', '克罗地亚', 'HRV', null, null, '2');
INSERT INTO `t_area` VALUES ('109', '303', '肯尼亚', 'KEN', null, null, '2');
INSERT INTO `t_area` VALUES ('110', '306', '库克群岛', 'COK', null, null, '2');
INSERT INTO `t_area` VALUES ('111', '302', '拉脱维亚', 'LVA', null, null, '2');
INSERT INTO `t_area` VALUES ('112', '303', '莱索托', 'LSO', null, null, '2');
INSERT INTO `t_area` VALUES ('113', '301', '老挝', 'LAO', null, null, '2');
INSERT INTO `t_area` VALUES ('114', '301', '黎巴嫩', 'LBN', null, null, '2');
INSERT INTO `t_area` VALUES ('115', '302', '立陶宛', 'LTU', null, null, '2');
INSERT INTO `t_area` VALUES ('116', '303', '利比里亚', 'LBR', null, null, '2');
INSERT INTO `t_area` VALUES ('117', '303', '利比亚', 'LBY', null, null, '2');
INSERT INTO `t_area` VALUES ('118', '302', '列支敦士登', 'LIE', null, null, '2');
INSERT INTO `t_area` VALUES ('119', '303', '留尼汪岛', 'REU', null, null, '2');
INSERT INTO `t_area` VALUES ('120', '302', '卢森堡', 'LUX', null, null, '2');
INSERT INTO `t_area` VALUES ('121', '303', '卢旺达', 'RWA', null, null, '2');
INSERT INTO `t_area` VALUES ('122', '302', '罗马尼亚', 'ROU', null, null, '2');
INSERT INTO `t_area` VALUES ('123', '303', '马达加斯加', 'MDG', null, null, '2');
INSERT INTO `t_area` VALUES ('124', '301', '马尔代夫', 'MDV', null, null, '2');
INSERT INTO `t_area` VALUES ('125', '302', '马耳他', 'MLT', null, null, '2');
INSERT INTO `t_area` VALUES ('126', '303', '马拉维', 'MWI', null, null, '2');
INSERT INTO `t_area` VALUES ('127', '301', '马来西亚', 'MYS', null, null, '2');
INSERT INTO `t_area` VALUES ('128', '303', '马里', 'MLI', null, null, '2');
INSERT INTO `t_area` VALUES ('129', '302', '马其顿', 'MKD', null, null, '2');
INSERT INTO `t_area` VALUES ('130', '306', '马绍尔群岛', 'MHL', null, null, '2');
INSERT INTO `t_area` VALUES ('131', null, '马提尼克', 'MTQ', null, null, '2');
INSERT INTO `t_area` VALUES ('132', null, '马约特岛', 'MYT', null, null, '2');
INSERT INTO `t_area` VALUES ('133', null, '曼岛', 'IMN', null, null, '2');
INSERT INTO `t_area` VALUES ('134', '303', '毛里求斯', 'MUS', null, null, '2');
INSERT INTO `t_area` VALUES ('135', '303', '毛里塔尼亚', 'MRT', null, null, '2');
INSERT INTO `t_area` VALUES ('136', '304', '美国', 'USA', null, null, '2');
INSERT INTO `t_area` VALUES ('137', '306', '美属萨摩亚', 'ASM', null, null, '2');
INSERT INTO `t_area` VALUES ('138', null, '美属外岛', 'UMI', null, null, '2');
INSERT INTO `t_area` VALUES ('139', '301', '蒙古', 'MNG', null, null, '2');
INSERT INTO `t_area` VALUES ('140', null, '蒙特塞拉特', 'MSR', null, null, '2');
INSERT INTO `t_area` VALUES ('141', '301', '孟加拉国', 'BGD', null, null, '2');
INSERT INTO `t_area` VALUES ('142', '305', '秘鲁', 'PER', null, null, '2');
INSERT INTO `t_area` VALUES ('143', null, '密克罗尼西亚', 'FSM', null, null, '2');
INSERT INTO `t_area` VALUES ('144', '301', '缅甸', 'MMR', null, null, '2');
INSERT INTO `t_area` VALUES ('145', '302', '摩尔多瓦', 'MDA', null, null, '2');
INSERT INTO `t_area` VALUES ('146', '303', '摩洛哥', 'MAR', null, null, '2');
INSERT INTO `t_area` VALUES ('147', '302', '摩纳哥', 'MCO', null, null, '2');
INSERT INTO `t_area` VALUES ('148', '303', '莫桑比克', 'MOZ', null, null, '2');
INSERT INTO `t_area` VALUES ('149', '304', '墨西哥', 'MEX', null, null, '2');
INSERT INTO `t_area` VALUES ('150', '303', '纳米比亚', 'NAM', null, null, '2');
INSERT INTO `t_area` VALUES ('151', '303', '南非', 'ZAF', null, null, '2');
INSERT INTO `t_area` VALUES ('152', null, '南极洲', 'ATA', null, null, '2');
INSERT INTO `t_area` VALUES ('153', null, '南乔治亚和南桑德威奇群岛', 'SGS', null, null, '2');
INSERT INTO `t_area` VALUES ('154', '306', '瑙鲁', 'NRU', null, null, '2');
INSERT INTO `t_area` VALUES ('155', '301', '尼泊尔', 'NPL', null, null, '2');
INSERT INTO `t_area` VALUES ('156', '304', '尼加拉瓜', 'NIC', null, null, '2');
INSERT INTO `t_area` VALUES ('157', '303', '尼日尔', 'NER', null, null, '2');
INSERT INTO `t_area` VALUES ('158', '303', '尼日利亚', 'NGA', null, null, '2');
INSERT INTO `t_area` VALUES ('159', '306', '纽埃', 'NIU', null, null, '2');
INSERT INTO `t_area` VALUES ('160', '302', '挪威', 'NOR', null, null, '2');
INSERT INTO `t_area` VALUES ('161', null, '诺福克', 'NFK', null, null, '2');
INSERT INTO `t_area` VALUES ('162', '306', '帕劳群岛', 'PLW', null, null, '2');
INSERT INTO `t_area` VALUES ('163', null, '皮特凯恩', 'PCN', null, null, '2');
INSERT INTO `t_area` VALUES ('164', '302', '葡萄牙', 'PRT', null, null, '2');
INSERT INTO `t_area` VALUES ('165', null, '乔治亚', 'GEO', null, null, '2');
INSERT INTO `t_area` VALUES ('166', '301', '日本', 'JPN', null, null, '2');
INSERT INTO `t_area` VALUES ('167', '302', '瑞典', 'SWE', null, null, '2');
INSERT INTO `t_area` VALUES ('168', '302', '瑞士', 'CHE', null, null, '2');
INSERT INTO `t_area` VALUES ('169', '304', '萨尔瓦多', 'SLV', null, null, '2');
INSERT INTO `t_area` VALUES ('170', '306', '萨摩亚', 'WSM', null, null, '2');
INSERT INTO `t_area` VALUES ('171', '302', '塞尔维亚', 'SCG', null, null, '2');
INSERT INTO `t_area` VALUES ('172', '303', '塞拉利昂', 'SLE', null, null, '2');
INSERT INTO `t_area` VALUES ('173', '303', '塞内加尔', 'SEN', null, null, '2');
INSERT INTO `t_area` VALUES ('174', '301', '塞浦路斯', 'CYP', null, null, '2');
INSERT INTO `t_area` VALUES ('175', '303', '塞舌尔', 'SYC', null, null, '2');
INSERT INTO `t_area` VALUES ('176', '301', '沙特阿拉伯', 'SAU', null, null, '2');
INSERT INTO `t_area` VALUES ('177', '306', '圣诞岛', 'CXR', null, null, '2');
INSERT INTO `t_area` VALUES ('178', '303', '圣多美和普林西比', 'STP', null, null, '2');
INSERT INTO `t_area` VALUES ('179', null, '圣赫勒拿', 'SHN', null, null, '2');
INSERT INTO `t_area` VALUES ('180', '304', '圣基茨和尼维斯', 'KNA', null, null, '2');
INSERT INTO `t_area` VALUES ('181', '304', '圣卢西亚', 'LCA', null, null, '2');
INSERT INTO `t_area` VALUES ('182', '302', '圣马力诺', 'SMR', null, null, '2');
INSERT INTO `t_area` VALUES ('183', null, '圣皮埃尔和米克隆群岛', 'SPM', null, null, '2');
INSERT INTO `t_area` VALUES ('184', '304', '圣文森特和格林纳丁斯', 'VCT', null, null, '2');
INSERT INTO `t_area` VALUES ('185', '301', '斯里兰卡', 'LKA', null, null, '2');
INSERT INTO `t_area` VALUES ('186', '302', '斯洛伐克', 'SVK', null, null, '2');
INSERT INTO `t_area` VALUES ('187', '302', '斯洛文尼亚', 'SVN', null, null, '2');
INSERT INTO `t_area` VALUES ('188', null, '斯瓦尔巴和扬马廷', 'SJM', null, null, '2');
INSERT INTO `t_area` VALUES ('189', '303', '斯威士兰', 'SWZ', null, null, '2');
INSERT INTO `t_area` VALUES ('190', '303', '苏丹', 'SDN', null, null, '2');
INSERT INTO `t_area` VALUES ('191', '305', '苏里南', 'SUR', null, null, '2');
INSERT INTO `t_area` VALUES ('192', '306', '所罗门群岛', 'SLB', null, null, '2');
INSERT INTO `t_area` VALUES ('193', '303', '索马里', 'SOM', null, null, '2');
INSERT INTO `t_area` VALUES ('194', '301', '塔吉克斯坦', 'TJK', null, null, '2');
INSERT INTO `t_area` VALUES ('195', '301', '泰国', 'THA', null, null, '2');
INSERT INTO `t_area` VALUES ('196', '303', '坦桑尼亚', 'TZA', null, null, '2');
INSERT INTO `t_area` VALUES ('197', '306', '汤加', 'TON', null, null, '2');
INSERT INTO `t_area` VALUES ('198', '304', '特克斯和凯克特斯群岛', 'TCA', null, null, '2');
INSERT INTO `t_area` VALUES ('199', null, '特里斯坦达昆哈', 'TAA', null, null, '2');
INSERT INTO `t_area` VALUES ('200', '304', '特立尼达和多巴哥', 'TTO', null, null, '2');
INSERT INTO `t_area` VALUES ('201', '303', '突尼斯', 'TUN', null, null, '2');
INSERT INTO `t_area` VALUES ('202', '306', '图瓦卢', 'TUV', null, null, '2');
INSERT INTO `t_area` VALUES ('203', '301', '土耳其', 'TUR', null, null, '2');
INSERT INTO `t_area` VALUES ('204', '301', '土库曼斯坦', 'TKM', null, null, '2');
INSERT INTO `t_area` VALUES ('205', '306', '托克劳', 'TKL', null, null, '2');
INSERT INTO `t_area` VALUES ('206', '306', '瓦利斯和福图纳', 'WLF', null, null, '2');
INSERT INTO `t_area` VALUES ('207', '306', '瓦努阿图', 'VUT', null, null, '2');
INSERT INTO `t_area` VALUES ('208', '304', '危地马拉', 'GTM', null, null, '2');
INSERT INTO `t_area` VALUES ('209', '304', '美属维尔京群岛', 'VIR', null, null, '2');
INSERT INTO `t_area` VALUES ('210', '304', '英属维尔京群岛', 'VGB', null, null, '2');
INSERT INTO `t_area` VALUES ('211', '305', '委内瑞拉', 'VEN', null, null, '2');
INSERT INTO `t_area` VALUES ('212', '301', '文莱', 'BRN', null, null, '2');
INSERT INTO `t_area` VALUES ('213', '303', '乌干达', 'UGA', null, null, '2');
INSERT INTO `t_area` VALUES ('214', '302', '乌克兰', 'UKR', null, null, '2');
INSERT INTO `t_area` VALUES ('215', '305', '乌拉圭', 'URY', null, null, '2');
INSERT INTO `t_area` VALUES ('216', '301', '乌兹别克斯坦', 'UZB', null, null, '2');
INSERT INTO `t_area` VALUES ('217', '302', '西班牙', 'ESP', null, null, '2');
INSERT INTO `t_area` VALUES ('218', '302', '希腊', 'GRC', null, null, '2');
INSERT INTO `t_area` VALUES ('219', '301', '新加坡', 'SGP', null, null, '2');
INSERT INTO `t_area` VALUES ('220', '306', '新喀里多尼亚', 'NCL', null, null, '2');
INSERT INTO `t_area` VALUES ('221', '306', '新西兰', 'NZL', null, null, '2');
INSERT INTO `t_area` VALUES ('222', '302', '匈牙利', 'HUN', null, null, '2');
INSERT INTO `t_area` VALUES ('223', '301', '叙利亚', 'SYR', null, null, '2');
INSERT INTO `t_area` VALUES ('224', '304', '牙买加', 'JAM', null, null, '2');
INSERT INTO `t_area` VALUES ('225', '301', '亚美尼亚', 'ARM', null, null, '2');
INSERT INTO `t_area` VALUES ('226', '301', '也门', 'YEM', null, null, '2');
INSERT INTO `t_area` VALUES ('227', '301', '伊拉克', 'IRQ', null, null, '2');
INSERT INTO `t_area` VALUES ('228', '301', '伊朗', 'IRN', null, null, '2');
INSERT INTO `t_area` VALUES ('229', '301', '以色列', 'ISR', null, null, '2');
INSERT INTO `t_area` VALUES ('230', '302', '意大利', 'ITA', null, null, '2');
INSERT INTO `t_area` VALUES ('231', '301', '印度', 'IND', null, null, '2');
INSERT INTO `t_area` VALUES ('232', '301', '印度尼西亚', 'IDN', null, null, '2');
INSERT INTO `t_area` VALUES ('233', '302', '英国', 'GBR', null, null, '2');
INSERT INTO `t_area` VALUES ('234', '301', '英属印度洋领地', 'IOT', null, null, '2');
INSERT INTO `t_area` VALUES ('235', '301', '约旦', 'JOR', null, null, '2');
INSERT INTO `t_area` VALUES ('236', '301', '越南', 'VNM', null, null, '2');
INSERT INTO `t_area` VALUES ('237', '303', '赞比亚', 'ZMB', null, null, '2');
INSERT INTO `t_area` VALUES ('238', '302', '泽西岛', 'JEY', null, null, '2');
INSERT INTO `t_area` VALUES ('239', '303', '乍得', 'TCD', null, null, '2');
INSERT INTO `t_area` VALUES ('240', '302', '直布罗陀', 'GIB', null, null, '2');
INSERT INTO `t_area` VALUES ('241', '305', '智利', 'CHL', null, null, '2');
INSERT INTO `t_area` VALUES ('242', '303', '中非共和国', 'CAF', null, null, '2');
INSERT INTO `t_area` VALUES ('301', '0', '亚洲', null, null, null, '1');
INSERT INTO `t_area` VALUES ('302', '0', '欧洲', null, null, null, '1');
INSERT INTO `t_area` VALUES ('303', '0', '非洲', null, null, null, '1');
INSERT INTO `t_area` VALUES ('304', '0', '北美洲', null, null, null, '1');
INSERT INTO `t_area` VALUES ('305', '0', '南美洲', null, null, null, '1');
INSERT INTO `t_area` VALUES ('306', '0', '大洋洲', null, null, null, '1');
INSERT INTO `t_area` VALUES ('307', '0', '南极洲', null, null, null, '1');
INSERT INTO `t_area` VALUES ('100001', '1', '华北', null, null, null, '3');
INSERT INTO `t_area` VALUES ('100002', '1', '东北', null, null, null, '3');
INSERT INTO `t_area` VALUES ('100003', '1', '华东', null, null, null, '3');
INSERT INTO `t_area` VALUES ('100004', '1', '中南', null, null, null, '3');
INSERT INTO `t_area` VALUES ('100005', '1', '西南', null, null, null, '3');
INSERT INTO `t_area` VALUES ('100006', '1', '西北', null, null, null, '3');
INSERT INTO `t_area` VALUES ('100007', '1', '港澳台', null, null, null, '3');
INSERT INTO `t_area` VALUES ('110000', '100001', '北京', null, null, null, '4');
INSERT INTO `t_area` VALUES ('120000', '100001', '天津', null, null, null, '4');
INSERT INTO `t_area` VALUES ('130000', '100001', '河北', null, null, null, '4');
INSERT INTO `t_area` VALUES ('140000', '100001', '山西', null, null, null, '4');
INSERT INTO `t_area` VALUES ('150000', '100001', '内蒙古', null, null, null, '4');
INSERT INTO `t_area` VALUES ('210000', '100002', '辽宁', null, null, null, '4');
INSERT INTO `t_area` VALUES ('220000', '100002', '吉林', null, null, null, '4');
INSERT INTO `t_area` VALUES ('230000', '100002', '黑龙江', null, null, null, '4');
INSERT INTO `t_area` VALUES ('310000', '100003', '上海', 'Shanghai', null, null, '4');
INSERT INTO `t_area` VALUES ('320000', '100003', '江苏', null, null, null, '4');
INSERT INTO `t_area` VALUES ('330000', '100003', '浙江', null, null, null, '4');
INSERT INTO `t_area` VALUES ('340000', '100003', '安徽', null, null, null, '4');
INSERT INTO `t_area` VALUES ('350000', '100003', '福建', null, null, null, '4');
INSERT INTO `t_area` VALUES ('360000', '100003', '江西', null, null, null, '4');
INSERT INTO `t_area` VALUES ('370000', '100003', '山东', null, null, null, '4');
INSERT INTO `t_area` VALUES ('410000', '100004', '河南', null, null, null, '4');
INSERT INTO `t_area` VALUES ('420000', '100004', '湖北', null, null, null, '4');
INSERT INTO `t_area` VALUES ('430000', '100004', '湖南', null, null, null, '4');
INSERT INTO `t_area` VALUES ('440000', '100004', '广东', null, null, null, '4');
INSERT INTO `t_area` VALUES ('450000', '100004', '广西', null, null, null, '4');
INSERT INTO `t_area` VALUES ('460000', '100004', '海南', null, null, null, '4');
INSERT INTO `t_area` VALUES ('500000', '100005', '重庆', null, null, null, '4');
INSERT INTO `t_area` VALUES ('510000', '100005', '四川', null, null, null, '4');
INSERT INTO `t_area` VALUES ('520000', '100005', '贵州', null, null, null, '4');
INSERT INTO `t_area` VALUES ('530000', '100005', '云南', null, null, null, '4');
INSERT INTO `t_area` VALUES ('540000', '100005', '西藏', null, null, null, '4');
INSERT INTO `t_area` VALUES ('610000', '100006', '陕西', null, null, null, '4');
INSERT INTO `t_area` VALUES ('620000', '100006', '甘肃', null, null, null, '4');
INSERT INTO `t_area` VALUES ('630000', '100006', '青海', null, null, null, '4');
INSERT INTO `t_area` VALUES ('640000', '100006', '宁夏', null, null, null, '4');
INSERT INTO `t_area` VALUES ('650000', '100006', '新疆', null, null, null, '4');
INSERT INTO `t_area` VALUES ('710000', '100007', '台湾', 'TW', null, null, '4');
INSERT INTO `t_area` VALUES ('810000', '100007', '香港', 'HK', null, null, '4');
INSERT INTO `t_area` VALUES ('820000', '100007', '澳门', 'MO', null, null, '4');

-- ----------------------------
-- Table structure for t_cultural_famous_ht
-- ----------------------------
DROP TABLE IF EXISTS `t_cultural_famous_ht`;
CREATE TABLE `t_cultural_famous_ht` (
  `id` int(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `area_code` varchar(32) DEFAULT NULL COMMENT '区域code',
  `sex` int(1) DEFAULT NULL COMMENT '0男1女',
  `age` int(2) DEFAULT NULL,
  `profession_code` varchar(255) DEFAULT NULL COMMENT '职业code',
  `representative_works` varchar(255) DEFAULT NULL COMMENT '代表作品',
  `resume` varchar(1000) DEFAULT NULL COMMENT '简介',
  `lifetime` varchar(1000) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL COMMENT '职务',
  `head_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='沪台文化名人';

-- ----------------------------
-- Records of t_cultural_famous_ht
-- ----------------------------
INSERT INTO `t_cultural_famous_ht` VALUES ('1', '段亦宏', 'CHN', '0', '46', '10011', '《楚汉传奇》\n《士兵突击》\n《我的团长我的团》\n《西风烈》\n《烈日灼心》\n《暴雪将至》', '段奕宏（1973年5月16日－），原名段龙，中国大陆男演员，出生于新疆伊犁伊宁市。1998年，毕业于中央戏剧学院表演系，之后进入中国国家话剧院工作。\n生平：段奕宏曾分别于1992年和1993年两度报考中央戏剧学院表演系，但两度均未被录取，直至1994年三度报考才被录取。1998年毕业前夕，中央戏剧学院老师赵有亮通过中国文化部为段奕宏申请留京名额，在获得留京名额之后进入中央实验话剧院（今中国国家话剧院）。之后，段奕宏出演多部话剧，并成为先锋话剧《恋爱的犀牛》第二代男主角，其亦于此时期将本名由段龙改为段奕宏。', '无', '无', 'https://blog.sepclub.com/img/01/段亦宏.png', '2019-10-20 16:28:07', '2019-10-20 16:35:18');
INSERT INTO `t_cultural_famous_ht` VALUES ('2', '傅榆', 'TW', '0', '33', '10020', '无', '无', '无', '无', '无', '2019-10-20 16:28:07', '2019-10-20 16:35:18');
INSERT INTO `t_cultural_famous_ht` VALUES ('3', '周一围', 'CHN', '0', '37', '10011', '《创业时代》\n《你和我的倾城时光》\n《长安十二时辰》\n《爱上你治愈我》', '周一围，1982年8月24日出生于湖南湘西小城吉首，毕业于北京电影学院表演系。2004年，因在海岩剧《深牢大狱》中饰演男一号刘川而被观众熟识。2006年，与赵薇共同主演情感剧《谢谢你曾经爱过我》。2007，获新浪网络盛典年度新人。2008年，领衔主演农村偶像剧《八百里洞庭我的家》。2010年，与林心如、李依晓共同参演都市情感剧《独家披露》。2012年，与马苏共同主演年代悬疑电视剧《烈焰》。', '无', '无', 'https://blog.sepclub.com/img/01/周一围.png', '2019-10-20 16:28:07', '2019-10-20 16:35:18');
INSERT INTO `t_cultural_famous_ht` VALUES ('4', '朱丹', 'CHN', '1', '33', '10071', '无', '无', '无', '无', '无', '2019-10-20 16:28:07', '2019-10-20 16:35:18');
INSERT INTO `t_cultural_famous_ht` VALUES ('5', '胡歌', 'CHN', '0', '33', '10011', '无', '无', '无', '无', '无', '2019-10-20 16:28:07', '2019-10-20 16:35:18');
INSERT INTO `t_cultural_famous_ht` VALUES ('6', '雷震卿', 'TW', '1', '33', '10072', '无', '无', '无', '无', '无', '2019-10-20 16:28:07', '2019-10-20 16:35:18');
INSERT INTO `t_cultural_famous_ht` VALUES ('7', '孔劲蕾', 'CHN', '1', '33', '10072', '无', '无', '无', '无', '无', '2019-10-20 16:28:07', '2019-10-20 16:35:18');
INSERT INTO `t_cultural_famous_ht` VALUES ('8', '廖庆松', 'TW', '0', '33', '10072', '无', '无', '无', '无', '无', '2019-10-20 16:28:07', '2019-10-20 16:35:18');
INSERT INTO `t_cultural_famous_ht` VALUES ('9', '邓超', 'CHN', '0', '33', '10011', '无', '无', '无', '无', '无', '2019-10-20 16:28:07', '2019-10-20 16:35:18');
INSERT INTO `t_cultural_famous_ht` VALUES ('10', '周迅', 'CHN', '1', '33', '10011', '无', '无', '无', '无', '无', '2019-10-20 16:28:07', '2019-10-20 16:35:18');
INSERT INTO `t_cultural_famous_ht` VALUES ('11', '朱琳', 'CHN', '1', '33', '10011', '无', '无', '无', '无', '无', '2019-10-20 16:28:07', '2019-10-20 16:35:18');
INSERT INTO `t_cultural_famous_ht` VALUES ('12', '张韶涵', 'TW', '1', '33', '10012', '无', '无', '无', '无', '无', '2019-10-20 16:28:07', '2019-10-20 16:35:18');
INSERT INTO `t_cultural_famous_ht` VALUES ('13', '李安', 'TW', '0', '65', '10020', '《双子杀手》\n《比利·林恩的中场战事》\n《少年派的奇幻漂流》\n《制造伍德斯托克音乐节》\n《色·戒》\n《断背山》', '李安（Ang Lee），1954年10月23日出生于台湾省屏东县潮州镇，电影导演、编剧、制片人，毕业于伊利诺伊大学香槟分校、纽约大学。\n1990年，执导了个人首部电影《推手》，该片获得了第28届台湾电影金马奖评审团特别奖。1993年，拍摄了剧情片《喜宴》，该片获得第43届柏林国际电影节金熊奖 ，李安凭借该片获得了第30届台湾电影金马奖最佳导演奖 。1994年，执导了剧情片《饮食男女》，该片获得第67届奥斯卡金像奖最佳外语片奖提名。1995年12月13日，执导的剧情片《理智与情感》上映，该片获得了第46届柏林国际电影节金熊奖。2000年7月7日，执导的武侠剧情片《卧虎藏龙》上映，该片获得了第73届奥斯卡金像奖最佳外语片奖。2003年6月17日，执导的超级英雄电影《绿巨人浩克》上映。2005年12月9日，执导的剧情片《断背山》上映，李安凭借该片获得了第78届奥斯卡金像奖最佳导演奖，成为首位获得该奖项的亚洲人。2007年9月24日，执导的剧情片《色·戒》上映，该片获得了第64届威尼斯国际电影节金狮奖。2009年2月，受邀担任第66届威尼斯国际电影节评委会主席。', '无', '无', 'https://blog.sepclub.com/img/01/李安.png', '2019-10-20 16:28:07', '2019-10-20 16:35:18');
INSERT INTO `t_cultural_famous_ht` VALUES ('14', '张子枫', 'CHN', '0', '33', '10011', '无', '无', '无', '无', '无', '2019-10-20 16:28:07', '2019-10-20 16:35:18');
INSERT INTO `t_cultural_famous_ht` VALUES ('15', '陈乔恩', 'TW', '1', '33', '10011', '无', '无', '无', '无', '无', '2019-10-20 16:28:07', '2019-10-20 16:35:18');
INSERT INTO `t_cultural_famous_ht` VALUES ('16', '张艺谋', 'CHN', '0', '33', '10020', '无', '无', '无', '无', '无', '2019-10-20 16:28:07', '2019-10-20 16:35:18');
INSERT INTO `t_cultural_famous_ht` VALUES ('17', '林志玲', 'TW', '1', '33', '10011', '无', '无', '无', '无', '无', '2019-10-20 16:28:07', '2019-10-20 16:35:18');

-- ----------------------------
-- Table structure for t_cultural_item
-- ----------------------------
DROP TABLE IF EXISTS `t_cultural_item`;
CREATE TABLE `t_cultural_item` (
  `id` int(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL COMMENT '项目名',
  `organizer` varchar(32) DEFAULT NULL COMMENT '主办单位',
  `time` datetime DEFAULT NULL,
  `area_code` varchar(32) DEFAULT NULL,
  `resume` varchar(1000) DEFAULT NULL COMMENT '简介',
  `pic_url` varchar(255) DEFAULT NULL COMMENT '图片',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文化项目';

-- ----------------------------
-- Records of t_cultural_item
-- ----------------------------

-- ----------------------------
-- Table structure for t_cultural_organ
-- ----------------------------
DROP TABLE IF EXISTS `t_cultural_organ`;
CREATE TABLE `t_cultural_organ` (
  `id` int(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL COMMENT '机构名',
  `resume` varchar(1000) DEFAULT NULL COMMENT '简介',
  `set_up_time` datetime DEFAULT NULL COMMENT '成立时间',
  `possess_by` varchar(255) DEFAULT NULL COMMENT '隶属',
  `Incumbent` varchar(1000) DEFAULT NULL COMMENT '任职人员',
  `nature` varchar(255) DEFAULT NULL COMMENT '性质',
  `pic_url` varchar(255) DEFAULT NULL COMMENT '图片',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文化机构';

-- ----------------------------
-- Records of t_cultural_organ
-- ----------------------------

-- ----------------------------
-- Table structure for t_cultural_people_tw
-- ----------------------------
DROP TABLE IF EXISTS `t_cultural_people_tw`;
CREATE TABLE `t_cultural_people_tw` (
  `id` int(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `area_code` varchar(32) DEFAULT NULL COMMENT '区域code',
  `sex` int(1) DEFAULT NULL COMMENT '0男1女',
  `age` int(1) DEFAULT NULL,
  `profession_code` varchar(255) DEFAULT NULL COMMENT '职业code',
  `representative_works` varchar(255) DEFAULT NULL COMMENT '代表作品',
  `resume` varchar(1000) DEFAULT NULL COMMENT '简介',
  `lifetime` varchar(1000) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL COMMENT '职务',
  `head_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
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
  `sex` int(1) DEFAULT NULL COMMENT '0男1女',
  `age` int(1) DEFAULT NULL,
  `profession_code` varchar(255) DEFAULT NULL COMMENT '职业code',
  `representative_works` varchar(255) DEFAULT NULL COMMENT '代表作品',
  `resume` varchar(1000) DEFAULT NULL COMMENT '简介',
  `lifetime` varchar(1000) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL COMMENT '职务',
  `head_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='上海文化专家';

-- ----------------------------
-- Records of t_cultural_specialist_sh
-- ----------------------------

-- ----------------------------
-- Table structure for t_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(32) NOT NULL COMMENT '字典显示',
  `value` varchar(255) NOT NULL COMMENT '字典数值',
  `type` varchar(255) DEFAULT NULL COMMENT '字典类型',
  `description` varchar(255) DEFAULT NULL COMMENT '字典描述',
  PRIMARY KEY (`id`),
  KEY `index_username` (`label`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dict
-- ----------------------------
INSERT INTO `t_dict` VALUES ('1', '男', '0', 'sex', '性别');
INSERT INTO `t_dict` VALUES ('2', '女', '1', 'sex', '性别');
INSERT INTO `t_dict` VALUES ('3', '长', '0', 'label', '长度');
INSERT INTO `t_dict` VALUES ('4', '短', '1', 'label', '长度');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'yunfei', '5e75d0de843c3a9871ffd3b063f0003e', null, '云飞', null, '2019-10-12 18:01:55', '83a644435dd24578ab00dede9f36f6ad', null, null, null);

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
