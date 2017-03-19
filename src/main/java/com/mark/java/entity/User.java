package com.mark.java.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lois on 2017/3/6.
 */

@Entity
@Table

public class User {

    private int id;

    private String username;

    private String password;

    private int role; //前台，店长，经理:4

    private Hotel hotel;


    @Id
    @Column(name = "id")
    @GeneratedValue
    public int getId(){
        return id;
    }

    public void setId(int id){this.id = id;}

    @Basic
    @Column(name = "username")
    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword(){return password;}

    public void setPassword(String password){
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public int getRole(){return role;}
    public void setRole(int role){this.role = role;}


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "hotelId")
    public Hotel getHotel() {return hotel;}
    public void setHotel(Hotel hotel){this.hotel = hotel;}



}
