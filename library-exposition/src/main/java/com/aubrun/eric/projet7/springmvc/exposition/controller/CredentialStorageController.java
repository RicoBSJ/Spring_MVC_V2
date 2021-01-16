package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.model.CredentialStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CredentialStorageController {

    @ModelAttribute(value = "credentialStorage")
    public CredentialStorage setCredentialStorage() {
        return new CredentialStorage();
    }

    @GetMapping("/signInForm")
    public String showSignIn(ModelMap modelMap) {
        modelMap.addAttribute("credentialStorage", new CredentialStorage());
        return "signInForm";
    }
}
