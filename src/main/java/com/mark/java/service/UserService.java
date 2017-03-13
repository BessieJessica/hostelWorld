package com.mark.java.service;

import com.mark.java.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by lois on 2017/3/6.
 */
public interface UserService {
    public Map<String, Object> login(String username, String password);

//    public void saveUsers(List<User> users);

    public List<User> getAllUsers();

}
