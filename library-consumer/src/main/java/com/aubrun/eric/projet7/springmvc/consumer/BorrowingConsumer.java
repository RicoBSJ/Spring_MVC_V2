package com.aubrun.eric.projet7.springmvc.consumer;

import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import com.aubrun.eric.projet7.springmvc.model.Borrowings;
import com.aubrun.eric.projet7.springmvc.model.JwtToken;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BorrowingConsumer {

    private final RestTemplate restTemplate;

    public BorrowingConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Void> addBorrowing(Borrowing borrowing, JwtToken jwtToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", jwtToken.getJwt());
        HttpEntity entity = new HttpEntity(borrowing, headers);
        return restTemplate.exchange("http://localhost:8081/biblio-api/borrowings/", HttpMethod.POST, entity, Void.class);
    }

    public ResponseEntity<Borrowings> getBorrowing() {
        return restTemplate.getForEntity("http://localhost:8081/biblio-api/borrowings/", Borrowings.class);
    }
}
