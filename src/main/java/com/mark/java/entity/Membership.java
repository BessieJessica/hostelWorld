package com.mark.java.entity;

import javax.persistence.*;
import java.security.Timestamp;

/**
 * Created by lois on 2017/3/12.
 */

@Entity
@Table

public class Membership {
    private int id;
    private int memberId; //会员卡号
    private String cellphone;
    private String password;
    int state;
//    String name;

    @Id
    @Column(name = "id")
    @GeneratedValue
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public int getMemberId(){return memberId;}
    public void setMemberId(int memberId){this.memberId = memberId;}

    public String getCellphone(){return cellphone;}
    public void setCellphone(String cellphone){this.cellphone = cellphone;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

    public int getState(){return state;}
    public void setState(int state){this.state = state;}

//    public String getName(){return name;}
//    public void setName(String name){this.name = name;}
}
