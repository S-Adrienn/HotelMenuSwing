package org.example;

import org.example.business.HotelService;
import org.example.persistence.HotelDaoPostgresImpl;
import org.example.presentation.HotelController;
import org.example.presentation.HotelModel;
import org.example.presentation.HotelView;

public class Main {
    public static void main(String[] args) {
        HotelService service = new HotelService(new HotelDaoPostgresImpl());
//        service.update("   '; DROP table cars_tmp;update persons set adress ='aaaa' WHERE ''='", "adddress");
        HotelModel model = new HotelModel(service.getAllHotels());

        HotelView view = new HotelView(model.getHotelList());

        HotelController controller = new HotelController(view, model, service);
        view.setController(controller);
    }
}