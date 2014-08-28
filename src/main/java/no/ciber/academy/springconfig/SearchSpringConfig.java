package no.ciber.academy.springconfig;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;

import javax.persistence.EntityManager;

//@Configuration
public class SearchSpringConfig {

//    @PersistenceContext
    EntityManager em;

//    @Bean
    FullTextEntityManager fullTextEntityManager() {
        return Search.getFullTextEntityManager(em);
    }
}
