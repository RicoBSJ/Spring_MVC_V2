package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
import com.aubrun.eric.projet7.springmvc.business.service.BorrowingService;
import com.aubrun.eric.projet7.springmvc.business.service.UserAccountService;
import com.aubrun.eric.projet7.springmvc.model.Book;
import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import com.aubrun.eric.projet7.springmvc.model.SearchBook;
import com.aubrun.eric.projet7.springmvc.model.UserAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final BookService bookService;
    private final BorrowingService borrowingService;
    private final UserAccountService userAccountService;

    public HomeController(BookService bookService, BorrowingService borrowingService, UserAccountService userAccountService) {
        this.bookService = bookService;
        this.borrowingService = borrowingService;
        this.userAccountService = userAccountService;
    }

    @GetMapping(value = {"","/","/home","/homePage"})
    public ModelAndView home() {
        SearchBook searchBook = new SearchBook();
        List<Book> result = bookService.searchBook(searchBook).getBody();
        ModelAndView modelAndView = new ModelAndView("/home", "searchBook", new SearchBook());
        modelAndView.addObject("books", result);
        return modelAndView;
    }

    @PostMapping(value = "/home/search")
    private ModelAndView searchBookSubmit(@ModelAttribute("searchBook") SearchBook searchBook) {

        List<Book> result = bookService.searchBook(searchBook).getBody();
        ModelAndView modelAndView = new ModelAndView("/home", "searchBook", new SearchBook());
        modelAndView.addObject("books", result);
        return modelAndView;
    }

    @PostMapping(value="/borrowing")
    public String borrowing(@ModelAttribute("newBorrowing") Borrowing newBorrowing, Model model){

        Borrowing borrowing = borrowingService.addBorrow(newBorrowing).getBody();
        model.addAttribute("borrowing",borrowing);
        return "home";
    }

    @PostMapping(value="/signupForm")
    public String createUser(@ModelAttribute("newUser") UserAccount newUser, Model model){

        UserAccount userAccount = userAccountService.addUser(newUser).getBody();
        model.addAttribute("userAccount",userAccount);
        return "home";
    }

    @PostMapping(value="/signinForm")
    public String connectUser(@ModelAttribute("currentUser") UserAccount currentUser, Model model){

        UserAccount userAccount = userAccountService.connectUser(currentUser).getBody();
        model.addAttribute("userAccount",userAccount);
        return "home";
    }
}
