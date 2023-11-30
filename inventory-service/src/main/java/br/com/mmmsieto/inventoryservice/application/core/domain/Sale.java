package br.com.mmmsieto.inventoryservice.application.core.domain;

import br.com.mmmsieto.inventoryservice.application.core.domain.enums.SaleStatus;

import java.math.BigDecimal;

public class Sale {

    private String id;

    private Long productId;

    private Long userId;

    private BigDecimal value;

    private SaleStatus status;

    private Integer quantity;

    public Sale() {
    }

    public Sale(String id, Long productId, Long userId, BigDecimal value, SaleStatus status, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.value = value;
        this.status = status;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
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
