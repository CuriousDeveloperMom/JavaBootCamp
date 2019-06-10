package com.company;

public class Kitchen {
    private boolean hasIsland;
    private double area;
    private String flooring;

    //default constructor

    public Kitchen() {
    }


    //Getter And Setters

    public boolean isHasIsland() {
        return hasIsland;
    }

    public void setHasIsland(boolean hasIsland) {
        this.hasIsland = hasIsland;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getFlooring() {
        return flooring;
    }

    public void setFlooring(String flooring) {
        this.flooring = flooring;
    }

}
