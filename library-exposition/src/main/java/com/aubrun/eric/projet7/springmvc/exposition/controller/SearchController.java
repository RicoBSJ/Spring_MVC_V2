package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
import com.aubrun.eric.projet7.springmvc.model.Books;
import com.aubrun.eric.projet7.springmvc.model.SearchBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@ControllerAdvice
public class SearchController {

    private final BookService bookService;

    public SearchController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/searchBookForm")
    public String printAllBooks(ModelMap modelMap) {

        /*Books books = bookService.findBooks().getBody();*/
        modelMap.addAttribute("searchBook" , new SearchBook());
        return "../include/searchBookForm";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to Javaland!");
    }
}
