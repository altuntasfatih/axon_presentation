package com.demo.wallet.handler;

import com.demo.wallet.event.DepositedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.annotation.SourceId;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ProcessingGroup("mail")//it is a Tracking Event Processors
public class MailEventHandler {
    @EventHandler//act on incoming event
    public void handle(DepositedEvent event, @SourceId String walletId) {
        //the place where ou would put your business logic to be performed when an event is received

        //send mail for deposit event
        log.info("{} for wallet: {} is mail sent", event.toString(), walletId);
    }
}
