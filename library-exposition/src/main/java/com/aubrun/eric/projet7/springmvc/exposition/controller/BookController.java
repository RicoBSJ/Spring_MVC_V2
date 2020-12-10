package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
import com.aubrun.eric.projet7.springmvc.model.Books;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = {"/book","/getAllBook"}, method = RequestMethod.GET)
    public String printAllBooks(ModelMap modelMap) {

        Books books = bookService.findBooks().getBody();
        modelMap.addAttribute("books" , books);
        return "/book";
    }
}
