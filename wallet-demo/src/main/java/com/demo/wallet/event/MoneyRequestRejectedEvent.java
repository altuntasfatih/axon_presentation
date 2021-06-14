package com.demo.wallet.event;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.axonframework.serialization.Revision;

import java.math.BigDecimal;

@Revision("1.0")//for versioning events
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MoneyRequestRejectedEvent {
    private String requestId;
}