package com.mark.java.service.impl;

/**
 * Created by lois on 2017/3/13.
 */

import com.mark.java.DAO.ChargeDAO;
import com.mark.java.DAO.CreditDAO;
import com.mark.java.DAO.MembershipDAO;
import com.mark.java.entity.Membership;
import com.mark.java.entity.VipLevel;
import com.mark.java.service.MembershipService;
import com.mark.java.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service

public class MembershipServiceImpl implements MembershipService{

    @Autowired
    private MembershipDAO membershipDAO;
    @Autowired
    private CreditDAO creditDAO;
    @Autowired
    private ChargeDAO chargeDAO;


    @Override
    public Map<String, Object> register(String cellphone, String password, String passwordSecondTime) {
        Map<String, Object> map = new HashMap<>();
        cellphone = cellphone.trim();
        password = password.trim();
        passwordSecondTime = passwordSecondTime.trim();

        if(cellphone.length()==0||password.length()==0||password.length()==0){
            map.put("success",false);
            map.put("error","信息不完整!");
        }else if(!Utils.isMobileNumber(cellphone)){
            map.put("success",false);
            map.put("error","手机号码格式错误!");
        }else if(!password.equals(passwordSecondTime)){
            map.put("success",false);
            map.put("error","两次密码输入不同!");
        }else if(membershipDAO.ifMemberExists(cellphone)){
            map.put("success",false);
            map.put("error","该手机号已注册过啦！");
        }else{
            Membership membership = membershipDAO.create(cellphone,password);
            map.put("success",true);
            map.put("id",membership.getId());
            map.put("memberName",membership.getMemberInfo().getName());
        }

        return map;
    }

    @Override
    public Map<String, Object> login(String cellphone, String password) {
        Map<String, Object> map = new HashMap<>();

        cellphone = cellphone.trim();
        password = password.trim();
        if(cellphone.length()==0||password.length()==0){
            map.put("success",false);
            map.put("error","信息不完整！");
        }else {
            Membership membership = membershipDAO.findByCellphone(cellphone);
            if(membership == null){
                map.put("success",false);
                map.put("error","手机号或密码错误！");
            }else{
                if(!password.equals(membership.getPassword())){
                    map.put("success",false);
                    map.put("error","手机号或密码错误！");
                }else{
                    map.put("success",true);
                    map.put("id",membership.getId());
                    map.put("memberName",membership.getMemberInfo().getName());
                }
            }
        }
        return map;
    }

    /**
     *
     * @param id
     * @param money
     * @return
     * 激活会员卡
     */
    @Override
    public Map<String, Object> validate(int id, String money) {
        Map<String, Object> map = new HashMap<>();

        int moneyInt = 0;
        try{
            moneyInt = Integer.parseInt(money);
        }catch (Exception e){
            map.put("success", false);
            map.put("error", "金额格式有误！");
            return map;
        }

        if(moneyInt<1000){
            map.put("success",false);
            map.put("error","信息不完整！");
            return map;
        }

        Membership membership = membershipDAO.findById(id);
        membership.getMemberAccount().setBalance(membership.getMemberAccount().getBalance()+moneyInt);
        membership.setState(1);

        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        membership.getMemberState().setStartTime(startTime);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.YEAR,1);
        Timestamp pauseTime = new Timestamp(calendar.getTime().getTime());
        membership.getMemberState().setPauseTime(pauseTime);

        calendar.add(Calendar.YEAR,1);
        Timestamp stopTime = new Timestamp(calendar.getTime().getTime());
        membership.getMemberState().setStopTime(stopTime);

        VipLevel vipLevel = new VipLevel();

        //不同金额对应不同等级
        //money:10000 -> 10级；money:9000 -> 9级
        int level = moneyInt/1000;
        if ((int) membership.getMemberAccount().getVipLevel().getLevel()<level){
            vipLevel.setLevel(level);
            membership.getMemberAccount().setVipLevel(vipLevel);
        }

        membershipDAO.update(membership);

        map.put("success",true);

