package com.aubrun.eric.projet7.springmvc.exposition.controller;

import com.aubrun.eric.projet7.springmvc.business.service.BookService;
import com.aubrun.eric.projet7.springmvc.model.SearchBook;
import com.aubrun.eric.projet7.springmvc.model.SearchBooks;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SearchController {

    private final BookService bookService;

    public SearchController(BookService bookService) {
        this.bookService = bookService;
    }

    /*@PostMapping(value = "/book/search")
    public SearchBooks searchBooks(@Valid @RequestBody SearchBook searchBook) {

        SearchBooks searchBooks = bookService.bookResponseEntity().getBody();
        searchBook.setSearchBookTitle(searchBook.getSearchBookTitle());
        searchBook.setSearchBookAuthorLastName(searchBook.getSearchBookAuthorLastName());
        searchBook.setSearchBookPublishingHouse(searchBook.getSearchBookPublishingHouse());
        searchBook.setSearchBookReleaseDate(searchBook.getSearchBookReleaseDate());
        searchBooks.add(searchBook);
        return searchBooks;
    }*/

    @PostMapping(value = "/book/search/")
    private SearchBooks searchBooks(@RequestBody SearchBook searchBook) {

        SearchBooks searchBooks = bookService.bookResponseEntity().getBody();
        searchBook.getSearchBookTitle();
        searchBook.getSearchBookAuthorLastName();
        searchBook.getSearchBookPublishingHouse();
        searchBook.getSearchBookReleaseDate();
        assert searchBooks != null;
        searchBooks.add(searchBook);
        return searchBooks;
    }
}
