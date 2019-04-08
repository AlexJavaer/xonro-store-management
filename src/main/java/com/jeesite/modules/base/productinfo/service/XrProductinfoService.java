/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.productinfo.service;

import java.util.List;

import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.sys.utils.EmpUtils;
import com.jeesite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.productinfo.entity.XrProductinfo;
import com.jeesite.modules.base.productinfo.dao.XrProductinfoDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * xr_productinfoService
 * @author Crysta-hu
 * @version 2019-04-04
 */
@Service
@Transactional(readOnly=true)
public class XrProductinfoService extends CrudService<XrProductinfoDao, XrProductinfo> {

	/**
	 * 获取单条数据
	 * @param xrProductinfo
	 * @return
	 */
	@Override
	public XrProductinfo get(XrProductinfo xrProductinfo) {
		return super.get(xrProductinfo);
	}

	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param xrProductinfo
	 * @return
	 */
	@Override
	public Page<XrProductinfo> findPage(Page<XrProductinfo> page, XrProductinfo xrProductinfo) {
		return super.findPage(page, xrProductinfo);
	}

	/**
	 * 保存数据（插入或更新）
	 * @param xrProductinfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(XrProductinfo xrProductinfo) {
		if(xrProductinfo.getIsNewRecord()){
			String officeCode = EmpUtils.getOffice().getOfficeCode();
			String s = StringUtils.getRandomNum(3);
            xrProductinfo.setProductCode(officeCode+s);
		}

		String user = UserUtils.getUser().getCurrentUser().getUserCode();
		String office = EmpUtils.getOffice().getOfficeCode();
		xrProductinfo.setUserCode(user);
		xrProductinfo.setOfficeCode(office);
		super.save(xrProductinfo);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(xrProductinfo.getId(), "xrProductinfo_image");
		// 保存上传附件
		//FileUploadUtils.saveFileUpload(xrProductinfo.getId(), "xrProductinfo_file");
	}
	
	/**
	 * 更新状态
	 * @param xrProductinfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(XrProductinfo xrProductinfo) {
		super.updateStatus(xrProductinfo);
	}
	
	/**
	 * 删除数据
	 * @param xrProductinfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(XrProductinfo xrProductinfo) {
		super.delete(xrProductinfo);
	}
	
}