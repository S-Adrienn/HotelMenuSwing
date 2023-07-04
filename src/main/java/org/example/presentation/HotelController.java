package org.example.presentation;

import org.example.business.HotelService;

public class HotelController { 
    
    private HotelView view;
    private  HotelModel model;
    private HotelService service;

    public HotelController(HotelView view, HotelModel model, HotelService service) {
        this.view = view;
        this.model = model;
        this.service = service;
    }

    public void menuItemSortHotelDataByNamePressed() {
        view.refreshTable(model.getHotelList());
        model.setHotelList(service.getAllHotels());
    }


    public void menuItemSortHotelDataByServicesPressed() {

    }
}
