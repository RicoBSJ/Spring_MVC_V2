package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BorrowingService;
import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import com.aubrun.eric.projet7.springmvc.model.Borrowings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @PostMapping("/home/borrowing")
    public ModelAndView borrowing(@ModelAttribute("borrowing") Borrowing borrowing) {
        borrowingService.addBorrow(borrowing);
        System.out.println("bookBorrowing : " + borrowing.getBookBorrowing());
        System.out.println("userAccountBorrowing : " + borrowing.getUserAccountBorrowing());
        System.out.println("beginDate : " + borrowing.getBeginDate());
        System.out.println("endDate : " + borrowing.getEndDate());
        System.out.println("renewal : " + borrowing.getRenewal());
        System.out.println("borrowingId : " + borrowing.getBorrowingId());

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("message", "Emprunt réalisé : ");
        modelAndView.addObject("borrowing", borrowing.getBookBorrowing());
        return modelAndView;
    }
}