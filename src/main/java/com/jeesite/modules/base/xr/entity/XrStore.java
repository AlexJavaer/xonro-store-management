/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xr.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * xr_storeEntity
 * @author Alex
 * @version 2019-04-08
 */
@Table(name="xr_store", alias="a", columns={
		@Column(name="xs_code", attrName="xsCode", label="编号", isPK=true),
		@Column(name="xs_full_name", attrName="xsFullName", label="店铺全称", queryType=QueryType.LIKE),
		@Column(name="xs_short_name", attrName="xsShortName", label="店铺简称", queryType=QueryType.LIKE),
		@Column(name="xs_chain_code", attrName="xsChainCode", label="连锁代码"),
		@Column(name="xs_phone", attrName="xsPhone", label="电话"),
		@Column(name="xs_address", attrName="xsAddress", label="地址"),
		@Column(name="xs_level", attrName="xsLevel", label="门店级别"),
		@Column(name="xs_we_public_account", attrName="xsWePublicAccount", label="微信公众号"),
		@Column(name="xs_website", attrName="xsWebsite", label="网址"),
		@Column(name="xs_manage_scope", attrName="xsManageScope", label="经营范围"),
		@Column(name="xs_opentime", attrName="xsOpentime", label="开业时间"),
		@Column(name="xs_logo_photo", attrName="xsLogoPhoto", label="门店logo"),
		@Column(name="xs_photo", attrName="xsPhoto", label="门店展示图片"),
		@Column(name="xs_lng", attrName="xsLng", label="经度"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="xs_lat", attrName="xsLat", label="纬度"),
		@Column(name="user_code", attrName="userCode", label="用户ID"),
		@Column(name="office_code", attrName="officeCode", label="组织ID"),
	}, orderBy="a.update_date DESC"
)
public class XrStore extends DataEntity<XrStore> {
	
	private static final long serialVersionUID = 1L;
	private String xsCode;		// 编号
	private String xsFullName;		// 店铺全称
	private String xsShortName;		// 店铺简称
	private String xsChainCode;		// 连锁代码
	private Long xsPhone;		// 电话
	private String xsAddress;		// 地址
	private String xsLevel;		// 门店级别
	private String xsWePublicAccount;		// 微信公众号
	private String xsWebsite;		// 网址
	private String xsManageScope;		// 经营范围
	private Date xsOpentime;		// 开业时间
	private String xsLogoPhoto;		// 门店logo
	private String xsPhoto;		// 门店展示图片
	private Long xsLng;		// 经度
	private Long xsLat;		// 纬度
	private String userCode;		// 用户ID
	private String officeCode;		// 组织ID
	
	public XrStore() {
		this(null);
	}

	public XrStore(String id){
		super(id);
	}
	
	public String getXsCode() {
		return xsCode;
	}

	public void setXsCode(String xsCode) {
		this.xsCode = xsCode;
	}
	
	@NotBlank(message="店铺全称不能为空")
	@Length(min=0, max=128, message="店铺全称长度不能超过 128 个字符")
	public String getXsFullName() {
		return xsFullName;
	}

	public void setXsFullName(String xsFullName) {
		this.xsFullName = xsFullName;
	}
	
	@NotBlank(message="店铺简称不能为空")
	@Length(min=0, max=128, message="店铺简称长度不能超过 128 个字符")
	public String getXsShortName() {
		return xsShortName;
	}

	public void setXsShortName(String xsShortName) {
		this.xsShortName = xsShortName;
	}
	
	@NotBlank(message="连锁代码不能为空")
	@Length(min=0, max=128, message="连锁代码长度不能超过 128 个字符")
	public String getXsChainCode() {
		return xsChainCode;
	}

	public void setXsChainCode(String xsChainCode) {
		this.xsChainCode = xsChainCode;
	}
	
	@NotNull(message="电话不能为空")
	public Long getXsPhone() {
		return xsPhone;
	}

	public void setXsPhone(Long xsPhone) {
		this.xsPhone = xsPhone;
	}
	
	@NotBlank(message="地址不能为空")
	@Length(min=0, max=255, message="地址长度不能超过 255 个字符")
	public String getXsAddress() {
		return xsAddress;
	}

	public void setXsAddress(String xsAddress) {
		this.xsAddress = xsAddress;
	}
	
	@NotBlank(message="门店级别不能为空")
	@Length(min=0, max=10, message="门店级别长度不能超过 10 个字符")
	public String getXsLevel() {
		return xsLevel;
	}

	public void setXsLevel(String xsLevel) {
		this.xsLevel = xsLevel;
	}
	
	@Length(min=0, max=128, message="微信公众号长度不能超过 128 个字符")
	public String getXsWePublicAccount() {
		return xsWePublicAccount;
	}

	public void setXsWePublicAccount(String xsWePublicAccount) {
		this.xsWePublicAccount = xsWePublicAccount;
	}
	
	@Length(min=0, max=255, message="网址长度不能超过 255 个字符")
	public String getXsWebsite() {
		return xsWebsite;
	}

	public void setXsWebsite(String xsWebsite) {
		this.xsWebsite = xsWebsite;
	}
	
	@Length(min=0, max=64, message="经营范围长度不能超过 64 个字符")
	public String getXsManageScope() {
		return xsManageScope;
	}

	public void setXsManageScope(String xsManageScope) {
		this.xsManageScope = xsManageScope;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getXsOpentime() {
		return xsOpentime;
	}

	public void setXsOpentime(Date xsOpentime) {
		this.xsOpentime = xsOpentime;
	}
	
	@Length(min=0, max=255, message="门店logo长度不能超过 255 个字符")
	public String getXsLogoPhoto() {
		return xsLogoPhoto;
	}

	public void setXsLogoPhoto(String xsLogoPhoto) {
		this.xsLogoPhoto = xsLogoPhoto;
	}
	
	@Length(min=0, max=255, message="门店展示图片长度不能超过 255 个字符")
	public String getXsPhoto() {
		return xsPhoto;
	}

	public void setXsPhoto(String xsPhoto) {
		this.xsPhoto = xsPhoto;
	}
	
	public Long getXsLng() {
		return xsLng;
	}

	public void setXsLng(Long xsLng) {
		this.xsLng = xsLng;
	}
	
	public Long getXsLat() {
		return xsLat;
	}

	public void setXsLat(Long xsLat) {
		this.xsLat = xsLat;
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
	
}