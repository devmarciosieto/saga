package br.com.mmmsieto.saleservice.application.core.domain;

import br.com.mmmsieto.saleservice.application.core.domain.enums.SaleStatus;

import java.math.BigDecimal;

public class Sale {

    public Sale() {
    }

    public Sale(Integer productId, Integer userId, BigDecimal price, SaleStatus status, Integer quantity) {
        this.productId = productId;
        this.userId = userId;
        this.price = price;
        this.status = status;
        this.quantity = quantity;
    }

    private Integer id;

    private Integer productId;

    private Integer userId;

    private BigDecimal price;

    private SaleStatus status;

    private Integer quantity;

    public Sale(Integer productId, Integer userId, BigDecimal price, Integer quantity) {
        this.productId = productId;
        this.userId = userId;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

