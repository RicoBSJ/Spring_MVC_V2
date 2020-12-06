package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
import com.aubrun.eric.projet7.springmvc.model.Books;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String printHelloWorld(ModelMap modelMap) {

        // add attribute to load modelMap
        modelMap.addAttribute("message",
                "Hello World and Welcome to Spring MVC!");
        Books books = bookService.findAll().getBody();
        // return the name of the file to be loaded "hello_world.jsp"
        return "book";
    }

}
