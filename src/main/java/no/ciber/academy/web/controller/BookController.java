package no.ciber.academy.web.controller;

import no.ciber.academy.model.Book;
import no.ciber.academy.model.Category;
import no.ciber.academy.repository.BookRepository;
import no.ciber.academy.repository.CategoryRepository;
import no.ciber.academy.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by chasjo on 26/08/14.
 */
@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/allBooks", method = RequestMethod.GET)
    public String showAll(Model model) {
        Book book = new Book();
        book.setIsbn("2");
        book.setTitle("Boka mi");
        bookRepository.save(book);
        Book book2 = new Book();
        book2.setIsbn("3");
        book2.setTitle("Your book");
        bookRepository.save(book2);

        model.addAttribute("books", bookRepository.findAll());
        return "books/allBooks";
    }

    @RequestMapping(value = "/search/{query}")
    public String search(Model model, @PathVariable String query) {
        model.addAttribute("books", searchService.search(query));
        return "books/allBooks";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("book", new Book());

        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categoryList", categoryList);

        return "books/addBook";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(Book book, BindingResult bindingResult, RedirectAttributes redirect) {
        //System.out.println(book.getCategories().get(0).getName());
        bookRepository.save(book);

        redirect.addFlashAttribute("message", String.format("Success")); //'%s.", book.getTitle()));

        return "redirect:/";
    }
}
