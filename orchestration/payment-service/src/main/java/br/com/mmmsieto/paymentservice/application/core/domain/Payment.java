package br.com.mmmsieto.paymentservice.application.core.domain;

import java.math.BigDecimal;

public class Payment {

    private Long id;

    private Long userId;

    private Long saleId;

    private BigDecimal value;


    public Payment() {
    }

    public Payment(Long id, Long userId, Long saleId, BigDecimal value) {
        this.id = id;
        this.userId = userId;
        this.saleId = saleId;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
