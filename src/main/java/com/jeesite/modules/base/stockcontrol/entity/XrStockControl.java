/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.stockcontrol.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * stockControlEntity
 * @author Crysta-hu
 * @version 2019-04-10
 */
@Table(name="xr_stock_control", alias="a",extWhereKeys="dsf", columns={
		@Column(name="matter_code", attrName="matterCode", label="物料编号", isPK=true),
		@Column(name="matter_name", attrName="matterName", label="物料名称", queryType=QueryType.LIKE),
		@Column(name="xsc_in_time", attrName="xscInTime", label="入库时间"),
		@Column(name="xsc_in_numr", attrName="xscInNumr", label="入库数量"),
		@Column(name="xsc_in_emp", attrName="xscInEmp", label="入库员工姓名"),
		@Column(name="xsc_in_current_num", attrName="xscInCurrentNum", label="当前库存"),
		@Column(name="xsc_in_new_num", attrName="xscInNewNum", label="最新库存"),
		@Column(name="xsc_out_emp", attrName="xscOutEmp", label="物料领用人"),
		@Column(name="xsc_out_time", attrName="xscOutTime", label="物料领用日期"),
		@Column(name="xsc_out_num", attrName="xscOutNum", label="领用数量"),
		@Column(name="xsc_out_current_num", attrName="xscOutCurrentNum", label="当前存量"),
		@Column(name="xsc_out_new_num", attrName="xscOutNewNum", label="最新存量"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="user_code", attrName="userCode", label="用户ID"),
		@Column(name="office_code", attrName="officeCode", label="组织ID"),
		@Column(name="product_name", attrName="productName", label="产品名称", queryType=QueryType.LIKE),
		@Column(name="product_code", attrName="productCode", label="产品编号"),
		@Column(name="xpd_statistical_class", attrName="xpdStatisticalClass", label="统计分类"),
		@Column(name="xpd_depository", attrName="xpdDepository", label="存放仓库"),
		@Column(name="xpd_max_stock", attrName="xpdMaxStock", label="最高存量"),
		@Column(name="xpd_safety_stock", attrName="xpdSafetyStock", label="安全存量"),
	}, orderBy="a.update_date DESC"
)
public class XrStockControl extends DataEntity<XrStockControl> {
	
	private static final long serialVersionUID = 1L;
	private String matterCode;		// 物料编号
	private String matterName;		// 物料名称
	private Date xscInTime;		// 入库时间
	private Long xscInNumr;		// 入库数量
	private String xscInEmp;		// 入库员工姓名
	private Long xscInCurrentNum;		// 当前库存
	private Long xscInNewNum;		// 最新库存
	private String xscOutEmp;		// 物料领用人
	private Date xscOutTime;		// 物料领用日期
	private Long xscOutNum;		// 领用数量
	private Long xscOutCurrentNum;		// 当前存量
	private Long xscOutNewNum;		// 最新存量
	private String userCode;		// 用户ID
	private String officeCode;		// 组织ID
	private String productName;		// 产品名称
	private String productCode;		// 产品编号
	private String xpdStatisticalClass;		// 统计分类
	private String xpdDepository;		// 存放仓库
	private Long xpdMaxStock;		// 最高存量
	private Long xpdSafetyStock;		// 安全存量
	
	public XrStockControl() {
		this(null);
	}

	public XrStockControl(String id){
		super(id);
	}
	
	public String getMatterCode() {
		return matterCode;
	}

	public void setMatterCode(String matterCode) {
		this.matterCode = matterCode;
	}
	
	@NotBlank(message="物料名称不能为空")
	@Length(min=0, max=128, message="物料名称长度不能超过 128 个字符")
	public String getMatterName() {
		return matterName;
	}

	public void setMatterName(String matterName) {
		this.matterName = matterName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getXscInTime() {
		return xscInTime;
	}

	public void setXscInTime(Date xscInTime) {
		this.xscInTime = xscInTime;
	}
	
	public Long getXscInNumr() {
		return xscInNumr;
	}

	public void setXscInNumr(Long xscInNumr) {
		this.xscInNumr = xscInNumr;
	}
	
	@Length(min=0, max=128, message="入库员工姓名长度不能超过 128 个字符")
	public String getXscInEmp() {
		return xscInEmp;
	}

	public void setXscInEmp(String xscInEmp) {
		this.xscInEmp = xscInEmp;
	}
	
	public Long getXscInCurrentNum() {
		return xscInCurrentNum;
	}

	public void setXscInCurrentNum(Long xscInCurrentNum) {
		this.xscInCurrentNum = xscInCurrentNum;
	}
	
	public Long getXscInNewNum() {
		return xscInNewNum;
	}

	public void setXscInNewNum(Long xscInNewNum) {
		this.xscInNewNum = xscInNewNum;
	}
	
	@Length(min=0, max=128, message="物料领用人长度不能超过 128 个字符")
	public String getXscOutEmp() {
		return xscOutEmp;
	}

	public void setXscOutEmp(String xscOutEmp) {
		this.xscOutEmp = xscOutEmp;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getXscOutTime() {
		return xscOutTime;
	}

	public void setXscOutTime(Date xscOutTime) {
		this.xscOutTime = xscOutTime;
	}
	
	public Long getXscOutNum() {
		return xscOutNum;
	}

	public void setXscOutNum(Long xscOutNum) {
		this.xscOutNum = xscOutNum;
	}
	
	public Long getXscOutCurrentNum() {
		return xscOutCurrentNum;
	}

	public void setXscOutCurrentNum(Long xscOutCurrentNum) {
		this.xscOutCurrentNum = xscOutCurrentNum;
	}
	
	public Long getXscOutNewNum() {
		return xscOutNewNum;
	}

	public void setXscOutNewNum(Long xscOutNewNum) {
		this.xscOutNewNum = xscOutNewNum;
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
	
	@Length(min=0, max=128, message="产品名称长度不能超过 128 个字符")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Length(min=0, max=64, message="产品编号长度不能超过 64 个字符")
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	@Length(min=0, max=64, message="统计分类长度不能超过 64 个字符")
	public String getXpdStatisticalClass() {
		return xpdStatisticalClass;
	}

	public void setXpdStatisticalClass(String xpdStatisticalClass) {
		this.xpdStatisticalClass = xpdStatisticalClass;
	}
	
	@Length(min=0, max=64, message="存放仓库长度不能超过 64 个字符")
	public String getXpdDepository() {
		return xpdDepository;
	}

	public void setXpdDepository(String xpdDepository) {
		this.xpdDepository = xpdDepository;
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
	
}