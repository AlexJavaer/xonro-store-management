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

 Date: 11/04/2019 09:27:39
*/

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



