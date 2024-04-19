package les_classes;

import java.util.List;

public class Room {
    private int roomId;
    private String roomType;
    private double price;
    private List<String> amenities;
    private boolean availability;

    // Constructeur par défaut
    public Room() {}

    // Constructeur avec tous les attributs
    public Room(int roomId, String roomType, double price, List<String> amenities, boolean availability) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.price = price;
        this.amenities = amenities;
        this.availability = availability;
    }

    // Getters et Setters

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    // toString pour l'affichage
    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomType='" + roomType + '\'' +
                ", price=" + price +
                ", amenities=" + amenities +
                ", availability=" + availability +
                '}';
    }
}
