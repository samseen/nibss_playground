package com.example.nibss.service;

import com.example.nibss.model.Account;
import com.example.nibss.model.Transaction;
import com.example.nibss.model.Transfer;
import com.example.nibss.repository.AccountRepository;
import com.example.nibss.repository.TransactionRepository;
import com.example.nibss.repository.TransferRepository;
import com.example.nibss.utility.TransactionOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransferService {
    private final TransferRepository transferRepository;

    private final AccountRepository accountRepository;

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransferService(TransferRepository transferRepository,
                           AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.transferRepository = transferRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public List<Transfer> getTransfers() {
        return transferRepository.findAll();
    }

    public Transfer newTransfer(Transfer transfer) {
         // Get destination account by account number
        Optional<Account> destinationAccount = accountRepository
                .findByTheAccountNumber(transfer.getDestinationAccount());

        Optional<Account> sourceAccount = accountRepository
                .findByTheAccountNumber(transfer.getSourceAccount());

        if (destinationAccount.isEmpty()) {
            throw new IllegalStateException("destination account doesn't exist");
        }

        if (sourceAccount.isPresent()) {
            // Calculate transaction fee
            double transactionFee = TransactionOperation.calculateTransactionFee(transfer.getAmount());
            System.out.println("Transaction fee: " + transactionFee);
            // Calculate amount to be transferred
            double amountToBeTransferred = transfer.getAmount() + transactionFee;
            // Check if the source account has enough money before saving
            if (amountToBeTransferred > sourceAccount.get().getBalance()) {
                throw new IllegalStateException("Insufficient funds");
            } else {
                //  LocalDateTime to Timestamp
                LocalDateTime now = LocalDateTime.now();
                Timestamp timestamp = Timestamp.valueOf(now);
                // Create a new transaction
                Transaction transaction = new Transaction(TransactionOperation.getTransactionReference(),
                        transfer.getAmount(), transactionFee,
                        amountToBeTransferred, transfer.getDescription(), timestamp.toLocalDateTime(),
                        "SUCCESSFUL",
                        TransactionOperation.checkIfTransactionIsCommissionWorthy(transactionFee),
                        TransactionOperation.calculateCommission(transactionFee));
                // Save transaction
                transactionRepository.save(transaction);
            }
        }

        return transferRepository.save(transfer);
    }
}
