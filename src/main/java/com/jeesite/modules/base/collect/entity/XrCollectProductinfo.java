/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.collect.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * xr_collect_productinfoEntity
 * @author Crysta-hu
 * @version 2019-04-26
 */
@Table(name="xr_collect_productinfo", alias="a", columns={
		@Column(name="id", attrName="id", label="产品子表ID", isPK=true),
		@Column(name="cm_code_id", attrName="collectMoney.cmCode", label="父主键ID"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="product_code", attrName="productCode", label="产品编号"),
		@Column(name="product_name", attrName="productName", label="产品名称", queryType=QueryType.LIKE),
		@Column(name="xpd_statistical_class", attrName="xpdStatisticalClass", label="统计分类"),
		@Column(name="xpd_depository", attrName="xpdDepository", label="存放仓库"),
		@Column(name="xpd_discount_category", attrName="xpdDiscountCategory", label="折扣类别"),
		@Column(name="xpd_filing_time", attrName="xpdFilingTime", label="建档时间"),
		@Column(name="xpd_purchase_unit", attrName="xpdPurchaseUnit", label="单位"),
		@Column(name="xpd_purchased", attrName="xpdPurchased", label="进货成本"),
		@Column(name="xpd_each", attrName="xpdEach", label="每含"),
		@Column(name="xpd_supplier", attrName="xpdSupplier", label="供应商"),
		@Column(name="xpd_quality_time", attrName="xpdQualityTime", label="保质期"),
		@Column(name="xpd_rule_desccription", attrName="xpdRuleDesccription", label="规格描述"),
		@Column(name="xpd_membership_prices", attrName="xpdMembershipPrices", label="会员价格"),
		@Column(name="xpd_store_price", attrName="xpdStorePrice", label="门店价格"),
		@Column(name="user_code", attrName="userCode", label="用户编号"),
		@Column(name="office_code", attrName="officeCode", label="组织编号"),
	}, orderBy="a.update_date DESC"
)
public class XrCollectProductinfo extends DataEntity<XrCollectProductinfo> {
	
	private static final long serialVersionUID = 1L;
	private String cmCodeId;		// 父主键ID
	private CollectMoney collectMoney; //父表主键父类
	private String productCode;		// 产品编号
	private String productName;		// 产品名称
	private String xpdStatisticalClass;		// 统计分类
	private String xpdDepository;		// 存放仓库
	private String xpdDiscountCategory;		// 折扣类别
	private Date xpdFilingTime;		// 建档时间
	private String xpdPurchaseUnit;		// 单位
	private Long xpdPurchased;		// 进货成本
	private Long xpdEach;		// 每含
	private String xpdSupplier;		// 供应商
	private Long xpdQualityTime;		// 保质期
	private String xpdRuleDesccription;		// 规格描述
	private Long xpdMembershipPrices;		// 会员价格
	private Long xpdStorePrice;		// 门店价格
	private String userCode;		// 用户编号
	private String officeCode;		// 组织编号
	
	public XrCollectProductinfo() {
		this(null);
	}

	public XrCollectProductinfo(CollectMoney collectMoney){
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
	
	@Length(min=0, max=64, message="产品编号长度不能超过 64 个字符")
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	@Length(min=0, max=128, message="产品名称长度不能超过 128 个字符")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Length(min=0, max=2, message="统计分类长度不能超过 2 个字符")
	public String getXpdStatisticalClass() {
		return xpdStatisticalClass;
	}

	public void setXpdStatisticalClass(String xpdStatisticalClass) {
		this.xpdStatisticalClass = xpdStatisticalClass;
	}
	
	@Length(min=0, max=2, message="存放仓库长度不能超过 2 个字符")
	public String getXpdDepository() {
		return xpdDepository;
	}

	public void setXpdDepository(String xpdDepository) {
		this.xpdDepository = xpdDepository;
	}
	
	@Length(min=0, max=2, message="折扣类别长度不能超过 2 个字符")
	public String getXpdDiscountCategory() {
		return xpdDiscountCategory;
	}

	public void setXpdDiscountCategory(String xpdDiscountCategory) {
		this.xpdDiscountCategory = xpdDiscountCategory;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getXpdFilingTime() {
		return xpdFilingTime;
	}

	public void setXpdFilingTime(Date xpdFilingTime) {
		this.xpdFilingTime = xpdFilingTime;
	}
	
	@Length(min=0, max=2, message="单位长度不能超过 2 个字符")
	public String getXpdPurchaseUnit() {
		return xpdPurchaseUnit;
	}

	public void setXpdPurchaseUnit(String xpdPurchaseUnit) {
		this.xpdPurchaseUnit = xpdPurchaseUnit;
	}
	
	public Long getXpdPurchased() {
		return xpdPurchased;
	}

	public void setXpdPurchased(Long xpdPurchased) {
		this.xpdPurchased = xpdPurchased;
	}
	
	public Long getXpdEach() {
		return xpdEach;
	}

	public void setXpdEach(Long xpdEach) {
		this.xpdEach = xpdEach;
	}
	
	@Length(min=0, max=2, message="供应商长度不能超过 2 个字符")
	public String getXpdSupplier() {
		return xpdSupplier;
	}

	public void setXpdSupplier(String xpdSupplier) {
		this.xpdSupplier = xpdSupplier;
	}
	
	public Long getXpdQualityTime() {
		return xpdQualityTime;
	}

	public void setXpdQualityTime(Long xpdQualityTime) {
		this.xpdQualityTime = xpdQualityTime;
	}
	
	@Length(min=0, max=500, message="规格描述长度不能超过 500 个字符")
	public String getXpdRuleDesccription() {
		return xpdRuleDesccription;
	}

	public void setXpdRuleDesccription(String xpdRuleDesccription) {
		this.xpdRuleDesccription = xpdRuleDesccription;
	}
	
	public Long getXpdMembershipPrices() {
		return xpdMembershipPrices;
	}

	public void setXpdMembershipPrices(Long xpdMembershipPrices) {
		this.xpdMembershipPrices = xpdMembershipPrices;
	}
	
	public Long getXpdStorePrice() {
		return xpdStorePrice;
	}

	public void setXpdStorePrice(Long xpdStorePrice) {
		this.xpdStorePrice = xpdStorePrice;
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