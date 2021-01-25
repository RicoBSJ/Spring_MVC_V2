package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.model.SearchBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class SearchController {

    @GetMapping(value = "/searchBookForm")
    public String printAllBooks(ModelMap modelMap) {

        modelMap.addAttribute("searchBook" , new SearchBook());
        return "../include/searchBookForm";
    }
}
