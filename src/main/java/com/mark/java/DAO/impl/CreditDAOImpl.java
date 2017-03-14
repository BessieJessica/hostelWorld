package com.mark.java.DAO.impl;

import com.mark.java.DAO.CreditDAO;
import com.mark.java.entity.Consumption;
import com.mark.java.entity.Credit;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by lois on 2017/3/14.
 */

@Repository
public class CreditDAOImpl implements CreditDAO{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Credit create(int id, int credit, int type, Integer consumptionId) {
        Session session = sessionFactory.getCurrentSession();

        Credit tmpCredit = new Credit();
        tmpCredit.setId(id);
        tmpCredit.setCredit(credit);
        tmpCredit.setType(type);
        if (consumptionId!=null){
            Consumption consumption = new Consumption();
            consumption.setId(consumptionId);
            tmpCredit.setConsumption(consumption);
        }
        tmpCredit.setTime(new Timestamp(System.currentTimeMillis()));

        session.save(tmpCredit);
        session.flush();

        return tmpCredit;
    }

    @Override
    public List<Credit> findByMemberId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from credit where memberId =: id order by time desc");
        query.setInteger("id",id);
        return query.list();
    }
}
