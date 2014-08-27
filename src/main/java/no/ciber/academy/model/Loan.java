package no.ciber.academy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by magmol on 26.08.2014.
 */
@Entity
public class Loan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Book book;
    //private User user;
    private Calendar loanDate;
    private Calendar deliveryDate;

    public Loan(){}

    public Loan(Book book /*, User user*/){
        this.book = book;
        //this.user = user;
        loanDate = Calendar.getInstance();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook(){
        return book;
    }
}
