package com.mark.java.entity;

import javax.persistence.*;

/**
 * Created by lois on 2017/3/12.
 */

@Entity
@Table

public class Membership {
    private int id;
    private int memberCode; //会员卡号
    private String cellphone;
    private String password;
    private int state;//0:未激活；1：可使用；2:暂停; 3:停止
//    String name;
    private MemberState memberState;
    private MemberAccount memberAccount;
    private MemberInfo memberInfo;

    @Id
    @Column(name = "id")
    @GeneratedValue
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public int getMemberCode(){return memberCode;}
    public void setMemberCode(int memberCode){this.memberCode = memberCode;}

    public String getCellphone(){return cellphone;}
    public void setCellphone(String cellphone){this.cellphone = cellphone;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

    public int getState(){return state;}
    public void setState(int state){this.state = state;}

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public MemberAccount getMemberAccount(){return memberAccount;}
    public void setMemberAccount(MemberAccount memberAccount){this.memberAccount = memberAccount;}


    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public MemberState getMemberState(){return memberState;}
    public void setMemberState(MemberState memberState){this.memberState = memberState;}

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public MemberInfo getMemberInfo(){return memberInfo;}
    public void setMemberInfo(MemberInfo memberInfo){this.memberInfo = memberInfo;}

//    public String getName(){return name;}
//    public void setName(String name){this.name = name;}
}
