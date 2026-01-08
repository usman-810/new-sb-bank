package com.example.bankapp.controller;

import com.example.bankapp.domain.Account;
import com.example.bankapp.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public Account create(@RequestParam String owner) {
        return service.create(owner);
    }

    @PostMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestParam BigDecimal amount) {
        return service.deposit(id, amount);
    }

    @GetMapping
    public List<Account> all() {
        return service.all();
    }
}
