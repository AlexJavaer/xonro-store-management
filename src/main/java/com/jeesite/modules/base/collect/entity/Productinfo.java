/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.collect.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * collectMoneyEntity
 * @author Crysta-hu
 * @version 2019-04-16
 */
@Table(name="xr_productinfo", alias="a", columns={
		@Column(name="product_code", attrName="productCode", label="产品编号", isPK=true),
		@Column(name="product_name", attrName="productName", label="产品名称", queryType=QueryType.LIKE),
		@Column(name="xpd_statistical_class", attrName="xpdStatisticalClass", label="统计分类"),
		@Column(name="xpd_depository", attrName="xpdDepository", label="存放仓库"),
		@Column(name="xpd_bar_code", attrName="xpdBarCode", label="条形码"),
		@Column(name="xpd_mnemonic_code", attrName="xpdMnemonicCode", label="助记码"),
		@Column(name="xpd_discount_category", attrName="xpdDiscountCategory", label="折扣类别"),
		@Column(name="xpd_filing_time", attrName="xpdFilingTime", label="建档时间"),
		@Column(name="xpd_standard_unit", attrName="xpdStandardUnit", label="标准单位"),
		@Column(name="xpd_norm_price", attrName="xpdNormPrice", label="标准价格"),
		@Column(name="xpd_each_containing", attrName="xpdEachContaining", label="每件含"),
		@Column(name="xpd_time", attrName="xpdTime", label="可用时间"),
		@Column(name="xpd_purchase_unit", attrName="xpdPurchaseUnit", label="进货单位"),
		@Column(name="xpd_purchased", attrName="xpdPurchased", label="进货成本"),
		@Column(name="xpd_each", attrName="xpdEach", label="每含单位", comment="每含单位:件"),
		@Column(name="xpd_supplier", attrName="xpdSupplier", label="供应商"),
		@Column(name="xpd_marketint_unit", attrName="xpdMarketintUnit", label="消耗单位"),
		@Column(name="xpd_consumption_cost", attrName="xpdConsumptionCost", label="消耗成本"),
		@Column(name="xpd_marketint_cost", attrName="xpdMarketintCost", label="销售成本"),
		@Column(name="xpd_quality_time", attrName="xpdQualityTime", label="保质期"),
		@Column(name="xpd_rule_desccription", attrName="xpdRuleDesccription", label="规格描述"),
		@Column(name="xpd_membership_prices", attrName="xpdMembershipPrices", label="会员价格"),
		@Column(name="xpd_store_price", attrName="xpdStorePrice", label="门店价格"),
		@Column(name="xpd_return_interval", attrName="xpdReturnInterval", label="回访间隔"),
		@Column(name="xpd_max_stock", attrName="xpdMaxStock", label="最高存量"),
		@Column(name="xpd_safety_stock", attrName="xpdSafetyStock", label="安全存量"),
		@Column(name="xpd_isgift", attrName="xpdIsgift", label="是否赠送"),
		@Column(name="xpd_isdiscountinued", attrName="xpdIsdiscountinued", label="是否停用"),
		@Column(name="xpd_end_sale", attrName="xpdEndSale", label="停止销售"),
		@Column(name="xpd_copy_cost_price", attrName="xpdCopyCostPrice", label="可拷贝成本价格"),
		@Column(name="xpd_remarks", attrName="xpdRemarks", label="产品备注"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="user_code", attrName="userCode", label="用户ID"),
		@Column(name="office_code", attrName="officeCode.cmCode", label="组织ID"),
		@Column(name="state", attrName="state", label="状态"),
	}, orderBy="a.create_date ASC"
)
public class Productinfo extends DataEntity<Productinfo> {
	
