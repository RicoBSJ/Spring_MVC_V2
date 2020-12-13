package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
import com.aubrun.eric.projet7.springmvc.model.SearchBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {

    private final BookService bookService;

    public SearchController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/searchBook")
    public String searchBookForm(Model model){
        model.addAttribute("searchBook", new SearchBook());
        return "searchBookForm";
    }

    @PostMapping("/searchBook")
    private String searchBooks(@ModelAttribute("searchBook") SearchBook searchBook, Model model) {

        SearchBook searchBook1 = bookService.bookResponseEntity().getBody();
        model.addAttribute("searchBook" , searchBook1);
        return "confirm";
    }
}
