package br.com.mmmsieto.saleservice.adapters.in.controller;

import br.com.mmmsieto.saleservice.adapters.in.controller.mapper.SaleRequestMapper;
import br.com.mmmsieto.saleservice.adapters.in.controller.request.SaleRequest;
import br.com.mmmsieto.saleservice.application.ports.in.CreateSaleInputPort;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    @Autowired
    private CreateSaleInputPort createSaleInputPort;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody SaleRequest saleRequest) {
        log.info("Starting the creation of the sale");
        createSaleInputPort.create(SaleRequestMapper.toSale(saleRequest));
        log.info("Successfully created sale");
    }

}
