package HotelBookingSystem;

public class HotelRoom {
    private boolean clean;
    private int capacity;
    private RoomType type;

    public HotelRoom(boolean clean, int capacity, RoomType type) {
        this.capacity = capacity;
        this.clean = clean;
        this.type = type;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    @Override
    public String toString() {
        return "Hotel Room {" +
                "type='" + type.getRoomType() + '\'' +
                ", price=" + type.getPrice() +
                '}';
    }
}
