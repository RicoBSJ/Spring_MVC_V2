package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
import com.aubrun.eric.projet7.springmvc.model.SearchBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {

    private final BookService bookService;

    public SearchController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/book/search/")
    private String searchBooks(ModelMap modelMap) {

        SearchBook searchBook = bookService.bookResponseEntity().getBody();
        modelMap.addAttribute("searchBook" , searchBook);
        return "search";
    }
}
