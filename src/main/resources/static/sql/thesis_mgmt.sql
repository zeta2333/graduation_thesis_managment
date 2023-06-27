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

 Date: 27/06/2023 11:58:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_administrator
-- ----------------------------
DROP TABLE IF EXISTS `sys_administrator`;
CREATE TABLE `sys_administrator`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint NOT NULL DEFAULT 0 COMMENT '用户id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_administrator
-- ----------------------------
INSERT INTO `sys_administrator` VALUES (1, 8, '2023-06-24 08:36:12', '2023-06-24 08:36:12', 0);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` bigint NOT NULL DEFAULT 0 COMMENT '上层 目录id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '名称',
  `type` int NOT NULL COMMENT '类型(0：目录，1：菜单）',
  `path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由地址',
  `component` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件路径',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图标',
  `sort_value` int NULL DEFAULT NULL COMMENT '排序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (2, 0, '系统管理', 0, 'system', 'Layout', 'el-icon-s-tools', 1, '2023-06-25 09:15:04', '2023-06-25 09:15:36', 0);
INSERT INTO `sys_menu` VALUES (3, 2, '用户管理', 1, 'sysUser', 'system/sysUser/list', 'el-icon-s-custom', 1, '2023-06-24 17:57:10', '2023-06-26 16:42:22', 0);
INSERT INTO `sys_menu` VALUES (4, 2, '教师管理', 1, 'sysTeacher', 'system/sysTeacher/list', 'el-icon-star-off', 2, '2023-06-24 17:50:13', '2023-06-26 16:42:22', 0);
INSERT INTO `sys_menu` VALUES (5, 2, '学生管理', 1, 'sysStudent', 'system/sysStudent/list', 'el-icon-star-on', 3, '2023-06-24 17:57:38', '2023-06-26 16:42:23', 0);
INSERT INTO `sys_menu` VALUES (6, 2, '课题管理', 1, 'sysProjectConfirm', 'system/sysProjectConfirm/list', 'el-icon-finished', 4, '2023-06-25 09:25:16', '2023-06-26 18:07:41', 0);
INSERT INTO `sys_menu` VALUES (7, 2, '课题选择', 1, 'sysProjectSelect', 'system/sysProjectSelect/list', 'el-icon-s-claim', 1, '2023-06-25 09:25:57', '2023-06-26 16:28:26', 0);
INSERT INTO `sys_menu` VALUES (8, 2, '流程管理', 1, 'sysProcess', 'system/sysProcess/list', 'el-icon-s-management', 2, '2023-06-25 09:26:03', '2023-06-26 16:21:42', 0);
INSERT INTO `sys_menu` VALUES (9, 2, '成绩查询', 1, 'sysSearchGrade', 'system/sysSearchGrade/list', 'el-icon-edit', 3, '2023-06-25 09:26:07', '2023-06-26 16:26:43', 0);
INSERT INTO `sys_menu` VALUES (11, 2, '课题申报', 1, 'sysProject', 'system/sysProject/list', 'el-icon-edit', 1, '2023-06-25 09:36:49', '2023-06-26 16:30:00', 0);
INSERT INTO `sys_menu` VALUES (12, 2, '流程管理', 1, 'sysProcessCopy', 'system/sysProcessCopy/list', 'el-icon-s-management', 2, '2023-06-25 09:37:15', '2023-06-26 16:22:00', 0);
INSERT INTO `sys_menu` VALUES (13, 2, '成绩评定', 1, 'sysGrade', 'system/sysGrade/list', 'el-icon-tickets', 3, '2023-06-25 09:37:30', '2023-06-26 16:26:31', 0);
INSERT INTO `sys_menu` VALUES (16, 2, '用户信息', 1, 'sysInformation', 'system/sysInformation/list', 'el-icon-user', 0, '2023-06-26 16:22:45', '2023-06-26 16:42:20', 0);

-- ----------------------------
-- Table structure for sys_paper
-- ----------------------------
DROP TABLE IF EXISTS `sys_paper`;
CREATE TABLE `sys_paper`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `paper_title` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '论文标题',
  `paper_path` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '论文路径',
  `student_id` bigint NOT NULL DEFAULT 0 COMMENT '作者id',
  `paper_status` tinyint NOT NULL DEFAULT 0 COMMENT '论文状态（1：开题报告，2：期中小结，3：论文初稿）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '论文' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_paper
-- ----------------------------
INSERT INTO `sys_paper` VALUES (1, '布耶尔的论文', '布耶尔的论文.txt', 4, 1, '2023-06-27 10:47:09', '2023-06-27 11:51:52', 0);
INSERT INTO `sys_paper` VALUES (2, 'article', 'article.md', 1, 1, '2023-06-27 11:16:03', '2023-06-27 11:16:03', 0);
INSERT INTO `sys_paper` VALUES (3, '凯特的论文', '凯特的论文.txt', 2, 1, '2023-06-27 11:28:25', '2023-06-27 11:52:28', 0);
INSERT INTO `sys_paper` VALUES (4, '派克若的论文', '派克若的论文.txt', 1, 1, '2023-06-27 11:46:19', '2023-06-27 11:53:06', 0);

