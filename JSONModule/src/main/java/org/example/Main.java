package org.example;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        //------------------------------------STUDENT  convert class into JSON---------------------------//

//        Student student = new Student("Bob", "Smith", 18, false, 65);
//        try {
//            student = mapper.writeValue(new File("C:\\Users\\DanaSeidakhmetova\\IdeaProjects\\student.json"), student);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


      //------------------------------------ANIMAL Converting JSON to Java Object---------------------------//
//        String input = "{\"type\":\"Cat\",\"sound\":\"meow\",\"age\":3}";
//        try {
//            Animal cat = mapper.readValue(input, Animal.class);
//            System.out.println(cat.getType());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //-------------STUDENT with @JSonCreator and @JsonProperty annotations-------------//
//        try {
//        String studentInput = "{\"firstName\":\"Tom\",\"lastName\":\"Smith\",\"age\":23,\"paid\":true,\"mark\":73}}}";
//        Student student = mapper.readValue(studentInput, Student.class);
//        System.out.println(student.getFirstName() + " " + student.getLastName());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //-------------STUDENT using the setVisibility method on ObjectMapper-------------//

        try {
            String studentInput = "{\"firstName\":\"Tom\",\"lastName\":\"Smith\",\"age\":23,\"paid\":true,\"mark\":73}}}";
            Student student = mapper.readValue(studentInput, Student.class);
            System.out.println(student.getFirstName() + " " + student.getLastName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}