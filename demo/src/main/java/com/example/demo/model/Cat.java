package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Cat extends AbstractEntity {

    @NotBlank
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    String catName;

    String catDate;

    String catSex;

    String catFixed;

    String catAge;

    String catBreed;

    String catColor;

    String catEars;

    String catTail;

    String catClaw;

    String catLocation;

    String catLost;

    String catCollar;

    String catChip;

    String catDescription;

    String catPic;



    public Cat(String catName, String catDate, String catSex, String catFixed, String catAge, String catBreed, String catColor, String catEars, String catTail, String catClaw, String catLocation, String catLost, String catCollar, String catChip, String catDescription, String catPic) {
        this.catName=catName;
        this.catDate=catDate;
        this.catSex=catSex;
        this.catFixed=catFixed;
        this.catAge=catAge;
        this.catBreed=catBreed;
        this.catColor=catColor;
        this.catEars=catEars;
        this.catTail=catTail;
        this.catClaw=catClaw;
        this.catLocation=catLocation;
        this.catLost=catLost;
        this.catCollar=catCollar;
        this.catChip=catChip;
        this.catDescription=catDescription;
        this.catPic=catPic;
    }

    public Cat(String catName, String catDate, String catSex, String catFixed, String catAge, String catBreed, String catColor, String catEars, String catTail, String catLocation, String catLost, String catCollar, String catChip, String catDescription, String catPic) {
        super();
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDate() {
        return catDate;
    }

    public void setCatDate(String catDate) {
        this.catDate = catDate;
    }

    public String getCatSex() {
        return catSex;
    }

    public void setCatSex(String catSex) {
        this.catSex = catSex;
    }

    public String getCatFixed() {
        return catFixed;
    }

    public void setCatFixed(String catFixed) {
        this.catFixed = catFixed;
    }

    public String getCatAge() {
        return catAge;
    }

    public void setCatAge(String catAge) {
        this.catAge = catAge;
    }

    public String getCatBreed() {
        return catBreed;
    }

    public void setCatBreed(String catBreed) {
        this.catBreed = catBreed;
    }

    public String getCatColor() {
        return catColor;
    }

    public void setCatColor(String catColor) {
        this.catColor = catColor;
    }

    public String getCatEars() {
        return catEars;
    }

    public void setCatEars(String catEars) {
        this.catEars = catEars;
    }

    public String getCatTail() {
        return catTail;
    }

    public void setCatTail(String catTail) {
        this.catTail = catTail;
    }

    public String getCatClaw() {
        return catClaw;
    }

    public void setCatClaw(String catClaw) {
        this.catClaw = catClaw;
    }

    public String getCatLocation() {
        return catLocation;
    }

    public void setCatLocation(String catLocation) {
        this.catLocation = catLocation;
    }

    public String getCatLost() {
        return catLost;
    }

    public void setCatLost(String catLost) {
        this.catLost = catLost;
    }

    public String getCatCollar() {
        return catCollar;
    }

    public void setCatCollar(String catCollar) {
        this.catCollar = catCollar;
    }

    public String getCatChip() {
        return catChip;
    }

    public void setCatChip(String catChip) {
        this.catChip = catChip;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public String getCatPic() {
        return catPic;
    }

    public void setCatPic(String catPic) {
        this.catPic = catPic;
    }

    @Override
    public String toString(){
        return catName;
    }
}
