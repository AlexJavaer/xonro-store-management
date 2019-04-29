/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.collect.entity;

import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.modules.base.productinfo.entity.XrProductinfo;
import com.jeesite.modules.base.project.entity.XrProjectinfo;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * xr_collect_projectinfoEntity
 * @author Crysta-hu
 * @version 2019-04-26
 */
@Table(name="xr_collect_projectinfo", alias="a", columns={
		@Column(name="id", attrName="id", label="项目子表主键", isPK=true),
		@Column(name="cm_code_id", attrName="collectMoney.cmCode", label="父主键ID"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="project_code", attrName="projectCode", label="项目编号"),
		@Column(name="project_name", attrName="projectName", label="项目名称", queryType=QueryType.LIKE),
		@Column(name="xp_charge_unit", attrName="xpChargeUnit", label="计价单位"),
		@Column(name="xp_mnemonic_code", attrName="xpMnemonicCode", label="助记码"),
		@Column(name="xp_norm_price", attrName="xpNormPrice", label="标准价格"),
		@Column(name="xp_discount_category", attrName="xpDiscountCategory", label="折扣类别"),
		@Column(name="xp_statistical_class", attrName="xpStatisticalClass", label="统计分类"),
		@Column(name="xp_statistical_dept", attrName="xpStatisticalDept", label="归属部门"),
		@Column(name="xp_pricing_method", attrName="xpPricingMethod", label="计价方式"),
		@Column(name="xp_project_time", attrName="xpProjectTime", label="项目时长"),
		@Column(name="xp_safety_times", attrName="xpSafetyTimes", label="安全次数"),
		@Column(name="xp_experience_price", attrName="xpExperiencePrice", label="体验价格"),
		@Column(name="xp_uniform_momber_price", attrName="xpUniformMomberPrice", label="统一会员价格"),
		@Column(name="xp_project_pre_pricing", attrName="xpProjectPrePricing", label="项目预订价"),
		@Column(name="xp_service_position", attrName="xpServicePosition", label="服务岗位"),
		@Column(name="xp_service_time", attrName="xpServiceTime", label="服务项目时长"),
		@Column(name="xp_project_predescription", attrName="xpProjectPredescription", label="项目预定描述"),
		@Column(name="user_code", attrName="userCode", label="用户编号"),
		@Column(name="office_code", attrName="officeCode", label="组织编号")},

		// 支持联合查询，如左右连接查询，支持设置查询自定义关联表的返回字段列
		joinTable={
		@JoinTable(type= JoinTable.Type.JOIN, entity=XrProjectinfo.class, alias="o",
				on="o.project_code = a.project_code",
				columns={@Column(includeEntity=XrProjectinfo.class)}),
	}, orderBy="a.update_date DESC"
)
public class XrCollectProjectinfo extends DataEntity<XrCollectProjectinfo> {
	
	private static final long serialVersionUID = 1L;
	private String cmCodeId;		// 父主键ID
	private CollectMoney collectMoney; //父表主键父类
	private String projectCode;		// 项目编号
	private String projectName;		// 项目名称
	private String xpChargeUnit;		// 计价单位
	private String xpMnemonicCode;		// 助记码
	private Double xpNormPrice;		// 标准价格
	private String xpDiscountCategory;		// 折扣类别
	private String xpStatisticalClass;		// 统计分类
	private String xpStatisticalDept;		// 归属部门
	private String xpPricingMethod;		// 计价方式
	private Long xpProjectTime;		// 项目时长
	private Long xpSafetyTimes;		// 安全次数
	private Double xpExperiencePrice;		// 体验价格
	private Double xpUniformMomberPrice;		// 统一会员价格
	private Double xpProjectPrePricing;		// 项目预订价
	private String xpServicePosition;		// 服务岗位
	private String xpServiceTime;		// 服务项目时长
	private String xpProjectPredescription;		// 项目预定描述
	private String userCode;		// 用户编号
	private String officeCode;		// 组织编号
	
	public XrCollectProjectinfo() {
		this(null);
	}

	public XrCollectProjectinfo(CollectMoney collectMoney){
		this.collectMoney=collectMoney;
	}

	public CollectMoney getCollectMoney() {
		return collectMoney;
	}

	public void setCollectMoney(CollectMoney collectMoney) {
		this.collectMoney = collectMoney;
	}

	@Length(min=0, max=64, message="父主键ID长度不能超过 64 个字符")
	public String getCmCodeId() {
		return cmCodeId;
	}

