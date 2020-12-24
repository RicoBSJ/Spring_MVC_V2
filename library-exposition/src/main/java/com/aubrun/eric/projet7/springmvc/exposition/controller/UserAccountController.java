package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.model.UserAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAccountController {

    @GetMapping(value = "/user_account")
    public String printAllUsers(ModelMap modelMap) {

        modelMap.addAttribute("user_account" , new UserAccount());
        return "home";
    }
}
