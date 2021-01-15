package com.aubrun.eric.projet7.springmvc.business.service;

import com.aubrun.eric.projet7.springmvc.consumer.UserAccountConsumer;
import com.aubrun.eric.projet7.springmvc.model.CredentialStorage;
import com.aubrun.eric.projet7.springmvc.model.JwtResponse;
import com.aubrun.eric.projet7.springmvc.model.JwtToken;
import com.aubrun.eric.projet7.springmvc.model.UserAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

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

    public ResponseEntity<UserAccount> connectUser(UserAccount userAccount) {

        return userAccountConsumer.addConnectedUser(userAccount);
    }

    public ResponseEntity<UserAccount> addUserById(int userId) {

        return userAccountConsumer.userById(userId);
    }

    public void login(CredentialStorage credentialStorage) {

        JwtResponse response = userAccountConsumer.login(credentialStorage).getBody();
        this.jwtToken.setJwt(response.getAccessToken());
    }
}
