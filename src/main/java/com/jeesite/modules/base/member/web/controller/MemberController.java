package com.jeesite.modules.base.member.web.controller;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.base.member.entity.MemberInfo;
import com.jeesite.modules.base.member.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("${adminPath}/memberInfo")
@SuppressWarnings("all")
public class MemberController extends BaseController{

    @Autowired
    private MemberInfoService memberInfoService;

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
}
