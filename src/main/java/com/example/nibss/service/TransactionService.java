package com.example.nibss.service;

import com.example.nibss.model.Transaction;
import com.example.nibss.repository.AccountRepository;
import com.example.nibss.repository.TransactionRepository;
import com.example.nibss.utility.TransactionOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public List<Transaction> findByDetails(boolean commissionWorthiness, String transactionReference,
                                            String status, String startDate, String endDate) {

        // Convert startDate and endDate to LocalDateTime
        LocalDateTime startDateTime = TransactionOperation.convertStringToLocalDateTime(startDate);
        LocalDateTime endDateTime = TransactionOperation.convertStringToLocalDateTime(endDate);
        return transactionRepository.findByDetails(commissionWorthiness, transactionReference,
                status, startDateTime, endDateTime);
    }

    public Transaction newTransaction(Transaction transaction) {
        //Get account and use for the transfer
        return transactionRepository.save(transaction);
    }

    /**
     *
     * @param startDate
     * @return list of transactions
     */
    public List<Transaction> fetchTransactionsByDate(String startDate) {

        // Convert startDate and endDate to LocalDateTime
        LocalDateTime startDateTime = TransactionOperation.convertStringToLocalDateTime(startDate);

        System.out.println("startDateTime: " + startDateTime);

        return transactionRepository.findByDateCreated(startDateTime);
    }

    // Schedule a cron job to run every day at 8pm
    @Scheduled(cron = "0 0 20 * * *")
    private void fetchTransactionsByDate() {
        System.out.println("fetchTransactionsByDate: " + LocalDateTime.now());
        fetchTransactionsByDate(LocalDateTime.now().toString());
    }
}