	private static final long serialVersionUID = 1L;
	private String productCode;		// 产品编号
	private String productName;		// 产品名称
	private String xpdStatisticalClass;		// 统计分类
	private String xpdDepository;		// 存放仓库
	private String xpdBarCode;		// 条形码
	private String xpdMnemonicCode;		// 助记码
	private String xpdDiscountCategory;		// 折扣类别
	private Date xpdFilingTime;		// 建档时间
	private String xpdStandardUnit;		// 标准单位
	private Double xpdNormPrice;		// 标准价格
	private Long xpdEachContaining;		// 每件含
	private Long xpdTime;		// 可用时间
	private String xpdPurchaseUnit;		// 进货单位
	private Long xpdPurchased;		// 进货成本
	private Long xpdEach;		// 每含单位:件
	private String xpdSupplier;		// 供应商
	private String xpdMarketintUnit;		// 消耗单位
	private Double xpdConsumptionCost;		// 消耗成本
	private Double xpdMarketintCost;		// 销售成本
	private Long xpdQualityTime;		// 保质期
	private String xpdRuleDesccription;		// 规格描述
	private Double xpdMembershipPrices;		// 会员价格
	private Double xpdStorePrice;		// 门店价格
	private Long xpdReturnInterval;		// 回访间隔
	private Long xpdMaxStock;		// 最高存量
	private Long xpdSafetyStock;		// 安全存量
	private String xpdIsgift;		// 是否赠送
	private String xpdIsdiscountinued;		// 是否停用
	private String xpdEndSale;		// 停止销售
	private String xpdCopyCostPrice;		// 可拷贝成本价格
	private String xpdRemarks;		// 产品备注
	private String userCode;		// 用户ID
	private CollectMoney officeCode;		// 组织ID 父类
	private String state;		// 状态
	
	public Productinfo() {
		this(null);
	}


	public Productinfo(CollectMoney officeCode){
		this.officeCode = officeCode;
	}
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	@NotBlank(message="产品名称不能为空")
	@Length(min=0, max=128, message="产品名称长度不能超过 128 个字符")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@NotBlank(message="统计分类不能为空")
	@Length(min=0, max=2, message="统计分类长度不能超过 2 个字符")
	public String getXpdStatisticalClass() {
		return xpdStatisticalClass;
	}

	public void setXpdStatisticalClass(String xpdStatisticalClass) {
		this.xpdStatisticalClass = xpdStatisticalClass;
	}
	
	@NotBlank(message="存放仓库不能为空")
	@Length(min=0, max=2, message="存放仓库长度不能超过 2 个字符")
	public String getXpdDepository() {
		return xpdDepository;
	}

	public void setXpdDepository(String xpdDepository) {
		this.xpdDepository = xpdDepository;
	}
	
	@Length(min=0, max=64, message="条形码长度不能超过 64 个字符")
	public String getXpdBarCode() {
		return xpdBarCode;
	}

	public void setXpdBarCode(String xpdBarCode) {
		this.xpdBarCode = xpdBarCode;
	}
	
	@Length(min=0, max=64, message="助记码长度不能超过 64 个字符")
	public String getXpdMnemonicCode() {
		return xpdMnemonicCode;
	}

	public void setXpdMnemonicCode(String xpdMnemonicCode) {
		this.xpdMnemonicCode = xpdMnemonicCode;
	}
	
	@NotBlank(message="折扣类别不能为空")
	@Length(min=0, max=2, message="折扣类别长度不能超过 2 个字符")
	public String getXpdDiscountCategory() {
		return xpdDiscountCategory;
	}

	public void setXpdDiscountCategory(String xpdDiscountCategory) {
		this.xpdDiscountCategory = xpdDiscountCategory;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="建档时间不能为空")
	public Date getXpdFilingTime() {
		return xpdFilingTime;
	}

	public void setXpdFilingTime(Date xpdFilingTime) {
		this.xpdFilingTime = xpdFilingTime;
	}
	
	@NotBlank(message="标准单位不能为空")
	@Length(min=0, max=2, message="标准单位长度不能超过 2 个字符")
	public String getXpdStandardUnit() {
		return xpdStandardUnit;
	}

	public void setXpdStandardUnit(String xpdStandardUnit) {
		this.xpdStandardUnit = xpdStandardUnit;
	}
	
	@NotNull(message="标准价格不能为空")
	public Double getXpdNormPrice() {
		return xpdNormPrice;
	}

	public void setXpdNormPrice(Double xpdNormPrice) {
		this.xpdNormPrice = xpdNormPrice;
	}
	
	public Long getXpdEachContaining() {
		return xpdEachContaining;
	}

