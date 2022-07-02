package com.example.nibss.service;

import com.example.nibss.model.Account;
import com.example.nibss.model.Transfer;
import com.example.nibss.repository.AccountRepository;
import com.example.nibss.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        System.out.println(transfer);
        return transferRepository.save(transfer);
    }
}
