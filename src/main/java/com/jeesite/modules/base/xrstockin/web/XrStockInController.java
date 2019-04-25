/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockin.web;

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
import com.jeesite.modules.base.xrstockin.entity.XrStockIn;
import com.jeesite.modules.base.xrstockin.service.XrStockInService;

/**
 * xr_stock_inController
 * @author Alex
 * @version 2019-04-24
 */
@Controller
@RequestMapping(value = "${adminPath}/xrstockin/xrStockIn")
public class XrStockInController extends BaseController {

	@Autowired
	private XrStockInService xrStockInService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public XrStockIn get(String id, boolean isNewRecord) {
		return xrStockInService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("xrstockin:xrStockIn:view")
	@RequestMapping(value = {"list", ""})
	public String list(XrStockIn xrStockIn, Model model) {
		model.addAttribute("xrStockIn", xrStockIn);
		return "base/xrstockin/xrStockInList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("xrstockin:xrStockIn:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<XrStockIn> listData(XrStockIn xrStockIn, HttpServletRequest request, HttpServletResponse response) {
		Page<XrStockIn> page = xrStockInService.findPage(new Page<XrStockIn>(request, response), xrStockIn); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("xrstockin:xrStockIn:view")
	@RequestMapping(value = "form")
	public String form(XrStockIn xrStockIn, Model model) {
		if (xrStockIn.getIsNewRecord()){
			xrStockIn.setOfficeCode(EmpUtils.getOffice().getOfficeCode());
			xrStockIn.setOfficeName(EmpUtils.getOffice().getOfficeName());
			xrStockIn.setUserCode(UserUtils.getUser().getCurrentUser().getUserCode());
			xrStockIn.setUserName(UserUtils.getUser().getCurrentUser().getUserName());
		}
		model.addAttribute("xrStockIn", xrStockIn);
		return "base/xrstockin/xrStockInForm";
	}

	/**
	 * 保存xr_stock_in
	 */
	@RequiresPermissions("xrstockin:xrStockIn:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated XrStockIn xrStockIn) {
		xrStockInService.save(xrStockIn);
		return renderResult(Global.TRUE, text("保存产品入库信息成功！"));
	}
	
	/**
	 * 删除xr_stock_in
	 */
	@RequiresPermissions("xrstockin:xrStockIn:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(XrStockIn xrStockIn) {
		xrStockInService.delete(xrStockIn);
		return renderResult(Global.TRUE, text("删除入库信息成功！"));
	}
	
}