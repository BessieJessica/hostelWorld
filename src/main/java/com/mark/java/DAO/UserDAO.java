package com.mark.java.DAO;

import com.mark.java.entity.User;

import java.util.List;

/**
 * Created by lois on 2017/3/6.
 */
public interface UserDAO {
    public User create(String username, String password, int role);

    public int save(User u);
    public List<User> findAll();

    public User findByUsername(String username);



    /**
     *  public User findByUsername(String username);

     public User findById(int id);

     public User update(User user);

     public User create(String username, String name, String password, int role, int shop);

     public List<User> getAll();

     public void delete(int id);
     */


}
