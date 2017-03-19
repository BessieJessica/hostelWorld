package com.mark.java.entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

/**
 * Created by lois on 2017/3/14.
 *
 * 房间实体
 * 多个房间可以属于同一个客栈
 */

@Entity
@Table

public class Room {

    private int id;
    private String roomNumber;
    private String description;
    private String image;

    private Hotel hotel;

    @Id
    @Column(name = "id")
    @GeneratedValue
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    @Basic
    @Column(name = "roomNumber")
    public String getRoomNumber(){return roomNumber;}
    public void setRoomNumber(String roomNumber){this.roomNumber = roomNumber;}

    @Basic
    @Column(name = "description")
    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

    @Basic
    @Column(name = "image")
    public String getImage(){return image;}
    public void setImage(String image){this.image = image;}

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "hotelId")
    @JsonIgnore
    public Hotel getHotel(){return hotel;}
    public void setHotel(Hotel hotel){this.hotel = hotel;}

}
