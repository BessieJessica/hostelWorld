package com.mark.java.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
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
    private Date checkinDate;
    private Date checkoutDate;
    private Date payDate;
    private int userId;
    private double discount;
    private double originalPay;
    private double actualPay;
    private int credit;

    private Set<BookItem> bookItems;

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
    @Column(name = "hostelId")
    public int getHotelId(){return hotelId;}
    public void setHotelId(int hotelId){this.hotelId = hotelId;}

    @Basic
    @Column(name = "state")
    public int getState(){return state;}
    public void setState(int state){this.state = state;}

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime(){return createTime;}
    public void setCreateTime(Timestamp createTime){this.createTime = createTime;}

    @Basic
    @Column(name = "checkinDate")
    public Date getCheckinDate() {return checkinDate;}
    public void setCheckinDate(Date checkinDate) {this.checkinDate = checkinDate;}

    @Basic
    @Column(name = "checkoutDate")
    public Date getCheckoutDate() {return checkoutDate;}
    public void setCheckoutDate(Date checkoutDate) {this.checkoutDate = checkoutDate;}

    @Basic
    @Column(name = "payDate")
    public Date getPayDate() {return payDate;}
    public void setPayDate(Date payDate) {this.payDate = payDate;}

    @Basic
    @Column(name = "userId")
    public int getUserId(){return userId;}
    public void setUserId(int userId){this.userId = userId;}

    @Basic
    @Column(name = "discount")
    public double getDiscount(){return discount;}
    public void setDiscount(double discount){this.discount = discount;}

    @Basic
    @Column(name = "originPay")
    public double getOriginalPay(){return originalPay;}
    public void setOriginalPay(double originalPay){this.originalPay = originalPay;}

    @Basic
    @Column(name = "actualPay")
    public double getActualPay(){return actualPay;}
    public void setActualPay(double actualPay) {this.actualPay = actualPay;}

    @Basic
    @Column(name = "credit")
    public int getCredit(){return credit;}
    public void setCredit(int credit) {this.credit = credit;}

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    public Set<BookItem> getBookItems(){return bookItems;}
    public void setBookItems(Set<BookItem> bookItems){this.bookItems = bookItems;}


}
