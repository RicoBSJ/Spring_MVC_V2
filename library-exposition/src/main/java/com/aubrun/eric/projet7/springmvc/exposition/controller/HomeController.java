package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
import com.aubrun.eric.projet7.springmvc.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@SessionAttributes("home")
public class HomeController {
    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = {"", "/", "/home", "/homePage"})
    public ModelAndView home() {
        SearchBook searchBook = new SearchBook();
        List<Book> result = bookService.searchBook(searchBook).getBody();
        ModelAndView modelAndView = new ModelAndView("/home", "searchBook", new SearchBook());
        modelAndView.addObject("books", result);
        return modelAndView;
    }

    /*@GetMapping("/deconnect")
    public String leave(WebRequest request) {
        request.setAttribute("connected", false, WebRequest.SCOPE_SESSION);
        request.removeAttribute("userAccount", WebRequest.SCOPE_SESSION);
        return "../view/home";
    }*/

    @GetMapping("/deconnect")
    public String endSessionHandlingMethod(HttpServletRequest httpRequest){
        httpRequest.getSession().invalidate();
        return "../view/home";
    }
}