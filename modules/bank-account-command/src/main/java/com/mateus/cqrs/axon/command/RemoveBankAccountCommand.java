package com.mateus.cqrs.axon.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Getter
@ToString
@AllArgsConstructor
public class RemoveBankAccountCommand {

    @TargetAggregateIdentifier
    private String id;

}
