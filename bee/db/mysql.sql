/*
 Navicat Premium Data Transfer

 Source Server         : Datawisher
 Source Server Type    : MySQL
 Source Server Version : 50740 (5.7.40)
 Source Host           : 47.103.21.83:3306
 Source Schema         : bee

 Target Server Type    : MySQL
 Target Server Version : 50740 (5.7.40)
 File Encoding         : 65001

 Date: 10/12/2022 09:05:28
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`          bigint(20) NOT NULL,
    `username`    varchar(50)  DEFAULT NULL COMMENT '用户名',
    `password`    varchar(50)  DEFAULT NULL COMMENT '密码',
    `salt`        varchar(50)  DEFAULT NULL COMMENT '盐',
    `realname`    varchar(100) DEFAULT NULL COMMENT '姓名',
    `avatar`      varchar(255) DEFAULT NULL COMMENT '头像',
    `email`       varchar(50)  DEFAULT NULL COMMENT '邮箱',
    `mobile`      varchar(50)  DEFAULT NULL COMMENT '手机号',
    `status`      varchar(1) DEFAULT NULL COMMENT '账号状态（1:正常；2:锁定；3:首次注册）',
    `dept_code`   varchar(50)  DEFAULT NULL COMMENT '已登录部门',
    `create_by`   varchar(50)  DEFAULT NULL COMMENT '创建人',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(50)  DEFAULT NULL COMMENT '修改人',
    `update_time` datetime     DEFAULT NULL COMMENT '修改时间',
    `del_flag`    varchar(1)   DEFAULT NULL COMMENT '删除标记（0:未删除；1:已删除）',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

SET
FOREIGN_KEY_CHECKS = 1;
