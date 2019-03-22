/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.gen.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.gen.entity.GenTable;

/**
 * 代码生成表DAO接口
 * @author alex
 * @version 2019-03-21
 */
@MyBatisDao
public interface GenTableDao extends CrudDao<GenTable> {
	
}