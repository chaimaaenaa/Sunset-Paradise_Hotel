package dao;

import beans.Room;
import utils.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM room";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Room room = new Room();
                room.setRoomId(resultSet.getInt("roomId"));
                room.setRoomType(resultSet.getString("roomType"));
                room.setPrice(resultSet.getDouble("price"));
                // ... set other fields
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public List<Room> searchRooms(Date startDate, Date endDate, String roomType, int numberOfGuests) {
        // Implementer la logique de recherche des chambres disponibles selon les critères fournis
        // Ceci est un exemple simplifié et vous devrez ajuster cette méthode en fonction de votre logique spécifique
        List<Room> availableRooms = new ArrayList<>();
        // Votre logique de recherche ici
        return availableRooms;
    }

    @Override
    public boolean updateRoomAvailability(int roomId, boolean availability) {
        String query = "UPDATE room SET availability = ? WHERE roomId = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setBoolean(1, availability);
            preparedStatement.setInt(2, roomId);
            int updatedRows = preparedStatement.executeUpdate();

            return updatedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addRoom(Room room) {
        String query = "INSERT INTO room (roomType, price, amenities, availability) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, room.getRoomType());
            preparedStatement.setDouble(2, room.getPrice());
            preparedStatement.setString(3, room.getAmenities().toString());
            preparedStatement.setBoolean(4, room.isAvailability());

            int insertedRows = preparedStatement.executeUpdate();

            return insertedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteRoom(int roomId) {
        String query = "DELETE FROM room WHERE roomId = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, roomId);
            int deletedRows = preparedStatement.executeUpdate();

            return deletedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
