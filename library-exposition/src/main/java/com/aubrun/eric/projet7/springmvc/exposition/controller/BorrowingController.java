package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BorrowingService;
import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import com.aubrun.eric.projet7.springmvc.model.Borrowings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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

    @GetMapping("/borrowing")
    public ModelAndView showForm() {

        return new ModelAndView("/home", "borrowing", new Borrowings());
    }

    /*@PostMapping("/home/borrowing")
    public String borrowing(@ModelAttribute("newBorrowing") Borrowing borrowing, Model model) {

        Borrowings newBorrowing = borrowingService.addBorrow(borrowing).getBody();

        System.out.println("bookBorrowing : " + borrowing.getBookBorrowing());
        System.out.println("userAccountBorrowing : " + borrowing.getUserAccountBorrowing());
        System.out.println("beginDate : " + borrowing.getBeginDate());
        System.out.println("endDate : " + borrowing.getEndDate());
        System.out.println("renewal : " + borrowing.getRenewal());
        System.out.println("borrowingId : " + borrowing.getBorrowingId());

        model.addAttribute("message", "Emprunt réussi : ");
        model.addAttribute("borrowing", newBorrowing);

        return "redirect:home";
    }*/
}
