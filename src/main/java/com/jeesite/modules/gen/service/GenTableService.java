/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.gen.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.gen.entity.GenTable;
import com.jeesite.modules.gen.dao.GenTableDao;

/**
 * 代码生成表Service
 * @author alex
 * @version 2019-03-21
 */
@Service
@Transactional(readOnly=true)
public class GenTableService extends CrudService<GenTableDao, GenTable> {
	
	/**
	 * 获取单条数据
	 * @param genTable
	 * @return
	 */
	@Override
	public GenTable get(GenTable genTable) {
		return super.get(genTable);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param genTable
	 * @return
	 */
	@Override
	public Page<GenTable> findPage(Page<GenTable> page, GenTable genTable) {
		return super.findPage(page, genTable);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param genTable
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(GenTable genTable) {
		super.save(genTable);
	}
	
	/**
	 * 更新状态
	 * @param genTable
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(GenTable genTable) {
		super.updateStatus(genTable);
	}
	
	/**
	 * 删除数据
	 * @param genTable
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(GenTable genTable) {
		super.delete(genTable);
	}
	
}