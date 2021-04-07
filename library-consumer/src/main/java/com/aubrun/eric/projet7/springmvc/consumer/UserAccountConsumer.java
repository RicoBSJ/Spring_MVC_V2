package com.aubrun.eric.projet7.springmvc.consumer;

import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import com.aubrun.eric.projet7.springmvc.model.JwtResponse;
import com.aubrun.eric.projet7.springmvc.model.JwtToken;
import com.aubrun.eric.projet7.springmvc.model.UserAccount;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

@Component
public class UserAccountConsumer {
    private final RestTemplate restTemplate;

    public UserAccountConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<UserAccount> addUserAccount(UserAccount userAccount){
        return restTemplate.postForEntity("http://localhost:8081/biblio-api/api/auth/signup", userAccount, UserAccount.class);
    }

    public ResponseEntity<UserAccount> userById(int userId) {
        return restTemplate.getForEntity("http://localhost:8081/biblio-api/users/{userId}", UserAccount.class);
    }

    public ResponseEntity<JwtResponse> login(UserAccount userAccount) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<UserAccount> entity = new HttpEntity<>(userAccount, requestHeaders);
        try{
            restTemplate.exchange("http://localhost:8081/biblio-api/api/auth/signin", HttpMethod.POST, entity, Object.class);
            System.out.println(restTemplate.toString());
        } catch(HttpClientErrorException e) {
            System.out.println("---------------");
            System.out.println(e.getStatusCode());
            System.out.println("---------------");
            System.out.println(e.toString());
            System.out.println("---------------");
        }
        return restTemplate.exchange("http://localhost:8081/biblio-api/api/auth/signin", HttpMethod.POST, entity, JwtResponse.class);
    }
}