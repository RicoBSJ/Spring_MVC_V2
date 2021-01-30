package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
import com.aubrun.eric.projet7.springmvc.model.Book;
import com.aubrun.eric.projet7.springmvc.model.Borrowings;
import com.aubrun.eric.projet7.springmvc.model.SearchBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {

    private final BookService bookService;

    public SearchController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute(value = "searchBook")
    public SearchBook setSearchBook() {
        return new SearchBook();
    }

    @GetMapping(value = "/searchBookForm")
    public String printAllBooks(ModelMap modelMap) {

        modelMap.addAttribute("searchBook" , new SearchBook());
        return "../include/searchBookForm";
    }

    @PostMapping(value = "/home/search")
    private ModelAndView searchBookSubmit(@ModelAttribute("searchBook") SearchBook searchBook) {
        List<Book> result = bookService.searchBook(searchBook).getBody();
        ModelAndView modelAndView = new ModelAndView("/home", "searchBook", new SearchBook());
        modelAndView.addObject("books", result);
        return modelAndView;
    }
}
