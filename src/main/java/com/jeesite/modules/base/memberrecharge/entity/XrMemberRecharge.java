/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.memberrecharge.entity;

import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * memberRechargeEntity
 * @author Crysta-hu
 * @version 2019-04-09
 */
@Table(name="xr_member_recharge", alias="a", columns={
		@Column(name="xmr_code", attrName="xmrCode", label="异地单号", isPK=true),
		@Column(name="xmr_date", attrName="xmrDate", label="异动日期"),
		@Column(name="mi_card_number", attrName="miCardNumber", label="会员卡号"),
		@Column(name="mi_card_type", attrName="miCardType", label="卡类别"),
		@Column(name="mi_code", attrName="miCode", label="会员编号"),
		@Column(name="mi_name", attrName="miName", label="会员姓名", queryType=QueryType.LIKE),
		@Column(name="xmr_account_type", attrName="xmrAccountType", label="账户类别"),
		@Column(name="mi_outlets", attrName="miOutlets", label="进店渠道"),
		@Column(name="transaction_mode", attrName="transactionMode", label="异动方式"),
		@Column(name="xmr_reserve_value", attrName="xmrReserveValue", label="储值应收"),
		@Column(name="xmr_save_money", attrName="xmrSaveMoney", label="储值金额"),
		@Column(name="xmr_produce_project_amount", attrName="xmrProduceProjectAmount", label="品项金额"),
		@Column(name="xmr_package_amount", attrName="xmrPackageAmount", label="套餐金额"),
		@Column(name="xmr_gift_account", attrName="xmrGiftAccount", label="赠送账户"),
		@Column(name="xmr_donation_amout", attrName="xmrDonationAmout", label="赠送金额"),
		@Column(name="xmr_current_balance", attrName="xmrCurrentBalance", label="当前余额"),
		@Column(name="xmr_latest_balance", attrName="xmrLatestBalance", label="最新余额"),
		@Column(name="xmr_payment_mode", attrName="xmrPaymentMode", label="支付方式"),
		@Column(name="xmr_recharge_valid_time", attrName="xmrRechargeValidTime", label="充值有效日期"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="user_code", attrName="userCode", label="用户ID"),
		@Column(name="office_code", attrName="officeCode", label="组织ID"),
		@Column(name="xmr_status", attrName="xmrStatus", label="状态"),
		@Column(name="xs_code", attrName="xsCode", label="门店编号"),
		@Column(name="xs_full_name", attrName="xsFullName", label="门店名称", queryType=QueryType.LIKE),
	}, orderBy="a.update_date DESC"
)
public class XrMemberRecharge extends DataEntity<XrMemberRecharge> {
	
	private static final long serialVersionUID = 1L;
	private String xmrCode;		// 异地单号
	private Date xmrDate;		// 异动日期
	private Long miCardNumber;		// 会员卡号
	private String miCardType;		// 卡类别
	private String miCode;		// 会员编号
	private String miName;		// 会员姓名
	private String xmrAccountType;		// 账户类别
	private String miOutlets;		// 进店渠道
	private String transactionMode;		// 异动方式
	private Long xmrReserveValue;		// 储值应收
	private Long xmrSaveMoney;		// 储值金额
	private Long xmrProduceProjectAmount;		// 品项金额
	private Long xmrPackageAmount;		// 套餐金额
	private Long xmrGiftAccount;		// 赠送账户
	private Long xmrDonationAmout;		// 赠送金额
	private Long xmrCurrentBalance;		// 当前余额
	private Long xmrLatestBalance;		// 最新余额
	private String xmrPaymentMode;		// 支付方式
	private Date xmrRechargeValidTime;		// 充值有效日期
	private String userCode;		// 用户ID
	private String officeCode;		// 组织ID
	private String xmrStatus;		// 状态
	private String xsCode;		// 门店编号
	private String xsFullName;		// 门店名称
	
	public XrMemberRecharge() {
		this(null);
	}

	public XrMemberRecharge(String id){
		super(id);
	}
	
	public String getXmrCode() {
		return xmrCode;
	}

