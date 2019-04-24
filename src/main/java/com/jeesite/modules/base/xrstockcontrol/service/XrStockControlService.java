/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockcontrol.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.xrstockcontrol.entity.XrStockControl;
import com.jeesite.modules.base.xrstockcontrol.dao.XrStockControlDao;

/**
 * xr_stock_controlService
 * @author Alex
 * @version 2019-04-23
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
		super.save(xrStockControl);
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