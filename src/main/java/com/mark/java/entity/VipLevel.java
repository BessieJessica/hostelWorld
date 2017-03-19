package com.mark.java.entity;

import javax.persistence.*;

/**
 * Created by lois on 2017/3/13.
 */

@Entity
@Table(name = "vipLevel", schema = "J2EE")
public class VipLevel {
    private int level;
    private String name;
    private double discount;
    private double money;


    @Id
    @Column(name = "level")
    public int getLevel(){return level;}
    public void setLevel(int level){this.level = level;}

    @Basic
    @Column(name = "name")
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    @Basic
    @Column(name = "discount")
    public double getDiscount(){return discount;}
    public void setDiscount(double discount){this.discount = discount;}

    @Basic
    @Column(name = "money")
    public double getMoney(){return money;}
    public void setMoney(double money){this.money = money;}
}
