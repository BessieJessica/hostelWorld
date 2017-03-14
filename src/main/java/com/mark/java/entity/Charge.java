package com.mark.java.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by lois on 2017/3/13.
 *
 * 用户账单
 * 记录充值信息
 */

@Entity
@Table
public class Charge {
    private int id;
    private int memberId;
    private int money;
    private Timestamp time;

    @Id
    @GeneratedValue
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public int getMemberId(){return memberId;}
    public void setMemberId(int memberId){this.memberId = memberId;}

    public int getMoney(){return money;}
    public void setMoney(int money){this.money = money;}

    public Timestamp getTime(){return time;}
    public void setTime(Timestamp time){this.time = time;}
}
