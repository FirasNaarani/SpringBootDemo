package com.KLA.Orbotech.Framework.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "OrderItems")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long orderItemId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "item_amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal itemAmount;

    @ManyToMany
    @JoinColumns({
            @JoinColumn(name = "order_id", referencedColumnName = "fk_order"),
            @JoinColumn(name = "product_id", referencedColumnName = "fk_product")
    })

    //GETTERS
    public Long getOrderItemId() {
        return orderItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getItemAmount() {
        return itemAmount;
    }

    //SETTERS

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setItemAmount(BigDecimal itemAmount) {
        this.itemAmount = itemAmount;
    }

    //CONSTRUCTOR
    public OrderItem(){

    }
}
