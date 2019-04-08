package com.jeesite.modules.base.store.web.controller;


import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.base.store.entity.XrStore;
import com.jeesite.modules.base.store.service.XrStoreService;
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
@RequestMapping("{adminPath}/storeInfo")
public class StoreController extends BaseController{

    @Autowired
    private XrStoreService xrStoreService;

    /**
     * 获取数据
     */
    @ModelAttribute
    public XrStore get(String id, boolean isNewRecord) {
        return xrStoreService.get(id ,isNewRecord);
    }

    /**
     * 查询列表
     */

    @RequestMapping(value = {"list", ""})
    public String list(XrStore xrStore, Model model) {
        model.addAttribute("storeInfoData", xrStore);
        return "modules/storeInfo/storeDataList";
    }

    /**
     * 查询列表数据
     */
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<XrStore> listData(XrStore xrStore, HttpServletRequest request, HttpServletResponse response) {
        Page<XrStore> page = xrStoreService.findPage(new Page<XrStore>(request, response), xrStore);
        return page;

    }

    /**
     * 查看编辑表单
     */

    @RequestMapping(value = "form")
    public String form(XrStore xrStore, Model model) {
        model.addAttribute("storeInfoData", xrStore);
        return "modules/storeInfo/storeDataForm";
    }

    /**
     * 保存数据
     */

    @PostMapping(value="save")
    @ResponseBody
    public String save(@Validated XrStore xrStore) {
        xrStoreService.save(xrStore);
        return renderResult(Global.TRUE, text("保存数据成功！"));
    }

    /**
     * 删除数据
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(XrStore xrStore) {
        xrStoreService.delete(xrStore);
        return renderResult(Global.TRUE, text("删除数据成功！"));
    }
}
