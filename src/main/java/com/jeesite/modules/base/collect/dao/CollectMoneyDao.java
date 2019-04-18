/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.collect.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.base.collect.entity.CollectMoney;

/**
 * collectMoneyDAO接口
 * @author Crysta-hu
 * @version 2019-04-18
 */
@MyBatisDao
public interface CollectMoneyDao extends CrudDao<CollectMoney> {
	
}