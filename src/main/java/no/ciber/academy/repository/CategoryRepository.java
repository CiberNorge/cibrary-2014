package no.ciber.academy.repository;

import no.ciber.academy.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chasjo on 26/08/14.
 */
public interface CategoryRepository extends JpaRepository<Category, String> {
}
