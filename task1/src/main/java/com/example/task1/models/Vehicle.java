package com.example.task1.models;


public class Vehicle {

    private String id;
    private String title;
    private String imageURL;
    private int year;
    private int mileage;
    private String price;

    public Vehicle(String id, String title, String imageURL, int year, int mileage, String price) {
        this.id = id;
        this.title = title;
        this.imageURL = imageURL;
        this.price = price;
        this.year = year;
        this.mileage = mileage;
    }
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return imageURL;
    }

    public int getYear() {
        return  year;
    }

    public int getMileage() {
        return   mileage;
    }

    public String getPrice() {
        return price;
    }



}
