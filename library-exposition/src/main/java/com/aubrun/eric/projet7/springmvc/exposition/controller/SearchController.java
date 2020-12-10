package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
import com.aubrun.eric.projet7.springmvc.model.SearchBook;
import com.aubrun.eric.projet7.springmvc.model.SearchBooks;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping ("/book")
public class SearchController {

    private final BookService bookService;

    public SearchController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/search")
    public SearchBooks searchBook(@Valid @RequestBody SearchBook searchBook) {

        SearchBooks searchBooks = bookService.bookResponseEntity().getBody();
        /*searchBooks.add(searchBook.getSearchBookTitle().getClass());*/
        return null;
    }
}
