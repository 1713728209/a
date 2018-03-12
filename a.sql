/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.40 : Database - a
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`a` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `a`;

/*Table structure for table `cartitem` */

DROP TABLE IF EXISTS `cartitem`;

CREATE TABLE `cartitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `number` int(11) NOT NULL DEFAULT '0',
  `sum` decimal(10,2) NOT NULL DEFAULT '0.00',
  `deleteAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cartitem_product` (`pid`),
  KEY `fk_cartitem_user` (`uid`),
  CONSTRAINT `fk_cartitem_product` FOREIGN KEY (`pid`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_cartitem_user` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `cartitem` */

insert  into `cartitem`(`id`,`uid`,`pid`,`number`,`sum`,`deleteAt`) values (2,3,1,1,'1800.00',NULL),(3,7,6,1,'500.00',NULL),(4,8,10,2,'1250.00',NULL),(5,8,6,1,'1600.00',NULL),(7,9,8,1,'0.00',NULL),(8,9,12,3,'0.00',NULL),(9,4,3,4,'0.00',NULL),(10,2,14,10,'0.00',NULL),(11,5,8,2,'0.00',NULL),(12,11,13,10,'0.00',NULL),(13,10,6,2,'0.00',NULL),(14,4,12,3,'0.00',NULL),(15,5,6,4,'0.00',NULL),(16,1,10,6,'0.00',NULL),(17,1,5,2,'0.00',NULL),(18,1,5,5,'0.00',NULL),(19,1,6,8,'0.00',NULL),(20,1,8,8,'0.00',NULL),(21,1,7,1,'0.00',NULL),(22,1,6,5,'0.00',NULL),(23,1,3,5,'0.00',NULL),(24,1,10,7,'0.00',NULL);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `recommend` int(11) NOT NULL DEFAULT '0',
  `deleteAt` datetime DEFAULT NULL,
  `imgPath` mediumblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`name`,`recommend`,`deleteAt`,`imgPath`) values (1,'服装',10,NULL,''),(2,'电器',2,'2018-03-03 22:24:35',NULL),(3,'家用',3,NULL,NULL),(4,'食品',1,NULL,NULL),(5,'娱乐',2,'2018-03-08 22:24:31',NULL),(6,'医药',2,NULL,NULL),(7,'运动',1,NULL,NULL),(8,'手机',1,NULL,'WIN_20170514_132356.JPG'),(10,'乐器',5,NULL,'WIN_20170416_191835.JPG'),(14,'美妆 ',0,NULL,NULL),(15,'保健品',0,NULL,NULL),(16,'洗护 ',0,NULL,NULL);

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `content` text,
  `createDate` datetime DEFAULT NULL,
  `deleteAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_product` (`pid`),
  KEY `fk_comment_user` (`uid`),
  CONSTRAINT `fk_comment_product` FOREIGN KEY (`pid`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_comment_user` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`id`,`pid`,`uid`,`content`,`createDate`,`deleteAt`) values (1,1,1,'面料很舒服，棒棒的，穿着很修身，下回还来光顾！','2018-06-01 22:44:38',NULL),(2,1,1,'物美价廉，很不错','2018-03-02 22:45:30',NULL),(3,1,1,'稍稍能肥一点，还不错，穿上挺韩范的','2018-03-01 22:45:27',NULL),(4,1,4,'买的时候有点怀疑，可没有想到打开上身真的合适，衣服太棒了，下次再来。。','2018-03-08 22:46:59',NULL),(5,1,2,'衣服满意，大小合适，170/66kgM码','2018-03-08 22:46:56',NULL),(6,1,5,'宝贝已再一次给买，样品宝贝与图片完全相符无色差，耐洗，不变形不缩水，值得点赞，好评五分，','2018-03-08 22:47:29',NULL),(7,1,6,'第二次购买 就是快递很慢','2018-03-08 22:47:58',NULL),(8,1,9,'第二次购买 就是快递很慢','2018-03-17 22:48:16',NULL),(9,3,6,'支持佛山本土潮牌！！就是153小个子穿上可能会有点长，质量挺好的','2018-03-08 22:52:06',NULL),(10,3,8,'觉得买大左 不过还ok啦 宽松又可以着好多衫系入边 冬天暖粒粒哈哈','2018-03-08 22:52:50',NULL),(11,5,5,'这个印花 我做好了把它当一次性衣服穿的准备','2018-03-08 22:53:17',NULL),(12,5,3,'卫衣很舒服，内有加绒，但就是有点吸毛，衣服尾边的那层布料不太好，太软，没有质感','2018-03-08 22:54:35',NULL),(13,4,2,'卫衣很舒服，内有加绒，但就是有点吸毛，衣服尾边的那层布料不太好，太软，没有质感','2018-03-08 22:54:38',NULL),(14,4,3,'卫衣很舒服，内有加绒，但就是有点吸毛，衣服尾边的那层布料不太好，太软，没有质感','2018-03-02 22:54:32',NULL),(15,6,5,'觉得买大左 不过还ok啦 宽松又可以着好多衫系入边 冬天暖粒粒哈哈',NULL,NULL),(16,7,4,'觉得买大左 不过还ok啦 宽松又可以着好多衫系入边 冬天暖粒粒哈哈',NULL,NULL),(17,8,3,'觉得买大左 不过还ok啦 宽松又可以着好多衫系入边 冬天暖粒粒哈哈',NULL,NULL),(18,9,3,'觉得买大左 不过还ok啦 宽松又可以着好多衫系入边 冬天暖粒粒哈哈',NULL,NULL),(19,10,2,'觉得买大左 不过还ok啦 宽松又可以着好多衫系入边 冬天暖粒粒哈哈',NULL,NULL),(20,11,4,'觉得买大左 不过还ok啦 宽松又可以着好多衫系入边 冬天暖粒粒哈哈',NULL,NULL),(21,12,7,'觉得买大左 不过还ok啦 宽松又可以着好多衫系入边 冬天暖粒粒哈哈',NULL,NULL),(22,13,9,'觉得买大左 不过还ok啦 宽松又可以着好多衫系入边 冬天暖粒粒哈哈',NULL,NULL),(23,14,8,'觉得买大左 不过还ok啦 宽松又可以着好多衫系入边 冬天暖粒粒哈哈',NULL,NULL),(24,15,4,'觉得买大左 不过还ok啦 宽松又可以着好多衫系入边 冬天暖粒粒哈哈',NULL,NULL),(27,15,10,'觉得买大左 不过还ok啦 宽松又可以着好多衫系入边 冬天暖粒粒哈哈',NULL,NULL),(28,6,1,'id为10的商品添加了评价','2018-03-12 09:38:39',NULL),(29,6,1,'id为10的商品添加了评价','2018-03-12 09:41:45',NULL),(30,6,1,'oid=1&pid=6','2018-03-12 10:32:52',NULL);

/*Table structure for table `config` */

DROP TABLE IF EXISTS `config`;

CREATE TABLE `config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `cname` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `rate` int(11) NOT NULL DEFAULT '0',
  `deleteAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `config` */

insert  into `config`(`id`,`name`,`cname`,`value`,`rate`,`deleteAt`) values (1,'website_name','网站名称','小小商城',100,NULL),(2,'index_description','首页描述','小小商城是我的一个非常小巧轻便的商城系统',50,NULL),(3,'index_keyword','首页关键词','小小商城,商超系统',25,NULL),(4,'index_title','首页标题','小小商城——基于Java的商城项目实践',12,NULL),(5,'path_product_img','产品图片存放目录','pictures/product/',6,NULL),(6,'path_category_img','分类图片存放目录','pictures/category/',5,NULL);

/*Table structure for table `order_` */

DROP TABLE IF EXISTS `order_`;

CREATE TABLE `order_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `orderCode` varchar(255) NOT NULL DEFAULT '',
  `sum` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `totalNumber` int(11) unsigned NOT NULL DEFAULT '0',
  `address` varchar(255) DEFAULT '',
  `post` varchar(255) DEFAULT '',
  `receiver` varchar(255) DEFAULT '',
  `mobile` varchar(255) DEFAULT '',
  `userMessage` varchar(255) DEFAULT '',
  `createDate` datetime DEFAULT NULL,
  `payDate` datetime DEFAULT NULL,
  `deliverDate` datetime DEFAULT NULL,
  `confirmDate` datetime DEFAULT NULL,
  `status` int(255) DEFAULT NULL COMMENT '0：未发货，1：已发货，2：已接收，3：已结账,5:等待评论，4：已完成订单，6：评论完成',
  `deleteAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_user` (`uid`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `order_` */

insert  into `order_`(`id`,`uid`,`orderCode`,`sum`,`totalNumber`,`address`,`post`,`receiver`,`mobile`,`userMessage`,`createDate`,`payDate`,`deliverDate`,`confirmDate`,`status`,`deleteAt`) values (1,1,'564155655312353253','0.00',3,'湖北武汉','','张三','1546151311','','2018-03-10 17:30:29','2018-03-11 17:30:31','2018-03-15 17:30:36','2018-03-15 17:30:54',6,NULL),(2,1,'345345345345345345','0.00',2,'湖北汉川','','历史','54354345345','','2018-03-03 17:33:59','2018-03-10 17:34:02','2018-03-10 17:34:04','2018-03-10 17:34:06',4,NULL),(3,1,'543453453453453453453','0.00',1,'湖北孝感','','王五','435434534','','2018-03-10 17:34:27','2018-03-10 17:34:44','2018-03-30 17:34:46','2018-03-24 17:34:50',3,NULL),(4,1,'345345345242424523','0.00',4,'湖北武汉江岸区','','赵六','65156541','','2018-03-10 17:35:47',NULL,'2018-03-16 17:35:52',NULL,3,NULL),(5,2,'453453453453422131321','0.00',4,'湖北武汉洪山区','','王麻子','757657','','2018-03-10 17:36:40',NULL,'2018-03-23 17:36:44',NULL,1,NULL),(6,5,'45654642425423453','0.00',6,'湖北武汉洪山区','','敖德萨','43543','','2018-03-10 17:37:36',NULL,'2018-03-16 17:37:42',NULL,2,NULL),(7,7,'12321345234523453','0.00',3,'湖北武汉洪山区','','啊是的个地方广泛的','3767857458','','2018-03-10 17:38:36',NULL,'2018-03-30 17:38:42',NULL,6,NULL),(9,1,'42324345234345','0.00',2,'湖北武汉洪山区','','赵倩','1256165','',NULL,NULL,NULL,NULL,4,NULL),(10,1,'4354354324343453','0.00',1,'湖北武汉洪山区','','孙俪','165496856','',NULL,NULL,NULL,NULL,5,NULL),(11,1,'4354534532423452354','0.00',4,'湖北武汉洪山区','','高清','214151515','',NULL,NULL,NULL,NULL,1,NULL),(12,1,'34534523423135745345','0.00',2,'湖北武汉洪山区','','浩气','156415156','',NULL,NULL,NULL,NULL,0,NULL);

/*Table structure for table `orderitem` */

DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `oid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `cmid` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT '0',
  `sum` decimal(10,2) DEFAULT '0.00',
  `deleteAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_orderitem_product` (`pid`),
  KEY `fk_orderitem_order` (`oid`),
  KEY `fk_orderitem_comment` (`cmid`),
  CONSTRAINT `fk_orderitem_comment` FOREIGN KEY (`cmid`) REFERENCES `comment` (`id`),
  CONSTRAINT `fk_orderitem_order` FOREIGN KEY (`oid`) REFERENCES `order_` (`id`),
  CONSTRAINT `fk_orderitem_product` FOREIGN KEY (`pid`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `orderitem` */

insert  into `orderitem`(`id`,`oid`,`pid`,`cmid`,`number`,`sum`,`deleteAt`) values (1,1,6,1,1,'0.00',NULL),(2,1,9,7,1,'0.00',NULL),(3,1,10,10,1,'0.00',NULL),(4,6,5,6,4,'0.00',NULL),(5,6,3,4,1,'0.00',NULL),(6,5,5,11,1,'0.00',NULL),(7,3,6,12,5,'0.00',NULL),(8,2,12,3,2,'0.00',NULL),(9,4,1,10,2,'0.00',NULL),(10,7,10,12,2,'0.00',NULL),(12,3,13,12,3,'0.00',NULL),(13,3,12,8,1,'0.00',NULL),(16,9,10,12,2,'0.00',NULL),(17,10,6,17,2,'0.00',NULL),(18,11,10,5,5,'0.00',NULL),(19,12,9,14,8,'0.00',NULL),(20,7,6,29,1,NULL,NULL),(21,1,6,30,1,NULL,NULL);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL DEFAULT '',
  `subTitle` varchar(255) NOT NULL DEFAULT '',
  `originalPrice` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `nowPrice` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `stock` int(11) unsigned NOT NULL DEFAULT '0',
  `imgid` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `commentCount` int(11) DEFAULT '0',
  `saleCount` int(11) DEFAULT '0',
  `deleteAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_category` (`cid`),
  KEY `fk_product_product_image` (`imgid`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`cid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`cid`,`name`,`subTitle`,`originalPrice`,`nowPrice`,`stock`,`imgid`,`createDate`,`commentCount`,`saleCount`,`deleteAt`) values (1,1,'男士休闲上衣','男士休闲上衣','300.00','200.00',2200,NULL,NULL,8,1021,'2018-03-11 12:11:49'),(3,2,'华硕笔记本','华硕笔记本','3000.00','4000.00',2,2,'2018-03-08 22:28:09',0,301,NULL),(4,1,'男士纯色V领全棉开衫韩版修身薄毛','男士纯色V领全棉开衫韩版修身薄毛','600.00','500.00',2200,NULL,NULL,2,620,NULL),(5,1,'青年麻花纯棉针织衫','青年麻花纯棉针织衫','300.00','250.00',0,NULL,'2018-03-08 22:31:54',2,421,NULL),(6,1,'2018春夏新品','2018春夏新品','250.00','200.00',12,NULL,'2018-03-08 22:32:48',4,652,NULL),(7,1,' 青春流行',' 青春流行','1000.00','800.00',0,NULL,'2018-03-07 22:35:18',1,952,NULL),(8,1,'夏季男士冰丝V领','夏季男士冰丝V领','620.00','400.00',25,NULL,'2018-03-01 22:34:32',1,320,NULL),(9,1,'2018春装 男士韩','2018春装 男士韩','620.00','500.00',0,NULL,'2018-03-08 22:35:04',1,9852,NULL),(10,1,'男士黑白细条纹短','男士黑白细条纹短','200.00','300.00',10,NULL,'2018-03-08 22:35:52',1,6521,NULL),(11,3,'花湖牌吸尘器','花湖牌吸尘器','2300.00','2000.00',0,NULL,'2018-03-08 22:36:39',1,200,NULL),(12,4,'大闸蟹','大闸蟹','680.00','500.00',85,NULL,'2018-03-08 22:37:13',1,350,NULL),(13,5,'唱片','唱片','100.00','120.00',0,NULL,'2018-03-08 22:38:03',0,600000,NULL),(14,6,'999感冒灵','999感冒灵','60.00','40.00',0,NULL,'2018-03-08 22:38:40',0,4500000,NULL),(15,7,'鲨鱼牌游泳衣','鲨鱼牌游泳衣','25000.00','26000.00',0,NULL,'2018-03-08 22:39:19',0,600,NULL);

/*Table structure for table `product_image` */

DROP TABLE IF EXISTS `product_image`;

CREATE TABLE `product_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '1:封面图片，2：顶部图片，3：详情图片',
  `deleteAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_image` (`pid`),
  CONSTRAINT `fk_product_image` FOREIGN KEY (`pid`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `product_image` */

insert  into `product_image`(`id`,`pid`,`type`,`deleteAt`) values (1,1,'1',NULL),(2,1,'3',NULL),(3,1,'2',NULL),(4,1,'3',NULL),(5,3,'2',NULL),(6,3,'2',NULL),(7,3,'1',NULL),(8,3,'3',NULL),(9,3,'3',NULL),(10,3,'3',NULL),(11,3,'3',NULL),(14,4,'3',NULL),(15,3,'2',NULL),(16,3,'1',NULL),(17,3,'2',NULL),(22,1,'2',NULL),(23,1,'2',NULL),(24,1,'1',NULL),(25,1,'1',NULL),(26,1,'2',NULL);

/*Table structure for table `property` */

DROP TABLE IF EXISTS `property`;

CREATE TABLE `property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL DEFAULT '',
  `deleteAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_property_category` (`cid`),
  CONSTRAINT `fk_property_category` FOREIGN KEY (`cid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `property` */

insert  into `property`(`id`,`cid`,`name`,`deleteAt`) values (3,1,'num',NULL),(4,2,'size',NULL),(5,2,'price',NULL),(6,2,'num',NULL),(8,3,'num',NULL),(9,3,'price',NULL),(10,4,'num',NULL),(11,4,'price',NULL),(12,4,'size',NULL),(13,5,'num',NULL),(14,5,'price',NULL),(15,5,'size',NULL),(16,1,'production date',NULL),(17,1,'cnm',NULL),(18,1,'type',NULL),(19,1,'type',NULL),(20,1,'type',NULL),(21,1,'type',NULL);

/*Table structure for table `property_value` */

DROP TABLE IF EXISTS `property_value`;

CREATE TABLE `property_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `ptid` int(11) DEFAULT NULL,
  `value` varchar(255) NOT NULL DEFAULT '',
  `deleteAt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_property_value_property` (`ptid`),
  KEY `fk_property_value_product` (`pid`),
  CONSTRAINT `fk_property_value_product` FOREIGN KEY (`pid`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_property_value_property` FOREIGN KEY (`ptid`) REFERENCES `property` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `property_value` */

insert  into `property_value`(`id`,`pid`,`ptid`,`value`,`deleteAt`) values (3,1,3,'182',NULL),(6,3,3,'200',NULL),(9,4,3,'500',NULL),(12,5,3,'1200',NULL),(18,1,5,'45',NULL),(19,1,3,'24',NULL),(20,1,3,'5454',NULL),(21,1,4,'5252',NULL),(22,1,5,'21',NULL),(23,1,6,'1212',NULL),(24,1,3,'5525',NULL),(25,1,17,'121',NULL),(26,1,5,'1212',NULL),(27,1,11,'121',NULL),(28,1,15,'424242',NULL),(29,6,3,'45',NULL),(30,1,16,'',NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT '',
  `password` varchar(255) DEFAULT '',
  `group_` varchar(255) NOT NULL DEFAULT 'user',
  `deleteAt` datetime DEFAULT NULL,
  `USERDOMAIN` varchar(255) DEFAULT NULL COMMENT '用户设备的类型',
  `USERNAME` varchar(255) DEFAULT NULL COMMENT '用户设备的名称',
  PRIMARY KEY (`id`,`group_`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`group_`,`deleteAt`,`USERDOMAIN`,`USERNAME`) values (1,'admin','e10adc3949ba59abbe56e057f20f883e','superAdmin',NULL,'asus-pc','asus'),(2,'zhangsan','e10adc3949ba59abbe56e057f20f883e','admin',NULL,'asus-pc','asus'),(3,'lishi','e10adc3949ba59abbe56e057f20f883e','user',NULL,'asus-pc','asus'),(4,'wangwu','e10adc3949ba59abbe56e057f20f883e','user',NULL,'asus-pc','asus'),(5,'zhaoliu','e10adc3949ba59abbe56e057f20f883e','user',NULL,'asus-pc','asus'),(6,'wangmazi','e10adc3949ba59abbe56e057f20f883e','user',NULL,'asus-pc','asus'),(7,'zhaoqian','e10adc3949ba59abbe56e057f20f883e','user',NULL,'asus-pc','asus'),(8,'shunli','e10adc3949ba59abbe56e057f20f883e','user',NULL,'asus-pc','asus'),(9,'weige','e10adc3949ba59abbe56e057f20f883e','user',NULL,'asus-pc','asus'),(10,'maigege','e10adc3949ba59abbe56e057f20f883e','user',NULL,'asus-pc','asus'),(11,'caochao','e10adc3949ba59abbe56e057f20f883e','user',NULL,'asus-pc','asus'),(12,'hugei','e35cf7b66449df565f93c607d5a81d09','user',NULL,'asus-pc','asus'),(13,'hugei','e35cf7b66449df565f93c607d5a81d09','user',NULL,'asus-pc','asus'),(14,'hugei','e35cf7b66449df565f93c607d5a81d09','user',NULL,'asus-pc','asus'),(15,'hugei','e35cf7b66449df565f93c607d5a81d09','user',NULL,'asus-pc','asus'),(16,'hugei','e35cf7b66449df565f93c607d5a81d09','user',NULL,'asus-pc','asus');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
