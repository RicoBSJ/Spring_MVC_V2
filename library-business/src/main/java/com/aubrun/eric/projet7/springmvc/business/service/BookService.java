package com.aubrun.eric.projet7.springmvc.business.service;

import com.aubrun.eric.projet7.springmvc.consumer.BookConsumer;
import com.aubrun.eric.projet7.springmvc.model.Books;
import com.aubrun.eric.projet7.springmvc.model.SearchBook;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {

    private final BookConsumer bookConsumer;

    public BookService(BookConsumer bookConsumer) {
        this.bookConsumer = bookConsumer;
    }

    public ResponseEntity<Books> findBooks() {

        return bookConsumer.findAllBooks();
    }

    public ResponseEntity<Books> searchBook(SearchBook searchBook){

        return bookConsumer.searchBook(searchBook);
    }

    public ResponseEntity<Books> getBook(int bookId) {

        return bookConsumer.getBooksById(bookId);
    }
}