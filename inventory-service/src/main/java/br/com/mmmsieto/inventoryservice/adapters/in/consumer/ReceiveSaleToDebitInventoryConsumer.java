package br.com.mmmsieto.inventoryservice.adapters.in.consumer;

import br.com.mmmsieto.inventoryservice.adapters.out.message.SaleMessage;
import br.com.mmmsieto.inventoryservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.inventoryservice.application.ports.in.DebitInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToDebitInventoryConsumer {

    private final DebitInventoryInputPort debitInventoryInputPort;

    public ReceiveSaleToDebitInventoryConsumer(DebitInventoryInputPort debitInventoryInputPort) {
        this.debitInventoryInputPort = debitInventoryInputPort;
    }

    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-debit")
    public void receive(SaleMessage saleMessage) {

        log.info("SaleMessage received: {}", saleMessage);

        if(SaleEvent.CREATED_SALE.equals(saleMessage.getSaleEvent())) {
            log.info("Start SaleEvent: {}", SaleEvent.CREATED_SALE);

            debitInventoryInputPort.debit(saleMessage.getSale());

            log.info("End SaleEvent: {}", SaleEvent.CREATED_SALE);
        }

    }

}
