package dao;

import les_classes.Reservation;

import java.sql.SQLException;
import java.util.List;

public interface ReservationDAO {
    List<Reservation> getAllReservations() throws ClassNotFoundException, SQLException;
   
   
}
