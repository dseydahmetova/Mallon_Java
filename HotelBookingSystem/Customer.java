package HotelBookingSystem;

import java.util.Random;

public class Customer {
        private String firstName;
        private String lastName;
        int ID;

        public Customer(String firstName, String lastName, int ID) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.ID = ID;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

    public int getID() {
        return ID;
    }

    public void setID() {
        double id = Math.random();
        this.ID = (int) id;
    }


}
