package no.ciber.academy.repository;

import no.ciber.academy.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chasjo on 26/08/14.
 */
@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, String> {
}
