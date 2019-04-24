/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockin.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.base.xrstockin.entity.XrStockInS;

/**
 * xr_stock_inDAO接口
 * @author Alex
 * @version 2019-04-24
 */
@MyBatisDao
public interface XrStockInSDao extends CrudDao<XrStockInS> {
	
}