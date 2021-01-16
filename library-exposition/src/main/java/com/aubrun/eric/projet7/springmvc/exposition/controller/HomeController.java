package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
import com.aubrun.eric.projet7.springmvc.business.service.BorrowingService;
import com.aubrun.eric.projet7.springmvc.business.service.UserAccountService;
import com.aubrun.eric.projet7.springmvc.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@SessionAttributes("userAccount")
public class HomeController {
    private final BookService bookService;
    private final BorrowingService borrowingService;
    private final UserAccountService userAccountService;

    public HomeController(BookService bookService, BorrowingService borrowingService, UserAccountService userAccountService) {
        this.bookService = bookService;
        this.borrowingService = borrowingService;
        this.userAccountService = userAccountService;
    }

    @GetMapping(value = {"", "/", "/home", "/homePage"})
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

    @PostMapping("/home/borrowing")
    public String borrowing(@ModelAttribute("newBorrowing") Borrowing borrowing, Model model) {
        borrowingService.addBorrow(borrowing);
        System.out.println("bookBorrowing : " + borrowing.getBookBorrowing());
        System.out.println("userAccountBorrowing : " + borrowing.getUserAccountBorrowing());
        System.out.println("beginDate : " + borrowing.getBeginDate());
        System.out.println("endDate : " + borrowing.getEndDate());
        System.out.println("renewal : " + borrowing.getRenewal());
        System.out.println("borrowingId : " + borrowing.getBorrowingId());
        model.addAttribute("message", "Emprunt réussi : ");
        return "home";
    }

    @PostMapping("/home/registration")
    public ModelAndView registrationUser(@ModelAttribute("userAccount") UserAccount userAccount) {

        UserAccount newUser = userAccountService.addUser(userAccount).getBody();

        System.out.println("Username : " + userAccount.getUsername());
        System.out.println("Password : " + userAccount.getPassword());
        System.out.println("Email : " + userAccount.getEmail());
        System.out.println("Role : " + userAccount.getRoleDtos());
        System.out.println("Id : " + userAccount.getUserId());

        ModelAndView modelAndView = new ModelAndView("../view/signUpSuccess");
        modelAndView.addObject("message", "Inscription réussie : ");
        modelAndView.addObject("userName", userAccount.getUsername());
        return modelAndView;
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute("credentialStorage") CredentialStorage credentialStorage){
        System.out.println(credentialStorage);
        userAccountService.login(credentialStorage);
        ModelAndView modelAndView = new ModelAndView("../view/signInSuccess");
        modelAndView.addObject("message", "Inscription réussie : ");
        return "/home";
    }
}