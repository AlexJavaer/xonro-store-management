/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * member_infoEntity
 * @author Cyrsta-hu
 * @version 2019-03-26
 */
@Table(name="member_info", alias="a", columns={
		@Column(name="mi_id", attrName="miId", label="会员编号", isPK=true),
		@Column(name="mi_name", attrName="miName", label="会员姓名", queryType=QueryType.LIKE),
		@Column(name="mi_gregorian_birthday", attrName="miGregorianBirthday", label="公历生日"),
		@Column(name="mi_sex", attrName="miSex", label="会员性别"),
		@Column(name="mi_phone", attrName="miPhone", label="手机号码"),
		@Column(name="mi_outlets", attrName="miOutlets", label="进店渠道"),
		@Column(name="mi_mark_status", attrName="miMarkStatus", label="标记状态"),
		@Column(name="mi_member_status", attrName="miMemberStatus", label="会员状态"),
		@Column(name="mi_wechat_number", attrName="miWechatNumber", label="微信号"),
		@Column(name="mi_qq_number", attrName="miQqNumber", label="QQ号码"),
		@Column(name="mi_email", attrName="miEmail", label="邮箱"),
		@Column(name="mi_family_phone", attrName="miFamilyPhone", label="家庭电话"),
		@Column(name="mi_constellation", attrName="miConstellation", label="星座"),
		@Column(name="mi_blood_type", attrName="miBloodType", label="血型"),
		@Column(name="mi_zip_code", attrName="miZipCode", label="邮编"),
		@Column(name="mi_family_address", attrName="miFamilyAddress", label="家庭住址"),
		@Column(name="mi_vocation", attrName="miVocation", label="职业"),
		@Column(name="mi_work_unit", attrName="miWorkUnit", label="工作单位"),
		@Column(name="mi_card_number", attrName="miCardNumber", label="会员卡号"),
		@Column(name="mi_card_type", attrName="miCardType", label="卡类别"),
		@Column(name="mi_id_number", attrName="miIdNumber", label="身份证号"),
		@Column(name="mi_message_notice", attrName="miMessageNotice", label="消息类通知"),
		@Column(name="mi_marketing_notice", attrName="miMarketingNotice", label="营销类通知"),
		@Column(name="mi_wechat_binding_card", attrName="miWechatBindingCard", label="微信绑卡"),
		@Column(name="mi_photo", attrName="miPhoto", label="会员头像"),
		@Column(name="mi_responsible_staff", attrName="miResponsibleStaff", label="负责员工"),
		@Column(name="mi_member_grade", attrName="miMemberGrade", label="会员等级"),
		@Column(name="mi_development_potential", attrName="miDevelopmentPotential", label="发展潜质"),
		@Column(name="user_code", attrName="userCode", label="用户ID"),
		@Column(name="office_code", attrName="officeCode", label="组织ID"),
		@Column(name="create_user", attrName="createUser", label="创建用户"),
		@Column(name="update_user", attrName="updateUser", label="更新用户"),
	}, orderBy="a.update_date DESC"
)
public class MemberInfo extends DataEntity<MemberInfo> {
	
	private static final long serialVersionUID = 1L;
	private String miId;		// 会员编号
	private String miName;		// 会员姓名
	private Date miGregorianBirthday;		// 公历生日
	private String miSex;		// 会员性别
	private Long miPhone;		// 手机号码
	private String miOutlets;		// 进店渠道
	private String miMarkStatus;		// 标记状态
	private String miMemberStatus;		// 会员状态
	private String miWechatNumber;		// 微信号
	private Long miQqNumber;		// QQ号码
	private String miEmail;		// 邮箱
	private Long miFamilyPhone;		// 家庭电话
	private String miConstellation;		// 星座
	private String miBloodType;		// 血型
	private Integer miZipCode;		// 邮编
	private String miFamilyAddress;		// 家庭住址
	private String miVocation;		// 职业
	private String miWorkUnit;		// 工作单位
	private Long miCardNumber;		// 会员卡号
	private String miCardType;		// 卡类别
	private String miIdNumber;		// 身份证号
	private String miMessageNotice;		// 消息类通知
	private String miMarketingNotice;		// 营销类通知
	private String miWechatBindingCard;		// 微信绑卡
	private String miPhoto;		// 会员头像
	private String miResponsibleStaff;		// 负责员工
	private String miMemberGrade;		// 会员等级
	private String miDevelopmentPotential;		// 发展潜质
	private String userCode;		// 用户ID
	private String officeCode;		// 组织ID
	private String createUser;		// 创建用户
	private String updateUser;		// 更新用户
	
