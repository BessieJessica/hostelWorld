package com.mark.java.DAO;

import com.mark.java.entity.Charge;

import java.util.List;

/**
 * Created by lois on 2017/3/13.
 */

public interface ChargeDAO {

    public Charge create(int id, int money);

    public List<Charge> findByMemberId(int id);

}
