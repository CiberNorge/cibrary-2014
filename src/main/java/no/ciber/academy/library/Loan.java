package no.ciber.academy.library;

import org.joda.time.LocalDateTime;

/**
 * Created by alegis on 25/08/14.
 */
public class Loan {

    private long Id;

    private BookLoaner bookLoaner;
    private Book book;
    private LocalDateTime timeOfCheckout;
    private LocalDateTime timeOfCheckin;

    public LocalDateTime getTimeOfCheckin() {
        return timeOfCheckin;
    }

    public void setTimeOfCheckin(LocalDateTime timeOfCheckin) {
        this.timeOfCheckin = timeOfCheckin;
    }

    public BookLoaner getBookLoaner() {
        return bookLoaner;
    }

    public void setBookLoaner(BookLoaner bookLoaner) {
        this.bookLoaner = bookLoaner;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getTimeOfCheckout() {
        return timeOfCheckout;
    }

    public void setTimeOfCheckout(LocalDateTime timeOfCheckout) {
        this.timeOfCheckout = timeOfCheckout;
    }



}
