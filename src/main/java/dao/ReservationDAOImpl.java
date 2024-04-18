package dao;

import beans.Reservation;
import utils.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {

    @Override
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservation";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(resultSet.getInt("reservationId"));
                reservation.setRoomId(resultSet.getInt("roomId"));
                reservation.setUserId(resultSet.getInt("userId"));
                reservation.setStartDate(resultSet.getDate("startDate"));
                reservation.setEndDate(resultSet.getDate("endDate"));
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    @Override
    public List<Reservation> getReservationsByUserId(int userId) {
        List<Reservation> userReservations = new ArrayList<>();
        String query = "SELECT * FROM reservation WHERE userId = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(resultSet.getInt("reservationId"));
                reservation.setRoomId(resultSet.getInt("roomId"));
                reservation.setUserId(resultSet.getInt("userId"));
                reservation.setStartDate(resultSet.getDate("startDate"));
                reservation.setEndDate(resultSet.getDate("endDate"));
                userReservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userReservations;
    }

    @Override
    public boolean createReservation(Reservation reservation) {
        String query = "INSERT INTO reservation (roomId, userId, startDate, endDate) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, reservation.getRoomId());
            preparedStatement.setInt(2, reservation.getUserId());
            preparedStatement.setDate(3, new java.sql.Date(reservation.getStartDate().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(reservation.getEndDate().getTime()));

            int insertedRows = preparedStatement.executeUpdate();

            return insertedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteReservation(int reservationId) {
        String query = "DELETE FROM reservation WHERE reservationId = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, reservationId);
            int deletedRows = preparedStatement.executeUpdate();

            return deletedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
