package com.mark.java.entity;

import javax.persistence.*;

/**
 * Created by lois on 2017/3/19.
 */

@Entity
@Table(name = "hotelInfo", schema = "J2EE")
public class HotelInfo {

    private int hotelId;
    private String city;
    private String description;
    private String address;

    @Id
    @Column(name = "hotelId")
    public int getHotelId() {return hotelId;}
    public void setHotelId(int hotelId) {this.hotelId = hotelId;}

    @Basic
    @Column(name = "city")
    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    @Basic
    @Column(name = "description")
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    @Basic
    @Column(name = "address")
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}


}
