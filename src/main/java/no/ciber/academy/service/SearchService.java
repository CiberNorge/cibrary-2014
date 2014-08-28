package no.ciber.academy.service;

import no.ciber.academy.model.Book;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class SearchService {


    /**
     * Search for a Book.
     */
    @SuppressWarnings("unchecked")
    public List<Book> search(String searchString) {

        // Create a Query Builder
        QueryBuilder qb = getFullTextEntityManager().getSearchFactory().buildQueryBuilder().forEntity(Book.class).get();

        // Create a Lucene Full Text Query
        Query junction = qb.bool().must(qb.keyword()
                .onFields("title", "description")
                .matching(searchString).createQuery())
                .createQuery();

        FullTextQuery fullTextQuery = getFullTextEntityManager().createFullTextQuery(junction, Book.class);

        // Run Query and print out results to console
        List<Book> result = (List<Book>) fullTextQuery.getResultList();

        return result;
    }

    @PersistenceContext
    EntityManager em;

    private FullTextEntityManager getFullTextEntityManager() {
        return Search.getFullTextEntityManager(em);
    }


}
