package com.mark.java.service;

import com.mark.java.entity.Charge;

import java.util.List;

/**
 * Created by lois on 2017/3/14.
 */
public interface ChargeService {

    public List<Charge> getChargeByMemberId(int id);

}
