package com.aubrun.eric.projet7.springmvc.consumer;

import com.aubrun.eric.projet7.springmvc.model.Authors;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthorConsumer {

    private final RestTemplate restTemplate;

    public AuthorConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Authors> findAllAuthors(){
        return restTemplate.getForEntity("http://localhost:8081/biblio-api/authors/", Authors.class);
    }
}
