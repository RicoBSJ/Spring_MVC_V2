package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.AuthorService;
import com.aubrun.eric.projet7.springmvc.model.Author;
import com.aubrun.eric.projet7.springmvc.model.Authors;
import com.aubrun.eric.projet7.springmvc.model.Book;
import com.aubrun.eric.projet7.springmvc.model.Borrowings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthorController {

    private final Map<Integer, Author> authorMap = new HashMap<>();

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ModelAttribute(value = "author")
    public Authors setAuthors() {
        return new Authors();
    }

    @GetMapping(value = {"/author","/getAllAuthor"})
    public String printAllAuthors(ModelMap model) {

        Authors authors = authorService.findAuthors().getBody();
        model.addAttribute("authors" , authors);
        return "/author";
    }

    @PostMapping(value = "/author")
    private String searchAuthorSubmit(@ModelAttribute("author")Author author, ModelMap model) {

        model.addAttribute("authorId", author.getAuthorId());
        model.addAttribute("firstName", author.getFirstName());
        model.addAttribute("lastName", author.getLastName());

        authorMap.put(author.getAuthorId(), author);

        return "book";
    }
}
