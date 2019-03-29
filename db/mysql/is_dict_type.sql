/*
 Navicat Premium Data Transfer

 Source Server         : hyy
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : xonro_store_management

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 -- Date: 29/03/2019 21:18:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for js_sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `js_sys_dict_type`;
CREATE TABLE `js_sys_dict_type`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '编号',
  `dict_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典类型',
  `is_sys` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '是否系统字典',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建者',
  `create_date` datetime(0) NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '更新者',
  `update_date` datetime(0) NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_sys_dict_type_is`(`is_sys`) USING BTREE,
  INDEX `idx_sys_dict_type_status`(`status`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of js_sys_dict_type
-- ----------------------------
INSERT INTO `js_sys_dict_type` VALUES ('1109024193751826432', '是否', 'sys_yes_no', '1', '0', 'system', '2019-03-22 17:29:07', 'system', '2019-03-22 17:29:07', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024193969930240', '状态', 'sys_status', '1', '0', 'system', '2019-03-22 17:29:07', 'system', '2019-03-22 17:29:07', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024194104147968', '显示隐藏', 'sys_show_hide', '1', '0', 'system', '2019-03-22 17:29:07', 'system', '2019-03-22 17:29:07', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024194238365696', '国际化语言类型', 'sys_lang_type', '1', '0', 'system', '2019-03-22 17:29:07', 'system', '2019-03-22 17:29:07', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024194351611904', '客户端设备类型', 'sys_device_type', '1', '0', 'system', '2019-03-22 17:29:07', 'system', '2019-03-22 17:29:07', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024194464858112', '菜单归属系统', 'sys_menu_sys_code', '1', '0', 'system', '2019-03-22 17:29:07', 'system', '2019-03-22 17:29:07', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024194607464448', '菜单类型', 'sys_menu_type', '1', '0', 'system', '2019-03-22 17:29:07', 'system', '2019-03-22 17:29:07', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024194750070784', '菜单权重', 'sys_menu_weight', '1', '0', 'system', '2019-03-22 17:29:07', 'system', '2019-03-22 17:29:07', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024194880094208', '区域类型', 'sys_area_type', '1', '0', 'system', '2019-03-22 17:29:07', 'system', '2019-03-22 17:29:07', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024195056254976', '机构类型', 'sys_office_type', '1', '0', 'system', '2019-03-22 17:29:07', 'system', '2019-03-22 17:29:07', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024195177889792', '查询状态', 'sys_search_status', '1', '0', 'system', '2019-03-22 17:29:07', 'system', '2019-03-22 17:29:07', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024195286941696', '用户性别', 'sys_user_sex', '1', '0', 'system', '2019-03-22 17:29:08', 'system', '2019-03-22 17:29:08', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024195471491072', '用户状态', 'sys_user_status', '1', '0', 'system', '2019-03-22 17:29:08', 'system', '2019-03-22 17:29:08', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024195584737280', '用户类型', 'sys_user_type', '1', '0', 'system', '2019-03-22 17:29:08', 'system', '2019-03-22 17:29:08', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024195999973376', '角色分类', 'sys_role_type', '1', '0', 'system', '2019-03-22 17:29:08', 'system', '2019-03-22 17:29:08', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024196129996800', '角色数据范围', 'sys_role_data_scope', '1', '0', 'system', '2019-03-22 17:29:08', 'system', '2019-03-22 17:29:08', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024196239048704', '岗位分类', 'sys_post_type', '1', '0', 'system', '2019-03-22 17:29:08', 'system', '2019-03-22 17:29:08', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024196348100608', '日志类型', 'sys_log_type', '1', '0', 'system', '2019-03-22 17:29:08', 'system', '2019-03-22 17:29:08', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024196448763904', '作业分组', 'sys_job_group', '1', '0', 'system', '2019-03-22 17:29:08', 'system', '2019-03-22 17:29:08', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024196553621504', '作业错过策略', 'sys_job_misfire_instruction', '1', '0', 'system', '2019-03-22 17:29:08', 'system', '2019-03-22 17:29:08', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024196666867712', '作业状态', 'sys_job_status', '1', '0', 'system', '2019-03-22 17:29:08', 'system', '2019-03-22 17:29:08', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024196784308224', '作业任务类型', 'sys_job_type', '1', '0', 'system', '2019-03-22 17:29:08', 'system', '2019-03-22 17:29:08', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024196897554432', '作业任务事件', 'sys_job_event', '1', '0', 'system', '2019-03-22 17:29:08', 'system', '2019-03-22 17:29:08', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024197002412032', '消息类型', 'sys_msg_type', '1', '0', 'system', '2019-03-22 17:29:08', 'system', '2019-03-22 17:29:08', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024197174378496', '推送状态', 'sys_msg_push_status', '1', '0', 'system', '2019-03-22 17:29:08', 'system', '2019-03-22 17:29:08', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1109024197287624704', '读取状态', 'sys_msg_read_status', '1', '0', 'system', '2019-03-22 17:29:08', 'system', '2019-03-22 17:29:08', NULL);
INSERT INTO `js_sys_dict_type` VALUES ('1110432420390248448', '进店渠道', 'mi_outlets', '0', '0', 'system', '2019-03-26 14:44:55', 'system', '2019-03-26 14:44:55', '01：别人推荐，02：网上了解');
INSERT INTO `js_sys_dict_type` VALUES ('1110433718338592768', '会员性别', 'mi_sex', '0', '0', 'system', '2019-03-26 14:50:04', 'system', '2019-03-26 14:50:04', '01:男，02:女');
INSERT INTO `js_sys_dict_type` VALUES ('1110434035612524544', '标记状态', 'mi_mark_status', '0', '0', 'system', '2019-03-26 14:51:20', 'system', '2019-03-26 14:51:20', '01：已标记，02：未标记');
INSERT INTO `js_sys_dict_type` VALUES ('1110434367021260800', '会员状态', 'mi_member_status', '0', '0', 'system', '2019-03-26 14:52:39', 'system', '2019-03-26 14:52:39', '01:有效，02:无效');
INSERT INTO `js_sys_dict_type` VALUES ('1110434628208959488', '星座', 'mi_constellation', '0', '0', 'system', '2019-03-26 14:53:41', 'system', '2019-03-26 14:53:41', '');
INSERT INTO `js_sys_dict_type` VALUES ('1110436342274203648', '血型', 'mi_blood_type', '0', '0', 'system', '2019-03-26 15:00:30', 'system', '2019-03-26 15:00:30', '');
INSERT INTO `js_sys_dict_type` VALUES ('1110436784169295872', '消息类通知', 'mi_message_notice', '0', '0', 'system', '2019-03-26 15:02:15', 'system', '2019-03-26 15:02:15', '');
INSERT INTO `js_sys_dict_type` VALUES ('1110437050511794176', '营销类通知', 'mi_marketing_notice', '0', '0', 'system', '2019-03-26 15:03:18', 'system', '2019-03-26 15:03:18', '');
INSERT INTO `js_sys_dict_type` VALUES ('1110437353751584768', '微信绑卡', 'mi_wechat_binding_card', '0', '0', 'system', '2019-03-26 15:04:31', 'system', '2019-03-26 15:04:31', '');
INSERT INTO `js_sys_dict_type` VALUES ('1110440143915851776', '卡类别', 'mi_card_type', '0', '0', 'system', '2019-03-26 15:15:36', 'system', '2019-03-26 15:15:36', '');
INSERT INTO `js_sys_dict_type` VALUES ('1110440595000664064', '会员等级', 'mi_member_grade', '0', '0', 'system', '2019-03-26 15:17:23', 'system', '2019-03-26 15:17:23', '');

SET FOREIGN_KEY_CHECKS = 1;
