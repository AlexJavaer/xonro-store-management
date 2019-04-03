/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.test.entity.TestDemo;

/**
 * test_demoDAO接口
 * @author Crysta-hu
 * @version 2019-03-28
 */
@MyBatisDao
public interface TestDemoDao extends CrudDao<TestDemo> {
	
}