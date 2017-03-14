package com.mark.java.service.impl;

import com.mark.java.DAO.HotelDAO;
import com.mark.java.entity.Hotel;
import com.mark.java.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lois on 2017/3/14.
 */
@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelDAO hotelDAO;

    @Override
    public Map<String, Object> add(String description, String city) {
        Map<String, Object> map = new HashMap<>();
        city = city.trim();

        if(city.length()==0||description.length()==0){
            map.put("success",false);
            map.put("error","信息不完整！");
        }else{
            Hotel hotel = hotelDAO.create(description,city);
            map.put("success",true);
            map.put("id",hotel.getId());
        }

        return map;
    }

    //TODO
    @Override
    public Map<String, Object> edit(int id, String description, String city) {

        return null;
    }

    @Override
    public Hotel getHotelById(int id) {

        return hotelDAO.findById(id);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelDAO.getAll();
    }

    @Override
    public Map<String, Object> deleteHotel(int id) {
        Map<String, Object> map = new HashMap<>();
        hotelDAO.delete(id);
        map.put("success",true);
        return map;
    }
}
