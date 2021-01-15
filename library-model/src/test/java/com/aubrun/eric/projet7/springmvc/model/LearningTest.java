package com.aubrun.eric.projet7.springmvc.model;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LearningTest {

    @Test
    public void encrypt_password() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String encodedPassword = passwordEncoder.encode("postgres");

        System.out.println(encodedPassword);
    }
}
