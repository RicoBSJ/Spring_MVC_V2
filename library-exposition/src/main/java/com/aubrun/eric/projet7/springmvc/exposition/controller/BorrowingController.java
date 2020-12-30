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

    /*@ModelAttribute(value = "borrowing")
    public Borrowing setBorrowing() {
        return new Borrowing();
    }*/

    @RequestMapping(value = "/borrowing", method = RequestMethod.GET)
    public String printAllBorrowings(ModelMap modelMap) {

        Borrowings borrowings = borrowingService.getAllBorrowing().getBody();
        modelMap.addAttribute("borrowings" , borrowings);
        return "/borrowing";
    }

    /*@GetMapping("/borrowing")
    public ModelAndView showForm() {
        return new ModelAndView("home", "borrowing", new Borrowing());
    }*/

    /*@GetMapping("/home")
    public String printAllBorrowing(ModelMap modelMap) {

        Borrowing borrowing = borrowingService.getAllBorrowing().getBody();
        modelMap.addAttribute("borrowing" , borrowing);
        return "home";
    }*/

    @PostMapping(value = "/borrowing")
    private String searchBorrowing(@ModelAttribute("borrowing") Borrowing borrowing, ModelMap model) {

        model.addAttribute("bookBorrowing : ", borrowing.getBookBorrowing());
        model.addAttribute("userAccountBorrowing : ", borrowing.getUserAccountBorrowing());
        model.addAttribute("beginDate : ", borrowing.getBeginDate());
        model.addAttribute("endDate : ", borrowing.getEndDate());
        model.addAttribute("renewal : ", borrowing.getRenewal());
        model.addAttribute("borrowingId : ", borrowing.getBorrowingId());

        borrowingMap.put(borrowing.getBorrowingId(), borrowing);

        return "/borrowing";
    }
}
