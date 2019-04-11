/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.stockcontrol.web;

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
import com.jeesite.modules.base.stockcontrol.entity.XrStockControl;
import com.jeesite.modules.base.stockcontrol.service.XrStockControlService;

/**
 * stockControlController
 * @author Crysta-hu
 * @version 2019-04-10
 */
@Controller
@RequestMapping(value = "${adminPath}/stockcontrol/xrStockControl")
@SuppressWarnings("all")
public class XrStockControlController extends BaseController {

	@Autowired
	private XrStockControlService xrStockControlService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public XrStockControl get(String matterCode, boolean isNewRecord) {
		return xrStockControlService.get(matterCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	/*@RequiresPermissions("stockcontrol:xrStockControl:view")*/
	@RequestMapping(value = {"list", ""})
	public String list(XrStockControl xrStockControl, Model model) {
		model.addAttribute("xrStockControl", xrStockControl);
		return "modules/stockcontrol/xrStockControlList";
	}
	
	/**
	 * 查询列表数据
	 */
	/*@RequiresPermissions("stockcontrol:xrStockControl:view")*/
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<XrStockControl> listData(XrStockControl xrStockControl, HttpServletRequest request, HttpServletResponse response) {
		Page<XrStockControl> page = xrStockControlService.findPage(new Page<XrStockControl>(request, response), xrStockControl); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	/*@RequiresPermissions("stockcontrol:xrStockControl:view")*/
	@RequestMapping(value = "form")
	public String form(XrStockControl xrStockControl, Model model) {
		model.addAttribute("xrStockControl", xrStockControl);
		return "modules/stockcontrol/xrStockControlForm";
	}

	/**
	 * 保存stockControl
	 */
	/*@RequiresPermissions("stockcontrol:xrStockControl:edit")*/
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated XrStockControl xrStockControl) {
		xrStockControlService.save(xrStockControl);
		return renderResult(Global.TRUE, text("保存stockControl成功！"));
	}
	
	/**
	 * 删除stockControl
	 */
	/*@RequiresPermissions("stockcontrol:xrStockControl:edit")*/
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(XrStockControl xrStockControl) {
		xrStockControlService.delete(xrStockControl);
		return renderResult(Global.TRUE, text("删除stockControl成功！"));
	}
	
}