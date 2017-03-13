package com.mark.java.service.impl;

import com.mark.java.DAO.ChargeDAO;
import com.mark.java.entity.Charge;
import com.mark.java.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lois on 2017/3/14.
 */

@Service
public class ChargeServiceImpl implements ChargeService{

    @Autowired
    private ChargeDAO chargeDAO;

    @Override
    public List<Charge> getChargeByMember(int id) {

        return chargeDAO.findByMemberId(id);
    }
}
