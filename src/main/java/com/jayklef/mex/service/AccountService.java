package com.jayklef.mex.service;

import com.jayklef.mex.dto.AccountDTO;
import com.jayklef.mex.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccounts();

    Account createAccount(AccountDTO accountDTO);

    Account updateAccount(Long residentId, Account account);

    Account findAccountById(Long residentId);
}
