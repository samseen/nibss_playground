package com.example.nibss.service;

import com.example.nibss.model.Transfer;
import com.example.nibss.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {

    private final TransferRepository transferRepository;

    @Autowired
    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public List<Transfer> getTransfers() {
        return transferRepository.findAll();
    }

    public void newTransfer(Transfer transfer) {
        System.out.println(transfer);
    }
}
