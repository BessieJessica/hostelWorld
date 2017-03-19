package com.mark.java.entity;

import javax.persistence.*;
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
    @Column(name = "id")
    @GeneratedValue
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    @Basic
    @Column(name = "memberId")
    public int getMemberId(){return memberId;}
    public void setMemberId(int memberId){this.memberId = memberId;}

    @Basic
    @Column(name = "money")
    public int getMoney(){return money;}
    public void setMoney(int money){this.money = money;}

    @Basic
    @Column(name = "time")
    public Timestamp getTime(){return time;}
    public void setTime(Timestamp time){this.time = time;}
}
