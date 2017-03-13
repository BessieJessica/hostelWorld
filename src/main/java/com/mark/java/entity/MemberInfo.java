package com.mark.java.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lois on 2017/3/13.
 */

@Entity
@Table
public class MemberInfo {

    private int memberId;
    private String name;

    @Id
    public int getMemberId(){return memberId;}
    public void setMemberId(int memberId){this.memberId = memberId;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

}
