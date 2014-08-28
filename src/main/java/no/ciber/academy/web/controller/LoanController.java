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
import java.util.Iterator;
import java.util.List;

@Controller
public class LoanController {

    @Autowired
    LoanRepository loanRepository;
    @Autowired
    BookRepository bookRepository;

   /* @RequestMapping(method = RequestMethod.POST, value = "/loanBook/{id}")
     public String loanBook(@PathVariable String id, RedirectAttributes redirect) {
        List <Loan> loans = loanRepository.findAll();
        Book book = bookRepository.findOne(id);
        if(book == null) {
            redirect.addFlashAttribute("globalMessageDanger", "Could not find book");
            return "redirect:/books/allBooks";
        }

        if(loans.isEmpty() && book.getNumberOfCopies() > 0){
            loanRepository.save(new Loan(book));
            if(book.getNumberOfCopies() == 1) {
                book.setAvailable(false);
                bookRepository.save(book);
            }
            redirect.addFlashAttribute("globalMessageSuccess", String.format("A loan of '%s' is now registered on you", book.getTitle()));
            return "redirect:/books/allBooks";
        }

        int booksLoaned = 1;

        for(Loan loan : loans){
            if(loan.getBook().getIsbn() == book.getIsbn() && loan.getDeliveryDate() == null)
                booksLoaned++;
        }
        if(booksLoaned > book.getNumberOfCopies()) {
            book.setAvailable(false);
            bookRepository.save(book);
            redirect.addFlashAttribute("globalMessageDanger", "There are no available copies of this book");
            return "redirect:/books/allBooks";
        }
        else if(booksLoaned == book.getNumberOfCopies()){
            book.setAvailable(false);
            bookRepository.save(book);
        }

        loanRepository.save(new Loan(book));
        redirect.addFlashAttribute("globalMessageSuccess", String.format("A loan of '%s' is now registered on you", book.getTitle()));
        return "redirect:/books/allBooks";
    }*/

    @RequestMapping(method = RequestMethod.POST, value = "/loanBook/{id}")
    public String loanBook(@PathVariable String id, RedirectAttributes redirect) {
        List <Loan> loans = loanRepository.findAll();
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
        List<Loan> loans = loanRepository.findAll();
        List<String> isbns = new ArrayList<String>();
        for (Loan loan : loans) {
            isbns.add(loan.getBook().getIsbn());
        }

        List<Book> books = bookRepository.findAll(isbns);
        model.addAttribute("books", books);

        return "/loan/userLoan";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/myLoans/{id}")
    public String deliverBook(@PathVariable String id, Model model) {
        List <Loan> loans = loanRepository.findAll();

        model.addAttribute("globalMessageSuccess", "A loan of '%s' is now registered on you");
        return "redirect:/loan/userLoan";
    }
}
