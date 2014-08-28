package no.ciber.academy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RootController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/books/allBooks";
    }
}
