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

        public List<Order> getOrdersByUsername(String username) {
            return orderRepository.findByUsername(username);
        }

    public Order createOrder(Order order, String username) {
        order.setUsername(username);
        return orderRepository.save(order);
    }

        // Cancelar o pedido
        public void cancelOrder(Long orderId, String username) {
            Order order = orderRepository.findById(orderId).orElse(null);
            if (order != null && order.getUsername().equals(username)) {
                order.setStatus("CANCELLED");
                orderRepository.save(order);
            }
        }

        //Atualizar Pedido
        public Order updateOrder(Order order, String username) {
            Order existingOrder = orderRepository.findById(order.getId()).orElse(null);
            if (existingOrder != null && existingOrder.getUsername().equals(username)) {
                existingOrder.setStatus(order.getStatus());
                existingOrder.setTotalPrice(order.getTotalPrice());
                return orderRepository.save(existingOrder);
            }
            return null;
        }


}
