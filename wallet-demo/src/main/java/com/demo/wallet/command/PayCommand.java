package com.demo.wallet.command;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Getter
public class PayCommand {

    @TargetAggregateIdentifier
    private final String walletId;//to find aggregate it is mandatory
    private final String orderId;
    private final BigDecimal payAmount;

    public PayCommand(String walletId, String orderId, BigDecimal payAmount) {
        this.walletId = walletId;
        this.orderId = orderId;
        this.payAmount = payAmount;
    }
}
