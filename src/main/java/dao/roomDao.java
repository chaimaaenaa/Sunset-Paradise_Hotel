package dao;

import les_classes.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO {
    List<Room> displayRoom()throws ClassNotFoundException, SQLException;;
    
}
