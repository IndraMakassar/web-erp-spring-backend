package com.example.weberpspringbackend.controller;

import com.example.weberpspringbackend.model.entity.Finance;
import com.example.weberpspringbackend.model.repository.FinanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/finances")
@RequiredArgsConstructor
public class FinanceController {
    private final FinanceRepository financeRepository;

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