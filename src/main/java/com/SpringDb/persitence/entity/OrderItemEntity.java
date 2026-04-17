package com.SpringDb.persitence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;


@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class)
public class OrderItemEntity {

    @Id
    @Column(name="id_order", nullable =false)
    private Integer idOrder;

    @Id
    @Column(name = "id_item", nullable = false)
    private Integer idItem;

    @Column(name = "id_pizza",nullable = false)
    private Integer idPizza;

    @Column (nullable = false, precision=2 , scale = 1)
    private BigDecimal quantity;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName ="id_order", insertable = false, updatable = false )
    private OrderEntity order;

    @OneToOne
    @JoinColumn(name = "id_pizza", referencedColumnName = "id_pizza", insertable = false, updatable = false)
    private PizzaEntity pizza;
}
