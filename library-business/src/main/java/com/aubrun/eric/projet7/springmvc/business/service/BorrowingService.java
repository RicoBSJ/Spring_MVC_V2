package com.aubrun.eric.projet7.springmvc.business.service;

import com.aubrun.eric.projet7.springmvc.consumer.BorrowingConsumer;
import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BorrowingService {

    private final BorrowingConsumer borrowingConsumer;

    public BorrowingService(BorrowingConsumer borrowingConsumer) {
        this.borrowingConsumer = borrowingConsumer;
    }

    public ResponseEntity<Borrowing> addBorrow() {

        return borrowingConsumer.addBorrowing();
    }
}
