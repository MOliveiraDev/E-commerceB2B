package com.springboot.E_commerceB2B.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_products")
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @NotBlank
        private String name;

        @NotNull
        private double price;


        @NotNull
        private int quantity;

        public Product () {
        }

        public Product(long id, String name, double price, int quantity) {
                this.id = id;
                this.name = name;
                this.price = price;
                this.quantity = quantity;
        }


        public Object getDescription() {
                return null;
        }
}
