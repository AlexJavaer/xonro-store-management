package com.jeesite.modules.base.member.web.controller;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.mybatis.mapper.provider.InsertSqlProvider;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.base.collect.entity.CollectMoney;
import com.jeesite.modules.base.collect.service.CollectMoneyService;
import com.jeesite.modules.base.member.entity.MemberInfo;
import com.jeesite.modules.base.member.service.MemberInfoService;
import com.jeesite.modules.base.memberrecharge.entity.XrMemberRecharge;
import com.jeesite.modules.base.memberrecharge.service.XrMemberRechargeService;
import com.jeesite.modules.config.MyBatisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("${adminPath}/memberInfo")
@SuppressWarnings("all")
public class MemberController extends BaseController{

    @Autowired
    private MemberInfoService memberInfoService;
    private CollectMoneyService collectMoneyService;
    private XrMemberRechargeService xrMemberRechargeService;

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
    public String form(MemberInfo memberInfo, Model model,XrMemberRecharge xrMemberRecharge) {
       /*SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMdd");
        String nowDate = dateFormat.format(new Date());*/
       if(memberInfo.getIsNewRecord()){
           memberInfo.setMiCardNumber(IdGen.nextId());
       }

       if(memberInfo.getMiCode()!=null&& "".equals(memberInfo.getMiCode()) && memberInfo.getMiCardNumber()!=null &&"".equals(memberInfo.getMiCardNumber()) &&memberInfo.getMiCardNumber().equals(xrMemberRecharge.getMiCardNumber().toString())){
           Long miBalance = 0L;

           //给账户存钱
           miBalance += xrMemberRecharge.getXmrSaveMoney();

           //向账户支出
           if(xrMemberRecharge.getXmrReserveValue()<memberInfo.getMiBalance()){
               miBalance = memberInfo.getMiBalance()-xrMemberRecharge.getXmrReserveValue();
           }

           memberInfo.setMiBalance(miBalance);
        }



        model.addAttribute("memberInfoData", memberInfo);
        return "modules/memberInfo/memberDataForm";
    }

    /**
     * 保存数据
     */

    @PostMapping(value="save")
    @ResponseBody
    public String save(@Validated MemberInfo memberInfo) {
        memberInfoService.save(memberInfo);
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

        if(xrMemberRecharge.getIsNewRecord()){
            //当天异动时间
            xrMemberRecharge.setXmrDate(new Date());
            //储值应收初始值
            xrMemberRecharge.setXmrReserveValue(0L);
            //储值金额初始值
            xrMemberRecharge.setXmrSaveMoney(0L);
            //当前余额:最新金额
            /*xrMemberRecharge.setXmrCurrentBalance(0L);
            xrMemberRecharge.setXmrLatestBalance(0L);*/
        }
       //充值有效日期
       xrMemberRecharge.setXmrRechargeValidTime(new Date());
        return "modules/memberInfo/xrMemberRechargeForm";
    }

    @RequestMapping(value="MiCodeIsPhone")
    @ResponseBody
    public String MiCodeIsPhone(HttpServletRequest request, HttpServletResponse response,Model model,String miCode,String miPhone){
        MemberInfo memberInfo = memberInfoService.getByForm(miCode,miPhone);
        if (!memberInfo.getIsNewRecord() && memberInfo !=null && memberInfo.getMiPhone().toString().equals(miPhone)){
            return "1";
        }else{
            return "0";
        }

    }
}
