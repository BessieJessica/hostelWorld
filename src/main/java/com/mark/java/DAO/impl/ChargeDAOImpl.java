package com.mark.java.DAO.impl;

import com.mark.java.DAO.ChargeDAO;
import com.mark.java.entity.Charge;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by lois on 2017/3/13.
 */

@Repository
public class ChargeDAOImpl implements ChargeDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Charge create(int id, int money) {
        Session session = sessionFactory.getCurrentSession();

        Charge charge = new Charge();
        charge.setMemberId(id);
        charge.setMoney(money);
        charge.setTime(new Timestamp(System.currentTimeMillis()));

        session.save(charge);

        return charge;
    }

    @Override
    public List<Charge> findByMemberId(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from charge where memberId =: id order by time desc ");
        query.setInteger("id",id);
        return query.list();
    }
}
