package no.ciber.academy.library;

/**
 * Created by alegis on 25/08/14.
 */
public class Book {

    private long Id;
    private String bookName;
    private long ISBN;
    //TODO: Field for which office owns the book?

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
