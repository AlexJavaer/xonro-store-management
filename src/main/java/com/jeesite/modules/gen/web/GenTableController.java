/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.gen.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.gen.entity.GenTable;
import com.jeesite.modules.gen.service.GenTableService;

/**
 * 代码生成表Controller
 * @author alex
 * @version 2019-03-21
 */
@Controller
@RequestMapping(value = "${adminPath}/gen/genTable")
public class GenTableController extends BaseController {

	@Autowired
	private GenTableService genTableService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public GenTable get(String tableName, boolean isNewRecord) {
		return genTableService.get(tableName, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("gen:genTable:view")
	@RequestMapping(value = {"list", ""})
	public String list(GenTable genTable, Model model) {
		model.addAttribute("genTable", genTable);
		return "modules/gen/genTableList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("gen:genTable:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<GenTable> listData(GenTable genTable, HttpServletRequest request, HttpServletResponse response) {
		Page<GenTable> page = genTableService.findPage(new Page<GenTable>(request, response), genTable); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("gen:genTable:view")
	@RequestMapping(value = "form")
	public String form(GenTable genTable, Model model) {
		model.addAttribute("genTable", genTable);
		return "modules/gen/genTableForm";
	}

	/**
	 * 保存代码生成表
	 */
	@RequiresPermissions("gen:genTable:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated GenTable genTable) {
		genTableService.save(genTable);
		return renderResult(Global.TRUE, text("保存代码生成表成功！"));
	}
	
	/**
	 * 删除代码生成表
	 */
	@RequiresPermissions("gen:genTable:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(GenTable genTable) {
		genTableService.delete(genTable);
		return renderResult(Global.TRUE, text("删除代码生成表成功！"));
	}
	
}