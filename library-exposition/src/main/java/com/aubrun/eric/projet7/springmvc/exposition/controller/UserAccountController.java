package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.UserAccountService;
import com.aubrun.eric.projet7.springmvc.model.JwtResponse;
import com.aubrun.eric.projet7.springmvc.model.UserAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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

    @GetMapping("/signInForm")
    public String showSignIn() {
        return "../view/signInForm";
    }

    @GetMapping("/signUpForm")
    public String showSignUp(ModelMap modelMap) {
        modelMap.addAttribute("userAccount", new UserAccount());
        return "../view/signUpForm";
    }

    @PostMapping("/registration")
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

    @PostMapping(value = "/login")
    public ModelAndView login(@ModelAttribute("userAccount") UserAccount userAccount, HttpSession session) {
        ResponseEntity<JwtResponse> result = userAccountService.login(userAccount);
        session.setAttribute("username", userAccount.getUsername());
        ModelAndView modelAndView = new ModelAndView("../view/signInSuccess");
        if(result.getStatusCode().equals(HttpStatus.OK)){
            modelAndView.addObject("message", "Connexion réussie : ");
        } else {
            modelAndView.addObject("message", result.getBody());
        }
        modelAndView.addObject("userName", userAccount.getUsername());
        return modelAndView;
    }

    @PostMapping("/deconnect")
    public String leave(HttpSession session) {
        session.removeAttribute("username");
        session.invalidate();
        userAccountService.logout();
        return "redirect:/home";
    }
}