-- ----------------------------
-- Table structure for sys_project
-- ----------------------------
DROP TABLE IF EXISTS `sys_project`;
CREATE TABLE `sys_project`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `project_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '课题名称',
  `teacher_id` bigint NOT NULL DEFAULT 0 COMMENT '所属教师id',
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '<...课题描述...>' COMMENT '课题描述',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT '课题状态（0：无人选择，1：有人选择）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '课题' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_project
-- ----------------------------
INSERT INTO `sys_project` VALUES (1, '基于神经网络的自然语言处理技术研究', 2, '神经网络、自然语言处理、语言模型、条件生成模型', 0, '2023-06-24 08:41:37', '2023-06-24 08:41:37', 0);
INSERT INTO `sys_project` VALUES (2, '面向云计算环境的安全性和可靠性研究', 1, '云计算、数据加密、虚拟化安全、多租户隔离', 0, '2023-06-24 08:44:13', '2023-06-24 08:44:13', 0);
INSERT INTO `sys_project` VALUES (3, '微电子与集成电路设计', 3, '微电子技术、高集成度电路、物联网芯片、射频集成电路', 0, '2023-06-24 08:46:12', '2023-06-24 08:46:12', 0);
INSERT INTO `sys_project` VALUES (4, '分布式计算的并行化和优化', 1, '并行化、调度、优化', 0, '2023-06-26 17:38:41', '2023-06-26 17:38:41', 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'student', '学生', '2023-06-21 20:02:17', '2023-06-22 21:49:09', 0);
INSERT INTO `sys_role` VALUES (2, 'teacher', '教师', '2023-06-21 20:08:22', '2023-06-22 21:49:10', 0);
INSERT INTO `sys_role` VALUES (3, 'administrator', '管理员', '2023-06-21 20:31:37', '2023-06-23 08:56:57', 0);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint NOT NULL DEFAULT 0 COMMENT '角色id',
  `menu_id` bigint NOT NULL DEFAULT 0 COMMENT '菜单id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色菜单关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 3, 2, '2023-06-24 18:27:08', '2023-06-25 09:41:37', 0);
INSERT INTO `sys_role_menu` VALUES (2, 3, 3, '2023-06-24 18:27:13', '2023-06-25 09:41:38', 0);
INSERT INTO `sys_role_menu` VALUES (3, 3, 4, '2023-06-24 18:27:17', '2023-06-25 09:41:38', 0);
INSERT INTO `sys_role_menu` VALUES (4, 3, 5, '2023-06-24 22:09:21', '2023-06-25 09:41:41', 0);
INSERT INTO `sys_role_menu` VALUES (5, 1, 2, '2023-06-25 09:41:59', '2023-06-25 10:18:53', 0);
INSERT INTO `sys_role_menu` VALUES (6, 1, 7, '2023-06-25 09:42:00', '2023-06-25 10:18:53', 0);
INSERT INTO `sys_role_menu` VALUES (7, 1, 8, '2023-06-25 09:42:01', '2023-06-25 10:18:54', 0);
INSERT INTO `sys_role_menu` VALUES (8, 1, 9, '2023-06-25 09:42:02', '2023-06-25 10:18:55', 0);
INSERT INTO `sys_role_menu` VALUES (9, 2, 2, '2023-06-25 09:42:02', '2023-06-25 10:18:56', 0);
INSERT INTO `sys_role_menu` VALUES (10, 2, 11, '2023-06-25 09:42:03', '2023-06-25 10:18:56', 0);
INSERT INTO `sys_role_menu` VALUES (11, 2, 12, '2023-06-25 09:42:03', '2023-06-25 10:18:57', 0);
INSERT INTO `sys_role_menu` VALUES (12, 2, 13, '2023-06-25 09:42:04', '2023-06-25 10:18:58', 0);
INSERT INTO `sys_role_menu` VALUES (13, 3, 6, '2023-06-25 09:42:30', '2023-06-25 09:42:30', 0);
INSERT INTO `sys_role_menu` VALUES (14, 1, 16, '2023-06-26 16:35:59', '2023-06-26 16:35:59', 0);
INSERT INTO `sys_role_menu` VALUES (15, 2, 16, '2023-06-26 16:36:03', '2023-06-26 16:36:03', 0);
INSERT INTO `sys_role_menu` VALUES (16, 3, 16, '2023-06-26 16:36:07', '2023-06-26 16:36:07', 0);

-- ----------------------------
-- Table structure for sys_student
-- ----------------------------
DROP TABLE IF EXISTS `sys_student`;
CREATE TABLE `sys_student`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `project_id` bigint NOT NULL DEFAULT 0 COMMENT '课题id',
  `project_status` tinyint NOT NULL DEFAULT 0 COMMENT '课题状态（0：未选择，1：已选择）',
  `project_score` bigint NOT NULL DEFAULT 0 COMMENT '课题成绩',
  `user_id` bigint NOT NULL DEFAULT 0 COMMENT '用户id',
  `teacher_id` bigint NOT NULL DEFAULT 0 COMMENT '所选课题的教师id',
  `subject_id` bigint NOT NULL DEFAULT 0 COMMENT '专业id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '学生' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_student
-- ----------------------------
INSERT INTO `sys_student` VALUES (1, 1, 0, 0, 1, 1, 1, '2023-06-23 22:15:23', '2023-06-25 22:47:48', 0);
INSERT INTO `sys_student` VALUES (2, 2, 0, 0, 2, 1, 1, '2023-06-23 22:16:35', '2023-06-24 14:23:44', 0);
INSERT INTO `sys_student` VALUES (3, 3, 0, 0, 3, 2, 2, '2023-06-23 22:16:50', '2023-06-24 14:23:49', 0);
INSERT INTO `sys_student` VALUES (4, 3, 0, 0, 6, 3, 3, '2023-06-23 22:17:17', '2023-06-24 14:24:01', 0);

-- ----------------------------
-- Table structure for sys_subject
-- ----------------------------
DROP TABLE IF EXISTS `sys_subject`;
CREATE TABLE `sys_subject`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `subject_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '专业名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '专业' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_subject
-- ----------------------------
INSERT INTO `sys_subject` VALUES (1, '计算机科学与技术', '2023-06-23 21:51:41', '2023-06-23 22:09:17', 0);
INSERT INTO `sys_subject` VALUES (2, '建筑电气与智能化', '2023-06-23 21:53:55', '2023-06-23 21:53:55', 0);
INSERT INTO `sys_subject` VALUES (3, '电子信息工程', '2023-06-23 21:54:07', '2023-06-23 21:54:07', 0);
INSERT INTO `sys_subject` VALUES (4, '通信工程', '2023-06-23 21:54:24', '2023-06-23 21:54:24', 0);
INSERT INTO `sys_subject` VALUES (5, '电气工程及其自动化', '2023-06-23 21:54:41', '2023-06-23 22:09:37', 0);
INSERT INTO `sys_subject` VALUES (6, '人工智能', '2023-06-23 21:54:48', '2023-06-23 21:54:48', 0);
INSERT INTO `sys_subject` VALUES (7, '区块链工程', '2023-06-23 21:55:02', '2023-06-23 21:55:02', 0);

