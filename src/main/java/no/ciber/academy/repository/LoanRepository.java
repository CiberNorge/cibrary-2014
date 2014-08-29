package no.ciber.academy.repository;

import no.ciber.academy.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by magmol on 26.08.2014.
 */
@Repository
@Transactional
public interface LoanRepository extends JpaRepository<Loan, Long> {

    public List<Loan> findByBookIsbn(String isbn);
}
