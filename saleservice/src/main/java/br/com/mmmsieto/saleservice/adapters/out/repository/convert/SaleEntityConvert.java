package br.com.mmmsieto.saleservice.adapters.out.repository.convert;

import br.com.mmmsieto.saleservice.adapters.out.repository.entity.SaleEntity;
import br.com.mmmsieto.saleservice.application.core.domain.Sale;

public interface SaleEntityConvert {

    static SaleEntity toEntity(Sale sale) {
        return SaleEntity.builder()
                .id(sale.getId())
                .productId(sale.getProductId())
                .userId(sale.getUserId())
                .price(sale.getPrice())
                .statusId(sale.getStatus().getStatusId())
                .quantity(sale.getQuantity())
                .build();
    }

}
