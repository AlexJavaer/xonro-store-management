/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockinsingle.service;

import com.jeesite.common.entity.DataScope;
import com.jeesite.common.mybatis.mapper.query.QueryDataScope;
import com.jeesite.modules.base.productinfo.entity.XrProductinfo;
import com.jeesite.modules.base.productinfo.service.XrProductinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.xrstockinsingle.entity.XrStockInSingle;
import com.jeesite.modules.base.xrstockinsingle.dao.XrStockInSingleDao;

/**
 * xr_stock_in_singleService
 * @author Crysta-hu
 * @version 2019-05-06
 */
@Service
@Transactional(readOnly=true)
@SuppressWarnings("all")
public class XrStockInSingleService extends CrudService<XrStockInSingleDao, XrStockInSingle> {

	@Autowired
	XrProductinfoService xrProductinfoService;

	/**
	 * 获取单条数据
	 * @param xrStockInSingle
	 * @return
	 */
	@Override
	public XrStockInSingle get(XrStockInSingle xrStockInSingle) {
		return super.get(xrStockInSingle);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param xrStockInSingle
	 * @return
	 */
	@Override
	public Page<XrStockInSingle> findPage(Page<XrStockInSingle> page, XrStockInSingle xrStockInSingle) {
		// 生成数据权限过滤条件
		QueryDataScope sss = xrStockInSingle.getSqlMap().getDataScope().addFilter("dsf", "Office",
				"a.office_code", "a.user_code", DataScope.CTRL_PERMI_MANAGE);
		return super.findPage(page, xrStockInSingle);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param xrStockInSingle
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(XrStockInSingle xrStockInSingle) {

		//产品建档之后让产品入库，更新产品的库存数量
		if(xrStockInSingle.getIsNewRecord()){
			XrProductinfo productStockin = xrProductinfoService.getByForm("product_code",xrStockInSingle.getProductCode());
			Long xpdStockNum = productStockin.getXpdStockNum();
			xpdStockNum += xrStockInSingle.getNumberIn();
			productStockin.setXpdStockNum(xpdStockNum);
			productStockin.setStatus("1");
			xrProductinfoService.save(productStockin);

		}

		super.save(xrStockInSingle);
	}
	
	/**
	 * 更新状态
	 * @param xrStockInSingle
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(XrStockInSingle xrStockInSingle) {
		super.updateStatus(xrStockInSingle);
	}
	
	/**
	 * 删除数据
	 * @param xrStockInSingle
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(XrStockInSingle xrStockInSingle) {
		super.delete(xrStockInSingle);
	}
	
}