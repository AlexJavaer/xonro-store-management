/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockcontrol.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.base.xrstockcontrol.entity.XrStockControl;

/**
 * xr_stock_controlDAO接口
 * @author Alex
 * @version 2019-04-23
 */
@MyBatisDao
public interface XrStockControlDao extends CrudDao<XrStockControl> {
	
}