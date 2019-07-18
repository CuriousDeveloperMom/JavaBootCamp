package com.company.PritiSolankiU1Capstone.viewmodel;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class InvoiceInputViewModel {

    @NotEmpty(message = "Please supply a value for name")
    private String name;
    @NotEmpty(message = "Please supply a value for street")
    private String street;
    @NotEmpty(message = "Please supply a value for city")
    private String city;
    @NotEmpty(message = "Please supply a value for state")
    private String state;
    @NotEmpty(message = "Please supply a value for zipcode")
    private String zipcode;
    @NotEmpty(message = "Please supply a value for itemType")
    private String itemType;
    @NotEmpty(message = "Please supply a value for itemId")
    private int itemId;
    @NotEmpty(message = "Please supply a value for quantity")
    private int quantity;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceInputViewModel that = (InvoiceInputViewModel) o;
        return itemId == that.itemId &&
                quantity == that.quantity &&
                Objects.equals(name, that.name) &&
                Objects.equals(street, that.street) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(zipcode, that.zipcode) &&
                Objects.equals(itemType, that.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, street, city, state, zipcode, itemType, itemId, quantity);
    }
}
