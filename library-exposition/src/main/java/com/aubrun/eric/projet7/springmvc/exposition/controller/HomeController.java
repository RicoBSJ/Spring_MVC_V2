package com.aubrun.eric.projet7.springmvc.exposition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = {"","/","/home","/homePage"}, method = RequestMethod.GET)
    public String home() {

        return "/home";
    }
}
