/*
Navicat MySQL Data Transfer

Source Server         : hlj
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : traveling

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2019-01-15 08:43:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `information`
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `lid` varchar(6) NOT NULL,
  `cname` varchar(20) NOT NULL,
  `place` varchar(20) NOT NULL,
  `special` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES ('1', '文兴米粉老店', '延安路', '吃南充米粉打卡地');
INSERT INTO `information` VALUES ('1', '王烧烤', '西华师大新区', '火爆烧烤、小米辣汤锅、木槿屋韩餐');
INSERT INTO `information` VALUES ('2', '凤源豆花', '果山街', '炖菜、豆花');
INSERT INTO `information` VALUES ('2', '小町屋', '西河中路路', '日式小店，猫饭');
INSERT INTO `information` VALUES ('1', '娜姐大叔娜姐陈', '阿龙肯德基卡', '阿李静大爹');

-- ----------------------------
-- Table structure for `location`
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `lid` varchar(3) NOT NULL,
  `lname` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of location
-- ----------------------------
INSERT INTO `location` VALUES ('1', '南充');
INSERT INTO `location` VALUES ('2', '成都');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `mgname` varchar(20) NOT NULL,
  `mgpsw` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('hhh', '1');
INSERT INTO `manager` VALUES ('侯丽娟', '123');
INSERT INTO `manager` VALUES ('123', '12');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('侯丽娟', '123456');
INSERT INTO `user` VALUES ('bbb', '111');
INSERT INTO `user` VALUES ('岳晓倩', '123');
INSERT INTO `user` VALUES ('唐家玉', '123');
INSERT INTO `user` VALUES ('糖糖', '123');
INSERT INTO `user` VALUES ('哈哈哈', '123');
INSERT INTO `user` VALUES ('计算的分红', '122312');
INSERT INTO `user` VALUES ('凯凯', '1212');
