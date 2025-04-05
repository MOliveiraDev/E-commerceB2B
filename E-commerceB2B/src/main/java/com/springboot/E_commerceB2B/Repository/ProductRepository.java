package com.springboot.E_commerceB2B.Repository;

import com.springboot.E_commerceB2B.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
