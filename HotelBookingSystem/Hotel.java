package HotelBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<RoomType> rooms = new ArrayList<RoomType>();
    private List<Customer> customers = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public void addRoom(String roomType, double price, int numberOfRooms) {
        rooms.add(new RoomType(roomType, price, numberOfRooms));
    }

    public void addCustomer(String firstName, String lastName, int ID) {
        customers.add(new Customer(firstName, lastName, ID));
    }

    public List<RoomType> getRoom(){
        return rooms;
    }

    public List<Customer> getCustomer(){
return customers;
    }
}
