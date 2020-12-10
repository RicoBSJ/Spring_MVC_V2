package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.SearchService;
import com.aubrun.eric.projet7.springmvc.model.SearchBooks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    /*@PostMapping("/search")
    public String searchBook(ModelMap modelMap) {

        SearchBooks searchBooks = searchService.bookResponseEntity().getBody();
        modelMap.addAttribute("searchBooks" , searchBooks);
        return "/search";
    }

    @PostMapping("/congratulations")
    public Manager assignToManager(@RequestBody Employee emp) {
        String name = emp.getName();
        int yearsWorked = emp.getYearsWorked();
        String message = "Congratulations, " + name + "! You have been working here for " + yearsWorked + ".";
        Manager manager = new Manager();
        manager.setEmployee(emp.getName()); // now this employee has been assigned to this manager
        return manager;
    }*/
}