	public void setCmCodeId(String cmCodeId) {
		this.cmCodeId = cmCodeId;
	}
	
	@Length(min=0, max=64, message="项目编号长度不能超过 64 个字符")
	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	@Length(min=0, max=128, message="项目名称长度不能超过 128 个字符")
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@Length(min=0, max=32, message="计价单位长度不能超过 32 个字符")
	public String getXpChargeUnit() {
		return xpChargeUnit;
	}

	public void setXpChargeUnit(String xpChargeUnit) {
		this.xpChargeUnit = xpChargeUnit;
	}
	
	@Length(min=0, max=64, message="助记码长度不能超过 64 个字符")
	public String getXpMnemonicCode() {
		return xpMnemonicCode;
	}

	public void setXpMnemonicCode(String xpMnemonicCode) {
		this.xpMnemonicCode = xpMnemonicCode;
	}
	
	public Double getXpNormPrice() {
		return xpNormPrice;
	}

	public void setXpNormPrice(Double xpNormPrice) {
		this.xpNormPrice = xpNormPrice;
	}
	
	@Length(min=0, max=4, message="折扣类别长度不能超过 4 个字符")
	public String getXpDiscountCategory() {
		return xpDiscountCategory;
	}

	public void setXpDiscountCategory(String xpDiscountCategory) {
		this.xpDiscountCategory = xpDiscountCategory;
	}
	
	@Length(min=0, max=4, message="统计分类长度不能超过 4 个字符")
	public String getXpStatisticalClass() {
		return xpStatisticalClass;
	}

	public void setXpStatisticalClass(String xpStatisticalClass) {
		this.xpStatisticalClass = xpStatisticalClass;
	}
	
	@Length(min=0, max=4, message="归属部门长度不能超过 4 个字符")
	public String getXpStatisticalDept() {
		return xpStatisticalDept;
	}

	public void setXpStatisticalDept(String xpStatisticalDept) {
		this.xpStatisticalDept = xpStatisticalDept;
	}
	
	@Length(min=0, max=2, message="计价方式长度不能超过 2 个字符")
	public String getXpPricingMethod() {
		return xpPricingMethod;
	}

	public void setXpPricingMethod(String xpPricingMethod) {
		this.xpPricingMethod = xpPricingMethod;
	}
	
	public Long getXpProjectTime() {
		return xpProjectTime;
	}

	public void setXpProjectTime(Long xpProjectTime) {
		this.xpProjectTime = xpProjectTime;
	}
	
	public Long getXpSafetyTimes() {
		return xpSafetyTimes;
	}

	public void setXpSafetyTimes(Long xpSafetyTimes) {
		this.xpSafetyTimes = xpSafetyTimes;
	}
	
	public Double getXpExperiencePrice() {
		return xpExperiencePrice;
	}

	public void setXpExperiencePrice(Double xpExperiencePrice) {
		this.xpExperiencePrice = xpExperiencePrice;
	}
	
	public Double getXpUniformMomberPrice() {
		return xpUniformMomberPrice;
	}

	public void setXpUniformMomberPrice(Double xpUniformMomberPrice) {
		this.xpUniformMomberPrice = xpUniformMomberPrice;
	}
	
	public Double getXpProjectPrePricing() {
		return xpProjectPrePricing;
	}

	public void setXpProjectPrePricing(Double xpProjectPrePricing) {
		this.xpProjectPrePricing = xpProjectPrePricing;
	}
	
	@Length(min=0, max=30, message="服务岗位长度不能超过 30 个字符")
	public String getXpServicePosition() {
		return xpServicePosition;
	}

	public void setXpServicePosition(String xpServicePosition) {
		this.xpServicePosition = xpServicePosition;
	}
	
	@Length(min=0, max=2, message="服务项目时长长度不能超过 2 个字符")
	public String getXpServiceTime() {
		return xpServiceTime;
	}

	public void setXpServiceTime(String xpServiceTime) {
		this.xpServiceTime = xpServiceTime;
	}
	
	@Length(min=0, max=500, message="项目预定描述长度不能超过 500 个字符")
	public String getXpProjectPredescription() {
		return xpProjectPredescription;
	}

	public void setXpProjectPredescription(String xpProjectPredescription) {
		this.xpProjectPredescription = xpProjectPredescription;
	}
	
	@Length(min=0, max=64, message="用户编号长度不能超过 64 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@Length(min=0, max=64, message="组织编号长度不能超过 64 个字符")
	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	
}