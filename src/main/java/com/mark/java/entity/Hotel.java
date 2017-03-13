package com.mark.java.entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by lois on 2017/3/13.
 *
 * 客栈实体
 * 每个客栈包含多个房间
 */

@Entity
@Table
public class Hotel {

    private int id;

    private int hotelId; //通过注册随机生成7位数

    private String city;

    private String description;

    private Set<User> users;
    private Set<Room> rooms;


    @Id
    @GeneratedValue
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public int getHotelId(){return hotelId;}
    public void setHotelId(int hotelId){this.hotelId = hotelId;}

    public String getCity(){return city;}
    public void setCity(String city){this.city = city;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<User> getUsers(){return users;}
    public void setUsers(Set<User> users){this.users = users;}

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<Room> getRooms(){return rooms;}
    public void setRooms(Set<Room> rooms){this.rooms = rooms;}

}
