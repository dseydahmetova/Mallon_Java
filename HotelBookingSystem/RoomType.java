package HotelBookingSystem;

public class RoomType {
    private String roomType;
    private double price;
    private int numberOfRooms;

    public RoomType(String roomType, double price, int numberOfRooms) {
        this.roomType = roomType;
        this.price = price;
        this.numberOfRooms = numberOfRooms;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return numberOfRooms;
    }

    public void setCount(int count) {
        if (count > 0) {
            this.numberOfRooms = count - 1;
        }
    }
}
