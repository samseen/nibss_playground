package com.example.nibss.controller;

import com.example.nibss.model.Transaction;
import com.example.nibss.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/transactions")
public class TransactionsController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/getTransactions")
    @ResponseBody
    public List<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }

    @PostMapping("/addTransaction")
    public ResponseEntity<Transaction> newTransaction(@RequestBody Transaction transaction) {
//        System.out.println(transfer);
        Transaction transactionResponse = transactionService.newTransaction(transaction);
        return ResponseEntity.ok(transactionResponse);
    }

}
