package com.aubrun.eric.projet7.springmvc.consumer;

import com.aubrun.eric.projet7.springmvc.model.JwtResponse;
import com.aubrun.eric.projet7.springmvc.model.UserAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
        return restTemplate.postForEntity("http://localhost:8081/biblio-api/api/auth/signin", userAccount, JwtResponse.class);
    }
}