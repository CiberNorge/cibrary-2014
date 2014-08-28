package no.ciber.academy.model;


import org.hibernate.search.annotations.Boost;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by chasjo on 25/08/14.
 */
@Entity
@Table(name="book")
@Indexed
public class Book implements Serializable {

    @Id
    @NotEmpty
    private String isbn;

    @Field
    @Boost(value = 1.5f)
    private String title;

    @Field
    @Boost(value = 1.5f)
    private String description;

    private String pictureAddress, webLink, auther;

    private int publicationYear, numberOfCopies;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "book_category", joinColumns = { @JoinColumn(name = "isbn") },
            inverseJoinColumns = { @JoinColumn(name = "name") })
    private List<Category> categories;

    public Book() {
    }

    public Book(String isbn, String title, String description, String pictureAddress, String webLink,
                String auther, int publicationYear, int numberOfCopies, List<Category> categories) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.pictureAddress = pictureAddress;
        this.webLink = webLink;
        this.auther = auther;
        this.publicationYear = publicationYear;
        this.numberOfCopies = numberOfCopies;
        this.categories = categories;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public String getWebLink() {
        return webLink;
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
