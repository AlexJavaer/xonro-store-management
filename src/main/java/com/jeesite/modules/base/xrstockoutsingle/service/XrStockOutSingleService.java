/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockoutsingle.service;

import com.jeesite.common.entity.DataScope;
import com.jeesite.common.mybatis.mapper.query.QueryDataScope;
import com.jeesite.modules.base.productinfo.entity.XrProductinfo;
import com.jeesite.modules.base.productinfo.service.XrProductinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.xrstockoutsingle.entity.XrStockOutSingle;
import com.jeesite.modules.base.xrstockoutsingle.dao.XrStockOutSingleDao;

/**
 * xr_stock_out_singleService
 * @author Crysta-hu
 * @version 2019-05-06
 */
@Service
@Transactional(readOnly=true)
@SuppressWarnings("all")
public class XrStockOutSingleService extends CrudService<XrStockOutSingleDao, XrStockOutSingle> {

	@Autowired
	private XrProductinfoService xrProductinfoService;

	/**
	 * 获取单条数据
	 * @param xrStockOutSingle
	 * @return
	 */
	@Override
	public XrStockOutSingle get(XrStockOutSingle xrStockOutSingle) {
		return super.get(xrStockOutSingle);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param xrStockOutSingle
	 * @return
	 */
	@Override
	public Page<XrStockOutSingle> findPage(Page<XrStockOutSingle> page, XrStockOutSingle xrStockOutSingle) {
		// 生成数据权限过滤条件
		QueryDataScope sss = xrStockOutSingle.getSqlMap().getDataScope().addFilter("dsf", "Office",
				"a.office_code", "a.user_code", DataScope.CTRL_PERMI_MANAGE);
		return super.findPage(page, xrStockOutSingle);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param xrStockOutSingle
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(XrStockOutSingle xrStockOutSingle) {
		//产品出库之后跟新产品库存数量
		XrProductinfo productStockOut = xrProductinfoService.getByForm("product_code",xrStockOutSingle.getProductCode());
		//产品库存数量
		Long xpdStockNum = productStockOut.getXpdStockNum();
		//产品出库数量
		Long numberOut = xrStockOutSingle.getNumberOut();
		if(xpdStockNum >= numberOut && xpdStockNum>0){
			xpdStockNum = xpdStockNum-xrStockOutSingle.getNumberOut();
			productStockOut.setXpdStockNum(xpdStockNum);
			productStockOut.setStatus("2");
			xrProductinfoService.save(productStockOut);
		}

		super.save(xrStockOutSingle);
	}
	
	/**
	 * 更新状态
	 * @param xrStockOutSingle
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(XrStockOutSingle xrStockOutSingle) {
		super.updateStatus(xrStockOutSingle);
	}
	
	/**
	 * 删除数据
	 * @param xrStockOutSingle
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(XrStockOutSingle xrStockOutSingle) {
		super.delete(xrStockOutSingle);
	}
	
}