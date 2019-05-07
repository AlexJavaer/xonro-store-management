/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockinsingle.web;

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
import com.jeesite.modules.base.xrstockinsingle.entity.XrStockInSingle;
import com.jeesite.modules.base.xrstockinsingle.service.XrStockInSingleService;

/**
 * xr_stock_in_singleController
 * @author Crysta-hu
 * @version 2019-05-06
 */
@Controller
@RequestMapping(value = "${adminPath}/xrStockInSingle")
public class XrStockInSingleController extends BaseController {

	@Autowired
	private XrStockInSingleService xrStockInSingleService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public XrStockInSingle get(String id, boolean isNewRecord) {
		return xrStockInSingleService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(XrStockInSingle xrStockInSingle, Model model) {
		model.addAttribute("xrStockInSingle", xrStockInSingle);
		return "base/xrstockinsingle/xrStockInSingleList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<XrStockInSingle> listData(XrStockInSingle xrStockInSingle, HttpServletRequest request, HttpServletResponse response) {
		Page<XrStockInSingle> page = xrStockInSingleService.findPage(new Page<XrStockInSingle>(request, response), xrStockInSingle); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(XrStockInSingle xrStockInSingle, Model model) {
		model.addAttribute("xrStockInSingle", xrStockInSingle);
		return "base/xrstockinsingle/xrStockInSingleForm";
	}

	/**
	 * 保存xr_stock_in_single
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated XrStockInSingle xrStockInSingle) {
		xrStockInSingleService.save(xrStockInSingle);
		return renderResult(Global.TRUE, text("保存产品入库信息成功！"));
	}
	
	/**
	 * 删除xr_stock_in_single
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(XrStockInSingle xrStockInSingle) {
		xrStockInSingleService.delete(xrStockInSingle);
		return renderResult(Global.TRUE, text("删除产品入库信息成功！"));
	}
	
}