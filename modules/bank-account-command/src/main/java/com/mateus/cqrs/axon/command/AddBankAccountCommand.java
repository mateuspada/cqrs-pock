package com.mateus.cqrs.axon.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@AllArgsConstructor
@ToString
@Getter
public class AddBankAccountCommand {

    @TargetAggregateIdentifier
    private String id;
    private String name;

}
