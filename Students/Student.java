package Students;

public class Student implements Comparable<Student> {
    String firstname;
    String surname;
    int ID;

    public Student(String firstname, String surname, int ID) {
        this.firstname = firstname;
        this.surname = surname;
        this.ID = ID;
    }

   public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public int getID() {
        return ID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
// sorting by first and last name

//    @Override
//    public int compareTo(Student other) {
//        int result = this.surname.compareTo(other.surname);
//        if(result == 0) {
//            return this.firstname.compareTo(other.firstname);
//        }
//       return result;
//   }

    // sorting by ID
    @Override
    public int compareTo(Student other) {
        return this.ID - other.ID;
    }
}
