package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private int mark; //(These should be between 0 and 100).
    public boolean paid;

    // constructor with @JsonCreator annotation
    @JsonCreator
    public void Person(@JsonProperty("firstName") String firstName,
                       @JsonProperty("lastName") String lastName,
                       @JsonProperty("age") int age,
                       @JsonProperty("paid") boolean paid,
                       @JsonProperty("mark") int mark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.paid = paid;
        this.mark = mark;
    }

    // getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean isPaid() {
        return paid;
    }

    public int getMark() {
        return mark;
    }


    // setter
    public void setPaid(boolean paid) {
        this.paid = paid;
    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", mark=" + mark +
                ", paid=" + paid +
                '}';
    }
}
