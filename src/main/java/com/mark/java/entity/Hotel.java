package com.mark.java.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lois on 2017/3/13.
 */

@Entity
@Table
public class Hotel {

    private int id;

    private int hotelId;

    private String city;


    @Id
    @GeneratedValue
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public int getHotelId(){return hotelId;}
    public void setHotelId(int hotelId){this.hotelId = hotelId;}

    public String getCity(){return city;}
    public void setCity(String city){this.city = city;}
}
