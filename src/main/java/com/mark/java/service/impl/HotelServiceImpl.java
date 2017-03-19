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
    public Map<String, Object> register(String name,String password, String passwordAgain){
        Map<String, Object> map = new HashMap<>();
        name = name.trim();
        password = password.trim();
        passwordAgain = passwordAgain.trim();

        if (name.length()==0||password.length()==0||passwordAgain.length()==0){
            map.put("sucess",false);
            map.put("error","信息不完整！");
        }else if(!password.equals(passwordAgain)){
            map.put("success",false);
            map.put("error","两次密码输入不同!");
        }else {
            Hotel hotel = hotelDAO.create(name,password);
            map.put("success",true);
            map.put("hotelId",hotel.getId());
            map.put("hotelName",hotel.getName());
        }

        return map;
    }

    @Override
    public Map<String, Object> login(int code, String password){
        Map<String, Object> map = new HashMap<>();

        password = password.trim();
        if (password.length()==0){
            map.put("success",false);
            map.put("error","信息不完整！");
        }else{
            Hotel hotel = hotelDAO.findByHotelCode(code);
            if(hotel==null){
                map.put("success",false);
                map.put("error","注册码或密码错误！");
            }else{
                if(!password.equals(hotel.getPassword())){
                    map.put("success",false);
                    map.put("error","注册码或密码错误！");
                }else{
                    map.put("success",true);
                    map.put("hotelCode",hotel.getHotelCode());
                    map.put("hotelName",hotel.getName());
                }
            }
        }

        return  map;
    }

    @Override
    public Map<String, Object> supplyInfo(int id, String city, String description, String address){
        Map<String, Object> map = new HashMap<>();
        city= city.trim();
        description = description.trim();
        address = address.trim();

        if (city.length()==0||description.length()==0||address.length()==0){
            map.put("success",false);
            map.put("error","信息不完整！");
            return map;
        }

        Hotel hotel = hotelDAO.findById(id);
        hotel.getHotelInfo().setCity(city);
        hotel.getHotelInfo().setDescription(description);
        hotel.getHotelInfo().setAddress(address);

        hotelDAO.update(hotel);
        map.put("success",true);
        map.put("hotelName",hotel.getName());
        return map;
    }


    @Override
    public Map<String, Object> editInfo(int id, String city, String description, String address ){
        Map<String, Object> map = new HashMap<>();

        Hotel hotel = hotelDAO.findById(id);

        hotel.getHotelInfo().setCity(city);
        hotel.getHotelInfo().setDescription(description);
        hotel.getHotelInfo().setAddress(address);
        hotelDAO.update(hotel);

        map.put("success",true);
        return map;
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
