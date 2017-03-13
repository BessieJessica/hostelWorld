package com.mark.java.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lois on 2017/3/13.
 */

@Entity
@Table

public class MemberAccount {

    private int memberId;
    private int bankId;
    private double balance;
    private int credit;
    private VipLevel vipLevel;


    @Id
    public int getMemberId(){return memberId;}
    public void setMemberId(int memberId){this.memberId = memberId;}

    public int getBankId(){return bankId;}
    public void setBankId(int bankId){this.bankId = bankId;}

    public double getBalance(){return balance;}
    public void setBalance(double balance){this.balance = balance;}

    public int getCredit(){return credit;}
    public void setCredit(int credit){this.credit = credit;}

    public VipLevel getVipLevel(){return vipLevel;}
    public void setVipLevel(VipLevel vipLevel){this.vipLevel = vipLevel;}

}
