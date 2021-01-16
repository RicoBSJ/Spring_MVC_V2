package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.model.Borrowings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BorrowingController {

    @ModelAttribute(value = "borrowing")
    public Borrowings setBorrowings() {
        return new Borrowings();
    }

    @GetMapping("/borrowing")
    public ModelAndView showForm() {

        return new ModelAndView("/home", "borrowing", new Borrowings());
    }
}