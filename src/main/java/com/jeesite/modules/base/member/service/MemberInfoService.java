/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.member.service;

import com.jeesite.common.entity.Page;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.member.dao.MemberInfoDao;
import com.jeesite.modules.base.member.entity.MemberInfo;
import com.jeesite.modules.file.utils.FileUploadUtils;
import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.service.DataScopeService;
import com.jeesite.modules.sys.utils.EmpUtils;
import com.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * member_infoService
 * @author Cyrsta-hu
 * @version 2019-03-26
 */
@Service
@Transactional(readOnly=true)
@SuppressWarnings("all")
public class MemberInfoService extends CrudService<MemberInfoDao, MemberInfo> {

	/**
	 * 获取单条数据
	 * @param memberInfo
	 * @return
	 */
	@Override
	public MemberInfo get(MemberInfo memberInfo) {
		return super.get(memberInfo);
	}

	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param memberInfo
	 * @return
	 */
	@Override
	public Page<MemberInfo> findPage(Page<MemberInfo> page, MemberInfo memberInfo) {



		return super.findPage(page, memberInfo);
	}

	/**
	 * 保存数据（插入或更新）
	 * @param memberInfo
	 */
	@Override
	@Transactional(readOnly=false)
    @SuppressWarnings("all")
	public void save(MemberInfo memberInfo) {
		if (memberInfo.getIsNewRecord()) {
			String officeCode = EmpUtils.getOffice().getOfficeCode();
			String s = StringUtils.getRandomNum(3);
			memberInfo.setMiCode(officeCode+s);
		}
		String  user = UserUtils.getUser().getCurrentUser().getUserCode();
		String  office = EmpUtils.getOffice().getOfficeCode();
		memberInfo.setUserCode(user);
		memberInfo.setOfficeCode(office);
		super.save(memberInfo);

		// 保存上传图片
		//FileUploadUtils.saveFileUpload(memberInfo.getMiCode(), "memberInfo_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(memberInfo.getMiCode(),"memberInfo_file");

	}

	/**
	 * 更新状态
	 * @param memberInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MemberInfo memberInfo) {
		super.updateStatus(memberInfo);
	}

	/**
	 * 删除数据
	 * @param memberInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MemberInfo memberInfo) {
		super.delete(memberInfo);
	}

}