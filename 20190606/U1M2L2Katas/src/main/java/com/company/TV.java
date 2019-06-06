package com.company;

public class TV {

    private String manufacturer;
    private String model;
    private int screenSize;
    private String channel;
    private int volume;
    private boolean powered;

    // Constructor

    public TV(String manufacturer, String model, int screenSize, String channel, int volume, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.screenSize = screenSize;
        this.channel = channel;
        this.volume = volume;
        this.powered = powered;
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
    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }
    public int getScreenSize() {
        return this.screenSize;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }
    public String getChannel() {
        return this.channel;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public int getVolume(){
        return this.volume;
    }
    public void setPowered(boolean powered) {
        this.powered = powered;
    }
    public boolean getPowered(){
        return this.powered;
    }

    public void togglePower(){
        System.out.println("Its TV Toggle Power .....");
    }
    public boolean isPowered(){
        System.out.println("Its Radio is powered ON ");
        return true;
    }

}
