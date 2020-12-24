package com.aubrun.eric.projet7.springmvc.consumer;

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
        return restTemplate.postForEntity("http://localhost:8081/biblio-api/users/", userAccount, UserAccount.class);
    }
}
