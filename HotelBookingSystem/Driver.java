package HotelBookingSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hotel hotel = new Hotel();

        do {
            printMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    addRoom(hotel);
                    break;
                case "2":
                    listRooms(hotel);
                    break;
                case "3":
//                    hotel.addCustomer(hotel);
                    break;
                case "4":
                    listGuests(hotel);
                    break;
                case "5":
                    makeBooking(hotel);
                    break;
                default:
                    break;
            }
        } while (true);
    }


    private static void printMenu() {
        System.out.println(
                "1. Add room\n" +
                        "2. List rooms\n" +
                        "3. Register guest\n" +
                        "4. List guests\n" +
                        "5. Make a booking");
    }

    private static void addRoom(Hotel hotel) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter room number");
        int numberOfRooms = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter room type");
        String roomType = scanner.nextLine();
        System.out.println("Ente room rate");
        double price = Double.parseDouble(scanner.nextLine());

        hotel.addRoom(roomType, price, numberOfRooms);
    }

    private static void listRooms(Hotel hotel) {
        for (RoomType room : hotel.getRoom()) {
            System.out.println(room);
        }
    }

    private static void addCustomer(Hotel hotel) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter guest's name");
        String name = scanner.nextLine();
//        hotel.addCustomer(name);
    }

    private static void listGuests(Hotel hotel) {
        for (Customer customer : hotel.getCustomer()) {
            System.out.println(customer);
        }
    }

    private static void makeBooking(Hotel hotel) {
        Scanner scanner = new Scanner(System.in);
        listGuests(hotel);
        System.out.println("Pick guest");
        String guestId = scanner.nextLine();
        listRooms(hotel);
        System.out.println("Enter room type");
        String roomType = scanner.nextLine();
        System.out.println("Making booking");
    }
//        Scanner scanner = new Scanner(System.in);
//        LocalDate currentDate = LocalDate.now();
//        int choice;
//
////        System.out.println("Please enter your first name: ");
//        String firstName = scanner.nextLine();
////        System.out.println("Please enter your last name: ");
//        String lastName = scanner.nextLine();
//createCustomer() {
//            Customer customer1 = new Customer(firstName, lastName);
//        }
//        System.out.println("Please choose the room type by choosing the corresponding number:");

//        int index = 1;
//        for (HotelRoom room : listOfRooms) {
//            if (room.getRoomCount() > 0) {
//                System.out.println(index + ". " + room);
//            } else {
//                System.out.println(index + ". " + room + " (Booked out)");
//            }
//            index++;
//        }
//
//        choice = scanner.nextInt();
//        switch (choice) {
//            case 1:
//                bookRoom(listOfRooms.get(0), firstName, lastName);
//                break;
//
//            case 2:
//                bookRoom(listOfRooms.get(1), firstName, lastName);
//                break;
//
//            case 3:
//                bookRoom(listOfRooms.get(2), firstName, lastName);
//                break;
//
//            case 4:
//                bookRoom(listOfRooms.get(3), firstName, lastName);
//                break;
//
//            default:
//                System.out.println("Try again");
//                break;
//        }


}

//    private static void bookRoom(HotelRoom hotelRoom, String firstName, String lastName) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("How many nights?");
//        int nightCount = scanner.nextInt();
//        System.out.println("How many guests?");
//        int guestCount = scanner.nextInt();
//        if(guestCount > 2) {
//            System.out.println("All the rooms can support a maximum of 2 occupants");
//        } else {
//            System.out.println("Enter the guests full name?");
//            scanner.nextLine();
//            String guestName = scanner.nextLine();
//            double totalPrice = nightCount * hotelRoom.price;
//            hotelRoom.setRoomCount(hotelRoom.roomCount);
//            hotelRoom.roomCount --;
//            System.out.println("Booking confirmed for " + firstName + " " + lastName + "  and " + guestName);
//            System.out.println("Your total price is £" + totalPrice);
//        }
//    }





//public static void main(String[] args) {
//    RoomType doubleStandard  = new RoomType("Double Standard", 150, 2);
//    RoomType deluxeDouble  = new RoomType("Deluxe Double", 200, 2);
//    RoomType juniorSuite  = new RoomType("Junior Suite", 300, 1);
//    RoomType grandSuite  = new RoomType("Grand Suite", 200, 1);
//
//
//    List<HotelRoom> listOfRooms = new ArrayList<>();
//    listOfRooms.add(new HotelRoom(true, 2,  doubleStandard));
//    listOfRooms.add(new HotelRoom(true, 2, deluxeDouble));
//    listOfRooms.add(new HotelRoom(true, 2, juniorSuite));
//    listOfRooms.add(new HotelRoom(true, 2, grandSuite));
//
//
//    Services breakfast = new Services("breakfast",20.00);
//    Services laundry = new Services("laundry", 50.00);
//    Services roomservice = new Services("room service", 75.00);
//}