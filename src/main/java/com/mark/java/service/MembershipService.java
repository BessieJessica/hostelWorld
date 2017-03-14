package com.mark.java.service;

import com.mark.java.entity.Membership;

import java.util.Map;

/**
 * Created by lois on 2017/3/12.
 */
public interface MembershipService {

    public Map<String, Object> register(String cellphone, String password, String passwordSecondTime);

    public Map<String, Object> login(String cellphone, String password);

    public Map<String, Object> validate(int id, String money);

    public Map<String, Object> changePassword(int id, String oldPassword, String newPassword, String newPasswordAgain);

    public Map<String, Object> exchangeCredit(int id, int credit);

    public Map<String, Object> recharge(int id, int money, String password);

    public Map<String, Object> stop(int id);

    public Map<String, Object> fillInfo(int id, String name);

    public Map<String, Object> editInfo(int id, String name);

    public void stateRecheck(int id);

    public Membership getMemberById(int id);

    public Membership getMembershipByMemberCode(int memberCode);


    /**
     *

     ----------------------------------------------------------------
     public List<Point> getPointsByCustomer(int id);

     public List<Payment> getPaymentsByCustomer(int id);
     ------------------------------------------------------------
     */

}
