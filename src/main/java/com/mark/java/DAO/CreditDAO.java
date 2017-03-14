package com.mark.java.DAO;

import com.mark.java.entity.Credit;

import java.util.List;

/**
 * Created by lois on 2017/3/14.
 */

public interface CreditDAO {

    public Credit create(int id, int credit, int type, Integer consumptionId);

    public List<Credit> findByMemberId(int id);

}
