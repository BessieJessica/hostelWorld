package com.mark.java.entity;

import javax.persistence.*;

/**
 * Created by lois on 2017/3/13.
 */

@Entity
@Table(name = "memberAcount", schema = "J2EE")

public class MemberAccount {

    private int memberId;
    private String bankId;
    private double balance;
    private int credit;
    private VipLevel vipLevel;


    @Id
    @Column(name = "memberId")
    public int getMemberId(){return memberId;}
    public void setMemberId(int memberId){this.memberId = memberId;}

    @Basic
    @Column(name = "bankId")
    public String getBankId(){return bankId;}
    public void setBankId(String bankId){this.bankId = bankId;}

    @Basic
    @Column(name = "balance")
    public double getBalance(){return balance;}
    public void setBalance(double balance){this.balance = balance;}

    @Basic
    @Column(name = "credit")
    public int getCredit(){return credit;}
    public void setCredit(int credit){this.credit = credit;}

    @ManyToOne
    @JoinColumn(name = "vipLevel")
    public VipLevel getVipLevel(){return vipLevel;}
    public void setVipLevel(VipLevel vipLevel){this.vipLevel = vipLevel;}

}
