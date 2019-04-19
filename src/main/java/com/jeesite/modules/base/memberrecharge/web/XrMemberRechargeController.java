/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.memberrecharge.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.collect.MapUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.mybatis.mapper.provider.InsertSqlProvider;
import com.jeesite.modules.base.member.entity.MemberInfo;
import com.jeesite.modules.base.member.service.MemberInfoService;
import com.jeesite.modules.base.xr.service.XrStoreService;
import com.jeesite.modules.config.MyBatisConfig;
import com.jeesite.modules.sys.entity.Office;
import com.jeesite.modules.test.entity.TestTree;
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
import com.jeesite.modules.base.memberrecharge.entity.XrMemberRecharge;
import com.jeesite.modules.base.memberrecharge.service.XrMemberRechargeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * member_rechargeController
 * @author Crysta-hu
 * @version 2019-04-08
 */
@Controller
@RequestMapping(value = "${adminPath}/xrMemberRecharge")
@SuppressWarnings("all")
public class XrMemberRechargeController extends BaseController {

	@Autowired
	private XrMemberRechargeService xrMemberRechargeService;

	//会员资料的service
	private MemberInfoService memberInfoService;

	//门店资料的service
	private XrStoreService xrStoreService;



	/**
	 * 获取数据
	 */
	@ModelAttribute
	public XrMemberRecharge get(String xmrCode, boolean isNewRecord) {
		return xrMemberRechargeService.get(xmrCode, isNewRecord);
	}

	/**
	 * 查询列表
	 */
	@RequestMapping(value = {"list", ""})
	public String list(XrMemberRecharge xrMemberRecharge, Model model) {
		model.addAttribute("xrMemberRecharge", xrMemberRecharge);
		return "modules/memberrecharge/xrMemberRechargeList";
	}

	/**
	 * 查询列表数据
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<XrMemberRecharge> listData(XrMemberRecharge xrMemberRecharge, HttpServletRequest request, HttpServletResponse response) {
		//实例化page对象
		/*Page page = new Page<XrMemberRecharge>(request, response);
		//设置分页数
		page.setPageSize(20);
		//参数map
		Map map=new HashMap();
		map.put("xrMemberRecharge",xrMemberRecharge);
		page = xrMemberRechargeService.findPageByParam(map);*/
		Page<XrMemberRecharge> page = xrMemberRechargeService.findPage(new Page<XrMemberRecharge>(request, response), xrMemberRecharge);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequestMapping(value = "form")
	public String form(XrMemberRecharge xrMemberRecharge, Model model,MemberInfo memberInfo) {


		model.addAttribute("xrMemberRecharge", xrMemberRecharge);
		return "modules/memberrecharge/xrMemberRechargeForm";
	}

	/**
	 * 保存member_recharge
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated XrMemberRecharge xrMemberRecharge) {
		xrMemberRechargeService.save(xrMemberRecharge);
		return renderResult(Global.TRUE, text("保存会员充值资料成功！"));
	}

	/**
	 * 停用member_recharge
	 */
	/*@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(XrMemberRecharge xrMemberRecharge) {
		xrMemberRecharge.setStatus(XrMemberRecharge.STATUS_DISABLE);
		xrMemberRechargeService.updateStatus(xrMemberRecharge);
		return renderResult(Global.TRUE, text("停用member_recharge成功"));
	}

	*//**
	 * 启用member_recharge
	 *//*
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(XrMemberRecharge xrMemberRecharge) {
		xrMemberRecharge.setStatus(XrMemberRecharge.STATUS_NORMAL);
		xrMemberRechargeService.updateStatus(xrMemberRecharge);
		return renderResult(Global.TRUE, text("启用member_recharge成功"));
	}*/

	/**
	 * 删除member_recharge
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(XrMemberRecharge xrMemberRecharge) {
		xrMemberRechargeService.delete(xrMemberRecharge);
		return renderResult(Global.TRUE, text("删除会员充值资料成功！"));
	}

	/*@RequiresPermissions({"user"})*/
	/*@RequestMapping({"treeData"})
	@ResponseBody
	public String  treeData( ) {
		*//*List<Map<String, Object>> mapList = ListUtils.newArrayList();
		*//**//*MemberInfo where =  new MemberInfo();*//**//*
		*//**//*where.setStatus("0");
		where.setMiCode(miCode);*//**//*
		List<MemberInfo> list = this.memberInfoService.findList(new MemberInfo());

		for(int i = 0; i < list.size(); ++i) {
			MemberInfo mi = (MemberInfo)list.get(i);
			// 过滤非正常的数据
			if (!TestTree.STATUS_NORMAL.equals(mi.getStatus())){
				continue;
			}
			// 过滤被排除的编码（包括所有子级）
			if (StringUtils.isNotBlank(excludeCode)){
				if (mi.getId().equals(excludeCode)){
					continue;
				}
				if (mi.getMiCode().contains("," + excludeCode + ",")){
					continue;
				}
			}
			if ("0".equals(mi.getStatus()) && (!StringUtils.isNotBlank(excludeCode) || !mi.getId().equals(excludeCode) && !mi.getMiCode().contains("," + excludeCode + ",")) && (!StringUtils.isNotBlank(miCode))) {
				Map<String, Object> map = MapUtils.newHashMap();
				map.put("id", mi.getId());
				map.put("pId", mi.getMiCode());
				String name = mi.getMiName();
				if ("true".equals(isShowFullName) || "1".equals(isShowFullName)) {
					name = mi.getMiName();
				}

				mapList.add(map);
			}
		}

		return mapList;*//*
		return "modules/xrMemberRecharge/xrMemberRechargeTabList";
	}
*/


}