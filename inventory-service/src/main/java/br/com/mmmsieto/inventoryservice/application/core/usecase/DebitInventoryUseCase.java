package br.com.mmmsieto.inventoryservice.application.core.usecase;

import br.com.mmmsieto.inventoryservice.application.core.domain.Sale;
import br.com.mmmsieto.inventoryservice.application.ports.in.FindInventoryByProductIdInputPort;
import br.com.mmmsieto.inventoryservice.application.ports.out.SendUpdatedInventoryOutputProt;
import br.com.mmmsieto.inventoryservice.application.ports.out.UpdateInventoryOutputPort;

public class DebitInventoryUseCase {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;

    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    private final SendUpdatedInventoryOutputProt sendUpdatedInventoryOutputProt;


    public DebitInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
                                 UpdateInventoryOutputPort updateInventoryOutputPort,
                                 SendUpdatedInventoryOutputProt sendUpdatedInventoryOutputProt) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendUpdatedInventoryOutputProt = sendUpdatedInventoryOutputProt;
    }

    public void debit(Sale sale) {
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        if (inventory.getQuantity() < sale.getQuantity()) {
            throw new RuntimeException("Insufficient inventory");
        }
        inventory.debitQuantity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);
    }

}
