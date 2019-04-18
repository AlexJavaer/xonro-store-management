package com.jeesite.modules.base.member.web.controller;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.mybatis.mapper.provider.InsertSqlProvider;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.base.collect.entity.CollectMoney;
import com.jeesite.modules.base.collect.service.CollectMoneyService;
import com.jeesite.modules.base.member.entity.MemberInfo;
import com.jeesite.modules.base.member.service.MemberInfoService;
import com.jeesite.modules.base.memberrecharge.entity.XrMemberRecharge;
import com.jeesite.modules.config.MyBatisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("${adminPath}/memberInfo")
@SuppressWarnings("all")
public class MemberController extends BaseController{

    @Autowired
    private MemberInfoService memberInfoService;
    private CollectMoneyService collectMoneyService;

    /**
     * 获取数据
     */
    @ModelAttribute
    public MemberInfo get(String id, boolean isNewRecord) {
        return memberInfoService.get(id ,isNewRecord);
    }

    /**
     * 查询列表
     */

    @RequestMapping(value = {"list", ""})
    public String list(MemberInfo memberInfo, Model model) {
        model.addAttribute("memberInfoData", memberInfo);
        return "modules/memberInfo/memberDataList";
    }

    /**
     * 查询列表数据
     */
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<MemberInfo> listData(MemberInfo memberInfo, HttpServletRequest request, HttpServletResponse response) {
        Page<MemberInfo> page = memberInfoService.findPage(new Page<MemberInfo>(request, response), memberInfo);
        return page;

    }

    /**
     * 查看编辑表单
     */

    @RequestMapping(value = "form")
    public String form(MemberInfo memberInfo, Model model) {
        model.addAttribute("memberInfoData", memberInfo);
        return "modules/memberInfo/memberDataForm";
    }

    /**
     * 保存数据
     */

    @PostMapping(value="save")
    @ResponseBody
    public String save(@Validated MemberInfo MemberInfo) {
        memberInfoService.save(MemberInfo);
        return renderResult(Global.TRUE, text("保存数据成功！"));
    }

    /**
     * 删除数据
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(MemberInfo MemberInfo) {
        memberInfoService.delete(MemberInfo);
        return renderResult(Global.TRUE, text("删除数据成功！"));
    }

    @RequestMapping({"treeData"})
    public String  treeData(MemberInfo memberInfo, Model model ) {
        /*List<Map<String, Object>> mapList = ListUtils.newArrayList();
         *//*MemberInfo where =  new MemberInfo();*//*
         *//*where.setStatus("0");
		where.setMiCode(miCode);*//*
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

		return mapList;*/
        model.addAttribute("memberInfoData", memberInfo);
        return "modules/memberInfo/memberDataListSelect";
    }

   @RequestMapping(value = "formAuthRecharge")
    public String formAuthRecharge(XrMemberRecharge xrMemberRecharge, Model model, MemberInfo memberInfo) {
        if (!memberInfo.getIsNewRecord()) {
            MemberInfo mi = new MemberInfo();
            mi.setMiCode(memberInfo.getMiCode());
            MemberInfo miList = this.memberInfoService.get(mi);
            //在会员充值页面回显会员的会员编号
            xrMemberRecharge.setMiCode(miList.getMiCode());
            //在会员充值页面回显会员的会员名称
            xrMemberRecharge.setMiName(miList.getMiName());
            //在会员充值页面回显会员的会员卡号
            xrMemberRecharge.setMiCardNumber(miList.getMiCardNumber());
            //在会员充值页面回显会员的卡类别
            xrMemberRecharge.setMiCardType(miList.getMiCardType());

            model.addAttribute("xrMemberRecharge",xrMemberRecharge);


        }
       System.err.println(111);
        return "modules/memberInfo/xrMemberRechargeForm";
    }
}
