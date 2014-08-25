package no.ciber.academy.library;
import org.joda.time.LocalDate;

/**
 * Created by alegis on 25/08/14.
 */
public class Book {

    private long Id;


    private String bookName;
    private String author;
    private LocalDate releaseDate;
    private String webLink;
    private long ISBN;
    //TODO: Field for which office owns the book?

    public Book(){

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getWebLink() {
        return webLink;
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }


    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}
