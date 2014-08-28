package no.ciber.academy.web.controller;

import no.ciber.academy.model.Book;
import no.ciber.academy.model.Category;
import no.ciber.academy.model.Loan;
import no.ciber.academy.repository.BookRepository;
import no.ciber.academy.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

@Controller
public class LoanController {

    @Autowired
    LoanRepository loanRepository;
    @Autowired
    BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/loanBook/{id}")
    public String loanBook(@PathVariable String id, RedirectAttributes redirect) {
        Book book = bookRepository.findOne(id);
        if(book == null) {
            redirect.addFlashAttribute("globalMessageDanger", "Could not find book");
            return "redirect:/books/allBooks";
        }

        if(book.getNumberOfCopies() > book.getBooksLoaned()){
            book.setBooksLoaned(book.getBooksLoaned() + 1);
            loanRepository.save(new Loan(book));
            redirect.addFlashAttribute("globalMessageSuccess", String.format("A loan of '%s' is now registered on you", book.getTitle()));
            return "redirect:/books/allBooks";
        }

        else {
            redirect.addFlashAttribute("globalMessageDanger", "There are no available copies of this book");
            return "redirect:/books/allBooks";
        }
    }

    @RequestMapping(value = "/myLoans", method = RequestMethod.GET)
    public String seeMyLoans( Model model) {
        List <Book> books = bookRepository.findAll();

        for (int i = books.size() - 1; i >= 0; i--) {
            Book book = books.get(i);
            if (book.getLoans().size() < 1)
                books.remove(i);
        }

        model.addAttribute("books", books);

        return "/loan/userLoan";
    }

    @RequestMapping(value = "/myLoans/{isbn}", method = RequestMethod.POST)
    public String deliverBook(@PathVariable String isbn, RedirectAttributes redirect) {
        List <Loan> loans = loanRepository.findByBookIsbn(isbn);
        boolean deliverd = false;

        if (!loans.isEmpty()) {
            int i = 0;
            Loan loan = loans.get(i);

            while (loan.getDeliveryDate() != null) loan = loans.get(++i);

            loan.setDeliveryDate(Calendar.getInstance());
            loanRepository.save(loan);

            redirect.addFlashAttribute("globalMessageSuccess",  "Success! Your book is now returned.");
            deliverd = true;
        }

        if (!deliverd)
            redirect.addFlashAttribute("globalMessageDanger", "Could not find the book.");

        return "redirect:/myLoans";
    }
}
