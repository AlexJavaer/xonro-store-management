/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.test.entity.TestDemo;
import com.jeesite.modules.test.dao.TestDemoDao;

/**
 * test_demoService
 * @author Crysta-hu
 * @version 2019-03-28
 */
@Service
@Transactional(readOnly=true)
public class TestDemoService extends CrudService<TestDemoDao, TestDemo> {
	
	/**
	 * 获取单条数据
	 * @param testDemo
	 * @return
	 */
	@Override
	public TestDemo get(TestDemo testDemo) {
		return super.get(testDemo);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param testDemo
	 * @return
	 */
	@Override
	public Page<TestDemo> findPage(Page<TestDemo> page, TestDemo testDemo) {
		return super.findPage(page, testDemo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param testDemo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TestDemo testDemo) {
		super.save(testDemo);
	}
	
	/**
	 * 更新状态
	 * @param testDemo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TestDemo testDemo) {
		super.updateStatus(testDemo);
	}
	
	/**
	 * 删除数据
	 * @param testDemo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TestDemo testDemo) {
		super.delete(testDemo);
	}
	
}