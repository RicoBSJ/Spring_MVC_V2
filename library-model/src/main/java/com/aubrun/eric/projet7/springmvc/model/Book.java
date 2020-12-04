package com.aubrun.eric.projet7.springmvc.model;

import java.util.Date;

public class Book {

    private Integer bookId;
    private String title;
    private Integer quantity;
    private Date yearBook;
    private Author bookAuthor;
    private Category bookCategory;
    private Edition bookEdition;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getYearBook() {
        return yearBook;
    }

    public void setYearBook(Date yearBook) {
        this.yearBook = yearBook;
    }

    public Author getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(Author bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Category getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(Category bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Edition getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(Edition bookEdition) {
        this.bookEdition = bookEdition;
    }
}
