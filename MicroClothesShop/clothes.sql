/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : clothes

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2016-09-27 12:37:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Create database clothes
-- ----------------------------
DROP DATABASE IF EXISTS `clothes`;
CREATE DATABASE `clothes`;
USE `clothes`;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `a_id` varchar(66) NOT NULL,
  `a_name` varchar(255) NOT NULL,
  `a_mail` varchar(255) NOT NULL,
  `a_phone` varchar(255) NOT NULL,
  `a_pw` varchar(255) NOT NULL,
  `a_lt` datetime NOT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('101', 'Lihua', 'jbw.ghost@foxmail.com', '15769398971', 'jbw994730', '2015-07-12 13:12:38');
INSERT INTO `admin` VALUES ('102', 'Admin', 'jbw.ghost@outlook.com', '15769398971', 'jbw994730', '2016-09-27 11:48:13');

-- ----------------------------
-- Table structure for clothes
-- ----------------------------
DROP TABLE IF EXISTS `clothes`;
CREATE TABLE `clothes` (
  `c_id` varchar(66) NOT NULL,
  `c_name` varchar(255) NOT NULL,
  `c_brand` varchar(255) NOT NULL,
  `c_product` varchar(255) NOT NULL,
  `c_size` varchar(255) NOT NULL,
  `c_style` varchar(255) NOT NULL,
  `c_color` varchar(255) NOT NULL,
  `c_metra` varchar(255) NOT NULL,
  `c_package` varchar(255) NOT NULL,
  `c_sellednum` int(11) NOT NULL,
  `c_surplusnum` int(11) NOT NULL,
  `c_image` varchar(255) NOT NULL,
  `c_price` double NOT NULL,
  `c_semester` varchar(255) NOT NULL,
  `c_people` varchar(255) NOT NULL,
  `c_discount` double NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothes
-- ----------------------------
INSERT INTO `clothes` VALUES ('095757526B104477850B37B2F53057D3', '爱马仕夏季女士T恤', '爱马仕', '北京制衣厂', 'XL', '休闲', '白色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c8.jpg', '145.6', '夏季', '女士', '6.8');
INSERT INTO `clothes` VALUES ('100001', '夏季爱马仕女款外套', '爱马仕', '北京服装制造有限公司', 'XL', '休闲', '蓝色', '丝绸', '精装礼盒', '876', '242', '/MicroClothesShop/clothes_img/c1.jpg', '672.99', '夏季', '女士', '8.9');
INSERT INTO `clothes` VALUES ('100002', '春季耐克男士外套', '耐克', '上海制衣厂', 'XXL', '休闲', '天蓝', '涤纶', '普通包装', '1985', '578', '/MicroClothesShop/clothes_img/c2.jpg', '361.87', '春季', '男士', '6.9');
INSERT INTO `clothes` VALUES ('100003', '秋季男士秋裤', '李宁', '中国制造总长', 'ML', '休闲', '浅灰', '棉布', '普通包装', '8891', '6659', '/MicroClothesShop/clothes_img/c3.jpg', '87.6', '秋季', '男士', '8.5');
INSERT INTO `clothes` VALUES ('100004', '哇哈哈儿童套装', '哇哈哈', '北京服装厂', '80', '童装', '天蓝', '纯棉', '普通', '880', '976', '/MicroClothesShop/clothes_img/c4.jpg', '69.5', '春季', '男孩', '9.7');
INSERT INTO `clothes` VALUES ('100005', '波司登男士羽绒服', '波司登', '上海制衣厂', 'XL', '棉衣', '黑色', '羽绒', '精装', '89', '113', '/MicroClothesShop/clothes_img/c5.jpg', '1098.8', '冬季', '男士', '8.7');
INSERT INTO `clothes` VALUES ('100006', 'LV专业高端女士皮草', 'LV', '大英制造厂', 'XXL', '皮草', '灰黑', '毛皮', '精装', '24', '68', '/MicroClothesShop/clothes_img/c6.jpg', '1889.8', '冬季', '女士', '9.9');
INSERT INTO `clothes` VALUES ('100007', '哇哈哈女孩外套', '哇哈哈', '兰州制衣厂', '110', '外套', '粉红', '纯棉', '精装', '75', '68', '/MicroClothesShop/clothes_img/c7.jpg', '187.5', '夏季', '女孩', '6.9');
INSERT INTO `clothes` VALUES ('100008', '特步登山外套', '特步', '北京制衣厂', 'ML', '外套', '绿色', '涤纶', '普通', '253', '164', '/MicroClothesShop/clothes_img/c8.jpg', '206.7', '春季', '男士', '9.5');
INSERT INTO `clothes` VALUES ('100009', '卡哇伊女士内衣', '卡哇伊', '兰州制衣厂', 'XXL', '内衣', '白色', '纯棉', '普通', '13', '66', '/MicroClothesShop/clothes_img/c1.jpg', '119.9', '秋季', '女士', '8.8');
INSERT INTO `clothes` VALUES ('100010', '美特斯邦威春季男士外套', '美特斯邦威', '上海制衣厂', 'ML', '休闲', '青色', '涤纶', '精装', '23', '3345', '/MicroClothesShop/clothes_img/c10.jpg', '346.7', '春季', '男士', '8.8');
INSERT INTO `clothes` VALUES ('100011', '哇哈哈童装', '哇哈哈', '北京制衣厂', '120', '外套', '橙色', '纯棉', '普通', '46', '33', '/MicroClothesShop/clothes_img/c11.jpg', '178.9', '秋季', '男孩', '5.4');
INSERT INTO `clothes` VALUES ('100012', '爱马仕女士今夏流行短袖', '爱马仕', '大英制衣厂', 'ML', '休闲', '白色', '纯棉', '精装', '275', '364', '/MicroClothesShop/clothes_img/c12.jpg', '889.56', '夏季', '女士', '8.8');
INSERT INTO `clothes` VALUES ('100013', '美特斯邦威男孩羽绒服', '美特斯邦威', '美利坚制衣厂', '90', '棉衣', '黑色', '羽绒', '普通', '124', '234', '/MicroClothesShop/clothes_img/c13.jpg', '264.6', '冬季', '男孩', '8.6');
INSERT INTO `clothes` VALUES ('100014', '乔丹男生篮球球服', '乔丹', '美利坚制衣厂', 'XXL', '运动', '红色', '涤纶', '普通', '468', '143', '/MicroClothesShop/clothes_img/c14.jpg', '156.8', '夏季', '男士', '9.4');
INSERT INTO `clothes` VALUES ('100015', '爱马仕女士外套', '爱马仕', '兰州制衣厂', 'XL', '休闲', '白色', '纯棉', '精装', '144', '63', '/MicroClothesShop/clothes_img/c15.jpg', '673.9', '秋季', '女士', '7.6');
INSERT INTO `clothes` VALUES ('100016', '杰克琼斯男士毛衣', '杰克.琼斯', '大英制衣厂', 'XXL', '保暖', '灰色', '羊毛', '普通', '64', '23', '/MicroClothesShop/clothes_img/c15.jpg', '886.8', '冬季', '男士', '8.8');
INSERT INTO `clothes` VALUES ('100017', '哇哈哈男孩T恤', '哇哈哈', '上海制衣厂', 'ML', '休闲', '天蓝', '纯棉', '普通', '2226', '2224', '/MicroClothesShop/clothes_img/c16.jpg', '399.8', '夏季', '男孩', '8.5');
INSERT INTO `clothes` VALUES ('100018', '特步运动短裤', '特步', '北京制衣厂', 'XL', '运动', '黑色', '涤纶', '普通', '1178', '687', '/MicroClothesShop/clothes_img/c12.jpg', '99', '夏季', '男士', '7.6');
INSERT INTO `clothes` VALUES ('100019', '天使女士保暖底裤', '天使', '兰州制衣厂', 'XL', '保暖', '黑色', '纯棉', '普通', '212', '323', '/MicroClothesShop/clothes_img/c15.jpg', '198.3', '冬季', '女士', '9.3');
INSERT INTO `clothes` VALUES ('128F1707037D4110BD26BBDFCD35C55C', 'dsd', 'dsds', 'sdd', 'dsds', 'dsd', 'dsdd', 'dsd', 'dsds', '0', '343', '/MicroClothesShop/clothes_img/c5.jpg', '3432', 'dsds', 'dsd', '4.7');
INSERT INTO `clothes` VALUES ('228D66756E154EDEB0DF5BBF4B73A158', '爱马仕夏季女士T恤', '爱马仕', '北京制衣厂', 'XL', '休闲', '白色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c2.jpg', '897.6', '夏季', '女士', '6.8');
INSERT INTO `clothes` VALUES ('294D4E9A15E84F0A88B5395B660688F7', '美特斯邦威夏季男士T恤', '美特斯邦威', '兰州制衣厂', 'XXL', '休闲', '花色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c11.jpg', '127', '夏季', '男士', '7.8');
INSERT INTO `clothes` VALUES ('29797EDF86BA4967B4BE5E5983956339', '爱马仕夏季女士T恤', '爱马仕', '北京制衣厂', 'XL', '休闲', '白色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c7.jpg', '128', '夏季', '女士', '6.8');
INSERT INTO `clothes` VALUES ('2EC0DD7F98F2436CBDB4550B779534CF', '杰克.琼斯夏季男士T恤', '杰克.琼斯', '上海制衣厂', 'XXL', '休闲', '蓝色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c5.jpg', '255', '夏季', '男士', '6.8');
INSERT INTO `clothes` VALUES ('35CF8C7AFF924DBEBEB3893F1330A0BF', '特步夏季男士运动衫', '特步', '大英制衣厂', 'ML', '运动', '橙色', '棉布', '普通', '0', '786', '/MicroClothesShop/clothes_img/c3.jpg', '904', '秋季', '男士', '8.8');
INSERT INTO `clothes` VALUES ('38782E049A264627BB01FD2E1B26377C', '杰克.琼斯夏季男士T恤', '杰克.琼斯', '上海制衣厂', 'XXL', '休闲', '蓝色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c10.jpg', '99', '夏季', '男士', '6.8');
INSERT INTO `clothes` VALUES ('38F28403FE8040E58F5CF3627BF3C4F4', '特步夏季男士运动衫', '特步', '大英制衣厂', 'ML', '运动', '橙色', '棉布', '普通', '0', '786', '/MicroClothesShop/clothes_img/c8.jpg', '323.23', '秋季', '男士', '8.8');
INSERT INTO `clothes` VALUES ('3A0ABD03877946D986B4015F5FF3F9DF', '特步夏季男士运动衫', '特步', '大英制衣厂', 'ML', '运动', '橙色', '棉布', '普通', '0', '786', '/MicroClothesShop/clothes_img/c9.jpg', '138.54', '秋季', '男士', '8.8');
INSERT INTO `clothes` VALUES ('3B35CCF0F9244B6BAD5FA139CA037874', '杰克.琼斯夏季男士T恤', '杰克.琼斯', '上海制衣厂', 'XXL', '休闲', '蓝色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c0.jpg', '640.77', '夏季', '男士', '6.8');
INSERT INTO `clothes` VALUES ('3F04A2D4A15F4BCD82BDBA07072BAC43', '杰克.琼斯夏季男士T恤', '杰克.琼斯', '上海制衣厂', 'XXL', '休闲', '蓝色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c13.jpg', '536.4', '夏季', '男士', '6.8');
INSERT INTO `clothes` VALUES ('43B8203F7A9740CBBC8E288EBA1F93B6', '美特斯邦威夏季男士T恤', '美特斯邦威', '兰州制衣厂', 'XXL', '休闲', '花色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c4.jpg', '389', '夏季', '男士', '7.8');
INSERT INTO `clothes` VALUES ('43CB75ED99C44B43848A75D40F7775B5', '杰克.琼斯夏季男士T恤', '杰克.琼斯', '上海制衣厂', 'XXL', '休闲', '蓝色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c6.jpg', '849', '夏季', '男士', '6.8');
INSERT INTO `clothes` VALUES ('43F6BCE4DB414B7DB3C9C32BCA822FB3', '爱马仕夏季女士T恤', '爱马仕', '北京制衣厂', 'XL', '休闲', '白色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c3.jpg', '693', '夏季', '女士', '6.8');
INSERT INTO `clothes` VALUES ('4A096087B6AA45528F782E61EDFCFA3E', 'asaasa', 'sasa', 'sasa', 'sas', 'asa', 'asa', 'sasa', 'sas', '0', '323', '/MicroClothesShop/clothes_img/c3.jpg', '32', 'sasa', 'sasa', '3.9');
INSERT INTO `clothes` VALUES ('4CB014F2AB28498B878C7597FF9F9474', '杰克.琼斯夏季男士T恤', '杰克.琼斯', '上海制衣厂', 'XXL', '休闲', '蓝色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c15.jpg', '707.7', '夏季', '男士', '6.8');
INSERT INTO `clothes` VALUES ('4D54AE6923434924AD3526BBE8C1A4C5', '杰克.琼斯夏季男士T恤', '杰克.琼斯', '上海制衣厂', 'XXL', '休闲', '蓝色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c12.jpg', '587.91', '夏季', '男士', '6.8');
INSERT INTO `clothes` VALUES ('4EF0C563D5D544EB9DF08B28860335C2', '爱马仕夏季女士T恤', '爱马仕', '北京制衣厂', 'XL', '休闲', '白色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c12.jpg', '564', '夏季', '女士', '6.8');
INSERT INTO `clothes` VALUES ('52CFF2FEA84A4367A5B223619F1C7BC6', '美特斯邦威夏季男士T恤', '美特斯邦威', '兰州制衣厂', 'XXL', '休闲', '花色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c7.jpg', '644.89', '夏季', '男士', '7.8');
INSERT INTO `clothes` VALUES ('535C6B8C41DF49B5AFA00693C3DB051B', '杰克.琼斯夏季男士T恤', '杰克.琼斯', '上海制衣厂', 'XXL', '休闲', '蓝色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c7.jpg', '982.17', '夏季', '男士', '6.8');
INSERT INTO `clothes` VALUES ('54ECA2B4FBF344429A65C0BC49110263', '特步夏季男士运动衫', '特步', '大英制衣厂', 'ML', '运动', '橙色', '棉布', '普通', '0', '786', '/MicroClothesShop/clothes_img/c4.jpg', '546', '秋季', '男士', '8.8');
INSERT INTO `clothes` VALUES ('5BA79937BA794A8085B185A73454839F', '特步夏季男士运动衫', '特步', '大英制衣厂', 'ML', '运动', '橙色', '棉布', '普通', '0', '786', '/MicroClothesShop/clothes_img/c11.jpg', '720.9', '秋季', '男士', '8.8');
INSERT INTO `clothes` VALUES ('5F00616D9B384ACBA29220F4E6E50BF5', '爱马仕夏季女士T恤', '爱马仕', '北京制衣厂', 'XL', '休闲', '白色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c1.jpg', '526', '夏季', '女士', '6.8');
INSERT INTO `clothes` VALUES ('64D12F768993417EBBBFED87DC782CA6', '爱马仕夏季女士T恤', '爱马仕', '北京制衣厂', 'XL', '休闲', '白色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c0.jpg', '286', '夏季', '女士', '6.8');
INSERT INTO `clothes` VALUES ('66CBF6086C074FF38144D309FE4C8751', '爱马仕夏季女士T恤', '爱马仕', '北京制衣厂', 'XL', '休闲', '白色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c14.jpg', '448', '夏季', '女士', '6.8');
INSERT INTO `clothes` VALUES ('6739BDFC54624CB3B8CF3AC52E406CC8', '爱马仕夏季女士T恤', '爱马仕', '北京制衣厂', 'XL', '休闲', '白色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c11.jpg', '292', '夏季', '女士', '6.8');
INSERT INTO `clothes` VALUES ('6A473D2D651E49EE8AF57F5355C717B5', '特步夏季男士运动衫', '特步', '大英制衣厂', 'ML', '运动', '橙色', '棉布', '普通', '0', '786', '/MicroClothesShop/clothes_img/c14.jpg', '546', '秋季', '男士', '8.8');
INSERT INTO `clothes` VALUES ('70D338B463554DCAB5C27D80053CFDE6', '特步夏季男士运动衫', '特步', '大英制衣厂', 'ML', '运动', '橙色', '棉布', '普通', '0', '786', '/MicroClothesShop/clothes_img/c1.jpg', '940.2', '秋季', '男士', '8.8');
INSERT INTO `clothes` VALUES ('73AD129D96EB409AB81947C25B7FCB2A', '特步夏季男士运动衫', '特步', '大英制衣厂', 'ML', '运动', '橙色', '棉布', '普通', '0', '786', '/MicroClothesShop/clothes_img/c15.jpg', '692.6', '秋季', '男士', '8.8');
INSERT INTO `clothes` VALUES ('7DB216FC48174F24AFAAA987ED59ECD9', '特步夏季男士运动衫', '特步', '大英制衣厂', 'ML', '运动', '橙色', '棉布', '普通', '0', '786', '/MicroClothesShop/clothes_img/c12.jpg', '761', '秋季', '男士', '8.8');
INSERT INTO `clothes` VALUES ('7EF69ECF3BBD4F81ACF5A5FA0339F4A9', '爱马仕夏季女士T恤', '爱马仕', '北京制衣厂', 'XL', '休闲', '白色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c6.jpg', '144', '夏季', '女士', '6.8');
INSERT INTO `clothes` VALUES ('88E48C5AD44546F5965AFE44714FA2C4', '特步夏季男士运动衫', '特步', '大英制衣厂', 'ML', '运动', '橙色', '棉布', '普通', '0', '786', '/MicroClothesShop/clothes_img/c2.jpg', '523.65', '秋季', '男士', '8.8');
INSERT INTO `clothes` VALUES ('8D1750970643489DB1B9B338E6C520CE', '杰克.琼斯夏季男士T恤', '杰克.琼斯', '上海制衣厂', 'XXL', '休闲', '蓝色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c14.jpg', '70.54', '夏季', '男士', '6.8');
INSERT INTO `clothes` VALUES ('933DA79E62FE4DDEBAAB55615BD92A40', '杰克.琼斯夏季男士T恤', '杰克.琼斯', '上海制衣厂', 'XXL', '休闲', '蓝色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c1.jpg', '59', '夏季', '男士', '6.8');
INSERT INTO `clothes` VALUES ('9CE4AA80DFCB4CE283D6EFA78757645A', '特步夏季男士运动衫', '特步', '大英制衣厂', 'ML', '运动', '橙色', '棉布', '普通', '0', '786', '/MicroClothesShop/clothes_img/c5.jpg', '881', '秋季', '男士', '8.8');
INSERT INTO `clothes` VALUES ('9E5CE0F0F3DD4C08AF31D5EF6168FF0E', '美特斯邦威夏季男士T恤', '美特斯邦威', '兰州制衣厂', 'XXL', '休闲', '花色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c9.jpg', '703.25', '夏季', '男士', '7.8');
INSERT INTO `clothes` VALUES ('A7E7465B75B9406AAB61E740CF8415EE', '爱马仕夏季女士T恤', '爱马仕', '北京制衣厂', 'XL', '休闲', '白色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c5.jpg', '217', '夏季', '女士', '6.8');
INSERT INTO `clothes` VALUES ('A7FAE5A3996F4B358548A93D5B74EA41', '爱马仕夏季女士T恤', '爱马仕', '北京制衣厂', 'XL', '休闲', '白色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c9.jpg', '396', '夏季', '女士', '6.8');
INSERT INTO `clothes` VALUES ('AD3D38D79DFE4F419C6AF066538DFD81', '杰克.琼斯夏季男士T恤', '杰克.琼斯', '上海制衣厂', 'XXL', '休闲', '蓝色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c4.jpg', '609.57', '夏季', '男士', '6.8');
INSERT INTO `clothes` VALUES ('ADAE259B52CE40919A872B8EA7C150D3', '美特斯邦威夏季男士T恤', '美特斯邦威', '兰州制衣厂', 'XXL', '休闲', '花色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c13.jpg', '528.44', '夏季', '男士', '7.8');
INSERT INTO `clothes` VALUES ('AE6EDBCEA12D4760A71A8CF4D5C4A34F', '美特斯邦威夏季男士T恤', '美特斯邦威', '兰州制衣厂', 'XXL', '休闲', '花色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c15.jpg', '857.7', '夏季', '男士', '7.8');
INSERT INTO `clothes` VALUES ('B3BFB98EDB194B7A988DB879D40950E7', '杰克.琼斯夏季男士T恤', '杰克.琼斯', '上海制衣厂', 'XXL', '休闲', '蓝色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c11.jpg', '401.2', '夏季', '男士', '6.8');
INSERT INTO `clothes` VALUES ('BD1EB4718F294999A78A00E1AF488719', '美特斯邦威夏季男士T恤', '美特斯邦威', '兰州制衣厂', 'XXL', '休闲', '花色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c12.jpg', '403.96', '夏季', '男士', '7.8');
INSERT INTO `clothes` VALUES ('BFEF36A84EAE4677903140CADDC98ED5', '美特斯邦威夏季男士T恤', '美特斯邦威', '兰州制衣厂', 'XXL', '休闲', '花色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c3.jpg', '108.18', '夏季', '男士', '7.8');
INSERT INTO `clothes` VALUES ('C1FFB4682BD5432C9517353E20631DA7', '美特斯邦威夏季男士T恤', '美特斯邦威', '兰州制衣厂', 'XXL', '休闲', '花色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c8.jpg', '442.2', '夏季', '男士', '7.8');
INSERT INTO `clothes` VALUES ('CCDE35E5745540D9B19924ABA8ABB82C', '美特斯邦威夏季男士T恤', '美特斯邦威', '兰州制衣厂', 'XXL', '休闲', '花色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c5.jpg', '937.341', '夏季', '男士', '7.8');
INSERT INTO `clothes` VALUES ('D1446335D4BD42EC94E4C570502F7A1A', '特步夏季男士运动衫', '特步', '大英制衣厂', 'ML', '运动', '橙色', '棉布', '普通', '0', '786', '/MicroClothesShop/clothes_img/c10.jpg', '537.46', '秋季', '男士', '8.8');
INSERT INTO `clothes` VALUES ('D3CF823486E64AACA47C2791A5FD20DA', '美特斯邦威夏季男士T恤', '美特斯邦威', '兰州制衣厂', 'XXL', '休闲', '花色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c0.jpg', '869.91', '夏季', '男士', '7.8');
INSERT INTO `clothes` VALUES ('D663381CE0C44FD89495852CB8E2C8E7', '爱马仕夏季女士T恤', '爱马仕', '北京制衣厂', 'XL', '休闲', '白色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c13.jpg', '177', '夏季', '女士', '6.8');
INSERT INTO `clothes` VALUES ('D7174AAEFC8A4E559D0FCD02196B759F', '美特斯邦威夏季男士T恤', '美特斯邦威', '兰州制衣厂', 'XXL', '休闲', '花色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c1.jpg', '261.06', '夏季', '男士', '7.8');
INSERT INTO `clothes` VALUES ('DAB3E1FC7DA34DAE82A50536440F6EEB', '杰克.琼斯夏季男士T恤', '杰克.琼斯', '上海制衣厂', 'XXL', '休闲', '蓝色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c2.jpg', '458.52', '夏季', '男士', '6.8');
INSERT INTO `clothes` VALUES ('DE68738D7ED04F56B291AB74DAAA81F3', '美特斯邦威夏季男士T恤', '美特斯邦威', '兰州制衣厂', 'XXL', '休闲', '花色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c14.jpg', '674', '夏季', '男士', '7.8');
INSERT INTO `clothes` VALUES ('DEFD355D76BD4C5F8A73FE81573E887C', '美特斯邦威夏季男士T恤', '美特斯邦威', '兰州制衣厂', 'XXL', '休闲', '花色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c6.jpg', '786.3', '夏季', '男士', '7.8');
INSERT INTO `clothes` VALUES ('E5C2CB59E6F145C6962927ECB3FAFE28', '爱马仕夏季女士T恤', '爱马仕', '北京制衣厂', 'XL', '休闲', '白色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c10.jpg', '6431', '夏季', '女士', '6.8');
INSERT INTO `clothes` VALUES ('E8366A16650E49B2AD86C4547B1B5426', '美特斯邦威夏季男士T恤', '美特斯邦威', '兰州制衣厂', 'XXL', '休闲', '花色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c10.jpg', '162.09', '夏季', '男士', '7.8');
INSERT INTO `clothes` VALUES ('EC68AF475776478FBDB52ED6E50B49E4', '爱马仕夏季女士T恤', '爱马仕', '北京制衣厂', 'XL', '休闲', '白色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c4.jpg', '673.2', '夏季', '女士', '6.8');
INSERT INTO `clothes` VALUES ('EE4AB697A6594CC5BAA677FF59FC6690', '杰克.琼斯夏季男士T恤', '杰克.琼斯', '上海制衣厂', 'XXL', '休闲', '蓝色', '棉布', '精装', '0', '246', '/MicroClothesShop/clothes_img/c8.jpg', '553.06', '夏季', '男士', '6.8');
INSERT INTO `clothes` VALUES ('FF32537605194A098BEC13FC5C9DF0FD', '特步夏季男士运动衫', '特步', '大英制衣厂', 'ML', '运动', '橙色', '棉布', '普通', '0', '786', '/MicroClothesShop/clothes_img/c6.jpg', '158', '秋季', '男士', '8.8');

-- ----------------------------
-- Table structure for com
-- ----------------------------
DROP TABLE IF EXISTS `com`;
CREATE TABLE `com` (
  `m_id` varchar(66) NOT NULL,
  `o_id` varchar(66) NOT NULL,
  `c_id` varchar(66) NOT NULL,
  `c_num` int(11) NOT NULL,
  PRIMARY KEY (`m_id`),
  KEY `ccw` (`c_id`),
  KEY `order` (`o_id`),
  CONSTRAINT `ccw` FOREIGN KEY (`c_id`) REFERENCES `clothes` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order` FOREIGN KEY (`o_id`) REFERENCES `orders` (`o_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of com
-- ----------------------------
INSERT INTO `com` VALUES ('70BAF8B6A84140EAA5298EE2A8512CFE', '48842D1AFEA74464B19C3BC0A08B335A', '095757526B104477850B37B2F53057D3', '0');
INSERT INTO `com` VALUES ('851D2322203F4A01B53F7BC72352B153', 'DDA8F0E2542A4141B89136FFE890B1E2', '095757526B104477850B37B2F53057D3', '1');
INSERT INTO `com` VALUES ('AAB0EA64E24D457583A58CE65E5206E8', 'F7137C659CEF40E2AC1B9FB7D385418E', '100006', '1');
INSERT INTO `com` VALUES ('C123A81061204FF08CB0FC014AC53046', '6282776BAB4745B6890861A858DE0D65', '73AD129D96EB409AB81947C25B7FCB2A', '0');

-- ----------------------------
-- Table structure for cum
-- ----------------------------
DROP TABLE IF EXISTS `cum`;
CREATE TABLE `cum` (
  `m_id` varchar(66) NOT NULL,
  `c_id` varchar(66) NOT NULL,
  `c_num` int(11) NOT NULL,
  `u_id` varchar(66) NOT NULL,
  `m_statu` int(11) NOT NULL,
  `c_package` varchar(255) NOT NULL,
  PRIMARY KEY (`m_id`),
  KEY `cccc` (`c_id`),
  KEY `uuis` (`u_id`),
  CONSTRAINT `cccc` FOREIGN KEY (`c_id`) REFERENCES `clothes` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `uuis` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cum
-- ----------------------------
INSERT INTO `cum` VALUES ('62B2D1FFC5C9443CA8CF719BC24B392D', '095757526B104477850B37B2F53057D3', '2', 'adsadasdada', '0', '精装礼盒');
INSERT INTO `cum` VALUES ('849D84655CA64BA9B15F1EE7C111546D', '100006', '1', 'adsadasdada', '0', '精装礼盒');
INSERT INTO `cum` VALUES ('98C23CB708AA4833A5C976318F665535', '100002', '1', '8FBE1D0877284CB19AFF324072479409', '0', '精装礼盒');
INSERT INTO `cum` VALUES ('E6C99D3528BC4FF2A4521F5919FF6149', '100001', '1', '8FBE1D0877284CB19AFF324072479409', '0', '精装礼盒');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `o_id` varchar(66) NOT NULL,
  `o_tdate` datetime NOT NULL,
  `o_money` double(255,0) NOT NULL,
  `u_id` varchar(66) NOT NULL,
  `o_statu` int(10) unsigned zerofill NOT NULL,
  `o_pdate` datetime DEFAULT NULL,
  `o_fdate` datetime DEFAULT NULL,
  `o_qdate` datetime DEFAULT NULL,
  `a_id` varchar(255) NOT NULL,
  PRIMARY KEY (`o_id`),
  KEY `uuu` (`u_id`),
  KEY `assd` (`a_id`),
  CONSTRAINT `assd` FOREIGN KEY (`a_id`) REFERENCES `admin` (`a_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `uuu` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('48842D1AFEA74464B19C3BC0A08B335A', '2015-11-13 17:09:33', '146', 'adsadasdada', '0000000004', '2015-11-13 17:09:48', '2015-11-13 17:17:28', '2015-11-13 17:30:41', '102');
INSERT INTO `orders` VALUES ('6282776BAB4745B6890861A858DE0D65', '2016-09-27 11:38:55', '693', '8FBE1D0877284CB19AFF324072479409', '0000000001', '2016-09-27 11:39:04', null, null, '101');
INSERT INTO `orders` VALUES ('DDA8F0E2542A4141B89136FFE890B1E2', '2015-11-13 17:11:44', '146', 'adsadasdada', '0000000000', null, null, '2015-11-13 17:30:56', '101');
INSERT INTO `orders` VALUES ('F7137C659CEF40E2AC1B9FB7D385418E', '2015-11-13 17:31:24', '1890', 'adsadasdada', '0000000001', '2015-11-13 17:31:33', null, '2015-11-13 17:32:42', '101');

-- ----------------------------
-- Table structure for ruku
-- ----------------------------
DROP TABLE IF EXISTS `ruku`;
CREATE TABLE `ruku` (
  `r_id` varchar(255) NOT NULL,
  `c_id` varchar(255) NOT NULL,
  `r_date` datetime NOT NULL,
  `r_num` int(11) NOT NULL,
  `a_id` varchar(66) NOT NULL,
  PRIMARY KEY (`r_id`),
  KEY `ccc` (`c_id`) USING BTREE,
  KEY `dwes` (`a_id`),
  CONSTRAINT `dwes` FOREIGN KEY (`a_id`) REFERENCES `admin` (`a_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rerew` FOREIGN KEY (`c_id`) REFERENCES `clothes` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ruku
-- ----------------------------
INSERT INTO `ruku` VALUES ('32323ERRERERER4343', '6739BDFC54624CB3B8CF3AC52E406CC8', '2015-07-13 20:53:02', '3443', '102');
INSERT INTO `ruku` VALUES ('343343434', '3B35CCF0F9244B6BAD5FA139CA037874', '2015-07-13 20:53:19', '344', '102');
INSERT INTO `ruku` VALUES ('34434', '6A473D2D651E49EE8AF57F5355C717B5', '2015-07-13 20:53:50', '656', '102');
INSERT INTO `ruku` VALUES ('4343RERER444434', 'EC68AF475776478FBDB52ED6E50B49E4', '2015-07-13 20:52:44', '323', '101');
INSERT INTO `ruku` VALUES ('434RERRER33', '4A096087B6AA45528F782E61EDFCFA3E', '2015-07-13 20:53:35', '43', '101');
INSERT INTO `ruku` VALUES ('ASSA3232DF', '52CFF2FEA84A4367A5B223619F1C7BC6', '2015-07-13 20:50:59', '3232', '102');
INSERT INTO `ruku` VALUES ('EWEWE3434334', 'B3BFB98EDB194B7A988DB879D40950E7', '2015-07-13 20:52:21', '4343', '101');
INSERT INTO `ruku` VALUES ('SASA321DD4454RR', '095757526B104477850B37B2F53057D3', '2015-07-13 20:44:47', '232', '102');
INSERT INTO `ruku` VALUES ('WQW232ERR44554TRT643', '43B8203F7A9740CBBC8E288EBA1F93B6', '2015-07-13 20:51:58', '434', '102');
INSERT INTO `ruku` VALUES ('WQW323232ERWEEWE', '3F04A2D4A15F4BCD82BDBA07072BAC43', '2015-07-13 20:51:22', '3232', '102');
INSERT INTO `ruku` VALUES ('WQW4343FFEERE', '2EC0DD7F98F2436CBDB4550B779534CF', '2015-07-13 20:45:46', '322', '102');

-- ----------------------------
-- Table structure for tui
-- ----------------------------
DROP TABLE IF EXISTS `tui`;
CREATE TABLE `tui` (
  `t_id` varchar(255) NOT NULL,
  `o_id` varchar(255) NOT NULL,
  `t_reson` varchar(255) NOT NULL,
  `a_id` varchar(255) NOT NULL,
  `t_date` datetime NOT NULL,
  `u_id` varchar(255) NOT NULL,
  `o_money` double NOT NULL,
  `t_odate` datetime NOT NULL,
  KEY `uuuis` (`a_id`),
  KEY `oooid` (`o_id`),
  KEY `uuuuid` (`u_id`),
  CONSTRAINT `oooid` FOREIGN KEY (`o_id`) REFERENCES `orders` (`o_id`) ON DELETE NO ACTION,
  CONSTRAINT `uuuis` FOREIGN KEY (`a_id`) REFERENCES `admin` (`a_id`),
  CONSTRAINT `uuuuid` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tui
-- ----------------------------
INSERT INTO `tui` VALUES ('38BAE84E175344BF9564861673583FCD', '48842D1AFEA74464B19C3BC0A08B335A', '不想买了', '102', '2015-11-13 17:30:11', 'adsadasdada', '146', '2015-11-13 17:34:11');
INSERT INTO `tui` VALUES ('B8E22E56D5F147B89779D8F9239743F6', '48842D1AFEA74464B19C3BC0A08B335A', '不想买了', '102', '2015-11-13 17:30:43', 'adsadasdada', '146', '2015-11-13 17:34:11');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` varchar(66) NOT NULL,
  `u_name` varchar(255) NOT NULL,
  `u_address` varchar(255) NOT NULL,
  `u_phone` varchar(255) NOT NULL,
  `u_code` varchar(255) NOT NULL,
  `u_mail` varchar(255) NOT NULL,
  `u_tax` varchar(255) NOT NULL,
  `u_bankname` varchar(255) NOT NULL,
  `u_banknum` varchar(255) NOT NULL,
  `u_glory` int(11) DEFAULT '1',
  `u_pw` varchar(255) NOT NULL,
  `u_sex` varchar(255) NOT NULL,
  `u_cmoney` double(255,0) DEFAULT '0',
  `u_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('8FBE1D0877284CB19AFF324072479409', 'alvin', 'gansu', '15769', '1234', 'jbw@qq.com', '1233', 'volvo', '622722199307302017', '1', '46F94C8DE14FB36680850768FF1B7F2A', '0', '1386', '');
INSERT INTO `user` VALUES ('adsadasdada', 'kevin', 'das', '213321312', '231312', 'jbw@qq.com', '213', '321321', '231', '1', 'jbw994730', 'm', '4072', 'sas');
