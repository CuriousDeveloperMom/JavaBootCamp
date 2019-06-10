package com.company;

public class VendingMachine {
    private int mints;
    private int gum;
    private int popcorn;
    private int chips;
    private int chocolate;
    private Store store;
    private Restaurant restaurant;

    //default constructor

    public VendingMachine() {
    }

    //Getter And Setters

    public int getMints() {
        return mints;
    }

    public void setMints(int mints) {
        this.mints = mints;
    }

    public int getGum() {
        return gum;
    }

    public void setGum(int gum) {
        this.gum = gum;
    }

    public int getPopcorn() {
        return popcorn;
    }

    public void setPopcorn(int popcorn) {
        this.popcorn = popcorn;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public int getChocolate() {
        return chocolate;
    }

    public void setChocolate(int chocolate) {
        this.chocolate = chocolate;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
