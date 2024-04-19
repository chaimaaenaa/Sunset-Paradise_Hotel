package dao;

import les_classes.Room;
import Utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public List<Room> displayRoom() throws SQLException {
        List<les_classes.Room> rooms = new ArrayList<>();
        String requet = "SELECT * FROM room";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(requet);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
             int roomId= resultSet.getInt("roomId");
             String roomType = resultSet.getString("roomType");
             double price = resultSet.getDouble("price");
             List<String> amenities = (List<String>) resultSet.getArray("amenities");
             boolean availability = resultSet.getBoolean("availability");
             
             Room Room = new Room(roomId,roomType,price,amenities,availability);
             rooms.add(Room);
            }
            System.out.println(rooms.get(0).getRoomId());
        
        return rooms;
    }

    }
}
