package br.com.mmmsieto.saleservice.adapters.out;

import br.com.mmmsieto.saleservice.adapters.out.repository.SaleRepository;
import br.com.mmmsieto.saleservice.adapters.out.repository.convert.SaleConvert;
import br.com.mmmsieto.saleservice.adapters.out.repository.convert.SaleEntityConvert;
import br.com.mmmsieto.saleservice.application.core.domain.Sale;
import br.com.mmmsieto.saleservice.application.ports.out.SaveSaleOutputPort;
import org.springframework.stereotype.Component;

@Component
public class SaveSaleAdapter implements SaveSaleOutputPort {

    private final SaleRepository saleRepository;

    public SaveSaleAdapter(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale save(Sale sale) {
        return SaleConvert.toSale(saleRepository.save(SaleEntityConvert.toEntity(sale)));
    }

}
