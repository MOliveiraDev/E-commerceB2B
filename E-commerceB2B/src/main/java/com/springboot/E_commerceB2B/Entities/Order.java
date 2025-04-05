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

        @OneToMany(cascade = CascadeType.ALL)
        private List<Product> products;

        @NotNull
        private double totalPrice;

        public Order() {
        }

        public Order(long id, String userId, List<Product> products, double totalPrice) {
                this.id = id;
                this.userId = userId;
                this.products = products;
                this.totalPrice = totalPrice;
        }

    public void setStatus(String canceled) {
        
    }

    public String getStatus() {
        return null;
    }
}
