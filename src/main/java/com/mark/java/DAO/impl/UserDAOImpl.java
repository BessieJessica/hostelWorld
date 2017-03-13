package com.mark.java.DAO.impl;

import com.mark.java.DAO.UserDAO;
import com.mark.java.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lois on 2017/3/6.
 * 第一个annotation注明这是一个repository，需要被Spring管理，
 * 然后自动装载之前在配置文件中配置的 SessionFactory，获取当前session后获取所有的用户，
 * 下面修改之前的UserService代码，service封装业务逻辑层代码，
 * 我把每个service方法封装为一个事务。
 * （PS:上面的SessionFactory获取当前Session是依赖于事务的，
 * 如果不在某个事务之内，会报错：No Session found for current thread。)
 */

@Repository

public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public User create(String username, String password, String cellphone, String identity) {
        Session session = sessionFactory.getCurrentSession();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);


        /**
         * TODO
         */



        return user;

    }


    public int save(User u){
        return (Integer) sessionFactory.getCurrentSession().save(u);
    }

    public List<User> findAll(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        return criteria.list();
    }

    public User findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username =: username");
        query.setString("username",username);
        if (query.list()==null||query.list().size()==0){
            return null;
        }else{
            return (User)query.list().get(0);
        }
    }
}
