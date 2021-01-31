package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BorrowingService;
import com.aubrun.eric.projet7.springmvc.model.Book;
import com.aubrun.eric.projet7.springmvc.model.Books;
import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import com.aubrun.eric.projet7.springmvc.model.Borrowings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BorrowingController {

    private final Map<Integer, Borrowing> borrowingMap = new HashMap<>();

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

        Borrowings borrowings = borrowingService.getAllBorrowing().getBody();
        modelMap.addAttribute("bookBorrowings" , borrowings);
        return "borrowing";
    }

    /*@PostMapping("/borrowing")
    public ModelAndView borrowing(@ModelAttribute("borrowing") Borrowing borrowing) {
        borrowingService.addBorrow(borrowing);
        System.out.println("bookBorrowing : " + borrowing.getBookBorrowing().getBookId());
        System.out.println("userAccountBorrowing : " + borrowing.getUserAccountBorrowing().getUserId());
        System.out.println("beginDate : " + borrowing.getBeginDate());
        System.out.println("endDate : " + borrowing.getEndDate());
        System.out.println("renewal : " + borrowing.getRenewal());
        System.out.println("borrowingId : " + borrowing.getBorrowingId());

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("message", "Emprunt réalisé : ");
        modelAndView.addObject("borrowing", borrowing.getBookBorrowing());
        return modelAndView;
    }*/

    @PostMapping(value = "/home/borrowing")
    private String searchBookSubmit(@ModelAttribute("borrowing") Borrowing borrowing, ModelMap model) {

        model.addAttribute("bookBorrowing", borrowing.getBookBorrowing().getBookId());
        model.addAttribute("userAccountBorrowing", borrowing.getUserAccountBorrowing().getUserId());
        model.addAttribute("beginDate", borrowing.getBeginDate());
        model.addAttribute("endDate", borrowing.getEndDate());
        model.addAttribute("renewal", borrowing.getRenewal());
        model.addAttribute("borrowingId", borrowing.getBorrowingId());

        borrowingMap.put(borrowing.getBorrowingId(), borrowing);

        return "borrowing";
    }
}