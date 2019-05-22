/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.productinfo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * xr_productinfoEntity
 * @author Crysta-hu
 * @version 2019-04-04
 */
@Table(name="xr_productinfo", alias="a",extWhereKeys="dsf", columns={
		@Column(name="product_code", attrName="productCode", label="产品编号", isPK=true),
		@Column(name="product_name", attrName="productName", label="产品名称", queryType=QueryType.LIKE),
		@Column(name="xpd_statistical_class", attrName="xpdStatisticalClass", label="统计分类"),
		@Column(name="xpd_depository", attrName="xpdDepository", label="存放仓库"),
		@Column(name="xpd_bar_code", attrName="xpdBarCode", label="条形码"),
		@Column(name="xpd_mnemonic_code", attrName="xpdMnemonicCode", label="助记码"),
		@Column(name="xpd_discount_category", attrName="xpdDiscountCategory", label="折扣类别"),
		@Column(name="xpd_filing_time", attrName="xpdFilingTime", label="建档时间"),
		@Column(name="xpd_purchase_unit", attrName="xpdPurchaseUnit", label="单位"),
		@Column(name="xpd_purchased", attrName="xpdPurchased", label="进货成本"),
		@Column(name="xpd_each", attrName="xpdEach", label="每含单位", comment="每含单位:件"),
		@Column(name="xpd_supplier", attrName="xpdSupplier", label="供应商"),
		@Column(name="xpd_quality_time", attrName="xpdQualityTime", label="保质期"),
		@Column(name="xpd_rule_desccription", attrName="xpdRuleDesccription", label="规格描述"),
		@Column(name="xpd_membership_prices", attrName="xpdMembershipPrices", label="会员价格"),
		@Column(name="xpd_store_price", attrName="xpdStorePrice", label="门店价格"),
		@Column(name="xpd_stock_num", attrName="xpdStockNum", label="库存数量"),
		@Column(name="xpd_isgift", attrName="xpdIsgift", label="是否赠送"),
		@Column(name="xpd_isdiscountinued", attrName="xpdIsdiscountinued", label="是否停用"),
		@Column(name="xpd_end_sale", attrName="xpdEndSale", label="停止销售"),
		@Column(name="xpd_remarks", attrName="xpdRemarks", label="产品备注"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="user_code", attrName="userCode", label="用户ID"),
		@Column(name="office_code", attrName="officeCode", label="组织ID"),
		@Column(name="user_name", attrName="userName", label="操作者"),
		@Column(name="office_name", attrName="officeName", label="操作者组织"),
	}, orderBy="a.update_date DESC"
)

@SuppressWarnings("all")
public class XrProductinfo extends DataEntity<XrProductinfo> {
	
	private static final long serialVersionUID = 1L;
	private String productCode;		// 产品编号
	private String productName;		// 产品名称
	private String xpdStatisticalClass;		// 统计分类
	private String xpdDepository;		// 存放仓库
	private String xpdBarCode;		// 条形码
	private String xpdMnemonicCode;		// 助记码
	private String xpdDiscountCategory;		// 折扣类别
	private Date xpdFilingTime;		// 建档时间
	private String xpdPurchaseUnit;		// 进货单位
	private Long xpdPurchased;		// 进货成本
	private Long xpdEach;		// 每含单位:件
	private String xpdSupplier;		// 供应商
	private Long xpdQualityTime;		// 保质期
	private String xpdRuleDesccription;		// 规格描述
	private Double xpdMembershipPrices;		// 会员价格
	private Double xpdStorePrice;		// 门店价格
	private Long xpdStockNum;		// 库存数量
	private String xpdIsgift;		// 是否赠送
	private String xpdIsdiscountinued;		// 是否停用
	private String xpdEndSale;		// 停止销售
	private String xpdRemarks;		// 产品备注
	private String userCode;		// 用户ID
	private String officeCode;		// 组织ID
	private String userName; //操作者
	private String officeName; //操作者组织
	
	public XrProductinfo() {
		this(null);
	}

	public XrProductinfo(String id){
		super(id);
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
/*	@Length(min=0, max=2, message="统计分类长度不能超过 5 个字符")*/
	public String getXpdStatisticalClass() {
		return xpdStatisticalClass;
	}

	public void setXpdStatisticalClass(String xpdStatisticalClass) {
		this.xpdStatisticalClass = xpdStatisticalClass;
	}
	
	@NotBlank(message="存放仓库不能为空")
	@Length(min=0, max=2, message="存放仓库长度不能超过 5 个字符")
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
	@Length(min=0, max=2, message="折扣类别长度不能超过5 个字符")
	public String getXpdDiscountCategory() {
		return xpdDiscountCategory;
	}

	public void setXpdDiscountCategory(String xpdDiscountCategory) {
		this.xpdDiscountCategory = xpdDiscountCategory;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="建档时间不能为空")
	public Date getXpdFilingTime() {
		return xpdFilingTime;
	}

	public void setXpdFilingTime(Date xpdFilingTime) {
		this.xpdFilingTime = xpdFilingTime;
	}
	
	@Length(min=0, max=2, message="进货单位长度不能超过 5个字符")
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

	public Long getXpdStockNum() {
		return xpdStockNum;
	}

	public void setXpdStockNum(Long xpdStockNum) {
		this.xpdStockNum = xpdStockNum;
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
	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOfficeName() {
		return officeName;
	}



	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
}