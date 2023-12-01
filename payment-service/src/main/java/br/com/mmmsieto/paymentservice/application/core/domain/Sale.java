package br.com.mmmsieto.paymentservice.application.core.domain;


import br.com.mmmsieto.paymentservice.application.core.domain.enums.SaleStatus;

import java.math.BigDecimal;

public class Sale {

    private Long id;

    private Long productId;

    private Long userId;

    private BigDecimal value;

    private SaleStatus status;

    private Integer quantity;

    public Sale() {
    }

    public Sale(Long id, Long productId, Long userId, BigDecimal value, SaleStatus status, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.value = value;
        this.status = status;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
