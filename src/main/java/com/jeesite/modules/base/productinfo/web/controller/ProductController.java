package com.jeesite.modules.base.productinfo.web.controller;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.base.productinfo.entity.XrProductinfo;
import com.jeesite.modules.base.productinfo.service.XrProductinfoService;
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
@RequestMapping("{adminPath}/productInfo")
public class ProductController extends BaseController {

    @Autowired
    private XrProductinfoService xrProductinfoService;

    /**
     * 获取数据
     */
    @ModelAttribute
    public XrProductinfo get(String id, boolean isNewRecord) {
        return xrProductinfoService.get(id ,isNewRecord);
    }

    /**
     * 查询列表
     */

    @RequestMapping(value = {"list", ""})
    public String list(XrProductinfo xrProductinfo, Model model) {
        model.addAttribute("productInfoData", xrProductinfo);
        return "modules/productInfo/productDataList";
    }

    /**
     * 查询列表数据
     */
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<XrProductinfo> listData(XrProductinfo xrProductinfo, HttpServletRequest request, HttpServletResponse response) {
        Page<XrProductinfo> page = xrProductinfoService.findPage(new Page<XrProductinfo>(request, response), xrProductinfo);
        return page;

    }

    /**
     * 查看编辑表单
     */

    @RequestMapping(value = "form")
    public String form(XrProductinfo xrProductinfo, Model model) {
        model.addAttribute("productInfoData", xrProductinfo);
        return "modules/productInfo/productDataForm";
    }

    /**
     * 保存数据
     */

    @PostMapping(value="save")
    @ResponseBody
    public String save(@Validated XrProductinfo xrProductinfo) {
        xrProductinfoService.save(xrProductinfo);
        return renderResult(Global.TRUE, text("保存数据成功！"));
    }

    /**
     * 删除数据
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(XrProductinfo xrProductinfo) {
        xrProductinfoService.delete(xrProductinfo);
        return renderResult(Global.TRUE, text("删除数据成功！"));
    }
}
