package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Animal {
    public Animal() {
    }
    @JsonProperty("type")
    public String type;

    @JsonProperty("sound")
    public String sound;

    @JsonProperty("age")
    public Integer age;


    // getters and setters

    @JsonGetter("type")
    public String getType() {
        return type;
    }

    @JsonSetter("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonGetter("sound")
    public String getSound() {
        return sound;
    }

    @JsonSetter("age")
    public void setAge(Integer age) {
        this.age = age;
    }
}

