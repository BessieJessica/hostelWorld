package com.mark.java.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by lois on 2017/3/14.
 *
 * 预定记录
 * 每条预定记录可以包含多个房间的预定
 */

@Entity
@Table

public class Book {

    private int id;
    private int memberId;
    private int hotelId;
    private int state; //订单状态：未生效／生效／取消
    private Timestamp createTime;
    private Timestamp cheakinTime;
    private Timestamp checkoutTime;
    private int userId;
    private double discount;
    private double originalPay;
    private double actualPay;
    private int credit;

    private Set<BookItem> bookItems;

    @Id
    @GeneratedValue
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public int getMemberId(){return memberId;}
    public void setMemberId(int memberId){this.memberId = memberId;}

    public int getHotelId(){return hotelId;}
    public void setHotelId(int hotelId){this.hotelId = hotelId;}

    public int getState(){return state;}
    public void setState(int state){this.state = state;}

    public Timestamp getCreateTime(){return createTime;}
    public void setCreateTime(Timestamp createTime){this.createTime = createTime;}

    public Timestamp getCheakinTime(){return cheakinTime;}
    public void setCheakinTime(Timestamp cheakinTime){this.cheakinTime = cheakinTime;}

    public Timestamp getCheckoutTime(){return checkoutTime;}
    public void setCheckoutTime(Timestamp checkoutTime){this.checkoutTime = checkoutTime;}

    public int getUserId(){return userId;}
    public void setUserId(int userId){this.userId = userId;}

    public double getDiscount(){return discount;}
    public void setDiscount(double discount){this.discount = discount;}

    public double getOriginalPay(){return originalPay;}
    public void setOriginalPay(double originalPay){this.originalPay = originalPay;}

    public double getActualPay(){return actualPay;}
    public void setActualPay(double actualPay) {this.actualPay = actualPay;}

    public int getCredit(){return credit;}
    public void setCredit(int credit) {this.credit = credit;}

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    public Set<BookItem> getBookItems(){return bookItems;}
    public void setBookItems(Set<BookItem> bookItems){this.bookItems = bookItems;}
}
