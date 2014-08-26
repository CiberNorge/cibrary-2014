package no.ciber.academy.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by chasjo on 25/08/14.
 */
@Entity
@Table(name="book")
public class Book implements Serializable {

    @Id
    private String isbn;

    private String name, description, pictureAddress, webLink;

    //@OneToMany(mappedBy = "auther", fetch = FetchType.EAGER)
    @ElementCollection
    private List<String> auther;

    private int publicationYear, numberOfCopies;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "book_category", joinColumns = { @JoinColumn(name = "isbn") },
            inverseJoinColumns = { @JoinColumn(name = "name") })
    private List<Category> categories;

    public Book() {
    }

    public Book(String isbn, String name, String description, String pictureAddress, String webLink,
                List<String> auther, int publicationYear, int numberOfCopies, List<Category> categories) {
        this.isbn = isbn;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<String> getAuther() {
        return auther;
    }

    public void setAuther(List<String> auther) {
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
