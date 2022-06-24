package com.jayklef.mex.service;

import com.jayklef.mex.dto.AccountDTO;
import com.jayklef.mex.entity.Account;
import com.jayklef.mex.exception.AccountNotFoundException;
import com.jayklef.mex.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account createAccount(AccountDTO accountDTO) {

        Account newAccount = Account.builder()
                .accountBalance(accountDTO.getAccountBalance())
                .build();
        return accountRepository.save(newAccount);
    }

    @Override
    public Account updateAccount(Long residentId, Account account) {

        Account accountInDb = accountRepository.findById(residentId).get();

        if (Objects.nonNull(account.getAccountBalance()) &&
        !"".equalsIgnoreCase(account.getAccountBalance().toString())){
            accountInDb.setAccountBalance(accountInDb.getAccountBalance());
        }
        return accountRepository.save(accountInDb);
    }

    @Override
    public Account findAccountById(Long residentId) {

        Optional<Account> account = accountRepository.findById(residentId);

        if (account == null){
            throw new AccountNotFoundException("Account Not found");
        }
        return accountRepository.findById(residentId).get();
    }
}
