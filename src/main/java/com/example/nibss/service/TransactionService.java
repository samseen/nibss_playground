package com.example.nibss.service;

import com.example.nibss.model.Transaction;
import com.example.nibss.repository.AccountRepository;
import com.example.nibss.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final AccountRepository accountRepository;


    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> fetchTransactions(String status, boolean commissionWorthiness, String transactionReference) {
        return transactionRepository.findByParams(commissionWorthiness, transactionReference, status);
    }

    public Transaction newTransaction(Transaction transaction) {
        //Get account and use for the transfer
        return transactionRepository.save(transaction);
    }
}
