package no.ciber.academy.repository;

import no.ciber.academy.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by magmol on 26.08.2014.
 */
public interface LoanRepository extends JpaRepository<Loan, String> {
}
