package no.ciber.academy.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by chasjo on 25/08/14.
 */
@Entity
public class Book implements Serializable {

    public Book(String text) {
        this.text = text;
    }

    @Id
    private long id;
    private String text;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
