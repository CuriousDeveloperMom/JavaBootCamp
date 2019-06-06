package com.company;

public class Radio {

    private String manufacturer;
    private String model;
    private int numSpeaker;
    private String station;
    private int volume;
    private boolean powered;

    // Constructor

    public Radio(String manufacturer, String model, int numSpeaker, String station, int volume, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.numSpeaker = numSpeaker;
        this.station = station;
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
    public void setNumSpeaker(int numSpeaker) {
        this.numSpeaker = numSpeaker;
    }
    public int getNumSpeakers() {
        return this.numSpeaker;
    }
    public void setStation(String station) {
        this.station = station;
    }
    public String getStation() {
        return this.station;
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
        System.out.println("Its Radio Toggle Power .....");
    }
    public boolean isPowered(){
        System.out.println("Its Radio is powered ON ");
        return true;
    }


}
