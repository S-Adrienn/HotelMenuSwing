package org.example.persistence;

import org.example.util.DBUtil;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;


public class HotelDaoPostgresImpl implements HotelDao {

    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * from hotels");
            while (rs.next()) {
                Hotel hotel = extractedHotelFromResultSet(rs);
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection);
        }
        return hotels;
    }

    private Hotel extractedHotelFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString(2);
        String address = resultSet.getString(3);
        String phoneNumber = resultSet.getString(4);
        String services = resultSet.getString(5);
        Hotel result = new Hotel(id, name, address, phoneNumber, services);

        return result;
    }

}
