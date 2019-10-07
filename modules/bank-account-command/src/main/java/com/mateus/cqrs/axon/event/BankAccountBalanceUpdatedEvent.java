package com.mateus.cqrs.axon.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@AllArgsConstructor
public class BankAccountBalanceUpdatedEvent {

    private String bankId;
    private BigDecimal balance;

}
