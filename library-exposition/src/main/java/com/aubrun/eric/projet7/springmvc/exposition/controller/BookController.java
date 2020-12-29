package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
import com.aubrun.eric.projet7.springmvc.model.Book;
import com.aubrun.eric.projet7.springmvc.model.Books;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BookController {

    private final Map<Integer, Book> bookMap = new HashMap<>();

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = {"/book","/getAllBook"})
    public String printAllBooks(ModelMap modelMap) {

        Books books = bookService.findBooks().getBody();
        modelMap.addAttribute("books" , books);
        return "/book";
    }

    @PostMapping(value = "/book")
    private String searchBookSubmit(@ModelAttribute("book") Book book, BindingResult result, ModelMap model) {

        if(result.hasErrors()){
            return "error";
        }

        model.addAttribute("title", book.getTitle());
        model.addAttribute("bookAuthor", book.getBookAuthor());
        model.addAttribute("quantity", book.getQuantity());
        model.addAttribute("bookId", book.getBookId());

        bookMap.put(book.getBookId(), book);

        return "book";
    }
}
