package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BorrowingController {

    @ModelAttribute(value = "borrowing")
    public Borrowing setBorrowing() {
        return new Borrowing();
    }
}
