package com.company.Television;

public class Television {
    private String brand;
    private String model;
    private double price;
    private double screenSize;


    public Television(String brand, String model, double price, double screenSize) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.screenSize = screenSize;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}
