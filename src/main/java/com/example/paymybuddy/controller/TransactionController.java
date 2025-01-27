package com.example.paymybuddy.controller;

import com.example.paymybuddy.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transfer")
    public void makePayment(@RequestParam Long senderId,
                            @RequestParam Long receiverId,
                            @RequestParam double amount) {
        transactionService.makePayment(senderId, receiverId, amount);
    }
}
