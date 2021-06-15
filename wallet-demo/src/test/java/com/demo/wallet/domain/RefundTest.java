package com.demo.wallet.domain;

import com.demo.wallet.command.PayCommand;
import com.demo.wallet.command.RefundCommand;
import com.demo.wallet.event.DepositedEvent;
import com.demo.wallet.event.PaidEvent;
import com.demo.wallet.event.RefundedEvent;
import com.demo.wallet.event.WalletCreatedEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.TestExecutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class RefundTest {

    private static final String ORDER_ID = "order1";
    private static final String WALLET_ID = "TEST";
    private TestExecutor<Wallet> textFixture;

    @BeforeEach
    public void setUp() {
        textFixture = new AggregateTestFixture<>(Wallet.class)
                .given(new WalletCreatedEvent(WALLET_ID, BigDecimal.ZERO))
                .andGiven(new DepositedEvent(new BigDecimal("500")))
                .andGiven(new PaidEvent(ORDER_ID, new BigDecimal("300")));
    }

    @Test
    public void it_should_publish_refundedEvent() {

        final BigDecimal refundAmount = new BigDecimal("100");
        textFixture.when(new RefundCommand(WALLET_ID, ORDER_ID, refundAmount))
                .expectSuccessfulHandlerExecution()
                .expectEvents(new RefundedEvent(ORDER_ID, refundAmount))
                .expectState(wallet -> {
                    assertThat(wallet.getBalance(), comparesEqualTo(new BigDecimal("300")));
                });
    }
}
