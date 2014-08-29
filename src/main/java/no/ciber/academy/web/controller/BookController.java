package no.ciber.academy.web.controller;

import no.ciber.academy.model.Book;
import no.ciber.academy.model.Category;
import no.ciber.academy.repository.BookRepository;
import no.ciber.academy.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chasjo on 26/08/14.
 */
@Controller
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping(value = "/allBooks", method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("books", bookRepository.findAll(new Sort(Sort.Direction.ASC, "categories")));
        return "books/allBooks";
    }

    @RequestMapping(value = "/lookupIsbn", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("book", new Book());

        addCategoriesToModel(model);

        return "books/addBook";
    }

    private void addCategoriesToModel(Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categoryList", categoryList);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(Book book, Model model, RedirectAttributes redirect) {

        bookRepository.save(book);
        model.addAttribute("book", book);

        redirect.addFlashAttribute("globalMessageSuccess", "Success adding book " + book.getTitle());
        addCategoriesToModel(model);

        return "redirect:/books/allBooks";
        //return "books/addBook";
    }

    @RequestMapping(value = "/lookupIsbn", method = RequestMethod.POST)
    public String addSearchForBook(Book book, Model model) {

        Book bookFromDB = bookRepository.findOne(book.getIsbn());

        if (bookFromDB != null) {
            book = bookFromDB;
        }

        model.addAttribute("book", book);
        addCategoriesToModel(model);

        return "books/addBook";
    }
}
