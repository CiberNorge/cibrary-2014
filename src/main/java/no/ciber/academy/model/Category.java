package no.ciber.academy.model;



import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chasjo on 26/08/14.
 */
@Entity
@Table(name="category")
public class Category implements Serializable {

    @Id
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
