package com.mark.java.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by lois on 2017/3/13.
 */

@Entity
@Table

public class MemberState {
    private int memberId;
    private Timestamp startTime;
    private Timestamp pauseTime;
    private Timestamp stopTime;

    @Id
    public int getMemberId(){return memberId;}
    public void setMemberId(int memberId){this.memberId = memberId;}

    public Timestamp getStartTime(){return startTime;}
    public void setStartTime(Timestamp startTime){this.startTime = startTime;}

    public Timestamp getPauseTime(){return pauseTime;}
    public void setPauseTime(Timestamp pauseTime){this.pauseTime = pauseTime;}

    public Timestamp getStopTime(){return stopTime;}
    public void setStopTime(Timestamp stopTime){this.stopTime = stopTime;}



}
