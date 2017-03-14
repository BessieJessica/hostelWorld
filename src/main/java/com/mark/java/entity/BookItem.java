package com.mark.java.entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

/**
 * Created by lois on 2017/3/14.
 *
 *订单明细
 * 一个订单可以预定多个房间
 */

@Entity
@Table

public class BookItem {

    private int id;
    private double price;
    private int number;

    private Book book;
    private Room room;

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id){this.id = id;}

    public double getPrice(){return price;}
    public void setPrice(double price){this.price = price;}

    public int getNumber(){return number;}
    public void setNumber(int number){this.number = number;}

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "bookId")
    @JsonIgnore
    public Book getBook(){return book;}
    public void setBook(Book book){this.book = book;}

    @OneToOne
    @JoinColumn(name = "roomId")
    public Room getRoom(){return room;}
    public void setRoom(Room room){this.room = room;}

}
