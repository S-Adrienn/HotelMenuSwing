package org.example.presentation;

import org.example.persistence.Hotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class HotelView extends JFrame {

    private DefaultTableModel tableModel;
    private HotelController controller;

    public HotelView(List<Hotel> hotelList) {
        this();
        refreshTable(hotelList);
    }
    public HotelView() {
        super("Hotel Menu with SWING");

        JPanel content = new JPanel();
        JScrollPane pane = getTablePane();

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Hotel Menu");

        JMenuItem printHotelData = new JMenuItem("Sort Hotel Data By Name");
        JMenuItem sortHotelData = new JMenuItem("Sort Hotel Data By Services");

        menu.add(printHotelData);
        printHotelData.addActionListener(e -> controller.menuItemSortHotelDataByNamePressed());

        menu.add(sortHotelData);
        sortHotelData.addActionListener(e -> controller.menuItemSortHotelDataByServicesPressed());

        content.add(pane);
        content.add(menuBar);
        menuBar.add(menu);

        this.setJMenuBar(menuBar);
        this.setContentPane(content);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }

    private JScrollPane getTablePane() {
        String[] header = {"Hotel ID", "Name", "Address", "Phone Number", "Services"};
        tableModel = new DefaultTableModel(header, 0);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 400));
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        JScrollPane pane = new JScrollPane(table);
        return pane;
    }

    public HotelController getController() {
        return controller;
    }

    public void setController(HotelController controller) {
        this.controller = controller;
    }

    public void refreshTable (List<Hotel> hotelList) {
        tableModel.setRowCount(0);
        for (Hotel hotel: hotelList) {
            tableModel.addRow(new Object[] {hotel.getHotelId(), hotel.getName(), hotel.getAddress(), hotel.getPhoneNumber(), hotel.getServices()});
        }
    }

}
