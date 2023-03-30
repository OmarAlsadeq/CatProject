package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Cat extends AbstractEntity {

    @NotBlank
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    String catName;

    int age;

    String color;

    String breed;

    String sex;

    int dateSeen;

    public Cat(String catName, int age, String color, String breed, String sex, int dateSeen){
        this.catName = catName;
        this.age = age;
        this.color = color;
        this.breed = breed;
        this.sex = sex;
        this.dateSeen = dateSeen;
    }
    public Cat(){}

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getDateSeen() {
        return dateSeen;
    }

    public void setDateSeen(int dateSeen) {
        this.dateSeen = dateSeen;
    }
    @Override
    public String toString(){
        return catName;
    }
}
