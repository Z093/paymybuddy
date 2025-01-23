package com.example.paymybuddy.service;

import com.example.paymybuddy.model.Account;
import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.repository.AccountRepository;
import com.example.paymybuddy.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public void transferMoney(Long senderId, Long receiverId, Double amount) {
        Account sender = accountRepository.findById(senderId)
                .orElseThrow(() -> new IllegalArgumentException("Sender account not found"));

        Account receiver = accountRepository.findById(receiverId)
                .orElseThrow(() -> new IllegalArgumentException("Receiver account not found"));

        if (sender.getBalance() < amount) {
            throw new IllegalStateException("Insufficient funds");
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        accountRepository.save(sender);
        accountRepository.save(receiver);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setTransactionDate(LocalDateTime.now());
        transactionRepository.save(transaction);
    }
}

