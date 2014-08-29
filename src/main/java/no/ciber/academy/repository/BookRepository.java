package no.ciber.academy.repository;

import no.ciber.academy.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chasjo on 25/08/14.
 */
@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, String>{


}
