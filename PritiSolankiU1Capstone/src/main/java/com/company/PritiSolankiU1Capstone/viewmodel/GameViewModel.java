package com.company.PritiSolankiU1Capstone.viewmodel;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Objects;

public class GameViewModel {

    private int gameId;
    @NotEmpty(message="Please supply a title")
    private String title;
    @NotEmpty(message="Please supply an ersbRating")
    private String ersbRating;
    @NotEmpty(message="Please supply description")
    private String description;
    @NotEmpty(message="Please supply an price")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999999.99", inclusive = true)
    private BigDecimal price;
    @NotEmpty(message="Please supply an studio")
    private String studio;
    @NotEmpty(message="Please supply an quantity")
    private int quantity;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getErsbRating() {
        return ersbRating;
    }

    public void setErsbRating(String ersbRating) {
        this.ersbRating = ersbRating;
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

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        GameViewModel that = (GameViewModel) o;
        return gameId == that.gameId &&
                quantity == that.quantity &&
                Objects.equals(title, that.title) &&
                Objects.equals(ersbRating, that.ersbRating) &&
                Objects.equals(description, that.description) &&
                Objects.equals(price, that.price) &&
                Objects.equals(studio, that.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, title, ersbRating, description, price, studio, quantity);
    }
}
