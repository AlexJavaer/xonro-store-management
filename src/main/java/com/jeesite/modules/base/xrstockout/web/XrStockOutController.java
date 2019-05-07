/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.xrstockout.web;

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
import com.jeesite.modules.base.xrstockout.entity.XrStockOut;
import com.jeesite.modules.base.xrstockout.service.XrStockOutService;

/**
 * xr_stock_outController
 * @author Crysta-hu
 * @version 2019-04-30
 */
@Controller
@RequestMapping(value = "${adminPath}/xrstockout/xrStockOut")
public class XrStockOutController extends BaseController {

	@Autowired
	private XrStockOutService xrStockOutService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public XrStockOut get(String id, boolean isNewRecord) {
		return xrStockOutService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("xrstockout:xrStockOut:view")
	@RequestMapping(value = {"list", ""})
	public String list(XrStockOut xrStockOut, Model model) {
		model.addAttribute("xrStockOut", xrStockOut);
		return "base/xrstockout/xrStockOutList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("xrstockout:xrStockOut:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<XrStockOut> listData(XrStockOut xrStockOut, HttpServletRequest request, HttpServletResponse response) {
		Page<XrStockOut> page = xrStockOutService.findPage(new Page<XrStockOut>(request, response), xrStockOut); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("xrstockout:xrStockOut:view")
	@RequestMapping(value = "form")
	public String form(XrStockOut xrStockOut, Model model) {
	    if(xrStockOut.getIsNewRecord()){
	        xrStockOut.setUserCode(UserUtils.getUser().getCurrentUser().getUserCode());
	        xrStockOut.setUserName(UserUtils.getUser().getCurrentUser().getUserName());
	        xrStockOut.setOfficeCode(EmpUtils.getOffice().getOfficeCode());
	        xrStockOut.setOfficeName(EmpUtils.getOffice().getFullName());

        }
		model.addAttribute("xrStockOut", xrStockOut);
		return "base/xrstockout/xrStockOutForm";
	}

	/**
	 * 保存xr_stock_out
	 */
	@RequiresPermissions("xrstockout:xrStockOut:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated XrStockOut xrStockOut) {
		xrStockOutService.save(xrStockOut);
		return renderResult(Global.TRUE, text("保存出库信息成功！"));
	}
	
	/**
	 * 删除xr_stock_out
	 */
	@RequiresPermissions("xrstockout:xrStockOut:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(XrStockOut xrStockOut) {
		xrStockOutService.delete(xrStockOut);
		return renderResult(Global.TRUE, text("删除出库信息成功！"));
	}
	
}