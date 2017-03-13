package com.mark.java.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lois on 2017/3/13.
 */

@Entity
@Table
public class VipLevel {
    private int level;
    private String name;
    private double discount;
    private double money;


    @Id
    public int getLevel(){return level;}
    public void setLevel(int level){this.level = level;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public double getDiscount(){return discount;}
    public void setDiscount(double discount){this.discount = discount;}

    public double getMoney(){return money;}
    public void setMoney(double money){this.money = money;}
}
