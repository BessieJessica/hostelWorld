package com.mark.java.DAO.impl;

import com.mark.java.DAO.BookDAO;
import com.mark.java.DAO.MembershipDAO;
import com.mark.java.entity.Book;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lois on 2017/3/15.
 */

@Repository
public class BookDAOImpl implements BookDAO{

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private MembershipDAO membershipDAO;


    @Override
    public Book create(int memberId) {
        return null;
    }

    @Override
    public List<Book> getByMemberId(int memberId) {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public Book findById(int id) {
        return null;
    }

    @Override
    public List<Book> getTodayByMemberId(int memberId) {
        return null;
    }
}
