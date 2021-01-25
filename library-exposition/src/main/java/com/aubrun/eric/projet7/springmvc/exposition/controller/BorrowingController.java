package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BorrowingService;
import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import com.aubrun.eric.projet7.springmvc.model.Borrowings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class BorrowingController {

    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @ModelAttribute(value = "borrowing")
    public Borrowings setBorrowings() {
        return new Borrowings();
    }

    @GetMapping(value = "/home/borrowing")
    public String printAllBooks(ModelMap modelMap) {

        modelMap.addAttribute("bookBorrowing" , new Borrowing());
        return "home";
    }

    @GetMapping(value = {"/borrowing"})
    public String printAllAuthors(ModelMap model) {

        Borrowings borrowings = borrowingService.getAllBorrowing().getBody();
        model.addAttribute("borrowing" , borrowings);
        return "/home";
    }
}