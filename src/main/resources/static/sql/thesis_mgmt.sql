/*
 Navicat Premium Data Transfer

 Source Server         : MySQL80
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : thesis_mgmt

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 23/06/2023 13:49:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'student', '学生', '2023-06-21 20:02:17', '2023-06-22 21:49:09', 0);
INSERT INTO `sys_role` VALUES (2, 'teacher', '教师', '2023-06-21 20:08:22', '2023-06-22 21:49:10', 0);
INSERT INTO `sys_role` VALUES (3, 'administrator', '管理员', '2023-06-21 20:31:37', '2023-06-23 08:56:57', 0);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '密码',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `tel` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机',
  `gender` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `role_id` bigint NOT NULL COMMENT '角色id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'pycro', 'e10adc3949ba59abbe56e057f20f883e', '派可若', '19876543210', '男', 1, '2023-06-22 22:58:07', '2023-06-23 11:07:17', 0);
INSERT INTO `sys_user` VALUES (2, 'kight', 'e10adc3949ba59abbe56e057f20f883e', '凯特', '19876543211', '男', 1, '2023-06-22 23:02:16', '2023-06-23 11:06:30', 0);
INSERT INTO `sys_user` VALUES (3, 'barbatos', 'e10adc3949ba59abbe56e057f20f883e', '巴巴托斯', '19876543212', '男', 1, '2023-06-22 23:12:03', '2023-06-23 11:06:31', 0);
INSERT INTO `sys_user` VALUES (4, 'morax', 'e10adc3949ba59abbe56e057f20f883e', '摩拉克斯', '19876543213', '男', 2, '2023-06-22 23:13:12', '2023-06-23 11:06:33', 0);
INSERT INTO `sys_user` VALUES (5, 'balzeb', 'e10adc3949ba59abbe56e057f20f883e', '巴尔泽布', '19876543214', '女', 2, '2023-06-22 23:17:03', '2023-06-23 10:58:03', 0);
INSERT INTO `sys_user` VALUES (6, 'bouyer', 'e10adc3949ba59abbe56e057f20f883e', '布耶尔', '19876543215', '女', 1, '2023-06-22 23:17:29', '2023-06-23 11:06:35', 0);
INSERT INTO `sys_user` VALUES (7, 'Fkarus', 'e10adc3949ba59abbe56e057f20f883e', '芙卡洛斯', '19876543216', '女', 2, '2023-06-23 10:47:59', '2023-06-23 11:06:36', 0);

SET FOREIGN_KEY_CHECKS = 1;
