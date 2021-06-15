package com.demo.wallet.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.serialization.Revision;

import java.math.BigDecimal;

@Revision("1.0")//for versioning events
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RefundedEvent {
    private String orderId;
    private BigDecimal amount;
}
