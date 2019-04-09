/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xr.web;

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
import com.jeesite.modules.base.xr.entity.XrStore;
import com.jeesite.modules.base.xr.service.XrStoreService;

/**
 * xr_storeController
 * @author Alex
 * @version 2019-04-08
 */
@Controller
@RequestMapping(value = "${adminPath}/xr/xrStore")
public class XrStoreController extends BaseController {

	@Autowired
	private XrStoreService xrStoreService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public XrStore get(String xsCode, boolean isNewRecord) {
		return xrStoreService.get(xsCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	/*@RequiresPermissions("xr:xrStore:view")*/
	@RequestMapping(value = {"list", ""})
	public String list(XrStore xrStore, Model model) {
		model.addAttribute("xrStore", xrStore);
		return "modules/xr/xrStoreList";
	}
	
	/**
	 * 查询列表数据
	 */
	/*@RequiresPermissions("xr:xrStore:view")*/
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<XrStore> listData(XrStore xrStore, HttpServletRequest request, HttpServletResponse response) {
		Page<XrStore> page = xrStoreService.findPage(new Page<XrStore>(request, response), xrStore); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	/*@RequiresPermissions("xr:xrStore:view")*/
	@RequestMapping(value = "form")
	public String form(XrStore xrStore, Model model) {
		model.addAttribute("xrStore", xrStore);
		return "modules/xr/xrStoreForm";
	}

	/**
	 * 保存xr_store
	 */
	/*@RequiresPermissions("xr:xrStore:edit")*/
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated XrStore xrStore) {
		xrStoreService.save(xrStore);
		return renderResult(Global.TRUE, text("保存xr_store成功！"));
	}
	
	/**
	 * 删除xr_store
	 */
	/*@RequiresPermissions("xr:xrStore:edit")*/
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(XrStore xrStore) {
		xrStoreService.delete(xrStore);
		return renderResult(Global.TRUE, text("删除xr_store成功！"));
	}
	
}