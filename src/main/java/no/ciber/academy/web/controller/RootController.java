package no.ciber.academy.web.controller;

import no.ciber.academy.model.Book;
import no.ciber.academy.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RootController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(Model model) {
        List<Book> books = bookRepository.findAll();
        return "hello";
    }
}
