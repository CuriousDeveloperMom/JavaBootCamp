package com.company.PritiSolankiU1Capstone.viewmodel;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Objects;

public class TshirtViewModel {

    private int tShirtId;
    @NotEmpty(message = "Please supply a value for size")
    private String size;
    @NotEmpty(message = "Please supply a value for color")
    private String color;
    @NotEmpty(message = "Please supply description")
    private String description;
    @NotEmpty(message = "Please supply a value for price")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999999.99", inclusive = true)
    private BigDecimal price;
    @NotEmpty(message = "Please supply a value for quantity")
    private int quantity;

    public int gettShirtId() {
        return tShirtId;
    }

    public void settShirtId(int tShirtId) {
        this.tShirtId = tShirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        TshirtViewModel that = (TshirtViewModel) o;
        return tShirtId == that.tShirtId &&
                quantity == that.quantity &&
                Objects.equals(size, that.size) &&
                Objects.equals(color, that.color) &&
                Objects.equals(description, that.description) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tShirtId, size, color, description, price, quantity);
    }
}
