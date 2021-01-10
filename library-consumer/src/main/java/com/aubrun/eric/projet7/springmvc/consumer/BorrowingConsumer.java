package com.aubrun.eric.projet7.springmvc.consumer;

import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import com.aubrun.eric.projet7.springmvc.model.Borrowings;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Component
public class BorrowingConsumer {

    private final RestTemplate restTemplate;

    public BorrowingConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /*public ResponseEntity<Borrowings> addBorrowing(Borrowing borrowing){
        return restTemplate.postForEntity("http://localhost:8081/biblio-api/borrowings/", borrowing, Borrowings.class);
    }*/

    public ResponseEntity<Borrowings> addBorrowing(Borrowing borrowing){
        String accessToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtb2QiLCJpYXQiOjE2MTAyMzIyMjIsImV4cCI6MTYxMDMxODYyMn0.lfrryLWk9Z5fTmT19XAEDClrO2c-KvFQ8zQJkmOShK-9wOZjV6-3O_wo0qaL5UkDkMcoBDPebPL_hWQSjXY7fw";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer" + accessToken);
        HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpRequest(
                .queryParam("branch", branch)
                .queryParam("customerInternalCode", internalCode)
                .queryParam("hierarchy", hierarchy);

                return Optional.ofNullable(restTemplate.exchange(builder))
        HttpMethod.GET, entity,
        CustomerRegistrationDTO.class).getBody());
    }

    public ResponseEntity<Borrowings> getBorrowing(){
        return restTemplate.getForEntity("http://localhost:8081/biblio-api/borrowings/", Borrowings.class);
    }
}
