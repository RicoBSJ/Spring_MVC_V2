package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BorrowingService;
import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BorrowingController {

    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @RequestMapping(value="/borrow", method = RequestMethod.POST)
    public String borrowing(Borrowing newBorrowing, Model m){
        Borrowing borrowing = borrowingService.addBorrow(newBorrowing).getBody();
        m.addAttribute("borrowing",borrowing);
        return "home";
    }
}
