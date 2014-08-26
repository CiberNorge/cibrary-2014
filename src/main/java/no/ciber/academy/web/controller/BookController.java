package no.ciber.academy.web.controller;

import no.ciber.academy.model.Book;
import no.ciber.academy.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by chasjo on 26/08/14.
 */
@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/addBook";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(Book book, BindingResult bindingResult) {
        bookRepository.save(book);
        return "/index";
    }
}
