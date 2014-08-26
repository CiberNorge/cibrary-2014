package no.ciber.academy.web.controller;

import no.ciber.academy.model.Book;
import no.ciber.academy.model.Category;
import no.ciber.academy.model.Loan;
import no.ciber.academy.repository.BookRepository;
import no.ciber.academy.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LoanController {

    @Autowired
    LoanRepository loanRepository;
    @Autowired
    BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/loanBook/{id}")
     public String loanBook(@PathVariable String id, RedirectAttributes redirect) {
        List <Loan> loans = loanRepository.findAll();
        Book book = bookRepository.findOne(id);
        if(book == null) {
            redirect.addFlashAttribute("globalMessage", "Could not find book");
            return "redirect:/";
        }
        int booksLoaned = 0;
        for(Loan loan : loans){
            if(loan.getBook().getIsbn() == book.getIsbn())
                booksLoaned++;
            if(booksLoaned > book.getNumberOfCopies()) {
                redirect.addFlashAttribute("globalMessage", "There are no available copies of this book");
                return "redirect:/";
            }
        }
        loanRepository.save(new Loan(book));
        redirect.addFlashAttribute("globalMessage", String.format("A loan of '%s' is now registered on you", book.getName()));
        return "redirect:/";
    }
}
