package com.mark.java.DAO.impl;

import com.mark.java.DAO.HotelDAO;
import com.mark.java.entity.Hotel;
import com.mark.java.util.Utils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lois on 2017/3/14.
 */

@Repository
public class HotelDAOImpl implements HotelDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Hotel create(String name, String password) {

        Session session = sessionFactory.getCurrentSession();

        /**
         * 生成注册码
         */
        boolean flag = false;
        int hotelCode;
        do{
            hotelCode = Utils.generateCode();
            SQLQuery query = session.createSQLQuery("select hotelCode from hotel where hotelCode = ?");
            query.setInteger(0,hotelCode);
            if (query.uniqueResult()==null){
                flag = true;
            }
        }while(!flag);

        Hotel hotel = new Hotel();
        hotel.setHotelCode(hotelCode);
        hotel.setName(name);
        hotel.setPassword(password);
        hotel.setState(0);//注册客栈，状态设为0
        session.save(hotel);

        session.flush();

        return hotel;
    }

    @Override
    public Hotel update(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.save(hotel);
        session.flush();
        return hotel;
    }

    @Override
    public Hotel findById(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from hotel where id =: id");
        query.setInteger("id",id);
        if (query.list()==null||query.list().size()==0) {
            return null;
        }else{
            return (Hotel)query.list().get(0);
        }
    }

    @Override
    public Hotel findByHotelCode(int hotelCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from hotel where hotelCode =: hotelCode");
        query.setInteger("hotelCode",hotelCode);
        if (query.list()==null||query.list().size()==0){
            return null;
        }else{
            return (Hotel)query.list().get(0);
        }
    }

    @Override
    public List<Hotel> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from hotel");
        List<Hotel> hotelList = (List<Hotel>)query.list();
        return hotelList;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete hotel where id =: id");
        query.setInteger("id",id);
        query.executeUpdate();
    }
}
