package com.mark.java.service;

import com.mark.java.entity.Hotel;

import java.util.List;
import java.util.Map;

/**
 * Created by lois on 2017/3/14.
 */

public interface HotelService {

    public Map<String, Object> add(String description, String city);

    public Map<String, Object> edit(int id, String description, String city );

    public Hotel getHotelById(int id);

    public List<Hotel> getAllHotels();

    public Map<String, Object> deleteHotel(int id);

    //TODO
    //validate after manager check

}
