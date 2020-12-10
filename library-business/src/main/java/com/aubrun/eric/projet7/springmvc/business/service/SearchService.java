package com.aubrun.eric.projet7.springmvc.business.service;

import com.aubrun.eric.projet7.springmvc.consumer.SearchConsumer;
import com.aubrun.eric.projet7.springmvc.model.SearchBooks;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SearchService {

    private final SearchConsumer searchConsumer;

    public SearchService(SearchConsumer searchConsumer) {
        this.searchConsumer = searchConsumer;
    }

    public ResponseEntity<SearchBooks> bookResponseEntity(){

        return searchConsumer.searchBook();
    }
}
