package org.example.presentation;

import org.example.persistence.Hotel;

import java.util.List;

public class HotelModel {

    private List<Hotel> hotelList;

    public HotelModel(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }
    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

}
