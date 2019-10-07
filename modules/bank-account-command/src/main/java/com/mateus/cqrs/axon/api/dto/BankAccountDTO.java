package com.mateus.cqrs.axon.api.dto;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDTO {
    private String name;
    private BigDecimal balance;
}
