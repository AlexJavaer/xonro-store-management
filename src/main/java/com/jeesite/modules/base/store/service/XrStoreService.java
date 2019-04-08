/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.store.service;

import java.util.List;

import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.sys.utils.EmpUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.store.entity.XrStore;
import com.jeesite.modules.base.store.dao.XrStoreDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * xr_storeInfoService
 * @author Crysta-hu
 * @version 2019-04-08
 */
@Service
@Transactional(readOnly=true)
public class XrStoreService extends CrudService<XrStoreDao, XrStore> {
	
	/**
	 * 获取单条数据
	 * @param xrStore
	 * @return
	 */
	@Override
	public XrStore get(XrStore xrStore) {
		return super.get(xrStore);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param xrStore
	 * @return
	 */
	@Override
	public Page<XrStore> findPage(Page<XrStore> page, XrStore xrStore) {
		return super.findPage(page, xrStore);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param xrStore
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(XrStore xrStore) {
		if(xrStore.getIsNewRecord()){
			String officeCode = EmpUtils.getOffice().getOfficeCode();
			String s = StringUtils.getRandomStr(3);
			xrStore.setXsCode(officeCode+s);
		}
		super.save(xrStore);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(xrStore.getXsCode(), "xrStore_image");
		// 保存上传附件
		//FileUploadUtils.saveFileUpload(xrStore.getId(), "xrStore_file");
	}
	
	/**
	 * 更新状态
	 * @param xrStore
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(XrStore xrStore) {
		super.updateStatus(xrStore);
	}
	
	/**
	 * 删除数据
	 * @param xrStore
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(XrStore xrStore) {
		super.delete(xrStore);
	}
	
}