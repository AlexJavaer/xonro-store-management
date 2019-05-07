/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockout.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import java.util.List;
import com.jeesite.common.collect.ListUtils;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * xr_stock_outEntity
 * @author Crysta-hu
 * @version 2019-04-30
 */
@Table(name="xr_stock_out", alias="a", columns={
		@Column(name="id", attrName="id", label="出库单号", isPK=true),
		@Column(includeEntity=DataEntity.class),
		@Column(name="user_code", attrName="userCode", label="用户ID"),
		@Column(name="user_name", attrName="userName", label="用户名称", queryType=QueryType.LIKE),
		@Column(name="office_code", attrName="officeCode", label="机构ID"),
		@Column(name="office_name", attrName="officeName", label="机构名称", queryType=QueryType.LIKE),
		@Column(name="stock_type", attrName="stockType", label="出库状态"),
	}, orderBy="a.update_date DESC"
)
public class XrStockOut extends DataEntity<XrStockOut> {
	
	private static final long serialVersionUID = 1L;
	private String userCode;		// 用户ID
	private String userName;		// 用户名称
	private String officeCode;		// 机构ID
	private String officeName;		// 机构名称
	private String stockType;       //出库状态
	private List<XrStockOutS> xrStockOutSList = ListUtils.newArrayList();		// 子表列表
	
	public XrStockOut() {
		this(null);
	}

	public XrStockOut(String id){
		super(id);
	}

	@Length(min=0, max=64, message="用户ID长度不能超过 64 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@NotBlank(message="用户名称不能为空")
	@Length(min=0, max=128, message="用户名称长度不能超过 128 个字符")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Length(min=0, max=64, message="机构ID长度不能超过 64 个字符")
	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	
	@NotBlank(message="机构名称不能为空")
	@Length(min=0, max=255, message="机构名称长度不能超过 255 个字符")
	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	
	public List<XrStockOutS> getXrStockOutSList() {
		return xrStockOutSList;
	}

	public void setXrStockOutSList(List<XrStockOutS> xrStockOutSList) {
		this.xrStockOutSList = xrStockOutSList;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
}