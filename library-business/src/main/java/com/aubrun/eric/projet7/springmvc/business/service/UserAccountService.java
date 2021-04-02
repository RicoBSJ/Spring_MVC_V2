package com.aubrun.eric.projet7.springmvc.business.service;

import com.aubrun.eric.projet7.springmvc.consumer.UserAccountConsumer;
import com.aubrun.eric.projet7.springmvc.model.JwtResponse;
import com.aubrun.eric.projet7.springmvc.model.JwtToken;
import com.aubrun.eric.projet7.springmvc.model.UserAccount;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserAccountService {

    private final UserAccountConsumer userAccountConsumer;
    private final JwtToken jwtToken;

    public UserAccountService(UserAccountConsumer userAccountConsumer, JwtToken jwtToken) {
        this.userAccountConsumer = userAccountConsumer;
        this.jwtToken = jwtToken;
    }

    public ResponseEntity<UserAccount> addUser(UserAccount userAccount) {

        return userAccountConsumer.addUserAccount(userAccount);
    }

    public ResponseEntity<UserAccount> addUserById(int userId) {

        return userAccountConsumer.userById(userId);
    }

    public ResponseEntity<JwtResponse> login(UserAccount userAccount) {

        ResponseEntity<JwtResponse> response = userAccountConsumer.login(userAccount);
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null ) {
            this.jwtToken.setJwt(response.getBody().getAccessToken());
        }
        return response;
    }

    public void logout() {
        jwtToken.setJwt(null);
    }
}
