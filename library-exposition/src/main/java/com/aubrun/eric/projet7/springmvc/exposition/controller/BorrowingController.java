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

    /*@GetMapping(value = "borrowing")
    public String printAllBorrowings(ModelMap modelMap) {

        Borrowings borrowings = borrowingService.getAllBorrowing().getBody();
        modelMap.addAttribute("borrowing", borrowings);
        return "./home";
    }*/

    @GetMapping("/borrowing")
    public ModelAndView showForm() {

        return new ModelAndView("/home", "borrowing", new Borrowings());
    }

    /*@RequestMapping(value = "/borrowing", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("home", "borrowing", new Borrowings());
    }*/

    /*@RequestMapping(value = "/home/borrowing", method = RequestMethod.POST)
    public String borrowing(@Valid @ModelAttribute("borrowing")Borrowing borrowing, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("bookBorrowing : " + borrowing.getBookBorrowing());
        model.addAttribute("userAccountBorrowing : " + borrowing.getUserAccountBorrowing());
        model.addAttribute("beginDate : " + borrowing.getBeginDate());
        model.addAttribute("endDate : " + borrowing.getEndDate());
        model.addAttribute("renewal : " + borrowing.getRenewal());
        model.addAttribute("borrowingId : " + borrowing.getBorrowingId());
        borrowingMap.put(borrowing.getBorrowingId(), borrowing);
        return "redirect:home";
    }*/

    @PostMapping("/home/borrowing")
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
    }
}
