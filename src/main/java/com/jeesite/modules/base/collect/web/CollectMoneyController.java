/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.collect.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.base.member.entity.MemberInfo;
import com.jeesite.modules.base.member.service.MemberInfoService;
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
import com.jeesite.modules.base.collect.entity.CollectMoney;
import com.jeesite.modules.base.collect.service.CollectMoneyService;
import java.util.Date;

/**
 * collectMoneyController
 * @author Crysta-hu
 * @version 2019-04-16
 */
@Controller
@SuppressWarnings("all")
@RequestMapping(value = "${adminPath}/collectMoney")
public class CollectMoneyController extends BaseController {

	@Autowired
	private CollectMoneyService collectMoneyService;

	@Autowired
	private MemberInfoService memberInfoService;

	/**
	 * 获取数据
	 */
	@ModelAttribute
	public CollectMoney get(String cmCode, boolean isNewRecord) {
		return collectMoneyService.get(cmCode, isNewRecord);
	}

	/**
	 * 查询列表
	 */
	/*@RequiresPermissions("collect:collectMoney:view")*/
	@RequestMapping(value = {"list", ""})
	public String list(CollectMoney collectMoney, Model model) {
		model.addAttribute("collectMoney", collectMoney);
		return "modules/collect/collectMoneyList";
	}

	/**
	 * 查询列表数据
	 */
	/*@RequiresPermissions("collect:collectMoney:view")*/
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CollectMoney> listData(CollectMoney collectMoney, HttpServletRequest request, HttpServletResponse response) {
		Page<CollectMoney> page = collectMoneyService.findPage(new Page<CollectMoney>(request, response), collectMoney);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	/*@RequiresPermissions("collect:collectMoney:view")*/
	@RequestMapping(value = "form")
	public String form(CollectMoney collectMoney, Model model ) {
		model.addAttribute("collectMoney", collectMoney);
		return "modules/collect/collectMoneyForm";
	}

	/**
	 * 保存collectMoney
	 */
	/*@RequiresPermissions("collect:collectMoney:edit")*/
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CollectMoney collectMoney) {
		collectMoneyService.save(collectMoney);
		return renderResult(Global.TRUE, text("保存订单资料成功！"));
	}

	/**
	 * 删除collectMoney
	 */
	/*@RequiresPermissions("collect:collectMoney:edit")*/
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CollectMoney collectMoney) {
		collectMoneyService.delete(collectMoney);
		return renderResult(Global.TRUE, text("删除订单资料成功！"));
	}


	@RequestMapping(value="CmPaymentMoneyVil")
	@ResponseBody
	public String CmPaymentMoneyVil(HttpServletRequest request, HttpServletResponse response,Model model,MemberInfo memberInfo,CollectMoney collectMoney,Long cm_payment_money) {

		MemberInfo memberInfoData = memberInfoService.findMemberBalance(collectMoney.getCmMemberCard());
		//从会员信息中获取会员卡余额
			return null;





	}
}