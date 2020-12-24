package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BorrowingController {

    @GetMapping(value = "/borrow")
    public String printAllBooks(ModelMap modelMap) {

        modelMap.addAttribute("borrowing" , new Borrowing());
        return "home";
    }
}
