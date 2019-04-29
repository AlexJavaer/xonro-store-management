/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.xrstockin.entity.XrStockIn;
import com.jeesite.modules.base.xrstockin.dao.XrStockInDao;
import com.jeesite.modules.base.xrstockin.entity.XrStockInS;
import com.jeesite.modules.base.xrstockin.dao.XrStockInSDao;

/**
 * xr_stock_inService
 * @author Alex
 * @version 2019-04-24
 */
@Service
@Transactional(readOnly=true)
@SuppressWarnings("all")
public class XrStockInService extends CrudService<XrStockInDao, XrStockIn> {
	
	@Autowired
	private XrStockInSDao xrStockInSDao;
	
	/**
	 * 获取单条数据
	 * @param xrStockIn
	 * @return
	 */
	@Override
	public XrStockIn get(XrStockIn xrStockIn) {
		XrStockIn entity = super.get(xrStockIn);
		if (entity != null){
			XrStockInS xrStockInS = new XrStockInS(entity);
			xrStockInS.setStatus(XrStockInS.STATUS_NORMAL);
			entity.setXrStockInSList(xrStockInSDao.findList(xrStockInS));
		}
		return entity;
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param xrStockIn
	 * @return
	 */
	@Override
	public Page<XrStockIn> findPage(Page<XrStockIn> page, XrStockIn xrStockIn) {
		return super.findPage(page, xrStockIn);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param xrStockIn
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(XrStockIn xrStockIn) {
		super.save(xrStockIn);
		// 保存 XrStockIn子表
		for (XrStockInS xrStockInS : xrStockIn.getXrStockInSList()){
			if (!XrStockInS.STATUS_DELETE.equals(xrStockInS.getStatus())){
				xrStockInS.setXrStockIn(xrStockIn);
					if (xrStockInS.getIsNewRecord()){
						xrStockInS.preInsert();
						xrStockInSDao.insert(xrStockInS);
				}else{
					xrStockInS.preUpdate();
					xrStockInSDao.update(xrStockInS);
				}
			}else{
				xrStockInSDao.delete(xrStockInS);
			}
		}

	}
	
	/**
	 * 更新状态
	 * @param xrStockIn
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(XrStockIn xrStockIn) {
		super.updateStatus(xrStockIn);
	}
	
	/**
	 * 删除数据
	 * @param xrStockIn
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(XrStockIn xrStockIn) {
		super.delete(xrStockIn);
		XrStockInS xrStockInS = new XrStockInS();
		xrStockInSDao.delete(xrStockInS);
	}
	
}