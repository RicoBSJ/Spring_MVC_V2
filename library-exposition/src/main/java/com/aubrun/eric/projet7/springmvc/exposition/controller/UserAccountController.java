package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
import com.aubrun.eric.projet7.springmvc.business.service.UserAccountService;
import com.aubrun.eric.projet7.springmvc.model.Book;
import com.aubrun.eric.projet7.springmvc.model.SearchBook;
import com.aubrun.eric.projet7.springmvc.model.UserAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("userAccount")
public class UserAccountController {

    private final UserAccountService userAccountService;
    private final BookService bookService;

    public UserAccountController(UserAccountService userAccountService, BookService bookService) {
        this.userAccountService = userAccountService;
        this.bookService = bookService;
    }

    @ModelAttribute(value = "userAccount")
    public UserAccount setUserAccount() {
        return new UserAccount();
    }

    @GetMapping("/signUpForm")
    public String showSignUp() {
        return "../view/signUpForm";
    }

    @GetMapping("/signInForm")
    public String showSignIn( ModelMap modelMap) {
        modelMap.addAttribute("userAccount", new UserAccount());
        return "../view/signInForm";
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
        modelAndView.addObject("username", userAccount.getUsername());
        return modelAndView;
    }

    @PostMapping(value = "/home/login")
    public ModelAndView login(@ModelAttribute("userAccount") UserAccount userAccount){
        userAccountService.login(userAccount);
        ModelAndView modelAndView = new ModelAndView("../view/signInSuccess");
        modelAndView.addObject("message", "Connexion réussie : ");
        modelAndView.addObject("userName", userAccount.getUsername());
        return modelAndView;
    }

    /*@GetMapping("/deconnect")
    public String endSessionHandlingMethod(UserAccount userAccount){
        ResponseEntity<UserAccount> currentUser = userAccountService.addUserById(userAccount.getUserId());
        currentUser = null;
        return "home";
    }*/

    @GetMapping("/deconnect")
    public ModelAndView leave(@ModelAttribute("searchBook") SearchBook searchBook, WebRequest request) {

        request.setAttribute("userAccount", false, WebRequest.SCOPE_SESSION);
        request.removeAttribute("connected", WebRequest.SCOPE_REQUEST);
        List<Book> result = bookService.searchBook(searchBook).getBody();
        ModelAndView modelAndView = new ModelAndView("home", "searchBook", new SearchBook());
        modelAndView.addObject("books", result);
        return modelAndView;
    }
}