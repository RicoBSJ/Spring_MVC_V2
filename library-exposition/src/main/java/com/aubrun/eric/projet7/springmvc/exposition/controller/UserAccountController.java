package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.model.UserAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserAccountController {

    private final Map<Long, UserAccount> userAccountMap = new HashMap<>();

    @GetMapping("/userAccount")
    public ModelAndView showForm() {

        return new ModelAndView("../include/signupForm", "userAccount", new UserAccount());
    }


    @PostMapping("/userAccount")
    private String userSubmit(@ModelAttribute("userAccount") UserAccount userAccount, BindingResult result, ModelMap model) {

        if(result.hasErrors()){
            return "error";
        }

        model.addAttribute("username", userAccount.getUsername());
        model.addAttribute("password", userAccount.getPassword());
        model.addAttribute("userId", userAccount.getUserId());

        userAccountMap.put(userAccount.getUserId(), userAccount);

        return "../include/signinForm";
    }
}
