package com.example.bankapp.service;

import com.example.bankapp.domain.Account;
import com.example.bankapp.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repo;

    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    public Account create(String owner) {
        return repo.save(new Account(owner, BigDecimal.ZERO));
    }

    public Account deposit(Long id, BigDecimal amount) {
        Account a = repo.findById(id).orElseThrow();
        a.setBalance(a.getBalance().add(amount));
        return repo.save(a);
    }

    public List<Account> all() {
        return repo.findAll();
    }
}
