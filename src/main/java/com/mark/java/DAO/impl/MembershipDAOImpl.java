package com.mark.java.DAO.impl;

import com.mark.java.DAO.MembershipDAO;
import com.mark.java.entity.Membership;
import com.mark.java.util.Utils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by lois on 2017/3/12.
 */

@Repository

public class MembershipDAOImpl implements MembershipDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Membership create(String identity){
        Session session = sessionFactory.getCurrentSession();

        //生成注册码
        boolean flag = false;
        int memberId;
        do{
            memberId = Utils.generateCode();
            SQLQuery query = session.createSQLQuery("SELECT memberId from membership where memberId = ?");
            query.setInteger(1,memberId);
            if(query.uniqueResult()==null) {
                flag = true;
            }
        }while(!flag);

        Membership membership = new Membership();

        membership.setMemberId(memberId);
        membership.setLevel(1);
        membership.setCredit(0);

        membership.setBalance(0);
        membership.setState(1); //state = 1,表示可用状态；state = 2，表示暂停； state=3，表示停止
        membership.setIdentity(identity);
//        membership.setName(name);
        session.save(membership);

        session.flush();

        return membership;
    }

    public Membership findByMemberId(int memberId){
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from membership where memberId =: memberId");
        query.setInteger("memberId",memberId);
        if (query.list()==null||query.list().size()==0){
            return null;
        }else{
            return (Membership)query.list().get(0);
        }

    }

    public Membership findByIdentity(String identity){
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from membership where identity =: identity");
        query.setString("identity",identity);

        if (query.list()==null||query.list().size()==0){
            return null;
        }else{
            return (Membership)query.list().get(0);
        }
    }

    public Membership update(Membership membership){
        Session session = sessionFactory.getCurrentSession();
        session.save(membership);
        session.flush();
        return membership;
    }

}
