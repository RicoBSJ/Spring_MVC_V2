package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.AuthorService;
import com.aubrun.eric.projet7.springmvc.model.Authors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = {"/author","/getAllAuthor"}, method = RequestMethod.GET)
    public String printAllAuthors(ModelMap model) {

        Authors authors = authorService.findAuthors().getBody();
        model.addAttribute("authors" , authors);
        return "/author";
    }
}
