package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BorrowingService;
import com.aubrun.eric.projet7.springmvc.exposition.controller.form.ExtendBorrowingForm;
import com.aubrun.eric.projet7.springmvc.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping(value = {"/borrowing","/getAllBorrowing"})
    public String printAllBorrowings(ModelMap modelMap) {

        Borrowings borrowings = borrowingService.getAllBorrowing().getBody();
        modelMap.addAttribute("borrowings" , borrowings);
        return "/borrowing";
    }

    @PostMapping("/borrowing")
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
        modelAndView.addObject("borrowing", borrowing);
        return modelAndView;
    }

    @PostMapping("/updateBorrowing")
    public String extendBorrowing(@ModelAttribute ("extendBorrowingForm")ExtendBorrowingForm form, ModelMap modelMap){

        Borrowings borrowings = borrowingService.getAllBorrowing().getBody();
        modelMap.addAttribute("borrowings" , borrowings);
        borrowingService.extendBorrowing(form.getBorrowingId());
        return "borrowing";
    }
}