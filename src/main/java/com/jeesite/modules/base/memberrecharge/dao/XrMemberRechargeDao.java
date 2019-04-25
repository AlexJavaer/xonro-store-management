/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.memberrecharge.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.base.member.entity.MemberInfo;
import com.jeesite.modules.base.memberrecharge.entity.XrMemberRecharge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * memberRechargeDAO接口
 * @author Crysta-hu
 * @version 2019-04-10
 */
@MyBatisDao
public interface XrMemberRechargeDao extends CrudDao<XrMemberRecharge> {
    /**
     * 查询分页的数据
     * @param map
     * @return
     */
   /* public List findPageBYParam(Map map);*/

    /**
     *查询记录数
     * @param map
     * @return
     * int 返回类型
     */
    /*public int byParamCount(Map map);*/

    /**
     * 查询会员充值信息
     * @param map
     * @return
     */
    public XrMemberRecharge findMemberCardNum(HashMap<String,Object> hmap);

}