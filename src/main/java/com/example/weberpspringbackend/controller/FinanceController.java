package com.example.weberpspringbackend.controller;

import com.example.weberpspringbackend.model.entity.Finance;
import com.example.weberpspringbackend.model.repository.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/finances")
public class FinanceController {
    @Autowired
    private FinanceRepository financeRepository;

    @GetMapping
    public ResponseEntity<Iterable<Finance>> getAllFinance() {
        Iterable<Finance> finances = financeRepository.findAll();
        if (!finances.iterator().hasNext()) {
            return new ResponseEntity<>(finances, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(finances, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Finance> addFinance(@RequestBody Finance finance) {
        financeRepository.save(finance);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}