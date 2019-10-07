package com.mateus.cqrs.axon.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class BankAccountRemovedEvent {

    private String id;
    
}
