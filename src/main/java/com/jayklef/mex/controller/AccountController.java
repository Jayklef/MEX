package com.jayklef.mex.controller;

import com.jayklef.mex.dto.AccountDTO;
import com.jayklef.mex.entity.Account;
import com.jayklef.mex.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts = accountService.findAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountDTO){
        Account newAccount = accountService.createAccount(accountDTO);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @PutMapping("/update/{residentId}")
    public ResponseEntity<Account> updateAccount(@PathVariable("residentId") Long residentId,
                                                 @RequestBody Account account){
        Account accountToUpdate = accountService.updateAccount(residentId, account);
        return new ResponseEntity<>(accountToUpdate, HttpStatus.OK);
    }

    @GetMapping("/single/{residentId}")
    public ResponseEntity<Account> getAccountById(@PathVariable("residentId") Long residentId){
        Account account = accountService.findAccountById(residentId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
