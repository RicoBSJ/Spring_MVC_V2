package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.model.ERole;
import com.aubrun.eric.projet7.springmvc.model.Role;
import com.aubrun.eric.projet7.springmvc.model.UserAccount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class UserAccountController {

    @ModelAttribute(value = "userAccount")
    public UserAccount setUserAccount() {
        return new UserAccount();
    }

    @GetMapping("/signUpForm")
    public String showSignUp() {
        return "../include/signUpForm";
    }

    @GetMapping("/signInForm")
    public String showSignIn() {
        return "../include/signInForm";
    }

    @ModelAttribute("rolesList")
    public Map<Integer, ERole> getRolesList() {
        Map<Integer, ERole> rolesList = new HashMap<Integer, ERole>();
        rolesList.put(2, ERole.ROLE_MODERATOR);
        rolesList.put(3, ERole.ROLE_ADMIN);
        return rolesList;
    }
}
