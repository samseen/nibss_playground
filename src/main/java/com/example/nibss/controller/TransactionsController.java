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

    @PostMapping("/fetchTransactions")
    public List<Transaction> fetchTransactions(@RequestParam(required = false) boolean commissionWorthiness,
                                               @RequestParam(required = false) String transactionReference,
                                               @RequestParam(required = false) String status) {
        System.out.println("commissionWorthiness: "
                + commissionWorthiness + " transactionReference: " + transactionReference
                + " status: " + status);
        return transactionService.fetchTransactions(status, commissionWorthiness, transactionReference);
    }

    @PostMapping("fetchTransactionsByDate")
    public List<Transaction> fetchTransactionsByDate(@RequestParam(required = false) String startDate) {
        System.out.println("startDate: " + startDate);
        return transactionService.fetchTransactionsByDate(startDate);
    }

    @PostMapping("/findByDetails")
    public List<Transaction> findByDetails(@RequestParam(required = false) boolean commissionWorthiness,
                                           @RequestParam(required = false) String transactionReference,
                                           @RequestParam(required = false) String status,
                                           @RequestParam(required = false) String startDate,
                                           @RequestParam(required = false) String endDate) {
        System.out.println("commissionWorthiness: "
                + commissionWorthiness + " transactionReference: " + transactionReference
                + " status: " + status
                + " startDate: " + startDate
                + " endDate: " + endDate);
        return transactionService.findByDetails(commissionWorthiness, transactionReference, status, startDate, endDate);
    }

//    @PutMapping(path = "{studentId}")
//    public void updateStudent(@PathVariable("studentId") Long studentId,
//                              @RequestParam(required = false) String name,
//                              @RequestParam(required = false) String email) {
//        studentService.updateStudent(studentId, name, email);
//    }

    @PostMapping("/addTransaction")
    public ResponseEntity<Transaction> newTransaction(@RequestBody Transaction transaction) {
//        System.out.println(transfer);
        Transaction transactionResponse = transactionService.newTransaction(transaction);
        return ResponseEntity.ok(transactionResponse);
    }

}
