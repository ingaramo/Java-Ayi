package com.educacionIt.spring.vo;

public class PaymentVo {

    private String type;
    private Double amount;

    public PaymentVo() {
    }

    public PaymentVo(String type, Double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
