/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstocklog.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * xr_stock_logEntity
 * @author Crysta-hu
 * @version 2019-05-05
 */
@Table(name="xr_stock_log", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(includeEntity=DataEntity.class),
		@Column(name="user_code", attrName="userCode", label="用户ID"),
		@Column(name="office_code", attrName="officeCode", label="组织ID"),
		@Column(name="stock_type", attrName="stockType", label="库存类型"),
		@Column(name="stock_in_no", attrName="stockInNo", label="入库单号"),
		@Column(name="stock_in_date", attrName="stockInDate", label="入库时间"),
		@Column(name="stock_out_no", attrName="stockOutNo", label="出库单号"),
		@Column(name="stock_out_date", attrName="stockOutDate", label="出库时间"),
		@Column(name="product_code", attrName="productCode", label="产品编号"),
		@Column(name="product_name", attrName="productName", label="产品名称", queryType=QueryType.LIKE),
		@Column(name="number_in", attrName="numberIn", label="入库数量"),
		@Column(name="number_out", attrName="numberOut", label="出库数量"),
	}, orderBy="a.update_date DESC"
)
public class XrStockLog extends DataEntity<XrStockLog> {
	
	private static final long serialVersionUID = 1L;
	private String userCode;		// 用户ID
	private String officeCode;		// 组织ID
	private String stockType;		// 库存类型
	private String stockInNo;		// 入库单号
	private Date stockInDate;		// 入库时间
	private String stockOutNo;		// 出库单号
	private Date stockOutDate;		// 出库时间
	private String productCode;		// 产品编号
	private String productName;		// 产品名称
	private Long numberIn;		// 入库数量
	private Long numberOut;		// 出库数量
	
	public XrStockLog() {
		this(null);
	}

	public XrStockLog(String id){
		super(id);
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
	
	@Length(min=0, max=255, message="库存类型长度不能超过 255 个字符")
	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	
	@NotBlank(message="入库单号不能为空")
	@Length(min=0, max=64, message="入库单号长度不能超过 64 个字符")
	public String getStockInNo() {
		return stockInNo;
	}

	public void setStockInNo(String stockInNo) {
		this.stockInNo = stockInNo;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="入库时间不能为空")
	public Date getStockInDate() {
		return stockInDate;
	}

	public void setStockInDate(Date stockInDate) {
		this.stockInDate = stockInDate;
	}
	
	@NotBlank(message="出库单号不能为空")
	@Length(min=0, max=64, message="出库单号长度不能超过 64 个字符")
	public String getStockOutNo() {
		return stockOutNo;
	}

	public void setStockOutNo(String stockOutNo) {
		this.stockOutNo = stockOutNo;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStockOutDate() {
		return stockOutDate;
	}

	public void setStockOutDate(Date stockOutDate) {
		this.stockOutDate = stockOutDate;
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
	
	public Long getNumberIn() {
		return numberIn;
	}

	public void setNumberIn(Long numberIn) {
		this.numberIn = numberIn;
	}
	
	public Long getNumberOut() {
		return numberOut;
	}

	public void setNumberOut(Long numberOut) {
		this.numberOut = numberOut;
	}
	
}