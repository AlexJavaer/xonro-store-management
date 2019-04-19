/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.member.service;

import com.jeesite.common.entity.DataScope;
import com.jeesite.common.entity.Page;
import com.jeesite.common.mybatis.mapper.query.QueryDataScope;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.member.dao.MemberInfoDao;
import com.jeesite.modules.base.member.entity.MemberInfo;
import com.jeesite.modules.file.utils.FileUploadUtils;
import com.jeesite.modules.sys.entity.RoleDataScope;
import com.jeesite.modules.sys.utils.EmpUtils;
import com.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * member_infoService
 * @author Cyrsta-hu
 * @version 2019-03-26
 */
@Service
@Transactional(readOnly=true)
@SuppressWarnings("all")
public class MemberInfoService extends CrudService<MemberInfoDao, MemberInfo> {
	@Autowired
	private MemberInfoDao memberInfoDao;

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

		// 生成数据权限过滤条件（dsf为dataScopeFilter的简写，在xml中使用 ${sqlMap.dsf}调用权限SQL）
		/*List<MemberInfo> dataList = memberInfoDao.findDataList();*/
		QueryDataScope sss = memberInfo.getSqlMap().getDataScope().addFilter("dsf", "Office",
				"a.office_code", "a.user_code", DataScope.CTRL_PERMI_MANAGE);
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

	public List<MemberInfo> findDataMemberList(MemberInfo memberInfo) {
		return this.memberInfoDao.findList(memberInfo);
	}

	public MemberInfo getByMiCode(String miCode){
		HashMap<String,Object>  hmap= new HashMap<String,Object>();
		hmap.put("miCode",miCode);
		return memberInfoDao.getByMiCode(hmap);
	}



}