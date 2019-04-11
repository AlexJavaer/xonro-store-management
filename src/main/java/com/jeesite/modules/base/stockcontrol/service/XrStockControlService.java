/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.stockcontrol.service;

import java.util.List;

import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.sys.utils.EmpUtils;
import com.jeesite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.stockcontrol.entity.XrStockControl;
import com.jeesite.modules.base.stockcontrol.dao.XrStockControlDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * stockControlService
 * @author Crysta-hu
 * @version 2019-04-10
 */
@Service
@Transactional(readOnly=true)
public class XrStockControlService extends CrudService<XrStockControlDao, XrStockControl> {
	
	/**
	 * 获取单条数据
	 * @param xrStockControl
	 * @return
	 */
	@Override
	public XrStockControl get(XrStockControl xrStockControl) {
		return super.get(xrStockControl);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param xrStockControl
	 * @return
	 */
	@Override
	public Page<XrStockControl> findPage(Page<XrStockControl> page, XrStockControl xrStockControl) {
		return super.findPage(page, xrStockControl);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param xrStockControl
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(XrStockControl xrStockControl) {
		if(xrStockControl.getIsNewRecord()){
			String officeCode = EmpUtils.getOffice().getOfficeCode();
			String s = StringUtils.getRandomNum(3);
			xrStockControl.setMatterCode(officeCode+s);
		}

		String user = UserUtils.getUser().getCurrentUser().getUserCode();
		String office = EmpUtils.getOffice().getOfficeCode();
		xrStockControl.setUserCode(user);
		xrStockControl.setOfficeCode(office);

		super.save(xrStockControl);
		// 保存上传图片
		//FileUploadUtils.saveFileUpload(xrStockControl.getId(), "xrStockControl_image");
		// 保存上传附件
		//FileUploadUtils.saveFileUpload(xrStockControl.getId(), "xrStockControl_file");
	}
	
	/**
	 * 更新状态
	 * @param xrStockControl
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(XrStockControl xrStockControl) {
		super.updateStatus(xrStockControl);
	}
	
	/**
	 * 删除数据
	 * @param xrStockControl
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(XrStockControl xrStockControl) {
		super.delete(xrStockControl);
	}
	
}