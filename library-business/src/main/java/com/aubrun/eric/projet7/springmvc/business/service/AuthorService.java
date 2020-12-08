package com.aubrun.eric.projet7.springmvc.business.service;

import com.aubrun.eric.projet7.springmvc.consumer.AuthorConsumer;
import com.aubrun.eric.projet7.springmvc.model.Authors;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorService {

    private final AuthorConsumer authorConsumer;

    public AuthorService(AuthorConsumer authorConsumer) {
        this.authorConsumer = authorConsumer;
    }

    public ResponseEntity<Authors> findAuthors(){

        return authorConsumer.findAllAuthors();
    }
}
