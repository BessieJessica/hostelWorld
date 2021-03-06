package com.mark.java.service;

import com.mark.java.entity.Charge;
import com.mark.java.entity.Credit;
import com.mark.java.entity.Membership;

import java.util.List;
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

    public Map<String, Object> supplyInfo(int id, String name, String birthday, int gender,
                                          String province, String city, String bank);

    public Map<String, Object> editInfo(int id, String name, String birthday, int gender,
                                        String province, String city);

    public void stateRecheck(int id);

    public Membership getMemberById(int id);

    public Membership getMembershipByMemberCode(int memberCode);

    public List<Credit> getCreditsByMember(int id);

    public List<Charge> getChargeByMember(int id);


}
