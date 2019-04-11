/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.stockcontrol.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.base.stockcontrol.entity.XrStockControl;

/**
 * stockControlDAO接口
 * @author Crysta-hu
 * @version 2019-04-10
 */
@MyBatisDao
public interface XrStockControlDao extends CrudDao<XrStockControl> {
	
}