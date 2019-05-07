/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockout.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.base.xrstockout.entity.XrStockOut;

/**
 * xr_stock_outDAO接口
 * @author Crysta-hu
 * @version 2019-04-30
 */
@MyBatisDao
public interface XrStockOutDao extends CrudDao<XrStockOut> {
	
}