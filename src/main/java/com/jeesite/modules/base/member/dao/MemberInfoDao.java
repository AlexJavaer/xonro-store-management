/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.member.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.base.member.entity.MemberInfo;

import java.util.HashMap;

/**
 * member_infoDAO接口
 * @author Cyrsta-hu
 * @version 2019-04-18
 */
@MyBatisDao
@SuppressWarnings("all")
public interface MemberInfoDao extends CrudDao<MemberInfo> {

    /**
     * 根据id查询手机号
     * @param hmap
     * @return
     */
    public MemberInfo getByForm(HashMap<String,Object> hmap);

    /**
     * 查询根据id查询会员余额
     * @param miCode
     * @return
     */
    public MemberInfo findMemberBalance(String miCode);
	
}