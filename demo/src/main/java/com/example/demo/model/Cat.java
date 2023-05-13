package com.example.demo.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Cat extends AbstractEntity {

    @NotBlank
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    private String catName;


    private String catAge;

    private String catDate;

    private String catSex;

    private String catFixed;

    private String catBreed;

    private String catColor;

    private String catEars;

    private String catTail;

    private String catClaw;

    private String catLocation;

    private String catLost;

    private String catCollar;

    private String catChip;
    @Size(max = 500, message = "Description too long. ")
    private String catDescription;

    private double longitude;

    private double latitude;

  /*  private String catPic;
*/


    public Cat(String catName,  String catAge,/* String catDate,*/ String catSex, String catFixed, String catBreed, String catColor, String catEars, String catTail, String catClaw, String catLocation, String catLost, String catCollar, String catChip, String catDescription, double latitude, double longitude/*, String catPic*/) {
        this.catName=catName;
        /*this.catDate=catDate;*/
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
        this.latitude=latitude;
        this.longitude=longitude;
      /*  this.catPic=catPic;*/
    }
    public Cat() {};

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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /*
        public String getCatPic() {
            return catPic;
        }

        public void setCatPic(String catPic) {
            this.catPic = catPic;
        }
    */
    @Override
    public String toString(){
        return catName;
    }
}
