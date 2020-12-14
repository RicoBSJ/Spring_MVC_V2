package com.aubrun.eric.projet7.springmvc.model;

import javax.persistence.Entity;

@Entity
public class SearchBook {

    private Integer searchBookId;
    private String searchBookTitle;
    private String searchBookAuthorName;
    private String searchBookPublishingHouse;
    private String searchBookReleaseDate;

    public Integer getSearchBookId() {
        return searchBookId;
    }

    public void setSearchBookId(Integer searchBookId) {
        this.searchBookId = searchBookId;
    }

    public String getSearchBookTitle() {
        return searchBookTitle;
    }

    public void setSearchBookTitle(String searchBookTitle) {
        this.searchBookTitle = searchBookTitle;
    }

    public String getSearchBookAuthorName() {
        return searchBookAuthorName;
    }

    public void setSearchBookAuthorName(String searchBookAuthorName) {
        this.searchBookAuthorName = searchBookAuthorName;
    }

    public String getSearchBookPublishingHouse() {
        return searchBookPublishingHouse;
    }

    public void setSearchBookPublishingHouse(String searchBookPublishingHouse) {
        this.searchBookPublishingHouse = searchBookPublishingHouse;
    }

    public String getSearchBookReleaseDate() {
        return searchBookReleaseDate;
    }

    public void setSearchBookReleaseDate(String searchBookReleaseDate) {
        this.searchBookReleaseDate = searchBookReleaseDate;
    }
}
