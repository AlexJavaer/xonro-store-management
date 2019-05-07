/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstocklog.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.base.xrstocklog.entity.XrStockLog;

/**
 * xr_stock_logDAO接口
 * @author Crysta-hu
 * @version 2019-05-05
 */
@MyBatisDao
public interface XrStockLogDao extends CrudDao<XrStockLog> {
	
}