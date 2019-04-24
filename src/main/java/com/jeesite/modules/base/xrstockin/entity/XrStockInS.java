/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockin.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * xr_stock_inEntity
 * @author Alex
 * @version 2019-04-24
 */
@Table(name="xr_stock_in_s", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(includeEntity=DataEntity.class),
		@Column(name="xr_stock_in_id", attrName="xrStockIn.id", label="父表主键"),
		@Column(name="product_code", attrName="productCode", label="产品编号"),
		@Column(name="product_name", attrName="productName", label="产品名称", queryType=QueryType.LIKE),
		@Column(name="xpd_supplier", attrName="xpdSupplier", label="供应商"),
		@Column(name="xpd_purchase_unit", attrName="xpdPurchaseUnit", label="单位"),
		@Column(name="xpd_purchased", attrName="xpdPurchased", label="进货成本"),
		@Column(name="number_in", attrName="numberIn", label="数量"),
	}, orderBy="a.create_date ASC"
)
public class XrStockInS extends DataEntity<XrStockInS> {
	
	private static final long serialVersionUID = 1L;
	private XrStockIn xrStockIn;		// 父表主键 父类
	private String productCode;		// 产品编号
	private String productName;		// 产品名称
	private String xpdSupplier;		// 供应商
	private String xpdPurchaseUnit;		// 单位
	private Long xpdPurchased;		// 进货成本
	private Long numberIn;		// 数量
	
	public XrStockInS() {
		this(null);
	}


	public XrStockInS(XrStockIn xrStockIn){
		this.xrStockIn = xrStockIn;
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
	@Length(min=0, max=2, message="供应商长度不能超过 2 个字符")
	public String getXpdSupplier() {
		return xpdSupplier;
	}

	public void setXpdSupplier(String xpdSupplier) {
		this.xpdSupplier = xpdSupplier;
	}
	
	@NotBlank(message="单位不能为空")
	@Length(min=0, max=2, message="单位长度不能超过 2 个字符")
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
	
	@NotNull(message="数量不能为空")
	public Long getNumberIn() {
		return numberIn;
	}

	public void setNumberIn(Long numberIn) {
		this.numberIn = numberIn;
	}

	public XrStockIn getXrStockIn() {
		return xrStockIn;
	}

	public void setXrStockIn(XrStockIn xrStockIn) {
		this.xrStockIn = xrStockIn;
	}
}