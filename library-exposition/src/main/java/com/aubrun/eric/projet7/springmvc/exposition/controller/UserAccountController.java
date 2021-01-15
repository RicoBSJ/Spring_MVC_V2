package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.UserAccountService;
import com.aubrun.eric.projet7.springmvc.model.CredentialStorage;
import com.aubrun.eric.projet7.springmvc.model.JwtResponse;
import com.aubrun.eric.projet7.springmvc.model.UserAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

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
        return "signUpForm";
    }

    @GetMapping("/signInForm")
    public String showSignIn(ModelMap modelMap) {
        modelMap.addAttribute("credentialStorage", new CredentialStorage());
        return "signInForm";
    }

    @GetMapping("/deconnect")
    public String leave(WebRequest request) {
        request.setAttribute("connected", false, WebRequest.SCOPE_SESSION);
        request.removeAttribute("userAccount", WebRequest.SCOPE_SESSION);
        return "redirect: signInForm";
    }

    @GetMapping(value = "/user/{id}")
    public String userById(@PathVariable(value = "id") int userId, ModelMap modelMap) {

        ResponseEntity<UserAccount> userAccountResponseEntity = userAccountService.addUserById(userId);
        modelMap.addAttribute("userAccountResponseEntity", userAccountResponseEntity);
        return "/home";
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute CredentialStorage credentialStorage, ModelMap modelMap){
        System.out.println(credentialStorage);
        ResponseEntity<JwtResponse> userAccountResponseEntity = userAccountService.login(credentialStorage);
        System.out.println(userAccountResponseEntity);
        return "/home";
    }
}