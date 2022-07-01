package com.example.nibss.controller;

import com.example.nibss.model.BankAccount;
import com.example.nibss.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bank")
public class BankAccountsController {
    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountsController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/getBankAccounts")
    public List<BankAccount> getBankAccounts() {
        return bankAccountService.getBankAccounts();
    }
}
