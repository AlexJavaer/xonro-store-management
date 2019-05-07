/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstocklog.web;

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
import com.jeesite.modules.base.xrstocklog.entity.XrStockLog;
import com.jeesite.modules.base.xrstocklog.service.XrStockLogService;

/**
 * xr_stock_logController
 * @author Crysta-hu
 * @version 2019-05-05
 */
@Controller
@RequestMapping(value = "${adminPath}/xrstocklog/xrStockLog")
public class XrStockLogController extends BaseController {

	@Autowired
	private XrStockLogService xrStockLogService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public XrStockLog get(String id, boolean isNewRecord) {
		return xrStockLogService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("xrstocklog:xrStockLog:view")
	@RequestMapping(value = {"list", ""})
	public String list(XrStockLog xrStockLog, Model model) {
		model.addAttribute("xrStockLog", xrStockLog);
		return "base/xrstocklog/xrStockLogList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("xrstocklog:xrStockLog:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<XrStockLog> listData(XrStockLog xrStockLog, HttpServletRequest request, HttpServletResponse response) {
		Page<XrStockLog> page = xrStockLogService.findPage(new Page<XrStockLog>(request, response), xrStockLog); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("xrstocklog:xrStockLog:view")
	@RequestMapping(value = "form")
	public String form(XrStockLog xrStockLog, Model model) {
		model.addAttribute("xrStockLog", xrStockLog);
		return "base/xrstocklog/xrStockLogForm";
	}

	/**
	 * 保存xr_stock_log
	 */
	@RequiresPermissions("xrstocklog:xrStockLog:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated XrStockLog xrStockLog) {
		xrStockLogService.save(xrStockLog);
		return renderResult(Global.TRUE, text("保存xr_stock_log成功！"));
	}
	
	/**
	 * 删除xr_stock_log
	 */
	@RequiresPermissions("xrstocklog:xrStockLog:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(XrStockLog xrStockLog) {
		xrStockLogService.delete(xrStockLog);
		return renderResult(Global.TRUE, text("删除xr_stock_log成功！"));
	}
	
}