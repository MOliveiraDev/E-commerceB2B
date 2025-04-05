package com.springboot.E_commerceB2B.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String userId;

    @Setter
    @Getter
    @NotNull
    private String username;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    @NotNull
    private double totalPrice;

    @Setter
    @Getter
    private String status;

    public Order() {
    }

    public Order(long id, String userId, String username, List<Product> products, double totalPrice, String status) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.products = products;
        this.totalPrice = totalPrice;
        this.status = status;
    }

}