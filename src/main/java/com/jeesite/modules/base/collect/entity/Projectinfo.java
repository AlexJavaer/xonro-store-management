/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.collect.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * collectMoneyEntity
 * @author Crysta-hu
 * @version 2019-04-16
 */
@Table(name="xr_projectinfo", alias="a", columns={
		@Column(name="project_code", attrName="projectCode", label="项目编号", isPK=true),
		@Column(name="cm_code_id", attrName="collectMoney.cmCode", label="父表主键"),
		@Column(name="project_name", attrName="projectName", label="项目名称", queryType=QueryType.LIKE),
		@Column(name="xp_charge_unit", attrName="xpChargeUnit", label="计价单位"),
		@Column(name="xp_mnemonic_code", attrName="xpMnemonicCode", label="助记码"),
		@Column(name="xp_norm_price", attrName="xpNormPrice", label="标准价格"),
		@Column(name="xp_discount_category", attrName="xpDiscountCategory", label="折扣类别011", comment="折扣类别011:其他类"),
		@Column(name="xp_statistical_class", attrName="xpStatisticalClass", label="统计分类011", comment="统计分类011:其他类"),
		@Column(name="xp_statistical_dept", attrName="xpStatisticalDept", label="归属部门003", comment="归属部门003：美容组"),
		@Column(name="xp_pricing_method", attrName="xpPricingMethod", label="计价方式01", comment="计价方式01:按次,02:按小时"),
		@Column(name="xp_project_time", attrName="xpProjectTime", label="项目时长"),
		@Column(name="xp_isdisplay_time", attrName="xpIsdisplayTime", label="是否展示计时"),
		@Column(name="xp_safety_times", attrName="xpSafetyTimes", label="安全次数"),
		@Column(name="xp_experience_price", attrName="xpExperiencePrice", label="体验价格"),
		@Column(name="xp_uniform_momber_price", attrName="xpUniformMomberPrice", label="统一会员价格"),
		@Column(name="xp_project_pre_pricing", attrName="xpProjectPrePricing", label="项目预订价"),
		@Column(name="xp_project_preplan", attrName="xpProjectPreplan", label="项目预定图"),
		@Column(name="xp_service_position", attrName="xpServicePosition", label="服务岗位"),
		@Column(name="xp_service_time", attrName="xpServiceTime", label="服务项目时长01", comment="服务项目时长01:30分钟，02:1小时,03:2小时"),
		@Column(name="xp_project_predescription", attrName="xpProjectPredescription", label="项目预定描述"),
		@Column(name="xp_consumption_interval", attrName="xpConsumptionInterval", label="消费间隔，单位", comment="消费间隔，单位:天"),
		@Column(name="xp_return_interval", attrName="xpReturnInterval", label="回访间隔，单位", comment="回访间隔，单位:天"),
		@Column(name="xp_iscash", attrName="xpIscash", label="是否必须现金01", comment="是否必须现金01:是，02:否"),
		@Column(name="xp_isblockup", attrName="xpIsblockup", label="是否停用01", comment="是否停用01:是,02:否"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="store_code", attrName="storeCode", label="店铺编号"),
		@Column(name="user_code", attrName="userCode", label="用户编号"),
		@Column(name="office_code", attrName="officeCode.cmCode", label="机构编号"),
		@Column(name="xp_remarks", attrName="xpRemarks", label="备注"),
	}, orderBy="a.create_date ASC"
)
public class Projectinfo extends DataEntity<Projectinfo> {
	
	private static final long serialVersionUID = 1L;
	private String projectCode;		// 项目编号
	private CollectMoney collectMoney;   //父表主键
	private String projectName;		// 项目名称
	private String xpChargeUnit;		// 计价单位
	private String xpMnemonicCode;		// 助记码
	private Double xpNormPrice;		// 标准价格
	private String xpDiscountCategory;		// 折扣类别011:其他类
	private String xpStatisticalClass;		// 统计分类011:其他类
	private String xpStatisticalDept;		// 归属部门003：美容组
	private String xpPricingMethod;		// 计价方式01:按次,02:按小时
	private Date xpProjectTime;		// 项目时长
	private Date xpIsdisplayTime;		// 是否展示计时
	private Long xpSafetyTimes;		// 安全次数
	private Double xpExperiencePrice;		// 体验价格
	private Double xpUniformMomberPrice;		// 统一会员价格
	private Long xpProjectPrePricing;		// 项目预订价
	private String xpProjectPreplan;		// 项目预定图
	private String xpServicePosition;		// 服务岗位
	private String xpServiceTime;		// 服务项目时长01:30分钟，02:1小时,03:2小时
	private String xpProjectPredescription;		// 项目预定描述
	private Long xpConsumptionInterval;		// 消费间隔，单位:天
	private Long xpReturnInterval;		// 回访间隔，单位:天
	private String xpIscash;		// 是否必须现金01:是，02:否
	private String xpIsblockup;		// 是否停用01:是,02:否
	private String storeCode;		// 店铺编号
	private String userCode;		// 用户编号
	private CollectMoney officeCode;		// 机构编号 父类
	private String xpRemarks;		// 备注
	
