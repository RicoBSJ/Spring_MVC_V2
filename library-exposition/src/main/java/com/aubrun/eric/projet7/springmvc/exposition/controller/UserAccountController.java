package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.UserAccountService;
import com.aubrun.eric.projet7.springmvc.model.UsersAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @RequestMapping(value = {"/user","/getAllUser"}, method = RequestMethod.GET)
    public String printAllUsers(ModelMap modelMap) {

        UsersAccount usersAccount = userAccountService.findUsers().getBody();
        modelMap.addAttribute("usersAccount" , usersAccount);
        return "/user";
    }
}
