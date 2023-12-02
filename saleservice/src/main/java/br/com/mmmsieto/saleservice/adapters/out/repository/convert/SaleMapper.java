package br.com.mmmsieto.saleservice.adapters.out.repository.convert;

import br.com.mmmsieto.saleservice.adapters.out.repository.entity.SaleEntity;
import br.com.mmmsieto.saleservice.application.core.domain.Sale;
import br.com.mmmsieto.saleservice.application.core.domain.enums.SaleStatus;

public interface SaleMapper {

    static Sale toSale(SaleEntity saleEntity) {
        return new Sale(
                saleEntity.getProductId(),
                saleEntity.getUserId(),
                saleEntity.getPrice(),
                SaleStatus.fromStatusId(saleEntity.getStatusId()),
                saleEntity.getQuantity()
        );

    }

}

