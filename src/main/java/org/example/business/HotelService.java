package org.example.business;

import org.example.persistence.Hotel;
import org.example.persistence.HotelDao;

import java.util.List;
import java.util.stream.Collectors;

public class HotelService {

    private HotelDao hotelDao;
    public HotelService(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    public List<Hotel> getAllHotels() {
        List<Hotel> list = hotelDao.getAllHotels();
        return list.stream().sorted().collect(Collectors.toList());
    }

}

