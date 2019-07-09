package com.company.PritiSolankiU1M5Summative.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Book {
    private int book_id;
    private String isbn;
    private String publish_date;
    private int author_id;
    private String title;
    private int publisher_id;
    private BigDecimal price;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return book_id == book.book_id &&
                author_id == book.author_id &&
                publisher_id == book.publisher_id &&
                isbn.equals(book.isbn) &&
                publish_date.equals(book.publish_date) &&
                title.equals(book.title) &&
                price.equals(book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_id, isbn, publish_date, author_id, title, publisher_id, price);
    }

    /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return getBook_id() == that.getBook_id() &&
                Objects.equals(getIsbn(), that.getIsbn()) &&
                Objects.equals(getPublish_date(), that.getPublish_date()) &&
                Objects.equals(getAuthor_id(), that.getAuthor_id()) &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getPublisher_id(), that.getPublisher_id()) &&
                Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBook_id(), getIsbn(), getPublish_date(), getAuthor_id(), getTitle(), getPublisher_id(), getPrice());
    }*/

}