	public MemberInfo() {
		this(null);
	}

	public MemberInfo(String id){
		super(id);
	}
	
	public String getMiId() {
		return miId;
	}

	public void setMiId(String miId) {
		this.miId = miId;
	}
	
	//@NotBlank(message="会员姓名不能为空")
    @NotNull
	@Length(min=0, max=128, message="会员姓名长度不能超过 128 个字符")
	public String getMiName() {
		return miName;
	}

	public void setMiName(String miName) {
		this.miName = miName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	//@NotNull(message="公历生日不能为空")
	public Date getMiGregorianBirthday() {
		return miGregorianBirthday;
	}

	public void setMiGregorianBirthday(Date miGregorianBirthday) {
		this.miGregorianBirthday = miGregorianBirthday;
	}
	
	//@NotBlank(message="会员性别不能为空")
	@Length(min=0, max=2, message="会员性别长度不能超过 2 个字符")
	public String getMiSex() {
		return miSex;
	}

	public void setMiSex(String miSex) {
		this.miSex = miSex;
	}
	
	//@NotNull(message="手机号码不能为空")
	public Long getMiPhone() {
		return miPhone;
	}

	public void setMiPhone(Long miPhone) {
		this.miPhone = miPhone;
	}
	
	//@NotBlank(message="进店渠道不能为空")
	@Length(min=0, max=10, message="进店渠道长度不能超过 10 个字符")
	public String getMiOutlets() {
		return miOutlets;
	}

	public void setMiOutlets(String miOutlets) {
		this.miOutlets = miOutlets;
	}
	
	//@NotBlank(message="标记状态不能为空")
	@Length(min=0, max=2, message="标记状态长度不能超过 2 个字符")
	public String getMiMarkStatus() {
		return miMarkStatus;
	}

	public void setMiMarkStatus(String miMarkStatus) {
		this.miMarkStatus = miMarkStatus;
	}
	
	//@NotBlank(message="会员状态不能为空")
	@Length(min=0, max=2, message="会员状态长度不能超过 2 个字符")
	public String getMiMemberStatus() {
		return miMemberStatus;
	}

	public void setMiMemberStatus(String miMemberStatus) {
		this.miMemberStatus = miMemberStatus;
	}
	
	@Length(min=0, max=64, message="微信号长度不能超过 64 个字符")
	public String getMiWechatNumber() {
		return miWechatNumber;
	}

	public void setMiWechatNumber(String miWechatNumber) {
		this.miWechatNumber = miWechatNumber;
	}
	
	public Long getMiQqNumber() {
		return miQqNumber;
	}

	public void setMiQqNumber(Long miQqNumber) {
		this.miQqNumber = miQqNumber;
	}
	
	@Length(min=0, max=64, message="邮箱长度不能超过 64 个字符")
	public String getMiEmail() {
		return miEmail;
	}

	public void setMiEmail(String miEmail) {
		this.miEmail = miEmail;
	}
	
	public Long getMiFamilyPhone() {
		return miFamilyPhone;
	}

	public void setMiFamilyPhone(Long miFamilyPhone) {
		this.miFamilyPhone = miFamilyPhone;
	}
	
	@Length(min=0, max=10, message="星座长度不能超过 10 个字符")
	public String getMiConstellation() {
		return miConstellation;
	}

	public void setMiConstellation(String miConstellation) {
		this.miConstellation = miConstellation;
	}
	
	@Length(min=0, max=2, message="血型长度不能超过 2 个字符")
	public String getMiBloodType() {
		return miBloodType;
	}

	public void setMiBloodType(String miBloodType) {
		this.miBloodType = miBloodType;
	}
	
	public Integer getMiZipCode() {
		return miZipCode;
	}

	public void setMiZipCode(Integer miZipCode) {
		this.miZipCode = miZipCode;
	}
	
	@Length(min=0, max=255, message="家庭住址长度不能超过 255 个字符")
	public String getMiFamilyAddress() {
		return miFamilyAddress;
	}

	public void setMiFamilyAddress(String miFamilyAddress) {
		this.miFamilyAddress = miFamilyAddress;
	}
	
	@Length(min=0, max=64, message="职业长度不能超过 64 个字符")
	public String getMiVocation() {
		return miVocation;
	}

	public void setMiVocation(String miVocation) {
		this.miVocation = miVocation;
	}
	
	@Length(min=0, max=255, message="工作单位长度不能超过 255 个字符")
	public String getMiWorkUnit() {
		return miWorkUnit;
	}

	public void setMiWorkUnit(String miWorkUnit) {
		this.miWorkUnit = miWorkUnit;
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
	
	@Length(min=0, max=50, message="身份证号长度不能超过 50 个字符")
	public String getMiIdNumber() {
		return miIdNumber;
	}

	public void setMiIdNumber(String miIdNumber) {
		this.miIdNumber = miIdNumber;
	}
	
	@Length(min=0, max=5, message="消息类通知长度不能超过 5 个字符")
	public String getMiMessageNotice() {
		return miMessageNotice;
	}

	public void setMiMessageNotice(String miMessageNotice) {
		this.miMessageNotice = miMessageNotice;
	}
	
	@Length(min=0, max=5, message="营销类通知长度不能超过 5 个字符")
	public String getMiMarketingNotice() {
		return miMarketingNotice;
	}

	public void setMiMarketingNotice(String miMarketingNotice) {
		this.miMarketingNotice = miMarketingNotice;
	}
	
	@Length(min=0, max=5, message="微信绑卡长度不能超过 5 个字符")
	public String getMiWechatBindingCard() {
		return miWechatBindingCard;
	}

	public void setMiWechatBindingCard(String miWechatBindingCard) {
		this.miWechatBindingCard = miWechatBindingCard;
	}
	
	@Length(min=0, max=128, message="会员头像长度不能超过 128 个字符")
	public String getMiPhoto() {
		return miPhoto;
	}

	public void setMiPhoto(String miPhoto) {
		this.miPhoto = miPhoto;
	}
	
	@Length(min=0, max=64, message="负责员工长度不能超过 64 个字符")
	public String getMiResponsibleStaff() {
		return miResponsibleStaff;
	}

	public void setMiResponsibleStaff(String miResponsibleStaff) {
		this.miResponsibleStaff = miResponsibleStaff;
	}
	
	@Length(min=0, max=64, message="会员等级长度不能超过 64 个字符")
	public String getMiMemberGrade() {
		return miMemberGrade;
	}

	public void setMiMemberGrade(String miMemberGrade) {
		this.miMemberGrade = miMemberGrade;
	}
	
	@Length(min=0, max=64, message="发展潜质长度不能超过 64 个字符")
	public String getMiDevelopmentPotential() {
		return miDevelopmentPotential;
	}

	public void setMiDevelopmentPotential(String miDevelopmentPotential) {
		this.miDevelopmentPotential = miDevelopmentPotential;
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
	
	@Length(min=0, max=64, message="创建用户长度不能超过 64 个字符")
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
}