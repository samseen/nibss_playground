package com.example.nibss.service;

import com.example.nibss.model.Account;
import com.example.nibss.model.Transfer;
import com.example.nibss.repository.AccountRepository;
import com.example.nibss.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransferService {
    private final TransferRepository transferRepository;

    private final AccountRepository accountRepository;

    @Autowired
    public TransferService(TransferRepository transferRepository, AccountRepository accountRepository) {
        this.transferRepository = transferRepository;
        this.accountRepository = accountRepository;
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
            // Check if the source account has enough money before saving
            if (transfer.getAmount() > sourceAccount.get().getBalance()) {
                throw new IllegalStateException("Insufficient funds");
            } else {
                System.out.println("Sufficient funds");
            }
        }

        return transferRepository.save(transfer);
    }
}
