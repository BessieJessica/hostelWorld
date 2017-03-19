package com.mark.java.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by lois on 2017/3/13.
 */

@Entity
@Table(name = "memberInfo", schema = "J2EE")
public class MemberInfo {

    private int memberId;
    private String name;
    private Date birthday;
    private int gender;
    private String province;
    private String city;


    @Id
    @Column(name = "memberId")
    public int getMemberId(){return memberId;}
    public void setMemberId(int memberId){this.memberId = memberId;}

    @Basic
    @Column(name="name")
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "gender")
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
