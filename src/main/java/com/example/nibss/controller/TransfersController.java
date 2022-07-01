package com.example.nibss.controller;

import com.example.nibss.model.Transfer;
import com.example.nibss.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/transfer")
public class TransfersController {

    private final TransferService transferService;

    @Autowired
    public TransfersController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/getTransfers")
    @ResponseBody
    public List<Transfer> getTransfers() {
        return transferService.getTransfers();
    }

    @PostMapping("/transfer")
    public void newTransfer(@RequestBody Transfer transfer) {
        transferService.newTransfer(transfer);
    }

}
