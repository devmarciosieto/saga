package br.com.mmmsieto.inventoryservice.application.ports.out;

import br.com.mmmsieto.inventoryservice.application.core.domain.Sale;
import br.com.mmmsieto.inventoryservice.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputProt {

    void send(Sale sale, SaleEvent saleEvent);

}
