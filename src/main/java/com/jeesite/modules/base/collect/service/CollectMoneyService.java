/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.collect.service;

import java.util.List;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.base.collect.dao.ProductinfoDao;
import com.jeesite.modules.base.collect.entity.Productinfo;
import com.jeesite.modules.base.productinfo.dao.XrProductinfoDao;
import com.jeesite.modules.base.xr.entity.XrStore;
import com.jeesite.modules.sys.utils.EmpUtils;
import com.jeesite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.collect.entity.CollectMoney;
import com.jeesite.modules.base.collect.dao.CollectMoneyDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * collectMoneyService
 * @author Crysta-hu
 * @version 2019-04-16
 */
@Service
@Transactional(readOnly=true)
public class CollectMoneyService extends CrudService<CollectMoneyDao, CollectMoney> {
	
	/**
	 * 获取单条数据
	 * @param collectMoney
	 * @return
	 */
	@Override
	public CollectMoney get(CollectMoney collectMoney) {
		return super.get(collectMoney);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param collectMoney
	 * @return
	 */
	@Override
	public Page<CollectMoney> findPage(Page<CollectMoney> page, CollectMoney collectMoney) {
		return super.findPage(page, collectMoney);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param collectMoney
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CollectMoney collectMoney) {
	    if(collectMoney.getIsNewRecord()){
            String officeCode = EmpUtils.getOffice().getOfficeCode();
            String s = StringUtils.getRandomNum(3);
            collectMoney.setCmCode(officeCode+s);
        }
		XrStore xrStore = new XrStore();

        String user = UserUtils.getUser().getCurrentUser().getUserCode();
        String office = EmpUtils.getOffice().getOfficeCode();
        collectMoney.setUserCode(user);
        collectMoney.setOfficeCode(office);
		collectMoney.setCmStoreCode(office);
		collectMoney.setCmStoreName(xrStore.getXsFullName());
		super.save(collectMoney);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(collectMoney.getId(), "collectMoney_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(collectMoney.getId(), "collectMoney_file");
	}
	
	/**
	 * 更新状态
	 * @param collectMoney
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CollectMoney collectMoney) {
		super.updateStatus(collectMoney);
	}
	
	/**
	 * 删除数据
	 * @param collectMoney
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CollectMoney collectMoney) {
		super.delete(collectMoney);
	}
	
}