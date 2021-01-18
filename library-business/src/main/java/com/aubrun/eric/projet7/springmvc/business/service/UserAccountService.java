package com.aubrun.eric.projet7.springmvc.business.service;

import com.aubrun.eric.projet7.springmvc.consumer.UserAccountConsumer;
import com.aubrun.eric.projet7.springmvc.model.JwtResponse;
import com.aubrun.eric.projet7.springmvc.model.JwtToken;
import com.aubrun.eric.projet7.springmvc.model.UserAccount;
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

    public void login(UserAccount userAccount) {

        JwtResponse response = userAccountConsumer.login(userAccount).getBody();
        if (response != null) {
            this.jwtToken.setJwt(response.getAccessToken());
        }
    }
}
