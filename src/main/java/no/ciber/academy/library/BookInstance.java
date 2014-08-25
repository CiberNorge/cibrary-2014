package no.ciber.academy.library;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alegis on 25/08/14.
 */
public class BookInstance {

    private long Id;

    private BookInstance bookInstance;

    private Book book;
    private List<Loan> bookLoans = new ArrayList<Loan>();

    public BookInstance(){

    }

    public BookInstance getBookInstance() {
        return bookInstance;
    }

    public void setBookInstance(BookInstance bookInstance) {
        this.bookInstance = bookInstance;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Loan> getBookLoans() {
        return bookLoans;
    }

    public void setBookLoans(List<Loan> bookLoans) {
        this.bookLoans = bookLoans;
    }
}
