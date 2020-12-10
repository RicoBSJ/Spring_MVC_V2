package com.aubrun.eric.projet7.springmvc.consumer;

import com.aubrun.eric.projet7.springmvc.model.SearchBooks;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SearchConsumer {

    private final RestTemplate restTemplate;

    public SearchConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<SearchBooks> searchBook(){
        return restTemplate.getForEntity("http://localhost:8081/biblio-api/books/search/", SearchBooks.class);
    }
}
