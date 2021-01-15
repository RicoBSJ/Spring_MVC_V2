package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BorrowingService;
import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import com.aubrun.eric.projet7.springmvc.model.Borrowings;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/borrowing")
    public ModelAndView showForm() {

        return new ModelAndView("/home", "borrowing", new Borrowings());
    }
}