package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
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

    private final Map<Integer, SearchBook> searchBookMap = new HashMap<>();

    private final BookService bookService;

    public SearchController(BookService bookService) {
        this.bookService = bookService;
    }

    /*@GetMapping("/searchBookForm")
    public String printAllBooks(ModelMap modelMap) {

        *//*Books books = bookService.findBooks().getBody();*//*
        modelMap.addAttribute("searchBook" , new SearchBook());
        return "../include/searchBookForm";
    }*/

    @PostMapping(value = "/searchBookForm")
    private String searchBookSubmit(@ModelAttribute("searchBook") SearchBook searchBook, BindingResult result, ModelMap model) {

        if(result.hasErrors()){
            return "error";
        }

        model.addAttribute("searchBookTitle", searchBook.getSearchBookTitle());
        model.addAttribute("searchBookAuthorName", searchBook.getSearchBookAuthorName());
        model.addAttribute("searchBookPublishingHouse", searchBook.getSearchBookPublishingHouse());
        model.addAttribute("searchBookReleaseDate", searchBook.getSearchBookReleaseDate());
        model.addAttribute("searchBookId", searchBook.getSearchBookId());

        searchBookMap.put(searchBook.getSearchBookId(), searchBook);

        return "../include/searchBookForm";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to the Javaland!");
    }
}
