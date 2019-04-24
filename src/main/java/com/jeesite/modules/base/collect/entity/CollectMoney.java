/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.collect.entity;

import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import java.util.List;
import com.jeesite.common.collect.ListUtils;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * collectMoneyEntity
 * @author Crysta-hu
 * @version 2019-04-19
 */
@Table(name="collect_money", alias="a", columns={
		@Column(name="cm_code", attrName="cmCode", label="消费单号", isPK=true),
		@Column(name="cm_date", attrName="cmDate", label="消费日期"),
		@Column(name="cm_store_code", attrName="cmStoreCode", label="消费门店编号"),
		@Column(name="cm_store_name", attrName="cmStoreName", label="消费门店名称", queryType=QueryType.LIKE),
		@Column(name="cm_member_card", attrName="cmMemberCard", label="会员卡号"),
		@Column(name="cm_member_type", attrName="cmMemberType", label="会员卡类别"),
		@Column(name="cm_customer_name", attrName="cmCustomerName", label="客户姓名", queryType=QueryType.LIKE),
		@Column(name="cm_customer_sex", attrName="cmCustomerSex", label="客户性别"),
		@Column(name="cm_customer_type", attrName="cmCustomerType", label="客户种类"),
		@Column(name="cm_access_channel", attrName="cmAccessChannel", label="客户进店渠道"),
		@Column(name="cm_customer_phone", attrName="cmCustomerPhone", label="手机号"),
		@Column(name="cm_customer_num", attrName="cmCustomerNum", label="客数"),
		@Column(name="cm_is_member", attrName="cmIsMember", label="是否是会员"),
		@Column(name="cm_member_integrate", attrName="cmMemberIntegrate", label="会员积分"),
		@Column(name="cm_account_type", attrName="cmAccountType", label="账户类别"),
		@Column(name="cm_account_balance", attrName="cmAccountBalance", label="余额"),
		@Column(name="cm_account_debt", attrName="cmAccountDebt", label="欠款"),
		@Column(name="cm_payment_type", attrName="cmPaymentType", label="支付方式"),
		@Column(name="cm_payment_money", attrName="cmPaymentMoney", label="金额"),
		@Column(name="cm_remarks", attrName="cmRemarks", label="备注说明"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="mi_code", attrName="miCode", label="会员编号ID"),
		@Column(name="user_code", attrName="userCode", label="用户ID"),
		@Column(name="office_code", attrName="officeCode", label="组织ID"),
		@Column(name="project_code", attrName="projectCode", label="项目编号"),
		@Column(name="project_name", attrName="projectName", label="项目名称", queryType=QueryType.LIKE),
		@Column(name="xp_norm_price", attrName="xpNormPrice", label="标准价格"),
		@Column(name="product_code", attrName="productCode", label="产品编号"),
		@Column(name="xp_remarks", attrName="xpRemarks", label="备注"),
		@Column(name="product_name", attrName="productName", label="产品名称", queryType=QueryType.LIKE),
	}, orderBy="a.update_date DESC"
)
public class CollectMoney extends DataEntity<CollectMoney> {
	
	private static final long serialVersionUID = 1L;
	private String cmCode;		// 消费单号
	private Date cmDate;		// 消费日期
	private String cmStoreCode;		// 消费门店编号
	private String cmStoreName;		// 消费门店名称
	private String cmMemberCard;		// 会员卡号
	private String cmMemberType;		// 会员卡类别
	private String cmCustomerName;		// 客户姓名
	private String cmCustomerSex;		// 客户性别
	private String cmCustomerType;		// 客户种类
	private String cmAccessChannel;		// 客户进店渠道
	private String cmCustomerPhone;		// 手机号
	private Long cmCustomerNum;		// 客数
	private String cmIsMember;		// 是否是会员
	private String cmMemberIntegrate;		// 会员积分
	private String cmAccountType;		// 账户类别
	private Double cmAccountBalance;		// 余额
	private Double cmAccountDebt;		// 欠款
	private String cmPaymentType;		// 支付方式
	private Long cmPaymentMoney;		// 消费金额
	private String cmRemarks;		// 备注说明
	private String miCode;		// 会员编号ID
	private String userCode;		// 用户ID
	private String officeCode;		// 组织ID
	private String projectCode;		// 项目编号
	private String projectName;		// 项目名称
	private Double xpNormPrice;		// 标准价格
	private String productCode;		// 产品编号
	private String xpRemarks;		// 备注
	private String productName;		// 产品名称
	private List<Projectinfo> xrProjectinfoList = ListUtils.newArrayList();		// 子表列表
	private List<Productinfo> xrProductinfoList = ListUtils.newArrayList();		// 子表列表
	
	public CollectMoney() {
		this(null);
	}

	public CollectMoney(String id){
		super(id);
	}
	
	public String getCmCode() {
		return cmCode;
	}

