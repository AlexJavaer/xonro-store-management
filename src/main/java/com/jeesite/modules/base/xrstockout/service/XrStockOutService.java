/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.xrstockout.entity.XrStockOut;
import com.jeesite.modules.base.xrstockout.dao.XrStockOutDao;
import com.jeesite.modules.base.xrstockout.entity.XrStockOutS;
import com.jeesite.modules.base.xrstockout.dao.XrStockOutSDao;

/**
 * xr_stock_outService
 * @author Crysta-hu
 * @version 2019-04-30
 */
@Service
@Transactional(readOnly=true)
public class XrStockOutService extends CrudService<XrStockOutDao, XrStockOut> {
	
	@Autowired
	private XrStockOutSDao xrStockOutSDao;
	
	/**
	 * 获取单条数据
	 * @param xrStockOut
	 * @return
	 */
	@Override
	public XrStockOut get(XrStockOut xrStockOut) {
		XrStockOut entity = super.get(xrStockOut);
		if (entity != null){
			XrStockOutS xrStockOutS = new XrStockOutS(entity);
			xrStockOutS.setStatus(XrStockOutS.STATUS_NORMAL);
			entity.setXrStockOutSList(xrStockOutSDao.findList(xrStockOutS));
		}
		return entity;
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param xrStockOut
	 * @return
	 */
	@Override
	public Page<XrStockOut> findPage(Page<XrStockOut> page, XrStockOut xrStockOut) {
		return super.findPage(page, xrStockOut);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param xrStockOut
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(XrStockOut xrStockOut) {
		xrStockOut.setStockType("11");
		super.save(xrStockOut);
		// 保存 XrStockOut子表
		for (XrStockOutS xrStockOutS : xrStockOut.getXrStockOutSList()){
			if (!XrStockOutS.STATUS_DELETE.equals(xrStockOutS.getStatus())){
				xrStockOutS.setXrStockOut(xrStockOut);
				if (xrStockOutS.getIsNewRecord()){
					xrStockOutS.preInsert();
					xrStockOutSDao.insert(xrStockOutS);
				}else{
					xrStockOutS.preUpdate();
					xrStockOutSDao.update(xrStockOutS);
				}
			}else{
				xrStockOutSDao.delete(xrStockOutS);
			}
		}
	}
	
	/**
	 * 更新状态
	 * @param xrStockOut
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(XrStockOut xrStockOut) {
		super.updateStatus(xrStockOut);
	}
	
	/**
	 * 删除数据
	 * @param xrStockOut
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(XrStockOut xrStockOut) {
		super.delete(xrStockOut);
		XrStockOutS xrStockOutS = new XrStockOutS();
		xrStockOutSDao.delete(xrStockOutS);
	}
	
}