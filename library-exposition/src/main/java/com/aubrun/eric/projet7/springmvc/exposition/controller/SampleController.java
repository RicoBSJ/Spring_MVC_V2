package com.aubrun.eric.projet7.springmvc.exposition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {

    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public String printHelloWorld(ModelMap modelMap) {

        // add attribute to load modelMap
        modelMap.addAttribute("message",
                "Hello World and Welcome to Spring MVC!");

        // return the name of the file to be loaded "hello_world.jsp"
        return "sample";
    }
}