package com.mateus.cqrs.axon.components;

import com.mateus.cqrs.axon.event.BankAccountAddedEvent;
import com.mateus.cqrs.axon.event.BankAccountBalanceUpdatedEvent;
import com.mateus.cqrs.axon.event.BankAccountRemovedEvent;
import com.mateus.cqrs.axon.exception.BankAccountNotFoundException;
import com.mateus.cqrs.axon.model.BankAccount;
import com.mateus.cqrs.axon.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
@ProcessingGroup("amqpEvents")
public class BankAccountEventProcessor {
    private final BankAccountRepository repository;

    @EventHandler
    public void on(BankAccountAddedEvent event) {
        BankAccount bankAccount = repository.save(new BankAccount(event.getId(), event.getName(), event.getBalance()));
        log.info("A bank account was added! {}", bankAccount);
    }

    @EventHandler
    public void on(BankAccountBalanceUpdatedEvent event) {
        var bank = repository.findById(event.getBankId())
                .orElseThrow(BankAccountNotFoundException::new);
        bank.setBalance(event.getBalance());
        repository.save(bank);
        log.info("A bank account balance was updated! {}", bank);
    }

    @EventHandler
    public void on(BankAccountRemovedEvent event) {
        repository.deleteById(event.getId());
        log.info("A bank account was removed! {}", event.getId());
    }
}
