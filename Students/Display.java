package Students;

import java.util.ArrayList;
import java.util.Collections;

public class Display {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();

        Student s1 = new Student("Lim", "Henry", 1796);
        Student s2 = new Student("Lim", "Brown", 1370);
//        Student s3 = new Student("Bob", "Tomas", 1258);
//        Student s4 = new Student("Sandra", "Hernandez", 1370);
//        Student s5 = new Student("Mariam", "Serion", 1258);
//        Student s6 = new Student("Xavier", "Bash", 1370);
        studentList.add(s1);
        studentList.add(s2);
//        studentList.add(s3);
//        studentList.add(s4);
//        studentList.add(s5);
//        studentList.add(s6);


        System.out.println("\n----------------BEFORE SORT-------------------------");

        for (Student s : studentList) {
            System.out.println("Name: " + s.getFirstname() + "  Surname: " + s.getSurname() + " ID: " + s.getID());
        }

        System.out.println("\n----------------COMPARE TO-------------------------");

        if (s1.compareTo(s2) < 0) {
            System.out.println("s1 is first: " + s1.compareTo(s2));
        } else if (s1.compareTo(s2) > 0) {
            System.out.println("s2 is first: " + s1.compareTo(s2));
        } else {
            System.out.println("s1 equal to s2: " + s1.compareTo(s2));
        }

        Collections.sort(studentList);

        System.out.println("\n----------------AFTER SORT-------------------------");
        for (Student s : studentList) {
            System.out.println("Name: " + s.getFirstname() + "  Surname: " + s.getSurname() + " ID: " + s.getID());
        }

    }
}
