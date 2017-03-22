package com.mark.java.controller;

import com.mark.java.entity.Charge;
import com.mark.java.entity.Credit;
import com.mark.java.entity.Membership;
import com.mark.java.service.ChargeService;
import com.mark.java.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by lois on 2017/3/15.
 */

@Controller
public class MembershipController {

    @Autowired
    private MembershipService membershipService;
    @Autowired
    private ChargeService chargeService;

    //supply the personal info
    @RequestMapping(value = "/supplyInfo", method = RequestMethod.GET)
    public String supplyInfoPage(){
        return "membership/supply_info";
    }


    //supplyInfo interface
    @RequestMapping(value = "/supplyInfo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> postSupplyInfo(String name, String birthday, int gender, String province,
                                              String city, String bank, HttpSession session){
        int id = (int)session.getAttribute("id");
        Map<String, Object> map = membershipService.supplyInfo(id, name, birthday,gender,province,city,bank);
        if ((boolean)map.get("success")){
            session.setAttribute("name",map.get("membership_name"));
        }
        return map;
    }

    //充值 激活会员资格
    @RequestMapping(value = "/validate",method = RequestMethod.GET)
    public ModelAndView validatePage(HttpSession session){
        Membership membership = membershipService.getMemberById((int)session.getAttribute("id"));
        ModelAndView modelAndView = new ModelAndView("membership/validate","membership",membership);
        return modelAndView;
    }

    //激活
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> postValidate(String money, HttpSession session){
        return membershipService.validate((int)session.getAttribute("id"),money);
    }

    //个人中心
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard(HttpSession session){
        int id = (int)session.getAttribute("id");

        membershipService.stateRecheck(id);
        Membership membership = membershipService.getMemberById(id);

        if ((int)membership.getState()==3){
            return new ModelAndView("common/error");
        }

        ModelAndView modelAndView = new ModelAndView("membership/dashboard");
        modelAndView.addObject("membership",membership);
        return modelAndView;
    }

    //personal Info
    @RequestMapping(value = "/user/info",method = RequestMethod.GET)
    public ModelAndView info(HttpSession session){
        int id = (int)session.getAttribute("id");
        Membership membership = membershipService.getMemberById(id);
        ModelAndView modelAndView = new ModelAndView("membership/info");
        modelAndView.addObject("membership",membership);
        return modelAndView;
    }

    //修改密码页面
    @RequestMapping(value = "/user/password",method = RequestMethod.GET)
    public String password(HttpSession session){
        return "membership/password";
    }

    //修改密码操作
    @RequestMapping(value = "/user/password", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> postPassword(String old, String newPassword,
                                            String newPasswordAgain, HttpSession session){
        int id = (int)session.getAttribute("id");
        return membershipService.changePassword(id,old,newPassword,newPasswordAgain);
    }

    //积分页面
    @RequestMapping(value = "/user/credit", method = RequestMethod.GET)
    public ModelAndView credit(HttpSession session){
        int id = (int)session.getAttribute("id");
        Membership membership = membershipService.getMemberById(id);
        List<Credit> creditList = membershipService.getCreditsByMember(id);
        ModelAndView modelAndView = new ModelAndView("membership/credit");
        modelAndView.addObject("membership",membership);
        modelAndView.addObject("creditList",creditList);
        return modelAndView;
    }

    //积分兑换
    @RequestMapping(value = "/user/credit/exchange", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> creditExchange(int credit, HttpSession session){
        int id = (int)session.getAttribute("id");
        return membershipService.exchangeCredit(id, credit);
    }

    //我的缴费页面
    @RequestMapping(value = "/user/payment", method = RequestMethod.GET)
    public ModelAndView payment(HttpSession session){
        int id = (int)session.getAttribute("id");
        Membership membership = membershipService.getMemberById(id);
        List<Charge> chargeList = membershipService.getChargeByMember(id);
        ModelAndView modelAndView = new ModelAndView("membership/charge");
        modelAndView.addObject("membership",membership);
        modelAndView.addObject("chargeList",chargeList);
        return modelAndView;
    }

    //充值页面
    @RequestMapping(value = "/user/recharge",method = RequestMethod.GET)
    public ModelAndView rechargePage(HttpSession session){
        int id = (int)session.getAttribute("id");
        Membership membership = membershipService.getMemberById(id);
        ModelAndView modelAndView = new ModelAndView("membership/recharge");
        modelAndView.addObject("membership",membership);
        return modelAndView;
    }

    //充值操作
    @RequestMapping(value = "/user/recharge", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> recharge(int money,String password, HttpSession session){
        int id = (int)session.getAttribute("id");
        return membershipService.recharge(id,money,password);
    }

    //停止账户
    @RequestMapping(value = "user/stop",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> stop(HttpSession session){
        int id = (int)session.getAttribute("id");
        return membershipService.stop(id);
    }

}
