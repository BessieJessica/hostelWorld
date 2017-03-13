package com.mark.java.service.impl;

import com.mark.java.DAO.UserDAO;
import com.mark.java.entity.User;
import com.mark.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lois on 2017/3/6.
 */

@Service("userService")
@Transactional //指明每个方法是一个事务

public class UserServiceImpl implements UserService {


    @Autowired
    private UserDAO userDao;

    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        username = username.trim();
        password = password.trim();

        if(username.length()==0||password.length()==0){
            map.put("success",false);
            map.put("error","请填写完整信息");
        }else{
            User user = userDao.findByUsername(username);
            if(user == null){
                map.put("success",false);
                map.put("error","用户名或密码错误！");
            }else{
                if(!password.equals(user.getPassword())){
                    map.put("success",false);
                    map.put("error","用户名或密码错误！");
                }else{
                    map.put("success",true);
                    map.put("user_id",user.getId());
                    map.put("user_name",user.getUsername());
                }
            }
        }

        return map;
    }

    public void saveUsers(List<User> users){
        for (User u: users){
            userDao.save(u);
        }
    }

    public List<User> getAllUsernames() {
        return userDao.findAll();
    }
}
