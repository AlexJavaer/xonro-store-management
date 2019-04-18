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

 Date: 18/04/2019 18:55:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collect_money
-- ----------------------------
DROP TABLE IF EXISTS `collect_money`;
CREATE TABLE `collect_money`  (
  `cm_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '消费单号',
  `cm_date` date NULL DEFAULT NULL COMMENT '消费日期',
  `cm_store_code` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '消费门店编号',
  `cm_store_name` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '消费门店名称',
  `cm_member_card` int(20) NULL DEFAULT NULL COMMENT '会员卡号',
  `cm_member_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '会员卡类别01:vip卡,02:疗程卡,03:365体验卡,04:单次卡',
  `cm_customer_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '客户姓名',
  `cm_customer_sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '客户性别01:女客02:男客',
  `cm_customer_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '客户种类01:新客,02:老客',
  `cm_access_channel` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '客户进店渠道01:朋友介绍,02:广告传单,03:电视广告,04:口碑,05:其他',
  `cm_customer_phone` bigint(64) NULL DEFAULT NULL COMMENT '手机号',
  `cm_customer_num` int(20) NULL DEFAULT NULL COMMENT '客数',
  `cm_is_member` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '是否是会员01:会员,02:非会员',
  `cm_member_integrate` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '会员积分',
  `cm_account_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '账户类别',
  `cm_account_balance` decimal(20, 2) NULL DEFAULT NULL COMMENT '余额',
  `cm_account_debt` decimal(20, 2) NULL DEFAULT NULL COMMENT '欠款',
  `cm_payment_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付方式01:微信,02:银行卡,03:支付宝',
  `cm_payment_money` decimal(20, 0) NULL DEFAULT NULL COMMENT '金额',
  `cm_remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注说明',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '状态',
  `mi_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '会员编号ID',
  `user_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户ID',
  `office_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '组织ID',
  `project_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目编号',
  `project_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目名称',
  `xp_norm_price` decimal(30, 2) NULL DEFAULT NULL COMMENT '标准价格',
  `xp_remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `product_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '产品编号',
  `product_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '产品名称',
  PRIMARY KEY (`cm_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collect_money
-- ----------------------------



SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for member_info
-- ----------------------------
DROP TABLE IF EXISTS `member_info`;
CREATE TABLE `member_info`  (
  `mi_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '会员编号',
  `mi_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '会员姓名',
  `mi_gregorian_birthday` date NULL DEFAULT NULL COMMENT '公历生日',
  `mi_sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '会员性别',
  `mi_phone` bigint(64) NULL DEFAULT NULL COMMENT '手机号码',
  `mi_outlets` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '进店渠道,例如01：别人推荐，02：网上了解',
  `mi_mark_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标记状态:01：已标记，02：未标记',
  `mi_member_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '会员状态:01:有效，02:无效',
  `mi_wechat_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '微信号',
  `mi_qq_number` int(20) NULL DEFAULT NULL COMMENT 'QQ号码',
  `mi_email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mi_family_phone` int(11) NULL DEFAULT NULL COMMENT '家庭电话',
  `mi_constellation` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '星座',
  `mi_blood_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '血型01:A,02:B,03:AB,04:O,05:其他',
  `mi_zip_code` int(10) NULL DEFAULT NULL COMMENT '邮编',
  `mi_family_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `mi_vocation` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '职业',
  `mi_work_unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '工作单位',
  `mi_card_number` int(30) NULL DEFAULT NULL COMMENT '会员卡号',
  `mi_card_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '卡类别',
  `mi_id_number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '身份证号',
  `mi_message_notice` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '消息类通知01:发送,02:不发送',
  `mi_marketing_notice` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '营销类通知01:发送,02:不发送',
  `mi_wechat_binding_card` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '微信绑卡01:微信,02:小程序',
  `mi_photo` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '会员头像',
  `mi_file` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '附件',
  `mi_responsible_staff` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '负责员工',
  `mi_member_grade` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '会员等级',
  `mi_development_potential` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发展潜质',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '状态（0正常 1删除 2停用）',
  `user_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户ID',
  `office_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '组织ID',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建用户',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新用户',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`mi_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member_info
-- ----------------------------


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for xr_member_recharge
-- ----------------------------
DROP TABLE IF EXISTS `xr_member_recharge`;
CREATE TABLE `xr_member_recharge`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '异地单号',
  `xmr_date` date NULL DEFAULT NULL COMMENT '异动日期',
  `mi_card_number` bigint(30) NULL DEFAULT NULL COMMENT '会员卡号',
  `mi_card_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '卡类别',
  `mi_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '会员编号',
  `mi_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '会员姓名',
  `xmr_account_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '账户类别',
  `mi_outlets` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '进店渠道',
  `transaction_mode` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '异动方式01:存款，02:取款，03:欠款,04:还款',
  `xmr_reserve_value` decimal(30, 0) UNSIGNED NULL DEFAULT NULL COMMENT '储值应收',
  `xmr_save_money` decimal(30, 0) NULL DEFAULT NULL COMMENT '储值金额',
  `xmr_produce_project_amount` decimal(30, 0) NULL DEFAULT NULL COMMENT '品项金额',
  `xmr_package_amount` decimal(30, 0) NULL DEFAULT NULL COMMENT '套餐金额',
  `xmr_gift_account` decimal(30, 0) NULL DEFAULT NULL COMMENT '赠送账户',
  `xmr_donation_amout` decimal(30, 0) NULL DEFAULT NULL COMMENT '赠送金额',
  `xmr_current_balance` decimal(30, 0) NULL DEFAULT NULL COMMENT '当前余额',
  `xmr_latest_balance` decimal(30, 0) NULL DEFAULT NULL COMMENT '最新余额',
  `xmr_payment_mode` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付方式01:现金;02:银行卡支付；03：微信转账;04:支付宝转账',
  `xmr_recharge_valid_time` date NULL DEFAULT NULL COMMENT '充值有效日期',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `user_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户ID',
  `office_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '组织ID',
  `xmr_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '状态',
  `xs_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '门店编号',
  `XS_FUll_NAME` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '门店名称',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xr_member_recharge
-- ----------------------------


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for xr_productinfo
-- ----------------------------
DROP TABLE IF EXISTS `xr_productinfo`;
CREATE TABLE `xr_productinfo`  (
  `product_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '产品编号',
  `product_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '产品名称',
  `xpd_statistical_class` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '统计分类01:身体管理器',
  `xpd_depository` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '存放仓库01:总仓库',
  `xpd_bar_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '条形码',
  `xpd_mnemonic_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '助记码',
  `xpd_discount_category` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '折扣类别01:身体管理器',
  `xpd_filing_time` date NOT NULL COMMENT '建档时间',
  `xpd_standard_unit` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标准单位01:J-件',
  `xpd_norm_price` decimal(30, 2) NOT NULL COMMENT '标准价格单位:元/件',
  `xpd_each_containing` bigint(30) NULL DEFAULT NULL COMMENT '每件含',
  `xpd_time` bigint(30) NULL DEFAULT NULL COMMENT '可用时间单位:天',
  `xpd_purchase_unit` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '进货单位01:件',
  `xpd_purchased` bigint(30) NULL DEFAULT NULL COMMENT '进货成本单位:元/件',
  `xpd_each` bigint(30) NULL DEFAULT NULL COMMENT '每含单位:件',
  `xpd_supplier` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '供应商01:芜湖制造公司',
  `xpd_marketint_unit` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '消耗单位02:芜湖美丽妈妈',
  `xpd_consumption_cost` decimal(30, 2) NULL DEFAULT NULL COMMENT '消耗成本单位:元',
  `xpd_marketint_cost` decimal(30, 2) NULL DEFAULT NULL COMMENT '销售成本单位:元/件',
  `xpd_quality_time` bigint(30) NULL DEFAULT NULL COMMENT '保质期单位:天',
  `xpd_rule_desccription` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '规格描述',
  `xpd_membership_prices` decimal(30, 2) NULL DEFAULT NULL COMMENT '会员价格',
  `xpd_store_price` decimal(30, 2) NULL DEFAULT NULL COMMENT '门店价格',
  `xpd_return_interval` bigint(30) NULL DEFAULT NULL COMMENT '回访间隔单位:天',
  `xpd_max_stock` bigint(30) NULL DEFAULT NULL COMMENT '最高存量单位:件',
  `xpd_safety_stock` bigint(30) NULL DEFAULT NULL COMMENT '安全存量单位:件',
  `xpd_isGift` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '是否赠送01:是;02:否',
  `xpd_isDiscountinued` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '是否停用01:是;02:否',
  `xpd_end_sale` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '停止销售01:是;02:否',
  `xpd_copy_cost_price` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '可拷贝成本价格01:是;02:否',
  `xpd_remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '产品备注',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '状态',
  `user_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户ID',
  `office_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '组织ID',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注信息',
  `state` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`product_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xr_productinfo
-- ----------------------------


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for xr_projectinfo
-- ----------------------------
DROP TABLE IF EXISTS `xr_projectinfo`;
CREATE TABLE `xr_projectinfo`  (
  `project_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '项目编号',
  `project_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '项目名称',
  `xp_charge_unit` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '计价单位',
  `xp_mnemonic_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '助记码',
  `xp_norm_price` decimal(30, 2) NULL DEFAULT NULL COMMENT '标准价格',
  `xp_discount_category` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '折扣类别011:其他类',
  `xp_statistical_class` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '统计分类011:其他类',
  `xp_statistical_dept` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '归属部门003：美容组',
  `xp_pricing_method` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '计价方式01:按次,02:按小时',
  `xp_project_time` bigint(20) NULL DEFAULT NULL COMMENT '项目时长',
  `xp_isDisplay_time` datetime(0) NULL DEFAULT NULL COMMENT '是否展示计时',
  `xp_safety_times` bigint(20) NULL DEFAULT NULL COMMENT '安全次数',
  `xp_experience_price` decimal(30, 2) NULL DEFAULT NULL COMMENT '体验价格',
  `xp_uniform_momber_price` decimal(30, 2) NULL DEFAULT NULL COMMENT '统一会员价格',
  `xp_project_pre_pricing` decimal(30, 0) NULL DEFAULT NULL COMMENT '项目预订价',
  `xp_project_preplan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目预定图',
  `xp_service_position` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '服务岗位',
  `xp_service_time` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '服务项目时长01:30分钟，02:1小时,03:2小时',
  `xp_project_predescription` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '项目预定描述',
  `xp_consumption_interval` bigint(30) NULL DEFAULT NULL COMMENT '消费间隔，单位:天',
  `xp_return_interval` bigint(30) NULL DEFAULT NULL COMMENT '回访间隔，单位:天',
  `xp_isCash` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '是否必须现金01:是，02:否',
  `xp_isBlockUp` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '是否停用01:是,02:否',
  `xp_remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `store_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '店铺编号',
  `user_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户编号',
  `office_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '机构编号',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`project_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xr_projectinfo
-- ----------------------------


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for xr_stock_control
-- ----------------------------
DROP TABLE IF EXISTS `xr_stock_control`;
CREATE TABLE `xr_stock_control`  (
  `matter_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '物料编号',
  `matter_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '物料名称',
  `xsc_in_time` date NULL DEFAULT NULL COMMENT '入库时间',
  `xsc_in_numr` bigint(30) NULL DEFAULT NULL COMMENT '入库数量',
  `xsc_in_emp` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '入库员工姓名',
  `xsc_in_current_num` bigint(30) NULL DEFAULT NULL COMMENT '入库前当前库存',
  `xsc_in_new_num` bigint(30) NULL DEFAULT NULL COMMENT '入库后最新库存',
  `xsc_out_emp` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '物料领用人',
  `xsc_out_time` date NULL DEFAULT NULL COMMENT '物料领用日期',
  `xsc_out_num` bigint(30) NULL DEFAULT NULL COMMENT '领用数量',
  `xsc_out_current_num` bigint(30) NULL DEFAULT NULL COMMENT '出库前当前存量',
  `xsc_out_new_num` bigint(30) NULL DEFAULT NULL COMMENT '出库后最新存量：当前存量-消耗成本/销售成本',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `user_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户ID',
  `office_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '组织ID',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '状态',
  `product_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '产品名称',
  `product_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '产品编号',
  `xpd_statistical_class` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '统计分类',
  `xpd_depository` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '存放仓库',
  `xpd_max_stock` bigint(30) NULL DEFAULT NULL COMMENT '最高存量',
  `xpd_safety_stock` bigint(30) NULL DEFAULT NULL COMMENT '安全存量',
  PRIMARY KEY (`matter_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xr_stock_control
-- ----------------------------


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for xr_store
-- ----------------------------
DROP TABLE IF EXISTS `xr_store`;
CREATE TABLE `xr_store`  (
  `xs_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '编号',
  `XS_FUll_NAME` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '店铺全称',
  `XS_SHORT_NAME` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '店铺简称',
  `XS_CHAIN_CODE` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '连锁代码',
  `XS_PHONE` bigint(64) NOT NULL COMMENT '电话',
  `XS_ADDRESS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '地址',
  `XS_LEVEL` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '门店级别',
  `XS_WE_PUBLIC_ACCOUNT` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '微信公众号',
  `XS_WEBSITE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '网址',
  `XS_MANAGE_SCOPE` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '经营范围',
  `XS_OPENTIME` datetime(0) NULL DEFAULT NULL COMMENT '开业时间',
  `XS_LOGO_PHOTO` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '门店logo',
  `XS_PHOTO` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '门店展示图片',
  `XS_LNG` int(50) NULL DEFAULT NULL COMMENT '经度',
  `STATUS` int(1) NULL DEFAULT NULL COMMENT '状态（0正常 1删除 2停用）',
  `XS_Lat` int(50) NULL DEFAULT NULL COMMENT '纬度',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `user_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户ID',
  `office_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '组织ID',
  PRIMARY KEY (`xs_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xr_store
-- ----------------------------
