package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BorrowingService;
import com.aubrun.eric.projet7.springmvc.model.Book;
import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BorrowingController {

    private final BorrowingService borrowingService;
    private final Map<Integer, Borrowing> borrowingMap = new HashMap<>();

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @ModelAttribute(value = "borrowing")
    public Borrowing setBorrowing() {
        return new Borrowing();
    }

    @GetMapping("/home/borrowing")
    public String printAllBorrowing(ModelMap modelMap) {

        Borrowing borrowing = borrowingService.getAllBorrowing().getBody();
        modelMap.addAttribute("borrowing" , borrowing);
        return "home";
    }

    /*@RequestMapping(value = "/home/borrowing", method = { RequestMethod.GET, RequestMethod.POST })
    private String printAllBorrowing(@ModelAttribute("borrowing") Borrowing borrowing, ModelMap model) {

        model.addAttribute("bookBorrowing : ", borrowing.getBookBorrowing());
        model.addAttribute("userAccountBorrowing : ", borrowing.getUserAccountBorrowing());
        model.addAttribute("beginDate : ", borrowing.getBeginDate());
        model.addAttribute("endDate : ", borrowing.getEndDate());
        model.addAttribute("renewal : ", borrowing.getRenewal());
        model.addAttribute("borrowingId : ", borrowing.getBorrowingId());

        borrowingMap.put(borrowing.getBorrowingId(), borrowing);

        return "home";
    }*/
}
