package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
import com.aubrun.eric.projet7.springmvc.model.Books;
import com.aubrun.eric.projet7.springmvc.model.SearchBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {

    private final BookService bookService;

    public SearchController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public String printAllBooks(ModelMap modelMap) {

        Books books = bookService.findBooks().getBody();
        modelMap.addAttribute("books" , books);
        return "/searchBookForm";
    }

    @PostMapping("/book")
    private String searchBookSubmit(@ModelAttribute("searchBook") SearchBook searchBook, Model model) {

        SearchBook searchBook1 = bookService.bookResponseEntity().getBody();
        model.addAttribute("searchBook" , searchBook1);
        return "confirm";
    }

    /*@GetMapping("/personne")
    public String personneForm(Model model) {
        model.addAttribute("personne", new Personne());
        return "personneForm";
    }
    @PostMapping("/personne")
    public String personneSubmit(@ModelAttribute("personne") Personne
                                         personne, Model model) {
        Personne p1 = personneRepository.save(personne);
        model.addAttribute("personne", p1);
        return "confirm";
    }*/
}
