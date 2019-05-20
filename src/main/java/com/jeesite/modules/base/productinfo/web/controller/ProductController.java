package com.jeesite.modules.base.productinfo.web.controller;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.base.productinfo.entity.XrProductinfo;
import com.jeesite.modules.base.productinfo.service.XrProductinfoService;
import com.jeesite.modules.base.project.entity.XrProjectinfo;
import com.jeesite.modules.base.xrstockin.entity.XrStockIn;
import com.jeesite.modules.base.xrstockin.entity.XrStockInS;
import com.jeesite.modules.base.xrstockinsingle.entity.XrStockInSingle;
import com.jeesite.modules.base.xrstockoutsingle.entity.XrStockOutSingle;
import com.jeesite.modules.msg.utils.MsgPushUtils;
import com.jeesite.modules.sys.utils.EmpUtils;
import com.jeesite.modules.sys.utils.UserUtils;
import net.sf.ehcache.util.ProductInfo;
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
@SuppressWarnings("all")
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
        if(xrProductinfo.getIsNewRecord()){
            xrProductinfo.setXpdStockNum(0L);
        }

        if(!xrProductinfo.getIsNewRecord()){
            xrProductinfo.setXpdStockNum(xrProductinfo.getXpdStockNum());
        }
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


    @RequestMapping(value = "formAuthStockInSingle")
    public String formAuthStockIn(Model model, XrProductinfo xrProductinfo, XrStockInSingle xrStockInSingle){
        if(xrStockInSingle.getIsNewRecord()){
            xrStockInSingle.setUserCode(UserUtils.getUser().getCurrentUser().getUserCode());
            xrStockInSingle.setUserName(UserUtils.getUser().getCurrentUser().getUserName());
            xrStockInSingle.setOfficeCode(EmpUtils.getOffice().getOfficeCode());
            xrStockInSingle.setOfficeName(EmpUtils.getOffice().getOfficeName());
        }

        XrProductinfo pi = new XrProductinfo();
        pi.setProductCode(xrProductinfo.getProductCode());
        XrProductinfo piList = this.xrProductinfoService.get(pi);
        //产品入库的产品编号
        xrStockInSingle.setProductCode(piList.getProductCode());
        //产品入库的产品名称
        xrStockInSingle.setProductName(piList.getProductName());
        //产品入库的供货商
        xrStockInSingle.setXpdSupplier(piList.getXpdSupplier());
        //产品入库的进货成本
       /* xrStockInSingle.setXpdPurchased(piList.getXpdPurchased());*/
        //产品入库的单位
        xrStockInSingle.setXpdPurchaseUnit(piList.getXpdPurchaseUnit());
        //产品的库存数量
        xrStockInSingle.setXpdStockNum(piList.getXpdStockNum());

        model.addAttribute("xrStockInSingle", xrStockInSingle);
        return "modules/productInfo/xrStockInSingleForm";
    }

    @RequestMapping(value = "formAuthStockOut")
    public String formAuthStockOut(Model model, XrProductinfo xrProductinfo, XrStockOutSingle xrStockOutSingle){

        if(xrStockOutSingle.getIsNewRecord()){
            xrStockOutSingle.setUserCode(UserUtils.getUser().getCurrentUser().getUserCode());
            xrStockOutSingle.setUserName(UserUtils.getUser().getCurrentUser().getUserName());
            xrStockOutSingle.setOfficeCode(EmpUtils.getOffice().getOfficeCode());
            xrStockOutSingle.setOfficeName(EmpUtils.getOffice().getOfficeName());
        }

        XrProductinfo pi = new XrProductinfo();
        pi.setProductCode(xrProductinfo.getProductCode());
        XrProductinfo piList = this.xrProductinfoService.get(pi);

        //产品出库的产品编号
        xrStockOutSingle.setProductCode(piList.getProductCode());
        //产品出库的产品名称
        xrStockOutSingle.setProductName(piList.getProductName());
        //产品出库的供应商
        xrStockOutSingle.setXpdSupplier(piList.getXpdSupplier());
        //产品出库的单位
        xrStockOutSingle.setXpdPurchaseUnit(piList.getXpdPurchaseUnit());
        //产品的库存数量
        xrStockOutSingle.setXpdStockNum(piList.getXpdStockNum());
        model.addAttribute("xrStockOutSingle",xrStockOutSingle);
        return "modules/productInfo/xrStockOutSingleForm";

    }

    @RequestMapping(value="productStockNum")
    @ResponseBody
    public String productStockNum(HttpServletRequest request, HttpServletResponse response,Long xpdStockNum,Long numberOut){
        if(numberOut!=null&&xpdStockNum<numberOut){
            return "1";
        }else{
            return "0";
        }
    }


    /**
     * 订单页面添加购买产品
     * @param xrProjectinfo
     * @param model
     * @return
     */
    @RequestMapping(value = {"collectProductDataRow", ""})
    public String collectProductDataRow(XrProductinfo xrProductinfo, Model model,String idName) {
        model.addAttribute("idName", idName);
        model.addAttribute("productInfoData", xrProductinfo);
        return "modules/productInfo/collectProductDataRow";
    }
}
