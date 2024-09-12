package DesignPatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VetApplication {
    static List<Owner> owners = new ArrayList<>();
    static List<Pet> pets = new ArrayList<>();
    static List<Pet> bookingQueue = new ArrayList<>();
    public static void main(String[] args) {
        String command = null;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Welcome to the vet system.");
        while (!"exit".equals(command)) {
            System.out.println("What would you like to do?");
            System.out.println("owner - Register new owner");
            System.out.println("pet - Register new pet");
            System.out.println("appointment - Book appointment");
            System.out.println("schedule - Generate Schedule");
            System.out.print("Command: ");
            command = myScanner.nextLine();
            switch (command) {
                case "pet" -> newPet();
                case "owner" -> newOwner();
                case "appointment" -> newAppointment();
                case "schedule" -> newSchedule();
            }

            System.out.println();
        }
    }

    public static void newPet() {
        if (owners.size() == 0) {
            System.err.println("No owners registered."); return;
        }
        Scanner petScanner = new Scanner(System.in);
        System.out.print("Enter pet's name: ");
        String name = petScanner.nextLine();
        Owner owner = ownerSelect();
        Pet p = new Pet(name, owner);
        pets.add(p);
        System.out.println("Pet "+p+ " created successfully.");
    }

    public static Owner ownerSelect() {
        System.out.println("Select owner from this list: ");
        for (int i = 0; i < owners.size(); i++) {
            System.out.println(i + " - "+owners.get(i));
        }
        Scanner ownerSelectScanner = new Scanner(System.in);
        // This does NOT validate input
        int entry = Integer.parseInt(ownerSelectScanner.nextLine());
        return owners.get(entry);
    }

    public static void newOwner() {
        Scanner ownerScanner = new Scanner(System.in);
        System.out.print("Enter owner's name: ");
        String name = ownerScanner.nextLine();
        System.out.print("Enter owner's email: ");
        String email = ownerScanner.nextLine();
        System.out.print("Enter owner's phone number: ");
        String phoneNumber = ownerScanner.nextLine();
        Owner o = new Owner(name, email, phoneNumber);
        owners.add(o);
        System.out.println("Owner "+o+" created successfully");
    }

    public static void newAppointment() {
        System.out.println("Book a new appointment for which pet?");
        Pet p = petSelect();
        System.out.println("Your pet has been added to the booking queue.");
        System.out.println("You will be contacted when your appointment is scheduled.");
        bookingQueue.add(p);
    }

    public static Pet petSelect() {
        System.out.println("Select pet from this list: ");
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(i + " - "+pets.get(i));
        }
        Scanner petSelectScanner = new Scanner(System.in);
        // This does NOT validate the input
        int entry = Integer.parseInt(petSelectScanner.nextLine());
        return pets.get(entry);
    }

    public static void newSchedule() {
        System.out.println();
        System.out.println("GENERATING SCHEDULE FOR TODAY");
        for (int i = 0; i < bookingQueue.size(); i++) {
            System.out.println("Appointment "+i+" - "+bookingQueue.get(i));
            System.out.println("Contact owner: "+bookingQueue.get(i).getOwner());
            System.out.println();
        }
        System.out.println("END SCHEDULE");
        bookingQueue.clear();
    }
}
