package com.springboot.E_commerceB2B.Repository;

import com.springboot.E_commerceB2B.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository  extends JpaRepository <Order, Long> {
    List<Order> findByUsername(String username);
}
