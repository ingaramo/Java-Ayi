package com.educacionIt.spring.model;

import javax.persistence.*;

@Entity
@Table(name ="Items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "item_seq", name = "item")
    private Long id;
    private Long orderId;
    private String description;
    private Integer quantity;
    private Double price;

    public Item() {
    }

    public Item(Long id, Long orderId, String description, Integer quantity, Double price){
        this.id = id;
        this.orderId = orderId;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdOrder() {
        return orderId;
    }

    public void setIdOrder(Long idOrder) {
        this.orderId = idOrder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
