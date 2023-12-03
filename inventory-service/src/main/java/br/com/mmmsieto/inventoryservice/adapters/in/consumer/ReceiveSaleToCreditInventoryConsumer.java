package br.com.mmmsieto.inventoryservice.adapters.in.consumer;

import br.com.mmmsieto.inventoryservice.adapters.out.message.SaleMessage;
import br.com.mmmsieto.inventoryservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.inventoryservice.application.ports.in.CreditInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToCreditInventoryConsumer {

    private final CreditInventoryInputPort creditInventoryInputPort;

    public ReceiveSaleToCreditInventoryConsumer(CreditInventoryInputPort creditInventoryInputPort) {
        this.creditInventoryInputPort = creditInventoryInputPort;
    }

    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-credit")
    public void receive(SaleMessage saleMessage) {
        log.info("Receive sale to credit inventory: {}", saleMessage);

        if (SaleEvent.FAILED_PAYMENT.equals(saleMessage.getEvent())) {
            log.info("Start Sale failed payment, compensating transaction: {}", saleMessage);
            creditInventoryInputPort.credit(saleMessage.getSale());
            log.info("End Sale failed payment, compensating transaction: {}", saleMessage);
        }
    }

}
