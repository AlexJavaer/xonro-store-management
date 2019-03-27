/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.xonro.modules.base.member.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.xonro.modules.base.member.entity.MemberInfo;

import java.util.List;
import java.util.Map;

/**
 * member_infoDAO接口
 * @author Cyrsta-hu
 * @version 2019-03-26
 */
@MyBatisDao
public interface MemberInfoDao extends CrudDao<MemberInfo> {

    /**
     * 演示Map参数和返回值，支持分页
     */
    public List<Map<String, Object>> findListForMap(Map<String, Object> params);
	
}