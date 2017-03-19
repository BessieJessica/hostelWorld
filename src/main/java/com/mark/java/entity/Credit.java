package com.mark.java.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by lois on 2017/3/14.
 *
 * 用户积分兑换记录
 *
 */

@Entity
@Table
public class Credit {
    private int id;
    private int memberId;
    private int type; //1:兑换积分
    private Consumption consumption;
    private int credit;
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
    @Column(name = "type")
    public int getType(){return type;}
    public void setType(int type){this.type = type;}

    @Basic
    @Column(name = "credit")
    public int getCredit(){return credit;}
    public void setCredit(int credit){this.credit = credit;}

    @Basic
    @Column(name = "time")
    public Timestamp getTime(){return time;}
    public void setTime(Timestamp time){this.time = time;}

    @OneToOne
    @JoinColumn(name = "consumptionId")
    public Consumption getConsumption(){return consumption;}
    public void setConsumption(Consumption consumption){this.consumption = consumption;}
}
