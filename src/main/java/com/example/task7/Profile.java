package com.example.task7;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public class Profile {
    //入力必須、長さ20桁まで
    @NotEmpty(message = "Please provide a name")
    @Length(max = 20)
    private String name;

    //入力必須
    @NotEmpty(message = "Please provide a dateOfBirth")
    private  LocalDate dateOfBirth;

    //対象年齢：20~65歳
    @Min(20)
    @Max(65)
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