	public void setXmrCode(String xmrCode) {
		this.xmrCode = xmrCode;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getXmrDate() {
		return xmrDate;
	}

	public void setXmrDate(Date xmrDate) {
		this.xmrDate = xmrDate;
	}
	
	public Long getMiCardNumber() {
		return miCardNumber;
	}

	public void setMiCardNumber(Long miCardNumber) {
		this.miCardNumber = miCardNumber;
	}
	
	@Length(min=0, max=2, message="卡类别长度不能超过 2 个字符")
	public String getMiCardType() {
		return miCardType;
	}

	public void setMiCardType(String miCardType) {
		this.miCardType = miCardType;
	}
	
	@Length(min=0, max=64, message="会员编号长度不能超过 64 个字符")
	public String getMiCode() {
		return miCode;
	}

	public void setMiCode(String miCode) {
		this.miCode = miCode;
	}
	
	@Length(min=0, max=255, message="会员姓名长度不能超过 255 个字符")
	public String getMiName() {
		return miName;
	}

	public void setMiName(String miName) {
		this.miName = miName;
	}
	
	@Length(min=0, max=2, message="账户类别长度不能超过 2 个字符")
	public String getXmrAccountType() {
		return xmrAccountType;
	}

	public void setXmrAccountType(String xmrAccountType) {
		this.xmrAccountType = xmrAccountType;
	}
	
	@Length(min=0, max=2, message="进店渠道长度不能超过 2 个字符")
	public String getMiOutlets() {
		return miOutlets;
	}

	public void setMiOutlets(String miOutlets) {
		this.miOutlets = miOutlets;
	}
	
	@Length(min=0, max=2, message="异动方式长度不能超过 2 个字符")
	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	
	public Long getXmrReserveValue() {
		return xmrReserveValue;
	}

	public void setXmrReserveValue(Long xmrReserveValue) {
		this.xmrReserveValue = xmrReserveValue;
	}
	
	public Long getXmrSaveMoney() {
		return xmrSaveMoney;
	}

	public void setXmrSaveMoney(Long xmrSaveMoney) {
		this.xmrSaveMoney = xmrSaveMoney;
	}
	
	public Long getXmrProduceProjectAmount() {
		return xmrProduceProjectAmount;
	}

	public void setXmrProduceProjectAmount(Long xmrProduceProjectAmount) {
		this.xmrProduceProjectAmount = xmrProduceProjectAmount;
	}
	
	public Long getXmrPackageAmount() {
		return xmrPackageAmount;
	}

	public void setXmrPackageAmount(Long xmrPackageAmount) {
		this.xmrPackageAmount = xmrPackageAmount;
	}
	
	public Long getXmrGiftAccount() {
		return xmrGiftAccount;
	}

	public void setXmrGiftAccount(Long xmrGiftAccount) {
		this.xmrGiftAccount = xmrGiftAccount;
	}
	
	public Long getXmrDonationAmout() {
		return xmrDonationAmout;
	}

	public void setXmrDonationAmout(Long xmrDonationAmout) {
		this.xmrDonationAmout = xmrDonationAmout;
	}
	
	public Long getXmrCurrentBalance() {
		return xmrCurrentBalance;
	}

	public void setXmrCurrentBalance(Long xmrCurrentBalance) {
		this.xmrCurrentBalance = xmrCurrentBalance;
	}
	
	public Long getXmrLatestBalance() {
		return xmrLatestBalance;
	}

	public void setXmrLatestBalance(Long xmrLatestBalance) {
		this.xmrLatestBalance = xmrLatestBalance;
	}
	
	@Length(min=0, max=2, message="支付方式长度不能超过 2 个字符")
	public String getXmrPaymentMode() {
		return xmrPaymentMode;
	}

	public void setXmrPaymentMode(String xmrPaymentMode) {
		this.xmrPaymentMode = xmrPaymentMode;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getXmrRechargeValidTime() {
		return xmrRechargeValidTime;
	}

	public void setXmrRechargeValidTime(Date xmrRechargeValidTime) {
		this.xmrRechargeValidTime = xmrRechargeValidTime;
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
	
	@Length(min=0, max=255, message="状态长度不能超过 255 个字符")
	public String getXmrStatus() {
		return xmrStatus;
	}

	public void setXmrStatus(String xmrStatus) {
		this.xmrStatus = xmrStatus;
	}
	
	@Length(min=0, max=64, message="门店编号长度不能超过 64 个字符")
	public String getXsCode() {
		return xsCode;
	}

	public void setXsCode(String xsCode) {
		this.xsCode = xsCode;
	}
	
	@Length(min=0, max=128, message="门店名称长度不能超过 128 个字符")
	public String getXsFullName() {
		return xsFullName;
	}

	public void setXsFullName(String xsFullName) {
		this.xsFullName = xsFullName;
	}
	
}