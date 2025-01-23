package com.example.paymybuddy.controller;

import com.example.paymybuddy.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestParam Long senderId,
                                                @RequestParam Long receiverId,
                                                @RequestParam Double amount) {
        transactionService.transferMoney(senderId, receiverId, amount);
        return ResponseEntity.ok("Transfer successful");
    }
}
