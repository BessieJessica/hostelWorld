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
    private int credit;
    private Timestamp time;

    private Consumption consumption;

    @Id
    @GeneratedValue
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public int getMemberId(){return memberId;}
    public void setMemberId(int memberId){this.memberId = memberId;}

    public int getType(){return type;}
    public void setType(int type){this.type = type;}

    public int getCredit(){return credit;}
    public void setCredit(int credit){this.credit = credit;}

    public Timestamp getTime(){return time;}
    public void setTime(Timestamp time){this.time = time;}

    @OneToOne
    @JoinColumn(name = "consumptionId")
    public Consumption getConsumption(){return consumption;}
    public void setConsumption(Consumption consumption){this.consumption = consumption;}
}
