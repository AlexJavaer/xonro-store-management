/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xr.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.base.xr.entity.XrStore;

/**
 * xr_storeDAO接口
 * @author Alex
 * @version 2019-04-08
 */
@MyBatisDao
public interface XrStoreDao extends CrudDao<XrStore> {
	
}