        return map;
    }

    @Override
    public Map<String, Object> changePassword(int id, String oldPassword, String newPassword, String newPasswordAgain) {
        Map<String, Object> map = new HashMap<>();

        oldPassword.trim();
        newPassword.trim();
        newPasswordAgain.trim();

        if(oldPassword.length()==0||newPassword.length()== 0||newPasswordAgain.length() ==0){
            map.put("success",false);
            map.put("error","密码未填充完整！");
        }else if(!newPassword.equals(newPasswordAgain)){
            map.put("success",false);
            map.put("error","密码不一致！");
        }else{
            Membership membership = membershipDAO.findById(id);
            if(!oldPassword.equals(membership.getPassword())){
                map.put("success",false);
                map.put("error","原始密码输入错误！");
            }else{
                membership.setPassword(newPassword);
                membershipDAO.update(membership);
                map.put("success",true);
            }
        }

        return map;
    }

    @Override
    public Map<String, Object> exchangeCredit(int id, int credit) {
        Map<String,Object> map = new HashMap<>();

        Membership membership = membershipDAO.findById(id);
        int currentCredit = membership.getMemberAccount().getCredit();
        double currentBalance = membership.getMemberAccount().getBalance();

        if (currentCredit < 100){
            map.put("success",false);
            map.put("error","抱歉您的积分不足100～");
            return map;
        }

        if (credit < 100){
            map.put("success",false);
            map.put("error","至少100积分才可以兑换～");
            return map;
        }

        if (credit > currentCredit){
             map.put("sucess",false);
             map.put("error","想要兑换积分超过已有积分啦！");
             return map;
        }

        int afterCredit = currentCredit - credit;
        membership.getMemberAccount().setCredit(afterCredit);

        //100积分 -> 一元
        double afterBalance = currentBalance + credit*1.0/100;
        membership.getMemberAccount().setBalance(afterBalance);

        membershipDAO.update(membership);

        //积分记录
        creditDAO.create(id,credit,1,null);

        map.put("success",true);
        map.put("credit",membership.getMemberAccount().getCredit());

        return map;
    }

    @Override
    public Map<String, Object> recharge(int id, int money, String password) {
        Map<String,Object> map = new HashMap<>();

        if (money<100) {
            map.put("success",false);
            map.put("error","充值金额不足100元！");
            return map;
        }

        Membership membership = membershipDAO.findById(id);
        if(!password.equals(membership.getPassword())){
            map.put("success",false);
            map.put("error","密码输入有误～");
            return map;
        }

        double afterBalance = membership.getMemberAccount().getBalance()+money;
        membership.getMemberAccount().setBalance(afterBalance);
        membership.setState(1);

        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        membership.getMemberState().setStartTime(startTime);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.YEAR,1);
        Timestamp pauseTime = new Timestamp(calendar.getTime().getTime());
        membership.getMemberState().setPauseTime(pauseTime);

        calendar.add(Calendar.YEAR,1);
        Timestamp stopTime = new Timestamp(calendar.getTime().getTime());
        membership.getMemberState().setStopTime(stopTime);

        VipLevel vipLevel = new VipLevel();
        int level = money/1000;
        if(membership.getMemberAccount().getVipLevel().getLevel()<level){
            vipLevel.setLevel(level);
            membership.getMemberAccount().setVipLevel(vipLevel);
        }

        membershipDAO.update(membership);
        chargeDAO.create(id, money);
        map.put("success",true);

        return map;
    }

    @Override
    public Map<String, Object> stop(int id) {
        Map<String, Object> map = new HashMap<>();

        Membership membership = membershipDAO.findById(id);
        membership.setState(3);

        membershipDAO.update(membership);
        map.put("success",true);
        return map;
    }

    @Override
    public Map<String, Object> fillInfo(int id, String name) {
        Map<String, Object> map = new HashMap<>();

        name = name.trim();

        if(name.length()==0){
            map.put("success",false);
            map.put("error","信息不完整！");
            return map;
        }

        Membership membership = membershipDAO.findById(id);
        membership.getMemberInfo().setName(name);
        membershipDAO.update(membership);
        map.put("success",true);
        map.put("memberName",membership.getMemberInfo().getName());
        
        return map;
    }

    @Override
    public Map<String, Object> editInfo(int id, String name) {
        Map<String, Object> map = new HashMap<>();
        Membership membership = membershipDAO.findById(id);
        membership.getMemberInfo().setName(name);
        membershipDAO.update(membership);
        map.put("success",true);

        return map;
    }

    @Override
    public void stateRecheck(int id) {
        Membership membership = membershipDAO.findById(id);

        if(membership.getState()==3){
            return;
        }
        if (membership.getState()==0&&membership.getMemberState().getPauseTime()==null){
            return;
        }

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        Timestamp pauseTime = membership.getMemberState().getPauseTime();
        Timestamp stopTime = membership.getMemberState().getStopTime();

        Calendar calendar = Calendar.getInstance();

        if(stopTime == null){
            calendar.setTime(new Date(stopTime.getTime()));
            calendar.add(Calendar.YEAR,1);
            membership.getMemberState().setStopTime(new Timestamp(calendar.getTime().getTime()));
            stopTime = membership.getMemberState().getStopTime();
        }

        if(membership.getMemberAccount().getBalance()<100
                && currentTime.compareTo(pauseTime)>0){
            membership.setState(2);
            calendar.setTime(new Date(pauseTime.getTime()));
            calendar.add(Calendar.YEAR,1);
            membership.getMemberState().setStopTime(new Timestamp(calendar.getTime().getTime()));
        }else if(currentTime.compareTo(pauseTime)<0){
            membership.setState(1);
        }

        if(currentTime.compareTo(stopTime) > 0){
            membership.setState(3);
        }

        membershipDAO.update(membership);

    }

    @Override
    public Membership getMemberById(int id) {

        return membershipDAO.findById(id);
    }

    @Override
    public Membership getMembershipByMemberCode(int memberCode) {

        return membershipDAO.findByMemberCode(memberCode);
    }



}
