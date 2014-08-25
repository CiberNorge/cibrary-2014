package no.ciber.academy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alegis on 25/08/14.
 */

@Controller
@RequestMapping("/books")
public class BookController {

    @RequestMapping(params = "init", method = RequestMethod.GET)


    @RequestMapping(params = "save", method = RequestMethod.POST)


}
