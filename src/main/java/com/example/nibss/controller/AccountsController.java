package com.example.nibss.controller;

import com.example.nibss.model.Account;
import com.example.nibss.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/account")
public class AccountsController {

    private final AccountService accountService;

    @Autowired
    public AccountsController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getAccounts")
    @ResponseBody
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @PostMapping("/addAccount")
    public ResponseEntity<Account> newAccount(@RequestBody Account account) {
        System.out.println(account);
        Account accountResponse = accountService.newAccount(account);
        return ResponseEntity.ok(accountResponse);
    }
}
