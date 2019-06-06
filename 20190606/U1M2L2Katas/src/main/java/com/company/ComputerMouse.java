package com.company;

public class ComputerMouse {

    private String manufacturer;
    private String model;
    private int xPosition;
    private int yPosition;
    private int [] lastCickedLocation;

    // Constructor

    public ComputerMouse(String manufacturer, String model, int xPosition, int yPosition, int[] lastCickedLocation) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.lastCickedLocation = lastCickedLocation;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getManufacturer(){
        return this.manufacturer;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getModel(){
        return this.model;
    }
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    public int getxPosition() {
        return this.xPosition;
    }
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
    public int getyPosition() {
        return this.yPosition;
    }
    public void setLastCickedLocation(int[] lastCickedLocation) {
        this.lastCickedLocation = lastCickedLocation;
    }
    public int[] getLastClickedLocation() {
        return this.lastCickedLocation;
    }

    public void move(int deltaX, int deltaY){
        System.out.println("Mouse Move .....");
    }
    public void click(){
        System.out.println("Mouse Click.");
    }

}
