package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
import org.springframework.stereotype.Controller;

@Controller
public class SearchController {

    private final BookService bookService;

    public SearchController(BookService bookService) {
        this.bookService = bookService;
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
