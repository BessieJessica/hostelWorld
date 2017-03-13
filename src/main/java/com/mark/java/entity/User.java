package com.mark.java.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by lois on 2017/3/6.
 */

@Entity
@Table

public class User implements Serializable{

    private int id;

    private String username;

    private String password;

    private int role; //前台，店长，经理

    private int hotelId;

    private Hotel hotel;


    @Id
    @GeneratedValue
    public int getId(){
        return id;
    }

//    public void setId(int id){this.id = id;}

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }


    public String getPassword(){return password;}

    public void setPassword(String password){
        this.password = password;
    }

    public int getRele(){return role;}
    public void setRole(int role){this.role = role;}


    public Hotel getHotel() {return hotel;}



}
