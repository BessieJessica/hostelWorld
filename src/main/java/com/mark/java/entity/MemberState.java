package com.mark.java.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by lois on 2017/3/13.
 */

@Entity
@Table(name = "memberState", schema = "J2EE")

public class MemberState {
    private int memberId;
    private Timestamp startTime;
    private Timestamp pauseTime;
    private Timestamp stopTime;

    @Id
    @Column(name = "memberId")
    public int getMemberId(){return memberId;}
    public void setMemberId(int memberId){this.memberId = memberId;}

    @Basic
    @Column(name = "startTime")
    public Timestamp getStartTime(){return startTime;}
    public void setStartTime(Timestamp startTime){this.startTime = startTime;}

    @Basic
    @Column(name = "pauseTime")
    public Timestamp getPauseTime(){return pauseTime;}
    public void setPauseTime(Timestamp pauseTime){this.pauseTime = pauseTime;}

    @Basic
    @Column(name = "stopTime")
    public Timestamp getStopTime(){return stopTime;}
    public void setStopTime(Timestamp stopTime){this.stopTime = stopTime;}



}
