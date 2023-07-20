package com.example.task7;

public class Profile {
    private String name;
    private String dateOfBirth;
    private int age;

    public Profile(String name, String dateOfBirth, int age) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return age;
    }
}
