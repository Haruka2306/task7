package com.example.task7;

import java.time.LocalDate;

public class Profile {
    private String name;
    private  LocalDate dateOfBirth;
    private int age;

    public Profile(String name, LocalDate dateOfBirth, int age) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public int getAge() {
        return age;
    }

}





