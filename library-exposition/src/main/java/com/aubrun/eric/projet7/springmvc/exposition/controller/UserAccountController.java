package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.UserAccountService;
import com.aubrun.eric.projet7.springmvc.model.UserAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
}