package com.aubrun.eric.projet7.springmvc.consumer;

import com.aubrun.eric.projet7.springmvc.model.Books;
import com.aubrun.eric.projet7.springmvc.model.SearchBook;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BookConsumer {

    private final RestTemplate restTemplate;

    public BookConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Books> findAllBooks(){
        return restTemplate.getForEntity("http://localhost:8081/biblio-api/books/", Books.class);
    }

    public ResponseEntity<Books> searchBook(SearchBook searchBook){
        return restTemplate.postForEntity("http://localhost:8081/biblio-api/books/search/", searchBook, Books.class);
    }
}
