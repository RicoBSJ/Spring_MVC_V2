package com.aubrun.eric.projet7.springmvc.business.service;

import com.aubrun.eric.projet7.springmvc.consumer.UserAccountConsumer;
import com.aubrun.eric.projet7.springmvc.model.UserAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserAccountService {

    private final UserAccountConsumer userAccountConsumer;

    public UserAccountService(UserAccountConsumer userAccountConsumer) {
        this.userAccountConsumer = userAccountConsumer;
    }

    public ResponseEntity<UserAccount> addUser(UserAccount userAccount) {

        return userAccountConsumer.addUserAccount(userAccount);
    }
}
