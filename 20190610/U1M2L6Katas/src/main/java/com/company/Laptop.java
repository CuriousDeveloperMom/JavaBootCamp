package com.company;

public class Laptop {

    private Processor processor;
    private Memory memory;
    private OpticalDrive opticalDrive;
    private Storage storage;

    //default constructor

    public Laptop() {
    }

    //Getter And Setters

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public OpticalDrive getOpticalDrive() {
        return opticalDrive;
    }

    public void setOpticalDrive(OpticalDrive opticalDrive) {
        this.opticalDrive = opticalDrive;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
