/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.member.entity;

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
 * member_infoEntity
 * @author Cyrsta-hu
 * @version 2019-04-18
 */
@Table(name="member_info", alias="a", columns={
		@Column(name="mi_code", attrName="miCode", label="会员编号", isPK=true),
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
		@Column(name="mi_effective_date", attrName="miEffectiveDate", label="有效日期"),
		@Column(name="mi_end_date", attrName="miEndDate", label="截止日期"),
		@Column(name="project_code", attrName="projectCode", label="项目编号"),
		@Column(name="project_name", attrName="projectName", label="项目名称"),
		@Column(name="course_of_treatment_num", attrName="courseOfTreatmentNum", label="疗程次数"),
		@Column(name="mi_balance", attrName="miBalance", label="会员卡余额"),
		@Column(name="mi_id_number", attrName="miIdNumber", label="身份证号"),
		@Column(name="mi_message_notice", attrName="miMessageNotice", label="消息类通知"),
		@Column(name="mi_marketing_notice", attrName="miMarketingNotice", label="营销类通知"),
		@Column(name="mi_wechat_binding_card", attrName="miWechatBindingCard", label="微信绑卡"),
		@Column(name="mi_photo", attrName="miPhoto", label="会员头像"),
		@Column(name="mi_responsible_staff", attrName="miResponsibleStaff", label="负责员工"),
		@Column(name="mi_member_grade", attrName="miMemberGrade", label="会员等级"),
		@Column(name="mi_development_potential", attrName="miDevelopmentPotential", label="发展潜质"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="user_code", attrName="userCode", label="用户ID"),
		@Column(name="office_code", attrName="officeCode", label="组织ID"),
		@Column(name="mi_file", attrName="miFile", label="附件"),
	}, orderBy="a.update_date DESC"
)
public class MemberInfo extends DataEntity<MemberInfo> {
	
	private static final long serialVersionUID = 1L;
	private String miCode;		// 会员编号
	private String miName;		// 会员姓名
	private Date miGregorianBirthday;		// 公历生日
	private String miSex;		// 会员性别
	private String miPhone;		// 手机号码
	private String miOutlets;		// 进店渠道
	private String miMarkStatus;		// 标记状态
	private String miMemberStatus;		// 会员状态
	private String miWechatNumber;		// 微信号
	private String miQqNumber;		// QQ号码
	private String miEmail;		// 邮箱
	private String miFamilyPhone;		// 家庭电话
	private String miConstellation;		// 星座
	private String miBloodType;		// 血型
	private Integer miZipCode;		// 邮编
	private String miFamilyAddress;		// 家庭住址
	private String miVocation;		// 职业
	private String miWorkUnit;		// 工作单位
	private String miCardNumber;		// 会员卡号
	private String miCardType;		// 卡类别
	private Long miBalance;		// 会员卡余额
	private Date miEffectiveDate;//有效日期
    private Date miEndDate;//截止日期
	private String projectCode;		// 项目编号
	private String projectName;		// 项目名称
    private Integer courseOfTreatmentNum;//疗程次数
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
	private String miFile;		// 附件
	
	public MemberInfo() {
		this(null);
	}

	public MemberInfo(String id){
		super(id);
	}
	
	public String getMiCode() {
		return miCode;
	}

	public void setMiCode(String miCode) {
		this.miCode = miCode;
	}
	
	@NotBlank(message="会员姓名不能为空")
	@Length(min=0, max=128, message="会员姓名长度不能超过 128 个字符")
	public String getMiName() {
		return miName;
	}

	public void setMiName(String miName) {
		this.miName = miName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getMiGregorianBirthday() {
		return miGregorianBirthday;
	}

	public void setMiGregorianBirthday(Date miGregorianBirthday) {
		this.miGregorianBirthday = miGregorianBirthday;
	}
	
	@Length(min=0, max=2, message="会员性别长度不能超过 2 个字符")
	public String getMiSex() {
		return miSex;
	}

	public void setMiSex(String miSex) {
		this.miSex = miSex;
	}
	
	public String getMiPhone() {
		return miPhone;
	}

	public void setMiPhone(String miPhone) {
		this.miPhone = miPhone;
	}
	
	@Length(min=0, max=10, message="进店渠道长度不能超过 10 个字符")
	public String getMiOutlets() {
		return miOutlets;
	}

	public void setMiOutlets(String miOutlets) {
		this.miOutlets = miOutlets;
	}
	
	@Length(min=0, max=2, message="标记状态长度不能超过 2 个字符")
	public String getMiMarkStatus() {
		return miMarkStatus;
	}

	public void setMiMarkStatus(String miMarkStatus) {
		this.miMarkStatus = miMarkStatus;
	}
	
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
	
	public String getMiQqNumber() {
		return miQqNumber;
	}

	public void setMiQqNumber(String miQqNumber) {
		this.miQqNumber = miQqNumber;
	}
	
	@Length(min=0, max=64, message="邮箱长度不能超过 64 个字符")
	public String getMiEmail() {
		return miEmail;
	}

	public void setMiEmail(String miEmail) {
		this.miEmail = miEmail;
	}
	
	public String getMiFamilyPhone() {
		return miFamilyPhone;
	}

	public void setMiFamilyPhone(String miFamilyPhone) {
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
	
	public String getMiCardNumber() {
		return miCardNumber;
	}

	public void setMiCardNumber(String miCardNumber) {
		this.miCardNumber = miCardNumber;
	}
	
	@Length(min=0, max=2, message="卡类别长度不能超过 2 个字符")
	public String getMiCardType() {
		return miCardType;
	}

	public void setMiCardType(String miCardType) {
		this.miCardType = miCardType;
	}

	public Long getMiBalance() {
		return miBalance;
	}

	public void setMiBalance(Long miBalance) {
		this.miBalance = miBalance;
	}

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getMiEffectiveDate() {
        return miEffectiveDate;
    }

    public void setMiEffectiveDate(Date miEffectiveDate) {
        this.miEffectiveDate = miEffectiveDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getMiEndDate() {
        return miEndDate;
    }

    public void setMiEndDate(Date miEndDate) {
        this.miEndDate = miEndDate;
    }

    public Integer getCourseOfTreatmentNum() {
        return courseOfTreatmentNum;
    }

    public void setCourseOfTreatmentNum(Integer courseOfTreatmentNum) {
        this.courseOfTreatmentNum = courseOfTreatmentNum;
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
	
	@Length(min=0, max=500, message="附件长度不能超过 500 个字符")
	public String getMiFile() {
		return miFile;
	}

	public void setMiFile(String miFile) {
		this.miFile = miFile;
	}


	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}