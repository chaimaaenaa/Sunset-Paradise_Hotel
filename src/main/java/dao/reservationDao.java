package dao;

import beans.Reservation;
import java.util.List;

public interface ReservationDAO {
    List<Reservation> getAllReservations();
    List<Reservation> getReservationsByUserId(int userId);
    boolean addReservation(Reservation reservation);
    boolean deleteReservation(int reservationId);
}
