package com.aubrun.eric.projet7.springmvc.consumer;

import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BorrowingConsumer {

    private final RestTemplate restTemplate;

    public BorrowingConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Borrowing> addBorrowing(Borrowing borrowing){
        return restTemplate.postForEntity("http://localhost:8081/biblio-api/borrowings/", borrowing, Borrowing.class);
    }

    public ResponseEntity<Borrowing> getBorrowing(){
        return restTemplate.getForEntity("http://localhost:8081/biblio-api/borrowings/", Borrowing.class);
    }
}