-- ----------------------------
-- Table structure for sys_teacher
-- ----------------------------
DROP TABLE IF EXISTS `sys_teacher`;
CREATE TABLE `sys_teacher`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `research_direction` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '研究方向',
  `position` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '' COMMENT '职位',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_admin_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_teacher
-- ----------------------------
INSERT INTO `sys_teacher` VALUES (1, 4, '分布式系统与云计算', '教授', '2023-06-23 23:49:33', '2023-06-23 23:49:33', 0);
INSERT INTO `sys_teacher` VALUES (2, 5, '自然语言处理(NLP)', '副教授', '2023-06-24 08:30:20', '2023-06-24 08:32:21', 0);
INSERT INTO `sys_teacher` VALUES (3, 7, '微电子与集成电路设计', '副教授', '2023-06-24 08:31:47', '2023-06-24 08:32:22', 0);

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
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'pycro', 'e10adc3949ba59abbe56e057f20f883e', '派克若', '19876543210', '男', 1, '2023-06-22 22:58:07', '2023-06-24 10:03:21', 0);
INSERT INTO `sys_user` VALUES (2, 'kight', 'e10adc3949ba59abbe56e057f20f883e', '凯特', '19876543211', '男', 1, '2023-06-22 23:02:16', '2023-06-23 11:06:30', 0);
INSERT INTO `sys_user` VALUES (3, 'barbatos', 'e10adc3949ba59abbe56e057f20f883e', '巴巴托斯', '19876543212', '男', 1, '2023-06-22 23:12:03', '2023-06-23 11:06:31', 0);
INSERT INTO `sys_user` VALUES (4, 'morax', 'e10adc3949ba59abbe56e057f20f883e', '摩拉克斯', '19876543213', '男', 2, '2023-06-22 23:13:12', '2023-06-23 11:06:33', 0);
INSERT INTO `sys_user` VALUES (5, 'balzeb', 'e10adc3949ba59abbe56e057f20f883e', '巴尔泽布', '19876543214', '女', 2, '2023-06-22 23:17:03', '2023-06-25 19:24:00', 0);
INSERT INTO `sys_user` VALUES (6, 'bouyer', 'e10adc3949ba59abbe56e057f20f883e', '布耶尔', '19876543215', '女', 1, '2023-06-22 23:17:29', '2023-06-23 11:06:35', 0);
INSERT INTO `sys_user` VALUES (7, 'fkarus', 'e10adc3949ba59abbe56e057f20f883e', '芙卡洛斯', '19876543216', '女', 2, '2023-06-23 10:47:59', '2023-06-24 08:35:10', 0);
INSERT INTO `sys_user` VALUES (8, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '阿德幂', '19876543233', '男', 3, '2023-06-24 08:35:00', '2023-06-24 08:35:00', 0);

SET FOREIGN_KEY_CHECKS = 1;
