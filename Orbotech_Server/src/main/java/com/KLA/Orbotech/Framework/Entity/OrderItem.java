package com.KLA.Orbotech.Framework.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "orderitems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Integer id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal itemAmount;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false, foreignKey=@ForeignKey(name = "fk_order"))
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false, foreignKey=@ForeignKey(name = "fk_product"))
    private Product product;

}
