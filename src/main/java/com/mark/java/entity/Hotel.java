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
    private String name;
    private String password;
    private int state; //初始注册状态0／待审批1／通过2／拒绝3

    private HotelInfo hotelInfo;
    private Set<User> users;
    private Set<Room> rooms;


    @Id
    @GeneratedValue
    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    @Basic
    @Column(name = "hotelCode")
    public int getHotelCode(){return hotelCode;}
    public void setHotelCode(int hotelCode){this.hotelCode = hotelCode;}

    @Basic
    @Column(name = "state")
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


    @Basic
    @Column(name = "name")
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Basic
    @Column(name = "password")
    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public HotelInfo getHotelInfo() {return hotelInfo;}

    public void setHotelInfo(HotelInfo hotelInfo) {this.hotelInfo = hotelInfo;}
}
