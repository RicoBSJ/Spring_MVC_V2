package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.model.ERole;
import com.aubrun.eric.projet7.springmvc.model.Role;
import com.aubrun.eric.projet7.springmvc.model.UserAccount;
import com.sun.javadoc.SeeTag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIBOidTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
@SessionAttributes("userAccount")
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

    /*@ModelAttribute("rolesList")
    public Map<Integer, String> getRolesList() {
        String str1 = String.valueOf(ERole.ROLE_MODERATOR);
        String str2 = String.valueOf(ERole.ROLE_ADMIN);
        Map<Integer, String> rolesList = new HashMap<Integer, String>();
        rolesList.put(2, new Role().setRoleName(ERole.ROLE_MODERATOR));
        rolesList.put(3, new Role().setRoleName(ERole.ROLE_ADMIN));
        return rolesList;
    }*/

    @GetMapping("/deconnect")
    public String leave(WebRequest request) {
        request.setAttribute("connected", false, WebRequest.SCOPE_SESSION);
        request.removeAttribute("userAccount", WebRequest.SCOPE_SESSION);
        return "redirect: signInForm";
    }
}
