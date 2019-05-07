/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockcontrol.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.sys.utils.EmpUtils;
import com.jeesite.modules.sys.utils.UserUtils;
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
import com.jeesite.modules.base.xrstockcontrol.entity.XrStockControl;
import com.jeesite.modules.base.xrstockcontrol.service.XrStockControlService;

/**
 * xr_stock_controlController
 * @author Alex
 * @version 2019-04-23
 */
@Controller
@RequestMapping(value = "${adminPath}/xrstockcontrol/xrStockControl")
public class XrStockControlController extends BaseController {

	@Autowired
	private XrStockControlService xrStockControlService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public XrStockControl get(String productCode, boolean isNewRecord) {
		return xrStockControlService.get(productCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("xrstockcontrol:xrStockControl:view")
	@RequestMapping(value = {"list", ""})
	public String list(XrStockControl xrStockControl, Model model) {
		model.addAttribute("xrStockControl", xrStockControl);
		return "base/xrstockcontrol/xrStockControlList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("xrstockcontrol:xrStockControl:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<XrStockControl> listData(XrStockControl xrStockControl, HttpServletRequest request, HttpServletResponse response) {
		Page<XrStockControl> page = xrStockControlService.findPage(new Page<XrStockControl>(request, response), xrStockControl); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("xrstockcontrol:xrStockControl:view")
	@RequestMapping(value = "form")
	public String form(XrStockControl xrStockControl, Model model) {
		if(xrStockControl.getIsNewRecord()){
			xrStockControl.setUserCode(UserUtils.getUser().getCurrentUser().getUserCode());
			xrStockControl.setOfficeCode(EmpUtils.getOffice().getOfficeCode());
		}
		model.addAttribute("xrStockControl", xrStockControl);
		return "base/xrstockcontrol/xrStockControlForm";
	}

	/**
	 * 保存xr_stock_control
	 */
	@RequiresPermissions("xrstockcontrol:xrStockControl:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated XrStockControl xrStockControl) {
		xrStockControlService.save(xrStockControl);
		return renderResult(Global.TRUE, text("保存成功！"));
	}
	
	/**
	 * 删除xr_stock_control
	 */
	@RequiresPermissions("xrstockcontrol:xrStockControl:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(XrStockControl xrStockControl) {
		xrStockControlService.delete(xrStockControl);
		return renderResult(Global.TRUE, text("删除库存资料成功！"));
	}
	
}