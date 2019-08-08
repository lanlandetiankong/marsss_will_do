/*
Navicat MySQL Data Transfer

Source Server         : myblog
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : mars_will_do

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-08-08 21:51:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity_project
-- ----------------------------
DROP TABLE IF EXISTS `activity_project`;
CREATE TABLE `activity_project` (
  `activity_project_id` varchar(36) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `user_account_id` varchar(36) DEFAULT NULL,
  `base_type` int(11) DEFAULT NULL,
  `group_id` varchar(36) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `goal` varchar(255) DEFAULT NULL COMMENT '目标',
  `hurry_level` varchar(36) DEFAULT NULL COMMENT '项目紧急级别',
  `first_note` varchar(255) DEFAULT NULL,
  `second_note` varchar(255) DEFAULT NULL,
  `description` varchar(255) NOT NULL COMMENT '描述',
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `is_translate_archive` int(11) DEFAULT NULL,
  `archive_project_id` varchar(36) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`activity_project_id`),
  KEY `FK5kvakg3p4jf6shfbe5t542dep` (`user_account_id`),
  KEY `FKbtr7u64qp9iqk64fo6lytmi97` (`archive_project_id`),
  CONSTRAINT `FK5kvakg3p4jf6shfbe5t542dep` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`user_account_id`),
  CONSTRAINT `FKbtr7u64qp9iqk64fo6lytmi97` FOREIGN KEY (`archive_project_id`) REFERENCES `archive_project` (`archive_project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for archive_project
-- ----------------------------
DROP TABLE IF EXISTS `archive_project`;
CREATE TABLE `archive_project` (
  `archive_project_id` varchar(36) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `user_account_id` varchar(36) DEFAULT NULL,
  `base_type` int(11) DEFAULT NULL,
  `group_id` varchar(36) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `goal` varchar(255) DEFAULT NULL COMMENT '目标',
  `hurry_level` varchar(36) DEFAULT NULL COMMENT '项目紧急级别',
  `first_note` varchar(255) DEFAULT NULL,
  `second_note` varchar(255) DEFAULT NULL,
  `description` varchar(255) NOT NULL COMMENT '描述',
  `activity_project_id` varchar(36) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`archive_project_id`),
  KEY `FK9gsfl6uphlgyt0g3dta03ufnw` (`user_account_id`),
  KEY `FKrjgpmrtgrlluw3n5pnvs9jmg7` (`activity_project_id`),
  CONSTRAINT `FK9gsfl6uphlgyt0g3dta03ufnw` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`user_account_id`),
  CONSTRAINT `FKrjgpmrtgrlluw3n5pnvs9jmg7` FOREIGN KEY (`activity_project_id`) REFERENCES `activity_project` (`activity_project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for short_note
-- ----------------------------
DROP TABLE IF EXISTS `short_note`;
CREATE TABLE `short_note` (
  `short_note_id` varchar(36) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `user_account_id` varchar(36) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`short_note_id`),
  KEY `FKt2s97vtvfa940yn3xl3lyjxk6` (`user_account_id`),
  CONSTRAINT `FKt2s97vtvfa940yn3xl3lyjxk6` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`user_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sub_task
-- ----------------------------
DROP TABLE IF EXISTS `sub_task`;
CREATE TABLE `sub_task` (
  `sub_task_id` varchar(36) NOT NULL,
  `task_id` varchar(36) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `refer_user_name` varchar(255) DEFAULT NULL COMMENT '相关人员',
  `first_note` varchar(255) DEFAULT NULL,
  `user_account_id` varchar(36) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sub_task_id`),
  KEY `FKdytg4t1ohm3qxnshcyxu54f7t` (`task_id`),
  CONSTRAINT `FKdytg4t1ohm3qxnshcyxu54f7t` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='子任务';

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `tag_id` varchar(36) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `level` varchar(36) DEFAULT NULL,
  `user_account_id` varchar(36) DEFAULT NULL,
  `first_note` varchar(255) DEFAULT NULL,
  `second_note` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tag_id`),
  KEY `FKp4e03k8tlu677vvpr4t4n2ejm` (`user_account_id`),
  CONSTRAINT `FKp4e03k8tlu677vvpr4t4n2ejm` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`user_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `task_id` varchar(255) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `name_spell` varchar(255) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `user_account_id` varchar(36) DEFAULT NULL,
  `presenter` varchar(255) DEFAULT NULL COMMENT '提出者',
  `participant` varchar(255) DEFAULT NULL COMMENT '参与人员',
  `task_level` int(11) DEFAULT NULL,
  `activity_project_id` varchar(255) DEFAULT NULL,
  `archive_project_id` varchar(255) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `first_note` varchar(255) DEFAULT NULL,
  `second_note` varchar(255) DEFAULT NULL,
  `third_note` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `progress_id` varchar(255) DEFAULT NULL COMMENT '进度百分比',
  `plan_start_date` datetime DEFAULT NULL,
  `plan_end_date` datetime DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `FKto9xkijvkiwmhl99h15cmwbwo` (`activity_project_id`),
  KEY `FKsp7ylohemr8a0k9uelbi0cg7w` (`archive_project_id`),
  KEY `FK601krw26erdx8adq49hsjhpwq` (`user_account_id`),
  CONSTRAINT `FK601krw26erdx8adq49hsjhpwq` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`user_account_id`),
  CONSTRAINT `FKsp7ylohemr8a0k9uelbi0cg7w` FOREIGN KEY (`archive_project_id`) REFERENCES `archive_project` (`archive_project_id`),
  CONSTRAINT `FKto9xkijvkiwmhl99h15cmwbwo` FOREIGN KEY (`activity_project_id`) REFERENCES `activity_project` (`activity_project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for task_tag
-- ----------------------------
DROP TABLE IF EXISTS `task_tag`;
CREATE TABLE `task_tag` (
  `task_tag_id` varchar(36) NOT NULL,
  `task_id` varchar(36) DEFAULT NULL,
  `tag_id` varchar(36) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`task_tag_id`),
  KEY `FK9mp6455j6w7duvlo9cwok7s6j` (`tag_id`),
  KEY `FKmnb6mkxwtvkg1utqig0ps56ne` (`task_id`),
  CONSTRAINT `FK9mp6455j6w7duvlo9cwok7s6j` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`),
  CONSTRAINT `FKmnb6mkxwtvkg1utqig0ps56ne` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `user_account_id` char(36) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  `user_name_spell` varchar(200) DEFAULT NULL,
  `nick_name_spell` varchar(200) DEFAULT NULL,
  `account` varchar(50) DEFAULT NULL,
  `salt` varchar(36) DEFAULT NULL,
  `password` varchar(36) DEFAULT NULL,
  `user_account_info_id` varchar(36) NOT NULL,
  `sex` int(11) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `base_type` int(255) DEFAULT NULL,
  `register_type` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_account_id`),
  KEY `FK8h8srek1crqquw74hj0vowjip` (`user_account_info_id`),
  CONSTRAINT `FK8h8srek1crqquw74hj0vowjip` FOREIGN KEY (`user_account_info_id`) REFERENCES `user_account_info` (`user_account_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_account_info
-- ----------------------------
DROP TABLE IF EXISTS `user_account_info`;
CREATE TABLE `user_account_info` (
  `user_account_info_id` char(36) NOT NULL,
  `intro` varchar(100) DEFAULT NULL,
  `head_protrait` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_account_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
