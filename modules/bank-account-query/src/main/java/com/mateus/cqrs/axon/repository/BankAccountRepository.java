package com.mateus.cqrs.axon.repository;

import com.mateus.cqrs.axon.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}