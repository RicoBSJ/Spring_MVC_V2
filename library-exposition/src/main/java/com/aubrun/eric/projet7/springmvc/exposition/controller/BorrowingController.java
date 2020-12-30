package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BorrowingService;
import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import com.aubrun.eric.projet7.springmvc.model.Borrowings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping(value = "/borrowing")
    public String printAllBorrowings(ModelMap modelMap) {

        Borrowings borrowings = borrowingService.getAllBorrowing().getBody();
        modelMap.addAttribute("borrowings" , borrowings);
        return "/borrowing";
    }
}
