/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockcontrol.entity;

import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.modules.base.productinfo.entity.XrProductinfo;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * xr_stock_controlEntity
 * @author Alex
 * @version 2019-04-23
 */
@Table(name="xr_stock_control", alias="a", columns={
		@Column(includeEntity=DataEntity.class),
		@Column(name="user_code", attrName="userCode", label="用户ID"),
		@Column(name="office_code", attrName="officeCode", label="组织ID"),
		@Column(name="product_code", attrName="productCode", label="产品编号", isPK=true),
		@Column(name="quan", attrName="quan", label="库存数量"),
		@Column(name="number_in", attrName="numberIn", label="入库数量"),
		@Column(name="number_out", attrName="numberOut", label="出库数量"),
	},
		// 支持联合查询，如左右连接查询，支持设置查询自定义关联表的返回字段列
		joinTable={
				@JoinTable(type= JoinTable.Type.JOIN, entity=XrProductinfo.class, alias="o",
						on="o.product_code = a.product_code",
						columns={@Column(includeEntity=XrProductinfo.class)})
		}, orderBy="a.update_date DESC"
)
public class XrStockControl extends DataEntity<XrStockControl> {
	
	private static final long serialVersionUID = 1L;
	private String userCode;		// 用户ID
	private String officeCode;		// 组织ID
	private String productCode;		// 产品编号
	private Long quan;		// 库存数量
	private Long numberIn;		// 入库数量
	private Long numberOut;		// 出库数量
	private XrProductinfo xrProductinfo;
	
	public XrStockControl() {
		this(null);
	}

	public XrStockControl(String id){
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
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	@NotNull(message="库存数量不能为空")
	public Long getQuan() {
		return quan;
	}

	public void setQuan(Long quan) {
		this.quan = quan;
	}
	
	@NotNull(message="入库数量不能为空")
	public Long getNumberIn() {
		return numberIn;
	}

	public void setNumberIn(Long numberIn) {
		this.numberIn = numberIn;
	}
	
	@NotNull(message="出库数量不能为空")
	public Long getNumberOut() {
		return numberOut;
	}

	public void setNumberOut(Long numberOut) {
		this.numberOut = numberOut;
	}

	@NotNull(
			message = "产品信息不能为空"
	)
	public XrProductinfo getXrProductinfo() {
		return xrProductinfo;
	}

	public void setXrProductinfo(XrProductinfo xrProductinfo) {
		this.xrProductinfo = xrProductinfo;
	}
}