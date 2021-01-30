package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.UserAccountService;
import com.aubrun.eric.projet7.springmvc.model.UserAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("userAccount")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @ModelAttribute(value = "userAccount")
    public UserAccount setUserAccount() {
        return new UserAccount();
    }

    @GetMapping("/signUpForm")
    public String showSignUp() {
        return "../view/signUpForm";
    }

    @GetMapping(value = "/user/{id}")
    public String userById(@PathVariable(value = "id") int userId, ModelMap modelMap) {

        ResponseEntity<UserAccount> userAccountResponseEntity = userAccountService.addUserById(userId);
        modelMap.addAttribute("userAccountResponseEntity", userAccountResponseEntity);
        return "/home";
    }

    @GetMapping("/signInForm")
    public String showSignIn( ModelMap modelMap) {
        modelMap.addAttribute("userAccount", new UserAccount());
        return "../view/signInForm";
    }

    @GetMapping("/deconnect")
    public String leave(WebRequest request) {
        request.setAttribute("connected", false, WebRequest.SCOPE_SESSION);
        request.removeAttribute("userAccount", WebRequest.SCOPE_SESSION);
        return "../view/home";
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
}