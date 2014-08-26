package no.ciber.academy.web.controller;

import no.ciber.academy.model.Book;
import no.ciber.academy.model.Category;
import no.ciber.academy.repository.BookRepository;
import no.ciber.academy.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("book", new Book());

        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categoryList", categoryList);

        return "books/addBook";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(Book book, BindingResult bindingResult, RedirectAttributes redirect) {
        System.out.println(book.getCategories().get(0).getName());
        bookRepository.save(book);

        redirect.addFlashAttribute("message", String.format("Success")); //'%s.", book.getTitle()));

        return "redirect:/";
    }
}
