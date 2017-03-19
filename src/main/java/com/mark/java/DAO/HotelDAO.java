package com.mark.java.DAO;

import com.mark.java.entity.Hotel;

import java.util.List;

/**
 * Created by lois on 2017/3/14.
 */
public interface HotelDAO {
    public Hotel create( String name, String password);

    public Hotel update(Hotel hotel);

    public Hotel findById(int id);

    public Hotel findByHotelCode(int hotelCode);

    public List<Hotel> getAll();

    public void delete(int id);

}


