package com.mark.java.DAO;

import com.mark.java.entity.Book;

import java.util.List;

/**
 * Created by lois on 2017/3/15.
 */


public interface BookDAO {

    public Book create(int memberId);

    public List<Book> getByMemberId(int memberId);

    public Book update(Book book);

    public Book findById(int id);

    public List<Book> getTodayByMemberId(int memberId);

//    public Book create

    /**
     *    public Book create(int customerId, ShoppingCart shoppingCart);

     public List<Book> getByCustomerId(int customerId);

     public Book update(Book book);

     public Book findById(int id);

     public List<Book> getTodayByCustomerId(int customerId);

     public Book createBySale(int customerId, int shopId, JSONArray items);
     */
}
