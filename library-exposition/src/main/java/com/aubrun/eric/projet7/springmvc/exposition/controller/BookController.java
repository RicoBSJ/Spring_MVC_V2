package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.consumer.BookConsumer;
import com.aubrun.eric.projet7.springmvc.model.Books;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private final BookConsumer bookConsumer;

    public BookController(BookConsumer bookConsumer) {
        this.bookConsumer = bookConsumer;
    }

    @GetMapping("/book")
    public String showForm() {
        Books books = bookConsumer.findAllBooks().getBody();
        return "book";
    }
}
