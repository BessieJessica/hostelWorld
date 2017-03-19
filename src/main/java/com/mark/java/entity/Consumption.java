package com.mark.java.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by lois on 2017/3/14.
 *
 * 消费记录
 *
 */

@Entity
@Table

public class Consumption {
    private int id;
    private int memberId;
    private Book book;
    private double money;
    private int payType;
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

    @OneToOne
    @JoinColumn(name = "bookId")
    public Book getBook(){return this.book;}
    public void setBook(Book book){this.book = book;}

    @Basic
    @Column(name = "money")
    public double getMoney(){return money;}
    public void setMoney(double money) {this.money = money;}

    @Basic
    @Column(name = "payType")
    public int getPayType(){return payType;}
    public void setPayType(int payType){this.payType = payType;}

    @Basic
    @Column(name = "credit")
    public int getCredit(){return credit;}
    public void setCredit(int credit){this.credit = credit;}

    @Basic
    @Column(name = "time")
    public Timestamp getTime(){return time;}
    public void setTime(Timestamp time){this.time = time;}


}
