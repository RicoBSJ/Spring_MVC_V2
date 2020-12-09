package com.aubrun.eric.projet7.springmvc.business.service;

import com.aubrun.eric.projet7.springmvc.consumer.UserAccountConsumer;
import com.aubrun.eric.projet7.springmvc.model.Books;
import com.aubrun.eric.projet7.springmvc.model.UsersAccount;
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

    public ResponseEntity<UsersAccount> findUsers() {

        return userAccountConsumer.findAllUsers();
    }
}
