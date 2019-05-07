/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockinsingle.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * xr_stock_in_singleEntity
 * @author Crysta-hu
 * @version 2019-05-06
 */
@Table(name="xr_stock_in_single", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(includeEntity=DataEntity.class),
		@Column(name="product_code", attrName="productCode", label="产品编号"),
		@Column(name="product_name", attrName="productName", label="产品名称", queryType=QueryType.LIKE),
		@Column(name="xpd_supplier", attrName="xpdSupplier", label="供应商"),
		@Column(name="xpd_purchase_unit", attrName="xpdPurchaseUnit", label="单位"),
		@Column(name="xpd_purchased", attrName="xpdPurchased", label="进货成本"),
		@Column(name="xpd_stock_num", attrName="xpdStockNum", label="库存数量"),
		@Column(name="number_in", attrName="numberIn", label="入库数量"),
		@Column(name="user_code", attrName="userCode", label="用户ID"),
		@Column(name="office_code", attrName="officeCode", label="组织ID"),
		@Column(name="user_name", attrName="userName", label="操作者"),
		@Column(name="office_name", attrName="officeName", label="操作者组织"),
	}, orderBy="a.update_date DESC"
)
public class XrStockInSingle extends DataEntity<XrStockInSingle> {
	
	private static final long serialVersionUID = 1L;
	private String productCode;		// 产品编号
	private String productName;		// 产品名称
	private String xpdSupplier;		// 供应商
	private String xpdPurchaseUnit;		// 单位01:件
	private Long xpdPurchased;		// 进货成本
	private Long xpdStockNum;		// 库存数量
	private Long numberIn;		// 数量

	private String userCode;		// 用户ID
	private String officeCode;		// 组织ID
	private String userName; //操作者
	private String officeName; //操作者组织
	
	public XrStockInSingle() {
		this(null);
	}

	public XrStockInSingle(String id){
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
	
	@Length(min=0, max=300, message="产品名称长度不能超过 300 个字符")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@NotBlank(message="供应商不能为空")
	@Length(min=0, max=2, message="供应商长度不能超过 2 个字符")
	public String getXpdSupplier() {
		return xpdSupplier;
	}

	public void setXpdSupplier(String xpdSupplier) {
		this.xpdSupplier = xpdSupplier;
	}
	
	@NotBlank(message="单位01不能为空")
	@Length(min=0, max=2, message="单位01长度不能超过 2 个字符")
	public String getXpdPurchaseUnit() {
		return xpdPurchaseUnit;
	}

	public void setXpdPurchaseUnit(String xpdPurchaseUnit) {
		this.xpdPurchaseUnit = xpdPurchaseUnit;
	}
	
	@NotNull(message="进货成本不能为空")
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

	@NotNull(message="数量不能为空")
	public Long getNumberIn() {
		return numberIn;
	}

	public void setNumberIn(Long numberIn) {
		this.numberIn = numberIn;
	}

	public String getUserCode() {
		return userCode;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public String getUserName() {
		return userName;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
}