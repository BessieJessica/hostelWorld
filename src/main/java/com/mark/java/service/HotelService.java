package com.mark.java.service;

import com.mark.java.entity.Hotel;

import java.util.List;
import java.util.Map;

/**
 * Created by lois on 2017/3/14.
 */

public interface HotelService {

    public Map<String, Object> register(String name, String password, String passwordAgain);

    public Map<String, Object> login(int code, String password);

    public Map<String, Object> supplyInfo(int id, String city, String description, String address);

    public Map<String, Object> editInfo(int id, String city, String description, String address );

    public Hotel getHotelById(int id);

    public List<Hotel> getAllHotels();

    public Map<String, Object> deleteHotel(int id);

    //TODO
    //validate after manager check

}