	public void setCmCode(String cmCode) {
		this.cmCode = cmCode;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getCmDate() {
		return cmDate;
	}

	public void setCmDate(Date cmDate) {
		this.cmDate = cmDate;
	}
	
	@Length(min=0, max=128, message="消费门店编号长度不能超过 128 个字符")
	public String getCmStoreCode() {
		return cmStoreCode;
	}

	public void setCmStoreCode(String cmStoreCode) {
		this.cmStoreCode = cmStoreCode;
	}

	public String getCmStoreName() {
		return cmStoreName;
	}

	public void setCmStoreName(String cmStoreName) {
		this.cmStoreName = cmStoreName;
	}
	
	public String getCmMemberCard() {
		return cmMemberCard;
	}

	public void setCmMemberCard(String cmMemberCard) {
		this.cmMemberCard = cmMemberCard;
	}
	
	@Length(min=0, max=2, message="会员卡类别长度不能超过 2 个字符")
	public String getCmMemberType() {
		return cmMemberType;
	}

	public void setCmMemberType(String cmMemberType) {
		this.cmMemberType = cmMemberType;
	}
	
	@Length(min=0, max=128, message="客户姓名长度不能超过 128 个字符")
	public String getCmCustomerName() {
		return cmCustomerName;
	}

	public void setCmCustomerName(String cmCustomerName) {
		this.cmCustomerName = cmCustomerName;
	}
	
	@Length(min=0, max=2, message="客户性别长度不能超过 2 个字符")
	public String getCmCustomerSex() {
		return cmCustomerSex;
	}

	public void setCmCustomerSex(String cmCustomerSex) {
		this.cmCustomerSex = cmCustomerSex;
	}
	
	@Length(min=0, max=2, message="客户种类长度不能超过 2 个字符")
	public String getCmCustomerType() {
		return cmCustomerType;
	}

	public void setCmCustomerType(String cmCustomerType) {
		this.cmCustomerType = cmCustomerType;
	}

	public String getCmAccessChannel() {
		return cmAccessChannel;
	}

	public void setCmAccessChannel(String cmAccessChannel) {
		this.cmAccessChannel = cmAccessChannel;
	}
	
	public String getCmCustomerPhone() {
		return cmCustomerPhone;
	}

	public void setCmCustomerPhone(String cmCustomerPhone) {
		this.cmCustomerPhone = cmCustomerPhone;
	}
	
	public Long getCmCustomerNum() {
		return cmCustomerNum;
	}

	public void setCmCustomerNum(Long cmCustomerNum) {
		this.cmCustomerNum = cmCustomerNum;
	}
	
	@Length(min=0, max=2, message="是否是会员长度不能超过 2 个字符")
	public String getCmIsMember() {
		return cmIsMember;
	}

	public void setCmIsMember(String cmIsMember) {
		this.cmIsMember = cmIsMember;
	}
	
	@Length(min=0, max=20, message="会员积分长度不能超过 20 个字符")
	public String getCmMemberIntegrate() {
		return cmMemberIntegrate;
	}

	public void setCmMemberIntegrate(String cmMemberIntegrate) {
		this.cmMemberIntegrate = cmMemberIntegrate;
	}
	
	@Length(min=0, max=20, message="账户类别长度不能超过 20 个字符")
	public String getCmAccountType() {
		return cmAccountType;
	}

	public void setCmAccountType(String cmAccountType) {
		this.cmAccountType = cmAccountType;
	}
	
	public Double getCmAccountBalance() {
		return cmAccountBalance;
	}

	public void setCmAccountBalance(Double cmAccountBalance) {
		this.cmAccountBalance = cmAccountBalance;
	}
	
	public Double getCmAccountDebt() {
		return cmAccountDebt;
	}

	public void setCmAccountDebt(Double cmAccountDebt) {
		this.cmAccountDebt = cmAccountDebt;
	}
	
	@Length(min=0, max=2, message="支付方式长度不能超过 2 个字符")
	public String getCmPaymentType() {
		return cmPaymentType;
	}

	public void setCmPaymentType(String cmPaymentType) {
		this.cmPaymentType = cmPaymentType;
	}
	
	public Long getCmPaymentMoney() {
		return cmPaymentMoney;
	}

	public void setCmPaymentMoney(Long cmPaymentMoney) {
		this.cmPaymentMoney = cmPaymentMoney;
	}
	
	@Length(min=0, max=500, message="备注说明长度不能超过 500 个字符")
	public String getCmRemarks() {
		return cmRemarks;
	}

	public void setCmRemarks(String cmRemarks) {
		this.cmRemarks = cmRemarks;
	}
	
	@Length(min=0, max=64, message="会员编号ID长度不能超过 64 个字符")
	public String getMiCode() {
		return miCode;
	}

	public void setMiCode(String miCode) {
		this.miCode = miCode;
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
	
	@Length(min=0, max=64, message="项目编号长度不能超过 64 个字符")
	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	@Length(min=0, max=128, message="项目名称长度不能超过 128 个字符")
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public Double getXpNormPrice() {
		return xpNormPrice;
	}

	public void setXpNormPrice(Double xpNormPrice) {
		this.xpNormPrice = xpNormPrice;
	}
	
	@Length(min=0, max=64, message="产品编号长度不能超过 64 个字符")
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	@Length(min=0, max=500, message="备注长度不能超过 500 个字符")
	public String getXpRemarks() {
		return xpRemarks;
	}

	public void setXpRemarks(String xpRemarks) {
		this.xpRemarks = xpRemarks;
	}
	
	@Length(min=0, max=128, message="产品名称长度不能超过 128 个字符")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public List<Projectinfo> getXrProjectinfoList() {
		return xrProjectinfoList;
	}

	public void setXrProjectinfoList(List<Projectinfo> xrProjectinfoList) {
		this.xrProjectinfoList = xrProjectinfoList;
	}
	
	public List<Productinfo> getXrProductinfoList() {
		return xrProductinfoList;
	}

	public void setXrProductinfoList(List<Productinfo> xrProductinfoList) {
		this.xrProductinfoList = xrProductinfoList;
	}
	
}