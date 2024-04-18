package dao;

import beans.Room;
import java.util.List;

public interface RoomDAO {
    List<Room> getAllRooms();
    List<Room> searchRooms(Date startDate, Date endDate, String roomType, int numberOfGuests);
    boolean updateRoomAvailability(int roomId, boolean availability);
    boolean addRoom(Room room);
    boolean deleteRoom(int roomId);
}
