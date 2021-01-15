package com.aubrun.eric.projet7.springmvc.business.service;

import com.aubrun.eric.projet7.springmvc.consumer.BorrowingConsumer;
import com.aubrun.eric.projet7.springmvc.model.Borrowing;
import com.aubrun.eric.projet7.springmvc.model.Borrowings;
import com.aubrun.eric.projet7.springmvc.model.JwtToken;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BorrowingService {

    private final BorrowingConsumer borrowingConsumer;
    private final JwtToken jwtToken;

    public BorrowingService(BorrowingConsumer borrowingConsumer, JwtToken jwtToken) {
        this.borrowingConsumer = borrowingConsumer;
        this.jwtToken = jwtToken;
    }

    public ResponseEntity<Borrowings> getAllBorrowing(){

        return borrowingConsumer.getBorrowing();
    }

    public ResponseEntity<Void> addBorrow(Borrowing borrowing) {

        return borrowingConsumer.addBorrowing(borrowing, jwtToken);
    }
}
