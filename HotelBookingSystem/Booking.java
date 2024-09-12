package HotelBookingSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Booking {
    private String firstName;
    private String lastName;
   private String checkIn;
    private String checkOut;
    private RoomType roomInfo;

    public Booking(String firstName, String lastName, String checkIn, String checkOut, RoomType roomInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomInfo = roomInfo;
    }


    public double calculateTotalprice() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate startDate = LocalDate.parse(checkIn, formatter);
        LocalDate endDate = LocalDate.parse(checkOut, formatter);

        int numberOfdays = (int) ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println(numberOfdays);

        double totalPrice = roomInfo.getPrice() * numberOfdays;
        return totalPrice;
    }

    public static void main(String[] args) {
       RoomType doubleStandard  = new RoomType("Double Standard", 150, 2);

        Booking book1 = new Booking ("H", "L", "06/21/2024","06/25/2024", doubleStandard);

        System.out.println(book1.calculateTotalprice());
    }
}
