package com.example.nibss.controller;


import com.example.nibss.model.Transfer;
import com.example.nibss.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/transfers")
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

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/addTransfer")
    public ResponseEntity<Transfer> newTransfer(@RequestBody Transfer transfer) {
        System.out.println(transfer);
        Transfer transferResponse = transferService.newTransfer(transfer);
        return ResponseEntity.ok(transferResponse);
    }
}