	public Projectinfo() {
		this(null);
	}


	public Projectinfo(CollectMoney officeCode){
		this.officeCode = officeCode;
	}

	public CollectMoney getCollectMoney() {
		return collectMoney;
	}

	public void setCollectMoney(CollectMoney collectMoney) {
		this.collectMoney = collectMoney;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	@NotBlank(message="项目名称不能为空")
	@Length(min=0, max=128, message="项目名称长度不能超过 128 个字符")
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@NotBlank(message="计价单位不能为空")
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
	
	@Length(min=0, max=4, message="折扣类别011长度不能超过 4 个字符")
	public String getXpDiscountCategory() {
		return xpDiscountCategory;
	}

	public void setXpDiscountCategory(String xpDiscountCategory) {
		this.xpDiscountCategory = xpDiscountCategory;
	}
	
	@Length(min=0, max=4, message="统计分类011长度不能超过 4 个字符")
	public String getXpStatisticalClass() {
		return xpStatisticalClass;
	}

	public void setXpStatisticalClass(String xpStatisticalClass) {
		this.xpStatisticalClass = xpStatisticalClass;
	}
	
	@Length(min=0, max=4, message="归属部门003长度不能超过 4 个字符")
	public String getXpStatisticalDept() {
		return xpStatisticalDept;
	}

	public void setXpStatisticalDept(String xpStatisticalDept) {
		this.xpStatisticalDept = xpStatisticalDept;
	}
	
	@Length(min=0, max=2, message="计价方式01长度不能超过 2 个字符")
	public String getXpPricingMethod() {
		return xpPricingMethod;
	}

	public void setXpPricingMethod(String xpPricingMethod) {
		this.xpPricingMethod = xpPricingMethod;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getXpProjectTime() {
		return xpProjectTime;
	}

	public void setXpProjectTime(Date xpProjectTime) {
		this.xpProjectTime = xpProjectTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getXpIsdisplayTime() {
		return xpIsdisplayTime;
	}

	public void setXpIsdisplayTime(Date xpIsdisplayTime) {
		this.xpIsdisplayTime = xpIsdisplayTime;
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
	
	public Long getXpProjectPrePricing() {
		return xpProjectPrePricing;
	}

	public void setXpProjectPrePricing(Long xpProjectPrePricing) {
		this.xpProjectPrePricing = xpProjectPrePricing;
	}
	
	@Length(min=0, max=255, message="项目预定图长度不能超过 255 个字符")
	public String getXpProjectPreplan() {
		return xpProjectPreplan;
	}

	public void setXpProjectPreplan(String xpProjectPreplan) {
		this.xpProjectPreplan = xpProjectPreplan;
	}
	
	@Length(min=0, max=30, message="服务岗位长度不能超过 30 个字符")
	public String getXpServicePosition() {
		return xpServicePosition;
	}

	public void setXpServicePosition(String xpServicePosition) {
		this.xpServicePosition = xpServicePosition;
	}
	
	@Length(min=0, max=2, message="服务项目时长01长度不能超过 2 个字符")
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
	
	public Long getXpConsumptionInterval() {
		return xpConsumptionInterval;
	}

	public void setXpConsumptionInterval(Long xpConsumptionInterval) {
		this.xpConsumptionInterval = xpConsumptionInterval;
	}
	
	public Long getXpReturnInterval() {
		return xpReturnInterval;
	}

	public void setXpReturnInterval(Long xpReturnInterval) {
		this.xpReturnInterval = xpReturnInterval;
	}
	
	@Length(min=0, max=2, message="是否必须现金01长度不能超过 2 个字符")
	public String getXpIscash() {
		return xpIscash;
	}

	public void setXpIscash(String xpIscash) {
		this.xpIscash = xpIscash;
	}
	
	@Length(min=0, max=2, message="是否停用01长度不能超过 2 个字符")
	public String getXpIsblockup() {
		return xpIsblockup;
	}

	public void setXpIsblockup(String xpIsblockup) {
		this.xpIsblockup = xpIsblockup;
	}
	
	@Length(min=0, max=64, message="店铺编号长度不能超过 64 个字符")
	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	
	@Length(min=0, max=64, message="用户编号长度不能超过 64 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@Length(min=0, max=64, message="机构编号长度不能超过 64 个字符")
	public CollectMoney getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(CollectMoney officeCode) {
		this.officeCode = officeCode;
	}
	
	@Length(min=0, max=500, message="备注长度不能超过 500 个字符")
	public String getXpRemarks() {
		return xpRemarks;
	}

	public void setXpRemarks(String xpRemarks) {
		this.xpRemarks = xpRemarks;
	}
	
}