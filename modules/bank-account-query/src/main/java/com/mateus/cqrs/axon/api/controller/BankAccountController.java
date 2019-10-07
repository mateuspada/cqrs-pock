package com.mateus.cqrs.axon.api.controller;

import com.mateus.cqrs.axon.model.BankAccount;
import com.mateus.cqrs.axon.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/bank-accounts")
public class BankAccountController {
    private BankAccountRepository repository;

    @GetMapping
    public List<BankAccount> getAll() {
        return repository.findAll();
    }
}
