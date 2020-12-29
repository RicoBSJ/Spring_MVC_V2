package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BorrowingService;
import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BorrowingController {

    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @ModelAttribute(value = "borrowing")
    public Borrowing setBorrowing() {
        return new Borrowing();
    }

    @GetMapping("home")
    public String printAllBorrowing(ModelMap modelMap) {

        Borrowing borrowing = borrowingService.getAllBorrowing().getBody();
        modelMap.addAttribute("borrowing" , borrowing);
        return "home";
    }
}
