package com.mateus.cqrs.axon.api.controller;

import com.mateus.cqrs.axon.api.dto.BankAccountDTO;
import com.mateus.cqrs.axon.command.AddBankAccountCommand;
import com.mateus.cqrs.axon.command.RemoveBankAccountCommand;
import com.mateus.cqrs.axon.command.UpdateBalanceBankAccountCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/bank-accounts")
public class BankAccountController {
    private CommandGateway commandGateway;

    @PostMapping
    public CompletableFuture<String> create(@RequestBody BankAccountDTO dto) {
        var command = new AddBankAccountCommand(UUID.randomUUID().toString(), dto.getName());
        log.info("Executing command: {}", command);
        return commandGateway.send(command);
    }

    @PutMapping("/{id}/balances")
    public CompletableFuture<String> updateBalance(@PathVariable String id, @RequestBody BankAccountDTO dto) {
        var command = new UpdateBalanceBankAccountCommand(id, dto.getBalance());
        log.info("Executing command: {}", command);
        return commandGateway.send(command);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<String> remove(@PathVariable String id) {
        var command = new RemoveBankAccountCommand(id);
        log.info("Executing command: {}", command);
        return commandGateway.send(command);
    }
}
