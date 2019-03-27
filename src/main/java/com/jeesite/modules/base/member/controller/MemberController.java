package com.jeesite.modules.base.member.controller;

import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.base.member.entity.MemberInfo;
import com.jeesite.modules.base.member.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("${adminPath}/memberinfo")
public class MemberController extends BaseController{

    @Autowired
    private MemberInfoService memberInfoService;

    /**
     * 查询列表
     */

    @RequestMapping(value = {"list", ""})
    public String list(MemberInfo MemberInfo, Model model) {
        model.addAttribute("memberinfoData", MemberInfo);
        return "modules/memberinfo/memberDataList";
    }

    /**
     * 查询列表数据
     */
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<MemberInfo> listData(MemberInfo MemberInfo, HttpServletRequest request, HttpServletResponse response) {
       Page<MemberInfo> page = memberInfoService.findPage(new Page<MemberInfo>(request, response), MemberInfo);
        return page;

    }
}
