package com.mark.java.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private int type;
    private int credit;
    private Timestamp time;

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
}
