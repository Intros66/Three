/*
Navicat MySQL Data Transfer

Source Server         : Javaweb
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : mystu

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-11-17 15:29:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sno` int(11) NOT NULL,
  `sname` varchar(20) DEFAULT NULL,
  `sage` int(3) DEFAULT NULL,
  `saddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '弥豆子', '33', 'za');
INSERT INTO `student` VALUES ('2', '尔尔', '23', 'wx');
INSERT INTO `student` VALUES ('4', '豆子', '20', '北京');
INSERT INTO `student` VALUES ('5', '无无无', '20', '紫荆');
INSERT INTO `student` VALUES ('6', '六六', '66', 'sss');
INSERT INTO `student` VALUES ('7', '凌凌漆', '77', 'qqqq');
INSERT INTO `student` VALUES ('8', 'jojo', '8', '杭州');
INSERT INTO `student` VALUES ('9', 'JoJo', '9', '北京');
INSERT INTO `student` VALUES ('11', 'wws', '50', 'za');
