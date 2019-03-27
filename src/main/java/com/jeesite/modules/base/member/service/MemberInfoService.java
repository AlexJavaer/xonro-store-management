/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.member.service;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.member.dao.MemberInfoDao;
import com.jeesite.modules.base.member.entity.MemberInfo;
import com.jeesite.modules.file.utils.FileUploadUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * member_infoService
 * @author Cyrsta-hu
 * @version 2019-03-26
 */
@Service
@Transactional(readOnly=true)
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
	public void save(MemberInfo memberInfo) {
		super.save(memberInfo);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(memberInfo.getId(), "memberInfo_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(memberInfo.getId(), "memberInfo_file");
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