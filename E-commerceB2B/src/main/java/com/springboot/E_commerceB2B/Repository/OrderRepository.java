package com.springboot.E_commerceB2B.Repository;

import com.springboot.E_commerceB2B.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository <Order, Long> {
}
