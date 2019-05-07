/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockoutsingle.web;

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
import com.jeesite.modules.base.xrstockoutsingle.entity.XrStockOutSingle;
import com.jeesite.modules.base.xrstockoutsingle.service.XrStockOutSingleService;

/**
 * xr_stock_out_singleController
 * @author Crysta-hu
 * @version 2019-05-06
 */
@Controller
@RequestMapping(value = "${adminPath}/xrStockOutSingle")
public class XrStockOutSingleController extends BaseController {

	@Autowired
	private XrStockOutSingleService xrStockOutSingleService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public XrStockOutSingle get(String id, boolean isNewRecord) {
		return xrStockOutSingleService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(XrStockOutSingle xrStockOutSingle, Model model) {
		model.addAttribute("xrStockOutSingle", xrStockOutSingle);
		return "base/xrstockoutsingle/xrStockOutSingleList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<XrStockOutSingle> listData(XrStockOutSingle xrStockOutSingle, HttpServletRequest request, HttpServletResponse response) {
		Page<XrStockOutSingle> page = xrStockOutSingleService.findPage(new Page<XrStockOutSingle>(request, response), xrStockOutSingle); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(XrStockOutSingle xrStockOutSingle, Model model) {
		model.addAttribute("xrStockOutSingle", xrStockOutSingle);
		return "base/xrstockoutsingle/xrStockOutSingleForm";
	}

	/**
	 * 保存xr_stock_out_single
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated XrStockOutSingle xrStockOutSingle) {
		xrStockOutSingleService.save(xrStockOutSingle);
		return renderResult(Global.TRUE, text("保存产品出库信息成功！"));
	}
	
	/**
	 * 删除xr_stock_out_single
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(XrStockOutSingle xrStockOutSingle) {
		xrStockOutSingleService.delete(xrStockOutSingle);
		return renderResult(Global.TRUE, text("删除产品出库信息成功！"));
	}
	
}