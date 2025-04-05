package com.springboot.E_commerceB2B.Service;

import com.springboot.E_commerceB2B.Entities.Order;
import com.springboot.E_commerceB2B.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

        @Autowired
        private OrderRepository orderRepository;

        public List <Order> getAllOrders() {
            return orderRepository.findAll();
        }

        public void addOrder(Order order) {
            orderRepository.save(order);
        }

        // Cancelar o pedido
        public void cancelOrder(Long orderId) {
            Order order = orderRepository.findById(orderId).orElse(null);
            if (order != null)
            {
                order.setStatus("Canceled");
                orderRepository.save(order);
            }
        }

        //Atualizar Pedido
        public void updateOrder(Order order) {
            Order existingOrder = orderRepository.findById(order.getId()).orElse(null);
            if (existingOrder != null) {
                existingOrder.setStatus(order.getStatus());
                existingOrder.setTotalPrice(order.getTotalPrice());
                orderRepository.save(existingOrder);
            }
        }
}
