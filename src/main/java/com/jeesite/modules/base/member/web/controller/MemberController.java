package com.jeesite.modules.base.member.web.controller;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.lang.DateUtils;
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
import com.jeesite.modules.sys.utils.EmpUtils;
import com.jeesite.modules.sys.utils.UserUtils;
import com.sun.org.apache.bcel.internal.generic.CALOAD;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.beetl.ext.format.DateFormat;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("${adminPath}/memberInfo")
@SuppressWarnings("all")
public class MemberController extends BaseController{

    @Autowired
    private MemberInfoService memberInfoService;
    @Autowired
    private CollectMoneyService collectMoneyService;
    @Autowired
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
    public String form(MemberInfo memberInfo, Model model,XrMemberRecharge xrMemberRecharge,String miCardType,Date miEndDate) {
       if(memberInfo.getIsNewRecord()){
           memberInfo.setMiCardNumber(IdGen.nextId());
           Long miBalance = 0L;
           memberInfo.setMiBalance(miBalance);
           memberInfo.setUserName(UserUtils.getUser().getCurrentUser().getUserName());
           memberInfo.setOfficeName(EmpUtils.getOffice().getOfficeName());
           memberInfo.setUserCode(UserUtils.getUser().getCurrentUser().getUserCode());
           memberInfo.setOfficeCode(EmpUtils.getOffice().getOfficeCode());
       }


       if(!memberInfo.getIsNewRecord()){

           memberInfo.setMiBalance(memberInfo.getMiBalance());

       }

       //会员卡有效日期
       memberInfo.setMiEffectiveDate(new Date());
        /*memberInfo.setMiEndDate(new Date());*/
        memberInfo.setCourseOfTreatmentNum(0);
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

    /**
     * 会员充值信息
     * @param xrMemberRecharge
     * @param model
     * @param memberInfo
     * @return
     */
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
            //在会员充值页面回显会员的进店渠道
            xrMemberRecharge.setMiOutlets(miList.getMiOutlets());

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

    /**
     * 验证手机号是否存在
     * @param request
     * @param response
     * @param model
     * @param miCode
     * @param miPhone
     * @return
     */
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


    @RequestMapping(value="formAuthCollectMoney")
    public String formAuthCollectMoney(CollectMoney collectMoney,MemberInfo memberInfo,Model model){

       if(!memberInfo.getIsNewRecord()){
           MemberInfo mi = new MemberInfo();
           mi.setMiCode(memberInfo.getMiCode());
           MemberInfo miList = this.memberInfoService.get(mi);
           //在会员消费页面回显会员的会员姓名
           collectMoney.setCmCustomerName(miList.getMiName());
           //在会员消费页面回显会员的进店渠道
           collectMoney.setCmAccessChannel(miList.getMiOutlets());
           //在会员消费页面回显会员的会员性别
           collectMoney.setCmCustomerSex(miList.getMiSex());
           //在会员消费页面回显会员的手机号码
           collectMoney.setCmCustomerPhone(miList.getMiPhone());
           //在会员消费页面回显会员的会员卡号
           collectMoney.setCmMemberCard(miList.getMiCardNumber());
           //在会员消费页面回显会员的会员卡类型
           collectMoney.setCmMemberType(miList.getMiCardType());
           collectMoney.setCmIsMember("01");
           collectMoney.setMiCode(miList.getMiCode());
           //在会员消费页面回显会员卡余额
           collectMoney.setCmAccountBalance(miList.getMiBalance());
       }
        collectMoney.setCmDate(new Date());
        collectMoney.setCmPaymentMoney(0L);
        model.addAttribute("collectMoney",collectMoney);

       return "modules/memberInfo/collectMoneyForm";
    }


    @RequestMapping(value = "mibalanceOrpaymentMoney")
    @ResponseBody
    public String MibalanceOrpaymentMoney(HttpServletRequest request, HttpServletResponse response,Model model,Long  paymentMoney,Long cmAccountBalance){
        if(cmAccountBalance!=null && cmAccountBalance<paymentMoney ){
            return "1";
        }else{
            return "0";
        }
    }


    @RequestMapping(value = "paymentMoneyProject")
    @ResponseBody
    public void paymentMoneyProject(HttpServletRequest request, HttpServletResponse response,Model model,Long  xpUniformMomberPrice,Long oldPaymentMoney){
        if(oldPaymentMoney>=0 && xpUniformMomberPrice>=0){
            oldPaymentMoney+=xpUniformMomberPrice;

        }

    }

}
