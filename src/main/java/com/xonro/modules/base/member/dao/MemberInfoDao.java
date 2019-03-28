/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.xonro.modules.base.member.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.xonro.modules.base.member.entity.MemberInfo;

/**
 * member_infoDAO接口
 * @author Cyrsta-hu
 * @version 2019-03-28
 */
@MyBatisDao
public interface MemberInfoDao extends CrudDao<MemberInfo> {
	
}