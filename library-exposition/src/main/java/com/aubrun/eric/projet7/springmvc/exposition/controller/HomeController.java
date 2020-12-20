package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
import com.aubrun.eric.projet7.springmvc.model.SearchBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/searchBook", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("searchBook", new SearchBook());
        return "book";
    }

    /*@RequestMapping(value = {"","/","/home","/homePage"}, method = RequestMethod.GET)
    public String home() {

        return "/home";
    }*/

    @PostMapping(value = "/book/search")
    private String searchBookSubmit(@ModelAttribute("searchBook") SearchBook searchBook, Model model) {

        SearchBook searchBook1 = bookService.bookResponseEntity().getBody();
        model.addAttribute("searchBook" , searchBook1);
        return "confirm";
    }
}
