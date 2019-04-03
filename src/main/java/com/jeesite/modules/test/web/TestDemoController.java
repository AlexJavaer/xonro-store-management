package com.jeesite.modules.test.web;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;

import com.jeesite.modules.test.entity.TestData;
import com.jeesite.modules.test.entity.TestDemo;
import com.jeesite.modules.test.service.TestDemoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@RequestMapping("${adminPath}/test11demo")
public class TestDemoController extends BaseController {

    @Autowired
    private TestDemoService testDemoService;

    /**
     * 获取数据
     */
    @ModelAttribute
    public TestDemo get(String id, boolean isNewRecord) {
        return testDemoService.get(id, isNewRecord);
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = {"list", ""})
    public String list(TestDemo testDemo, Model model) {
        model.addAttribute("testData", testDemo);
        return "modules/test/testDataDemoList";
    }

    /**
     * 查询列表数据
     */
    @RequestMapping(value = "listData")
    @ResponseBody
    public Page<TestDemo> listData(TestDemo testDemo, HttpServletRequest request, HttpServletResponse response) {
        Page<TestDemo> page = testDemoService.findPage(new Page<TestDemo>(request, response), testDemo);
        return page;
    }

    /**
     * 查看编辑表单
     */
    @RequestMapping(value = "form")
    public String form(TestData testData, Model model) {
        model.addAttribute("testData", testData);
        return "modules/test/testDataDemoForm";
    }

    /**
     * 保存数据
     */
    @PostMapping(value = "save")
    @ResponseBody
    public String save(@Validated TestDemo testDemo) {
        testDemoService.save(testDemo);
        return renderResult(Global.TRUE, text("保存数据成功！"));
    }

    /**
     * 删除数据
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(TestDemo testDemo) {
       testDemoService.delete(testDemo);
        return renderResult(Global.TRUE, text("删除数据成功！"));
    }

}
