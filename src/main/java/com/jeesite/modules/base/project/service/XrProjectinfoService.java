/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.project.service;

import java.util.List;

import com.jeesite.common.entity.DataScope;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.mybatis.mapper.query.QueryDataScope;
import com.jeesite.modules.sys.utils.EmpUtils;
import com.jeesite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.project.entity.XrProjectinfo;
import com.jeesite.modules.base.project.dao.XrProjectinfoDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * xr_projectinfoService
 * @author Crysta-hu
 * @version 2019-04-08
 */
@Service
@Transactional(readOnly=true)
public class XrProjectinfoService extends CrudService<XrProjectinfoDao, XrProjectinfo> {
	
	/**
	 * 获取单条数据
	 * @param xrProjectinfo
	 * @return
	 */
	@Override
	public XrProjectinfo get(XrProjectinfo xrProjectinfo) {
		return super.get(xrProjectinfo);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param xrProjectinfo
	 * @return
	 */
	@Override
	public Page<XrProjectinfo> findPage(Page<XrProjectinfo> page, XrProjectinfo xrProjectinfo) {
		QueryDataScope sss = xrProjectinfo.getSqlMap().getDataScope().addFilter("dsf", "Office",
				"a.office_code", "a.user_code", DataScope.CTRL_PERMI_MANAGE);
		return super.findPage(page, xrProjectinfo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param xrProjectinfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(XrProjectinfo xrProjectinfo) {

		if(xrProjectinfo.getIsNewRecord()){
			/*String officeCode = EmpUtils.getOffice().getOfficeCode();*/
			String officeCode="011";
			String s = StringUtils.getRandomNum(3);
			xrProjectinfo.setProjectCode(officeCode+s);
		}

		String user = UserUtils.getUser().getCurrentUser().getUserCode();
		String office = EmpUtils.getOffice().getOfficeCode();
		xrProjectinfo.setUserCode(user);
		xrProjectinfo.setOfficeCode(office);
		super.save(xrProjectinfo);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(xrProjectinfo.getId(), "xrProjectinfo_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(xrProjectinfo.getId(), "xrProjectinfo_file");
	}
	
	/**
	 * 更新状态
	 * @param xrProjectinfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(XrProjectinfo xrProjectinfo) {
		super.updateStatus(xrProjectinfo);
	}
	
	/**
	 * 删除数据
	 * @param xrProjectinfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(XrProjectinfo xrProjectinfo) {
		super.delete(xrProjectinfo);
	}
	
}