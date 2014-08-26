package no.ciber.academy.repository;

import no.ciber.academy.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by chasjo on 25/08/14.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, String>{


}
