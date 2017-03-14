package com.mark.java.entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by lois on 2017/3/13.
 *
 * 客栈实体
 * 每个客栈包含多个房间
 * 每个客栈有多个员工
 */

@Entity
@Table
public class Hotel {

    private int id;

    private int hotelCode; //通过注册随机生成7位数

    private String city;

    private String description;

    private int state; //待审批／通过／拒绝

    private Set<User> users;
    private Set<Room> rooms;


    @Id
    @GeneratedValue
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public int getHotelCode(){return hotelCode;}
    public void setHotelCode(int hotelCode){this.hotelCode = hotelCode;}

    public String getCity(){return city;}
    public void setCity(String city){this.city = city;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

    public int getState(){return state;}
    public void setState(int state){this.state = state;}

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<User> getUsers(){return users;}
    public void setUsers(Set<User> users){this.users = users;}

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<Room> getRooms(){return rooms;}
    public void setRooms(Set<Room> rooms){this.rooms = rooms;}


}
