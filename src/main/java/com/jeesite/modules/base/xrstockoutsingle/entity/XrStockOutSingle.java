/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockoutsingle.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * xr_stock_out_singleEntity
 * @author Crysta-hu
 * @version 2019-05-06
 */
@Table(name="xr_stock_out_single", alias="a",extWhereKeys="dsf", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(includeEntity=DataEntity.class),
		@Column(name="product_code", attrName="productCode", label="产品编号"),
		@Column(name="product_name", attrName="productName", label="产品名称", queryType=QueryType.LIKE),
		@Column(name="xpd_supplier", attrName="xpdSupplier", label="供应商"),
		@Column(name="xpd_purchase_unit", attrName="xpdPurchaseUnit", label="单位"),
		@Column(name="xpd_purchased", attrName="xpdPurchased", label="进货成本"),
		@Column(name="xpd_stock_num", attrName="xpdStockNum", label="库存数量"),
		@Column(name="number_out", attrName="numberOut", label="出库数量"),
		@Column(name="user_name", attrName="userName", label="用户昵称", queryType=QueryType.LIKE),
		@Column(name="user_code", attrName="userCode", label="用户ID"),
		@Column(name="office_name", attrName="officeName", label="组织名称", queryType=QueryType.LIKE),
		@Column(name="office_code", attrName="officeCode", label="组织ID"),
	}, orderBy="a.update_date DESC"
)
public class XrStockOutSingle extends DataEntity<XrStockOutSingle> {
	
	private static final long serialVersionUID = 1L;
	private String productCode;		// 产品编号
	private String productName;		// 产品名称
	private String xpdSupplier;		// 供应商
	private String xpdPurchaseUnit;		// 单位
	private Long xpdPurchased;		// 进货成本
	private Long xpdStockNum;		// 库存数量
	private Long numberOut;		// 出库数量
	private String userName;		// 用户昵称
	private String userCode;		// 用户ID
	private String officeName;		// 组织名称
	private String officeCode;		// 组织ID
	
	public XrStockOutSingle() {
		this(null);
	}

	public XrStockOutSingle(String id){
		super(id);
	}
	
	@NotBlank(message="产品编号不能为空")
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
	
	@NotBlank(message="供应商不能为空")
	@Length(min=0, max=5, message="供应商长度不能超过 5 个字符")
	public String getXpdSupplier() {
		return xpdSupplier;
	}

	public void setXpdSupplier(String xpdSupplier) {
		this.xpdSupplier = xpdSupplier;
	}
	
	@NotBlank(message="单位不能为空")
	@Length(min=0, max=5, message="单位长度不能超过 5 个字符")
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

	public Long getXpdStockNum() {
		return xpdStockNum;
	}

	public void setXpdStockNum(Long xpdStockNum) {
		this.xpdStockNum = xpdStockNum;
	}

	public Long getNumberOut() {
		return numberOut;
	}

	public void setNumberOut(Long numberOut) {
		this.numberOut = numberOut;
	}
	
	@Length(min=0, max=128, message="用户昵称长度不能超过 128 个字符")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Length(min=0, max=64, message="用户ID长度不能超过 64 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@Length(min=0, max=128, message="组织名称长度不能超过 128 个字符")
	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	
	@Length(min=0, max=64, message="组织ID长度不能超过 64 个字符")
	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	
}