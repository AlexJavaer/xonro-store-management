/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockin.entity;

import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.modules.sys.entity.Office;
import com.jeesite.modules.sys.entity.User;
import org.hibernate.validator.constraints.Length;
import java.util.List;
import com.jeesite.common.collect.ListUtils;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * xr_stock_inEntity
 * @author Alex
 * @version 2019-04-24
 */
@Table(name="xr_stock_in", alias="a", columns={
		@Column(name="id", attrName="id", label="入库单号", isPK=true),
		@Column(includeEntity=DataEntity.class),
		@Column(name="user_code", attrName="userCode", label="用户ID"),
		@Column(name="office_code", attrName="officeCode", label="组织ID"),
		@Column(name="user_name", attrName="userName", label="操作者"),
		@Column(name="office_name", attrName="officeName", label="操作者组织"),
		@Column(name="stock_type", attrName="stockType", label="入库状态"),
	},
	 orderBy="a.update_date DESC"
)
public class XrStockIn extends DataEntity<XrStockIn> {
	
	private static final long serialVersionUID = 1L;
	private String userCode;		// 用户ID
	private String officeCode;		// 组织ID
	private List<XrStockInS> xrStockInSList = ListUtils.newArrayList();		// 子表列表
	private String userName; //操作者
	private String officeName; //操作者组织
	private String stockType;//入库状态

	public XrStockIn() {
		this(null);
	}

	public XrStockIn(String id){
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
	
	public List<XrStockInS> getXrStockInSList() {
		return xrStockInSList;
	}

	public void setXrStockInSList(List<XrStockInS> xrStockInSList) {
		this.xrStockInSList = xrStockInSList;
	}

	@Length(min=0, max=100, message="操作者长度不能超过 64 个字符")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Length(min=0, max=100, message="操作者组织长度不能超过 64 个字符")
	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
}