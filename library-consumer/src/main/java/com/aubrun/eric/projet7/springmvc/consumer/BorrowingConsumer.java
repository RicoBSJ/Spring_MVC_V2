package com.aubrun.eric.projet7.springmvc.consumer;

import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import com.aubrun.eric.projet7.springmvc.model.Borrowings;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BorrowingConsumer {

    private final RestTemplate restTemplate;

    public BorrowingConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Borrowings> addBorrowing(Borrowing borrowing){
        return restTemplate.postForEntity("http://localhost:8081/biblio-api/borrowings/", borrowing, Borrowings.class);
    }

    public ResponseEntity<Borrowings> getBorrowing(){
        return restTemplate.getForEntity("http://localhost:8081/biblio-api/borrowings/", Borrowings.class);
    }
}
