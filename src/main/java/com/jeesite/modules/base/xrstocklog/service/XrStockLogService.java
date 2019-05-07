/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstocklog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.xrstocklog.entity.XrStockLog;
import com.jeesite.modules.base.xrstocklog.dao.XrStockLogDao;

/**
 * xr_stock_logService
 * @author Crysta-hu
 * @version 2019-05-05
 */
@Service
@Transactional(readOnly=true)
public class XrStockLogService extends CrudService<XrStockLogDao, XrStockLog> {
	
	/**
	 * 获取单条数据
	 * @param xrStockLog
	 * @return
	 */
	@Override
	public XrStockLog get(XrStockLog xrStockLog) {
		return super.get(xrStockLog);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param xrStockLog
	 * @return
	 */
	@Override
	public Page<XrStockLog> findPage(Page<XrStockLog> page, XrStockLog xrStockLog) {
		return super.findPage(page, xrStockLog);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param xrStockLog
	 */
	@Override
	@Transactional(readOnly=false)

	public void save(XrStockLog xrStockLog) {
		super.save(xrStockLog);
	}
	
	/**
	 * 更新状态
	 * @param xrStockLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(XrStockLog xrStockLog) {
		super.updateStatus(xrStockLog);
	}
	
	/**
	 * 删除数据
	 * @param xrStockLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(XrStockLog xrStockLog) {
		super.delete(xrStockLog);
	}
	
}