	public void setXpdEachContaining(Long xpdEachContaining) {
		this.xpdEachContaining = xpdEachContaining;
	}
	
	public Long getXpdTime() {
		return xpdTime;
	}

	public void setXpdTime(Long xpdTime) {
		this.xpdTime = xpdTime;
	}
	
	@Length(min=0, max=2, message="进货单位长度不能超过 2 个字符")
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
	
	@Length(min=0, max=2, message="消耗单位长度不能超过 2 个字符")
	public String getXpdMarketintUnit() {
		return xpdMarketintUnit;
	}

	public void setXpdMarketintUnit(String xpdMarketintUnit) {
		this.xpdMarketintUnit = xpdMarketintUnit;
	}
	
	public Double getXpdConsumptionCost() {
		return xpdConsumptionCost;
	}

	public void setXpdConsumptionCost(Double xpdConsumptionCost) {
		this.xpdConsumptionCost = xpdConsumptionCost;
	}
	
	public Double getXpdMarketintCost() {
		return xpdMarketintCost;
	}

	public void setXpdMarketintCost(Double xpdMarketintCost) {
		this.xpdMarketintCost = xpdMarketintCost;
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
	
	public Double getXpdMembershipPrices() {
		return xpdMembershipPrices;
	}

	public void setXpdMembershipPrices(Double xpdMembershipPrices) {
		this.xpdMembershipPrices = xpdMembershipPrices;
	}
	
	public Double getXpdStorePrice() {
		return xpdStorePrice;
	}

	public void setXpdStorePrice(Double xpdStorePrice) {
		this.xpdStorePrice = xpdStorePrice;
	}
	
	public Long getXpdReturnInterval() {
		return xpdReturnInterval;
	}

	public void setXpdReturnInterval(Long xpdReturnInterval) {
		this.xpdReturnInterval = xpdReturnInterval;
	}
	
	public Long getXpdMaxStock() {
		return xpdMaxStock;
	}

	public void setXpdMaxStock(Long xpdMaxStock) {
		this.xpdMaxStock = xpdMaxStock;
	}
	
	public Long getXpdSafetyStock() {
		return xpdSafetyStock;
	}

	public void setXpdSafetyStock(Long xpdSafetyStock) {
		this.xpdSafetyStock = xpdSafetyStock;
	}
	
	@Length(min=0, max=2, message="是否赠送长度不能超过 2 个字符")
	public String getXpdIsgift() {
		return xpdIsgift;
	}

	public void setXpdIsgift(String xpdIsgift) {
		this.xpdIsgift = xpdIsgift;
	}
	
	@Length(min=0, max=2, message="是否停用长度不能超过 2 个字符")
	public String getXpdIsdiscountinued() {
		return xpdIsdiscountinued;
	}

	public void setXpdIsdiscountinued(String xpdIsdiscountinued) {
		this.xpdIsdiscountinued = xpdIsdiscountinued;
	}
	
	@Length(min=0, max=2, message="停止销售长度不能超过 2 个字符")
	public String getXpdEndSale() {
		return xpdEndSale;
	}

	public void setXpdEndSale(String xpdEndSale) {
		this.xpdEndSale = xpdEndSale;
	}
	
	@Length(min=0, max=2, message="可拷贝成本价格长度不能超过 2 个字符")
	public String getXpdCopyCostPrice() {
		return xpdCopyCostPrice;
	}

	public void setXpdCopyCostPrice(String xpdCopyCostPrice) {
		this.xpdCopyCostPrice = xpdCopyCostPrice;
	}
	
	@Length(min=0, max=500, message="产品备注长度不能超过 500 个字符")
	public String getXpdRemarks() {
		return xpdRemarks;
	}

	public void setXpdRemarks(String xpdRemarks) {
		this.xpdRemarks = xpdRemarks;
	}
	
	@Length(min=0, max=64, message="用户ID长度不能超过 64 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@Length(min=0, max=64, message="组织ID长度不能超过 64 个字符")
	public CollectMoney getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(CollectMoney officeCode) {
		this.officeCode = officeCode;
	}
	
	@Length(min=0, max=2, message="状态长度不能超过 2 个字符")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}