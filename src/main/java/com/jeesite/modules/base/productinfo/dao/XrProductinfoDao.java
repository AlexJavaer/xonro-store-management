/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.productinfo.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.base.productinfo.entity.XrProductinfo;

import java.util.HashMap;

/**
 * xr_productinfoDAO接口
 * @author Crysta-hu
 * @version 2019-04-04
 */
@MyBatisDao
public interface XrProductinfoDao extends CrudDao<XrProductinfo> {


    /**
     * 根据id查询库存数量
     * @param hmap
     * @return
     */
    public XrProductinfo getByForm(HashMap<String,Object> hmap);
	
}