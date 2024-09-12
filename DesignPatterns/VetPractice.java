import java.util.List;

public interface VetPractice {
    // Takes the Pet to register, returns true if successfully registered.
    boolean registerPet(Pet p);

    // Takes the Owner to register, return true if successfully registered.
    boolean registerOwner(Owner o);

    // Returns the list of Pets
    List<Pet> getPets();

    // Returns the list of Owners
    List<Owner> getOwners();

    // Adds a Pet p to the booking queue IF it is a registered Pet at the practice
    void queueBooking(Pet p);

    // Returns a list (in order) of pets with appointments, clears the booking queue
    List<Pet> scheduleAppointments();
}
