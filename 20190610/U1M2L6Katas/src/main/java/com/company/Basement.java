package com.company;

public class Basement {

    private boolean isBasement;
    private double areaOfBasement;
    private boolean isFinished;

    //default Constructor

    public Basement()
    {
    }

    //Getter And Setters

    public boolean isBasement() {
        return isBasement;
    }

    public void setBasement(boolean basement) {
        isBasement = basement;
    }

    public double getAreaOfBasement() {
        return areaOfBasement;
    }

    public void setAreaOfBasement(double areaOfBasement) {
        this.areaOfBasement = areaOfBasement;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
