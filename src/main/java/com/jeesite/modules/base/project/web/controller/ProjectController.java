package com.jeesite.modules.base.project.web.controller;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.base.member.entity.MemberInfo;
import com.jeesite.modules.base.project.entity.XrProjectinfo;
import com.jeesite.modules.base.project.service.XrProjectinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("{adminPath}/projectInfo")
public class ProjectController extends BaseController{

    @Autowired
    private XrProjectinfoService xrProjectinfoService;

    /**
     * 获取数据
     */
    @ModelAttribute
    public XrProjectinfo get(String id, boolean isNewRecord) {
        return xrProjectinfoService.get(id ,isNewRecord);
    }

    /**
     * 查询列表
     */

    @RequestMapping(value = {"list", ""})
    public String list(XrProjectinfo xrProjectinfo, Model model) {
        model.addAttribute("projectInfoData", xrProjectinfo);
        return "modules/projectInfo/projectDataList";
    }

    /**
     * 查询列表数据
     */
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<XrProjectinfo> listData(XrProjectinfo xrProjectinfo, HttpServletRequest request, HttpServletResponse response) {
        Page<XrProjectinfo> page = xrProjectinfoService.findPage(new Page<XrProjectinfo>(request, response), xrProjectinfo);
        return page;

    }

    /**
     * 查看编辑表单
     */

    @RequestMapping(value = "form")
    public String form(XrProjectinfo xrProjectinfo, Model model) {
        model.addAttribute("projectInfoData", xrProjectinfo);
        return "modules/projectInfo/projectDataForm";
    }

    /**
     * 保存数据
     */

    @PostMapping(value="save")
    @ResponseBody
    public String save(@Validated XrProjectinfo xrProjectinfo) {
        xrProjectinfoService.save(xrProjectinfo);
        return renderResult(Global.TRUE, text("保存数据成功！"));
    }

    /**
     * 删除数据
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(XrProjectinfo xrProjectinfo) {
        xrProjectinfoService.delete(xrProjectinfo);
        return renderResult(Global.TRUE, text("删除数据成功！"));
    }

    /**
     * 订单页面添加消费项目
     * @param xrProjectinfo
     * @param model
     * @return
     */
    @RequestMapping(value = {"collectProductDataRow", ""})
    public String collectProductDataRow(XrProjectinfo xrProjectinfo, Model model) {
        model.addAttribute("projectInfoData", xrProjectinfo);
            return "modules/projectInfo/collectProjectDataRow";
    }



}
