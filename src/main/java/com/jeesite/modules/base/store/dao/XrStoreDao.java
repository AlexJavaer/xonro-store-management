/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.store.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.base.store.entity.XrStore;

/**
 * xr_storeInfoDAO接口
 * @author Crysta-hu
 * @version 2019-04-08
 */
@MyBatisDao
public interface XrStoreDao extends CrudDao<XrStore> {
	
}