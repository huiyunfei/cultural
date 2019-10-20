/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50155
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50155
File Encoding         : 65001

Date: 2019-10-20 22:13:05
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
  `representative_works` varchar(1000) DEFAULT NULL COMMENT '代表作品',
  `resume` varchar(1000) DEFAULT NULL COMMENT '简介',
  `lifetime` varchar(1000) DEFAULT NULL COMMENT '生涯',
  `job` varchar(255) DEFAULT NULL COMMENT '职务',
  `head_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='沪台文化名人';

-- ----------------------------
-- Records of t_cultural_famous_ht
-- ----------------------------
INSERT INTO `t_cultural_famous_ht` VALUES ('1', '段亦宏', 'CHN', '0', '46', '10011', '《楚汉传奇》\n《士兵突击》\n《我的团长我的团》\n《西风烈》\n《烈日灼心》\n《暴雪将至》', '段奕宏（1973年5月16日－），原名段龙，中国大陆男演员，出生于新疆伊犁伊宁市。1998年，毕业于中央戏剧学院表演系，之后进入中国国家话剧院工作。\n生平：段奕宏曾分别于1992年和1993年两度报考中央戏剧学院表演系，但两度均未被录取，直至1994年三度报考才被录取。1998年毕业前夕，中央戏剧学院老师赵有亮通过中国文化部为段奕宏申请留京名额，在获得留京名额之后进入中央实验话剧院（今中国国家话剧院）。之后，段奕宏出演多部话剧，并成为先锋话剧《恋爱的犀牛》第二代男主角，其亦于此时期将本名由段龙改为段奕宏。', '无', '无', 'http://blog.sepclub.com/img/01/段亦宏.png', '2019-10-20 22:05:27', '2019-10-20 22:05:27');
INSERT INTO `t_cultural_famous_ht` VALUES ('2', '傅榆', 'TW', '0', '37', '10020', '《苏格拉底草莓论》\n《大家一起照镜子》\n《百万格子小富翁》\n《123。草莓人》\n《蓝绿对话实验室》\n《我在台湾，我正青春》\n《太阳・不远－不小心变成总指挥》\n《完美坠地》\n《我们的青春，在台湾》\n《不曾消失的台湾省》', '傅榆之父为马来西亚华人，来台求学、定居，即所谓“侨生”；母为印尼华侨，9岁已随家人移民台湾，父母婚后都定居台湾，并生下傅榆。父母认同中华民国与中国国民党，虽非严格定义上的“外省人”，但自我认同极其相似；傅榆亦曾自谓长于外省家庭中，家人崇拜宋楚瑜，却又不是真正的外省人，与真正的台湾历史脱节。\n\n傅榆以拍摄纪录片为志业，曾拍摄短片《不曾消失的台湾省》（收录在国家电影中心所企划制作的《时光台湾》当中）、参与拍摄太阳花学运纪录片《太阳，不远》、记述中国大陆学生参与台湾社会运动的《我在台湾，我正青春》、探索青年价值认同的《蓝绿对话实验室》。\n\n2018年，傅榆以拍摄社会运动与学生运动要角陈为廷与中国大陆学生蔡博艺的《我们的青春，在台湾》一片，荣获台北电影节最佳纪录片、第55届金马奖最佳纪录片。\n', '无', '无', 'http://blog.sepclub.com/img/01/傅榆.jsp', '2019-10-20 22:05:27', '2019-10-20 22:05:27');
INSERT INTO `t_cultural_famous_ht` VALUES ('3', '周一围', 'CHN', '0', '37', '10011', '《创业时代》\n《你和我的倾城时光》\n《长安十二时辰》\n《爱上你治愈我》', '周一围，1982年8月24日出生于湖南湘西小城吉首，毕业于北京电影学院表演系。2004年，因在海岩剧《深牢大狱》中饰演男一号刘川而被观众熟识。2006年，与赵薇共同主演情感剧《谢谢你曾经爱过我》。2007，获新浪网络盛典年度新人。2008年，领衔主演农村偶像剧《八百里洞庭我的家》。2010年，与林心如、李依晓共同参演都市情感剧《独家披露》。2012年，与马苏共同主演年代悬疑电视剧《烈焰》。', '无', '无', 'http://blog.sepclub.com/img/01/周一围.png', '2019-10-20 22:05:27', '2019-10-20 22:05:27');
INSERT INTO `t_cultural_famous_ht` VALUES ('4', '朱丹', 'CHN', '1', '38', '10071', '龙的传人\n心路\n明星降临\n减出我人生\n亲爱的加油\n我的中国梦\n中国最强音\n女人如歌\n非常访谈\n势不可挡\n青春那些事儿\n每日文娱播报\n中国好声音\n', '朱丹（Dani），1981年8月4日出生于浙江省金华市，中国内地节目主持人、影视演员。\n2003年，毕业于浙江传媒学院播音与主持艺术专业的朱丹加入浙江卫视担任节目主持人。2007年，她开始主持歌唱争霸节目《我爱记歌词》 。2009年，朱丹获得华鼎奖综艺节目最佳表现女主持人提名   。2010年，出演浙江卫视自制剧《爱上女主播》 。2012年，签约湖南卫视并开始主持《中国最强音》节目。2013年，出演言情剧《一又二分之一的夏天》。2014年，朱丹成功跻身福布斯中国名人榜。2015年，其主演的都市剧《待嫁老爸》上星播出 ', '无', '无', 'http://blog.sepclub.com/img/01/朱丹.png', '2019-10-20 22:05:27', '2019-10-20 22:05:27');
INSERT INTO `t_cultural_famous_ht` VALUES ('5', '胡歌', 'CHN', '0', '37', '10011', '李娜\n攀登者\n南方车站的聚会\n你好，之华\n那年夏天你去了哪里\n大话天仙\n华丽之后\n辛亥革命', '胡歌，1982年9月20日出生于上海市徐汇区，中国内地男演员、歌手。\n1996年，14岁的胡歌便成为上海教育电视台的小主持人，2005年毕业于上海戏剧学院表演系，同年在仙侠剧《仙剑奇侠传》中塑造了“李逍遥”一角，并演唱该剧插曲《六月的雨》《逍遥叹》 [1-2]  。2006年8月遭受严重车祸，2007年6月复出 [3]  。2009年主演仙侠剧《仙剑奇侠传三》 [4]  ，并演唱片尾曲《忘记时间》 [5]  。2010年主演的穿越剧《神话》在央视八套播出 [6]  。2011年参演历史题材电影《辛亥革命》提名大众电影百花奖“最佳新人奖” [7-8]  。2012年主演玄幻剧《轩辕剑之天之痕》 [9]  。2013年主演两部话剧，凭借《如梦之梦》获得北京丹尼国际舞台表演艺术奖“最佳男演员奖” [10]  。2014年参演战争剧《四十九日·祭》提名上海电视节白玉兰奖“最佳男配角奖” [11-12]  。2015年主演的谍战剧《伪装者》、古装剧《琅琊榜》、都市剧《大好时光》相继播出，获得中国电视剧飞天奖“优秀男演员提名奖”、上海电视节白玉兰奖“最佳男主角奖”、中国电视金鹰奖“观众喜爱的男演员奖”、中国金鹰电视艺术节“最具人气男演员奖”等奖项 [13-17]  。2016年成为上海旅游形象大使，登上央视春晚演唱歌曲《相亲相爱》 [18-19]  。2017年二度登上央视春晚演唱歌曲《在此刻》，获得共青团中央“全国向上向善好青年”崇义友善好青年称号，2018年凭借都市剧《猎场》二度提名上海电视节白玉兰奖“最佳男主角奖”', '无', '无', 'http://blog.sepclub.com/img/01/胡歌.png', '2019-10-20 22:05:27', '2019-10-20 22:05:27');
INSERT INTO `t_cultural_famous_ht` VALUES ('6', '雷震卿', 'TW', '1', null, '10072', '《郊游》，《帮帮我，爱神》，《金刚经》', '雷震卿，女，电影剪辑师，作品有《郊游》，《帮帮我，爱神》，《金刚经》。\n2018年，凭借电影《谁先爱上他的》获得第55届金马奖最佳剪辑奖', '无', '无', 'http://blog.sepclub.com/img/01/雷震卿.jsp', '2019-10-20 22:05:27', '2019-10-20 22:05:27');
INSERT INTO `t_cultural_famous_ht` VALUES ('7', '孔劲蕾', 'CHN', '1', null, '10072', '《三峡好人》《卡拉是条狗》《厨子戏子痞子》', '孔劲蕾，电影剪辑师。1996年开始独立担任电影剪接工作至今，已完成数十部影视作品，并曾于1998年获得中国电影金鸡奖最佳剪辑提名奖、2009年获台湾金马奖最佳剪辑提名。代表作品有：《三峡好人》《卡拉是条狗》《厨子戏子痞子》 等。1996年开始独立担任电影剪接工作至今，曾于1998年获得中国电影金鸡奖最佳剪辑提名奖，与翟茹（已故）、杜媛齐名。', '无', '无', 'http://blog.sepclub.com/img/01/孔劲蕾.jsp', '2019-10-20 22:05:27', '2019-10-20 22:05:27');
INSERT INTO `t_cultural_famous_ht` VALUES ('8', '廖庆松', 'TW', '0', '69', '10072', '《海滩的一天》\n《童年往事》\n《蓝色大门》\n《梦幻部落》\n《半镜》', '廖庆松，男，1950年生，台北市人，现任台湾三视影业监制、剪接。1973年自中影第一期电影技术人员训练班毕业，隔年进入中影公司制片厂，任职剪辑，1987年执导第一部电影《期待你长大》。其从事剪接工作约三十年，剪接五十几部电影，为台湾电影界的著名剪接师。\n有“台湾新电影保姆”之称的廖庆松，在1973年进入台湾中央电影公司电影技术人员训练班以来，30多年来几乎和台湾每一位重要的导演都协作过，从杨德昌《海滩的一天》、侯孝贤《童年往事》到近年来易智言《蓝色大门》、郑文堂《梦幻部落》，王颂歌《半镜》 [1]  剪辑的电影超过70部。\n廖庆松也曾当过电影导演，拍过《期待你长大》、《海水正蓝》等作品。\n2018年，获得第55届台湾电影金马奖特别贡献奖 [2]  。', '无', '无', 'http://blog.sepclub.com/img/01/廖庆松.jsp', '2019-10-20 22:05:28', '2019-10-20 22:05:28');
INSERT INTO `t_cultural_famous_ht` VALUES ('9', '邓超', 'CHN', '0', '40', '10011', '《少年包青天3》《女人不哭》《艰难爱情》《倚天屠龙记》《你是我兄弟》《相爱十年》', '邓超，1979年出生于江西南昌，中国内地男演员、电影导演、投资出品人。1995年考入江西艺术职业学院话剧班，1998年考入中央戏剧学院表演系，毕业后编入中国国家话剧院 [1]  。\n2001至02年主演喜剧《欢乐青春》、《当爱情失去记忆》等 [2-3]  ，之后在《少年天子》中饰演顺治皇帝成名 [4-7]  ，接着在《少年康熙》《明末风云》《天下第一》接连饰演皇帝被称为“皇帝专业户” [8-9]  。05年后主演《幸福像花儿一样》及《甜蜜蜜》饰演高干子弟 [10-13]  。至12年相继主演《少年包青天3》《女人不哭》《艰难爱情》《倚天屠龙记》《你是我兄弟》及《相爱十年》等剧 [14-19]  。\n2006年主演战争片《集结号》获百花奖最佳男配角及提名金鸡奖 [20-22]  。07年主演文艺片《李米的猜想》获金凤凰奖 [23]  。09年主演武侠片《通天帝国》，获提名香港电影金像奖最佳男配角 [24-27]  。10年-13年，主演古装片《画壁》及《四大名捕》系列票房皆破亿 [28-33]  。12年主演《中国合伙人》票房5.3亿 [34-38]  。13年成立邓超工作室组建公司。\n2014年执导《分手大师》票房6.6亿 [39-43]  ，同期担任节目《奔跑吧兄弟》队长，其中收视率突破5% [44-45]  。15年凭《烈日灼心》获第18届上海国际电影节最佳男演员奖及提名金马奖最佳男主角奖 [46-52]  。15年执导《恶棍天使》票房6.4亿 [53]  。16年主演喜剧片《美人鱼》票房33.9亿 [54-58]  ，同年主演爱情片《从你的全世界路过》票房8.13亿 [59]  。17年主演《乘风破浪》票房超10亿 [60-61]  ，同年凭《烈日灼心》获第31届中国电影金鸡奖最佳男主角奖 [62]  。18年凭《影》二度提名金马奖最佳男主角奖 [63]  。19年执导剧情片《银河补习班》票房8.7亿。 [64]', '无', '无', 'http://blog.sepclub.com/img/01/邓超.png', '2019-10-20 22:05:28', '2019-10-20 22:05:28');
INSERT INTO `t_cultural_famous_ht` VALUES ('10', '周迅', 'CHN', '1', '45', '10011', '《古墓荒斋》\n《苏州河》\n《大明宫词》\n《烟雨红颜》\n《巴尔扎克与小裁缝》\n《恋爱中的宝贝》', '周迅，1974年10月18日生于浙江省衢州市，毕业于浙江艺术学校，中国影视女演员、歌手。\n1991年出演《古墓荒斋》出道。1998年凭《苏州河》获第15届巴黎国际电影节最佳女主角。2000年凭《大明宫词》获中国电视金鹰奖最受欢迎女演员。2002年主演《烟雨红颜》获第25届大众电影百花奖最佳女主角。 [1]  2003年主演《巴尔扎克与小裁缝》获第61届美国电影金球奖最佳外语片提名 [2]  。2004年凭《恋爱中的宝贝》获首届中国电影导演协会年度最佳女演员。2005年凭《如果·爱》获第25届香港电影金像奖最佳女主角、第43届台湾电影金马奖最佳女主角、获亚洲影评人协会奖、香港电影金紫荆奖、香港影评人协会最佳女主角及亚洲电影博览会年度最佳女演员 [3]  。2006年凭《夜宴》获第12届香港电影金紫荆奖及第26届香港电影金像奖最佳女配角。2008年主演《画皮》。2009年《李米的猜想》获第27届中国电影金鸡奖最佳女主角及第3届亚洲电影大奖最佳女主角。同年，获亚洲电影博览会授予年度之星表彰 [4-5]  。\n2010年被CNN评选为亚洲最伟大的25位演员之一。2014年被授予法国文学与艺术骑士勋章 [6]  ，周迅主演电视剧的《红高粱》播出，凭该片获上海电视节白玉兰奖最佳女主角、华鼎奖最佳女主角。 [7]  2015年任北京国际电影节评委。 [8]  2016年，主演史诗片《明月几时有》。 [9-10]  2017年，主演古装宫斗剧《如懿传》 [11]  ，与央视发起《今日影评·表演者言》 [12]  。2018，主演电影《你好，之华》 [13]  、《诗眼倦天涯》 [14]  。2019年8月，获2019福布斯中国100名人榜荣誉。', '无', '无', 'http://blog.sepclub.com/img/01/周迅.png', '2019-10-20 22:05:28', '2019-10-20 22:05:28');
INSERT INTO `t_cultural_famous_ht` VALUES ('11', '朱琳', 'CHN', '1', '67', '10011', '《西游记》\n《凯旋在子夜》\n《大众电视》\n《电视月刊》\n《时代电影》\n《远离战争年代》', '朱琳，1952年12月20日出生于北京，毕业于北京电影学院，国家一级演员，中国电影家协会会员、中国电影表演艺术学会会员、中国民主促进会会员，享受政府特殊津贴。 [1] \n1978年毕业于中国医学科学院 [2]  。1980年拍摄第一部电影《叛国者》 [3]  ；1981年，到北京电影学院表演培训班进修 [4]  。1985年，在电视剧《西游记》中扮演的女儿国国王，成为观众心目中的经典 [5]  ；1987年，因主演《凯旋在子夜》荣获第五届《大众电视》“金鹰奖”最佳女主角奖、《电视月刊》“永芳杯”首届电视十佳演员奖、《时代电影》最佳电视剧女明星奖。同年在影片《远离战争年代》中饰演歌剧演员文雁，该片获得苏联第十届亚非拉国际电影节--银奖、意大利第十二届萨尔索国际电影节评委会特别奖 [2]  [4]  ；2000年荣获“鄂尔多斯杯” 中央电视台电视剧观众最喜爱的演员奖 [4]  ；2010年，获得美国世界艺术家协会“华人艺术家表演杰出贡献奖” [4]  。', '无', '无', 'http://blog.sepclub.com/img/01/朱琳.jpg', '2019-10-20 22:05:28', '2019-10-20 22:05:28');
INSERT INTO `t_cultural_famous_ht` VALUES ('12', '张韶涵', 'TW', '1', '37', '10012', '亲爱的那不是爱情	\n欧若拉	\n看得最远的地方	\n遗失的美好\n喜欢你没道理	\n我恋爱了	\n香水百合	\n梦里花	\n不想懂得	\n隐形的翅膀	\n白白的	\n我的最爱', '张韶涵（Angela Zhang），1982年1月19日出生于台湾省桃园市中坜区，拥有四分之一维吾尔族血统 [1]  ，华语流行乐女歌手、影视演员，毕业于加拿大温斯顿爵士邱吉尔中等学校。\n2001年，出演个人首部电视剧《永不言弃》，从而正式进入演艺圈 [2-3]  。2003年，在爱情励志偶像剧《海豚湾恋人》中饰演女主角易天边 [4]  。2004年，推出首张个人音乐专辑《Over The Rainbow》 [5]  。2005年，凭借专辑《欧若拉》入围了第16届台湾金曲奖最佳国语女演唱人奖 [6]  ；同年，出演个人首部电影《短信一月追》 [7]  。2006年，推出第3张个人音乐专辑《潘朵拉》 [8]  ；同年，凭借电视剧《爱杀17》入围第41届台湾电视金钟奖戏剧节目最佳女主角奖 [9]  。2007年，相继推出个人音乐专辑《梦里花》 [10]  、《Ang 5.0》 [11]  ，并获得了新加坡金曲奖最佳演绎女歌手奖、年度全方位艺人奖等多个奖项 [12]  。2008年，凭借电视剧《公主小妹》获得第43届台湾电视金钟奖戏剧节目女主角奖的提名 [13]  。2009年，推出第6张个人音乐专辑《第5季》 [14]  。\n2012年，推出第7张个人音乐专辑《有形的翅膀》 [15]  。2013年，个人音乐品牌“天涵音乐”成立，并亲自担任CEO [16]  。2014年，凭借专辑《张韶涵Angela Zhang》获得全球华语歌曲排行榜最佳全能艺人奖、年度最佳专辑制作人奖等多个奖项 [17]  。2016年，推出第9张个人音乐专辑《全面沦陷》 [18]  。2018年，作为首发阵容参加湖南卫视原创歌手竞赛真人秀节目《歌手2018》 [19]  。2019年9月6日，推出个人单曲《引路的风筝》 [20]  。', '无', '无', 'http://blog.sepclub.com/img/01/张韶涵.png', '2019-10-20 22:05:28', '2019-10-20 22:05:28');
INSERT INTO `t_cultural_famous_ht` VALUES ('13', '李安', 'TW', '0', '65', '10020', '《双子杀手》\n《比利·林恩的中场战事》\n《少年派的奇幻漂流》\n《制造伍德斯托克音乐节》\n《色·戒》\n《断背山》', '李安（Ang Lee），1954年10月23日出生于台湾省屏东县潮州镇，电影导演、编剧、制片人，毕业于伊利诺伊大学香槟分校、纽约大学。\n1990年，执导了个人首部电影《推手》，该片获得了第28届台湾电影金马奖评审团特别奖。1993年，拍摄了剧情片《喜宴》，该片获得第43届柏林国际电影节金熊奖 ，李安凭借该片获得了第30届台湾电影金马奖最佳导演奖 。1994年，执导了剧情片《饮食男女》，该片获得第67届奥斯卡金像奖最佳外语片奖提名。1995年12月13日，执导的剧情片《理智与情感》上映，该片获得了第46届柏林国际电影节金熊奖。2000年7月7日，执导的武侠剧情片《卧虎藏龙》上映，该片获得了第73届奥斯卡金像奖最佳外语片奖。2003年6月17日，执导的超级英雄电影《绿巨人浩克》上映。2005年12月9日，执导的剧情片《断背山》上映，李安凭借该片获得了第78届奥斯卡金像奖最佳导演奖，成为首位获得该奖项的亚洲人。2007年9月24日，执导的剧情片《色·戒》上映，该片获得了第64届威尼斯国际电影节金狮奖。2009年2月，受邀担任第66届威尼斯国际电影节评委会主席。', '无', '无', 'http://blog.sepclub.com/img/01/李安.png', '2019-10-20 22:05:28', '2019-10-20 22:05:28');
INSERT INTO `t_cultural_famous_ht` VALUES ('14', '张子枫', 'CHN', '1', '18', '10011', '唐人街探案3\n我和我的祖国\n雪人奇缘\n欲念游戏\n秘密访客\n再见，少年\n你好，之华\n快把我哥带走\n李雷和韩梅梅\n岁月忽已暮', '张子枫，2001年8月27日出生于河南省三门峡市，中国内地女演员。\n在5岁时，张子枫开始拍广告并因参演多部电视剧从而进入演艺圈。2009年，凭灾难情感片《唐山大地震》的“小方登”一角而崭露头角，并获得第31届大众电影百花奖最佳新人奖 [1-2]  。2010年，主演了年代亲情剧《我的父亲是板凳》。2011年，主演家庭情感剧《情感战争》。2015年，在动作悬疑片《唐人街探案》中饰演神秘少女思诺；之后，主演都市家庭情感剧《小别离》。2016年，主演校园励志剧《我们的少年时代》。\n2017年5月4日，以十位文艺界优秀青年代表之一的身份荣获共青团中央宣传部特别授予的“五.四优秀青年”称号 [3]  。2018年，主演根据同名国产漫画改编的电影《快把我哥带走》。同年，出演文艺爱情电影《你好，之华》和悬疑电影《秘密访客》。\n2019年1月4日，张子枫当选中国电影频道评选的演技派新生代四小花旦 [4]  ；8月，获2019福布斯中国100名人榜荣誉。', '无', '无', 'http://blog.sepclub.com/img/01/张子枫.png', '2019-10-20 22:05:28', '2019-10-20 22:05:28');
INSERT INTO `t_cultural_famous_ht` VALUES ('15', '陈乔恩', 'TW', '1', '40', '10011', '独孤皇后\n传奇大亨\n人间至味是清欢\n天使的幸福\n壮志高飞\n鬼吹灯之精绝古城\n放弃我，抓紧我', '陈乔恩（Joe Chen），1979年4月4日出生于台湾省新竹县竹北市，华语影视女演员、主持人、歌手。\n2001年9月23日，陈乔恩正式出道 [1]  ，并于同年出演个人首部影视剧《薰衣草》 [2]  。2002年，她凭借旅游节目《中国那么大》在台湾主持界崭露头角。2004年，陈乔恩随七朵花团体进军乐坛 [3-4]  。2005年，其主演的爱情喜剧《王子变青蛙》打破台湾偶像剧收视纪录 [5]  。2008年，主演的都市剧《命中注定我爱你》创下台湾电视史上偶像剧冠军收视纪录 [6]  。\n2009年，陈乔恩将工作重心转向了中国内地，并主演了其在内地的首部正式作品《佳期如梦》 [7]  。2010年，陈乔恩主演了个人首部大银幕作品《激浪青春》 [8]  。2011年，陈乔恩主演了爱情片《倾城之泪》 [9]  ；同年，她还主演了时尚剧《胜女的代价》。2012年，陈乔恩主演了个人首部舞台剧《面包树上的女人》，并因此获得第四届丹尼奖话剧最佳女演员奖 [10-11]  。2013年，陈乔恩凭借武侠剧《笑傲江湖》在内地获得广泛关注 [12-14]  。2014年，陈乔恩主演了校园电影《既然青春留不住》 [15]  。2015年，陈乔恩不仅连续三年跻身福布斯中国名人榜 [16-17]  ；她还凭借年代剧《锦绣缘华丽冒险》获得华鼎奖中国近代电视剧最佳女演员', '无', '无', 'http://blog.sepclub.com/img/01/陈乔恩.jpg', '2019-10-20 22:05:28', '2019-10-20 22:05:28');
INSERT INTO `t_cultural_famous_ht` VALUES ('16', '张艺谋', 'CHN', '0', '69', '10020', '《一个和八个》\n摄影\n《黄土地》\n摄影\n1986\n《大阅兵》\n摄影\n1987\n《老井》\n主演/摄影\n《红高粱》\n导演\n1989\n《古今大战秦俑情》\n主演\n《代号美洲豹》\n导演\n1990\n《菊豆》\n导演\n1991\n《大红灯笼高高挂》\n导演\n1992\n《秋菊打官司》\n导演\n1994\n《活着》\n导演\n1995\n《摇啊摇，摇到外婆桥》\n导演\n1996	\n《卢米埃与四十大导》\n导演/演员\n1997	《有话好好说》	导演/演员\n1998\n《一个都不能少》\n导演\n1999\n《我的父亲母亲》\n导演\n2000\n《大宅门》\n演员/客串\n2000\n《幸福时光》\n导演\n2002\n《英雄》\n导演/编剧\n2004\n《十面埋伏》\n导演/编剧\n2005\n《千里走单骑》\n导演/编剧\n2006\n《满城尽带黄金甲》\n导演/编剧\n2009\n《三枪拍案惊奇》\n导演\n2010\n《山楂树之恋》\n导演\n2011\n《金陵十三钗》\n导演\n2014	《归来》	导演\n2016	《长城》	导演\n2018	《影》	导演/编剧\n2019	《一秒钟》', '张艺谋，1950年4月2日出生于陕西西安，中国电影导演，“第五代导演”代表人物之一，美国波士顿大学、耶鲁大学荣誉博士。 [1-2] \n1978年进入北京电影学院摄影系学习。1982年毕业后分配到广西电影制片厂。 [3]  1984年在电影《一个和八个》中首次担任摄影师，获中国电影优秀摄影师奖。 [4]  1986年主演第一部电影《老井》夺三座影帝。 [5]  1987年执导的第一部电影《红高粱》获中国首个国际电影节金熊奖。 [6]  从此开始实现他电影创作的三部曲，由摄影师走向演员，最后走向导演生涯。 [7] \n1987年至1999年执导的《红高粱》、《菊豆》、《大红灯笼高高挂》、《秋菊打官司》、《活着》、《一个都不能少》、《我的父亲母亲》等影片令其在国内外屡获电影奖项，并三次提名奥斯卡和五次提名金球奖。 [2]  [8]  2002年后转型执导的商业片《英雄》、《十面埋伏》、《满城尽带黄金甲》及《金陵十三钗》两次刷新中国电影票房纪录、四次夺得年度华语片票房冠军。 [9-10] \n曾任第18届东京国际电影节评委会主席和第64届威尼斯国际电影节评委会主席。 [11]  2008年担任北京奥运会开幕式和闭幕式总导演，获得2008影响世界华人大奖和央视主办的感动中国十大人物，并提名美国《时代周刊》年度人物。 [12-13] \n2013年，执导电影《归来》。 [14]  2015年，筹拍好莱坞电影《长城》。 [15-16]  2016年，担任中国杭州G20峰会文艺演出总导演。 [17]  2017年执导动作电影《影》，凭借该片获得第55届金马奖最佳导演奖 [18]  。2019年10月1日，担任庆祝新中国成立70周年联欢活动总导演。', '无', '无', 'http://blog.sepclub.com/img/01/张艺谋.jpg', '2019-10-20 22:05:28', '2019-10-20 22:05:28');
INSERT INTO `t_cultural_famous_ht` VALUES ('17', '林志玲', 'TW', '1', '45', '10011', '西游记女儿国\n祖宗十九代\n缝纫机乐队\n吃吃的爱\n喜欢你\n北京·纽约\n道士下山\n谁是卧底之王牌\n富春山居图\n甜心巧克力', '林志玲（Lin Chi-ling），1974年11月29日出生于台湾省台北市，华语影视女演员、模特、主持人。\n2000年，林志玲签约凯渥模特经纪公司并开始职业模特生涯。2002年，林志玲因拍摄某企业电视广告而获得更多关注。并于次年被媒体评选为“台湾第一美女” [1]  。2004年，她开始将演艺事业转向内地。2007年，林志玲出演银幕处女作《赤壁》并正式进军影视领域 [2]  。2008年，林志玲主演个人首部喜剧片《决战刹马镇》 [3]  。\n2010年，林志玲获得FHM全球百大美女四连冠 [4]  ；并于同年主演日本爱情剧《月之恋人》 [5]  。2011年，她在言情片《幸福额度》中首次一人分饰两角 [6]  。2014年，林志玲主演了剧情片《北京·纽约》 [7]  。2015年，林志玲开始参加真人秀节目《花样姐姐》 [8]  。2019年6月6日，林志玲宣布与日本艺人AKIRA结婚 [9]  。', '无', '无', 'http://blog.sepclub.com/img/01/林志玲.png', '2019-10-20 22:05:28', '2019-10-20 22:05:28');

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
  `representative_works` varchar(1000) DEFAULT NULL COMMENT '代表作品',
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
  `representative_works` varchar(1000) DEFAULT NULL COMMENT '代表作品',
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
