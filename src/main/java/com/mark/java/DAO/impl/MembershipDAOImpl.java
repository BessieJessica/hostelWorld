package com.mark.java.DAO.impl;

import com.mark.java.DAO.MembershipDAO;
import com.mark.java.entity.*;
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


    @Override
    public Membership create(String cellphone, String password) {
        Session session = sessionFactory.getCurrentSession();

        /**
         * 生成注册码
         */
        boolean flag = false;
        int memberId;
        do{
            memberId = Utils.generateCode();
            SQLQuery query = session.createSQLQuery("SELECT memberId from member where memberId = ?");
            query.setInteger(0,memberId);
            if(query.uniqueResult()==null){
                flag = true;
            }
        }while(!flag);

        Membership membership = new Membership();
        membership.setMemberCode(memberId);
        membership.setCellphone(cellphone);
        membership.setPassword(password);
        membership.setState(0);
        session.save(membership);

        session.flush();

        MemberAccount account = new MemberAccount();
        account.setMemberId(membership.getMemberCode());
        account.setCredit(0);
        account.setBalance(0);
        VipLevel vipLevel = (VipLevel)session.get(VipLevel.class,0);
        account.setVipLevel(vipLevel);
        membership.setMemberAccount(account);

        MemberState memberState = new MemberState();
        memberState.setMemberId(membership.getMemberCode());
        membership.setMemberState(memberState);

        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setMemberId(membership.getMemberCode());
        membership.setMemberInfo(memberInfo);

        session.flush();

        return membership;
    }

    @Override
    public Membership findById(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from member where id =: id");
        query.setInteger("id",id);
        if (query.list()==null||query.list().size()==0) {
            return null;
        }else{
            return (Membership)query.list().get(0);
        }
    }

    public Membership findByMemberCode(int memberCode){
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from member where memberId =: memberId");
        query.setInteger("memberCode", memberCode);
        if (query.list()==null||query.list().size()==0){
            return null;
        }else{
            return (Membership)query.list().get(0);
        }

    }

    @Override
    public Membership findByCellphone(String cellphone) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from member where  cellphone =: cellphone");
        query.setString("cellphone",cellphone);
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

    @Override
    public boolean ifMemberExists(String cellphone) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("select cellphone from member where cellphone = ?");
        query.setString(0,cellphone);
        if(query.uniqueResult()==null){
            return false;
        }
        return true;
    }

}
