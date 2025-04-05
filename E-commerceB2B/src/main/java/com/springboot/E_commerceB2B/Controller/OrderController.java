package com.springboot.E_commerceB2B.Controller;

import com.springboot.E_commerceB2B.Entities.Order;
import com.springboot.E_commerceB2B.Service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/order")
public class OrderController {

        @Autowired
        private OrderService orderService;

        //Listar todos os pedidos de tal usuário
        @GetMapping("/myOrders")
        public ResponseEntity<List<Order>> getUserOrders(Authentication authentication) {
            String username = authentication.getName();
            List<Order> orders = orderService.getOrdersByUsername(username);
            return ResponseEntity.ok(orders);
        }

        // Atualizar o pedido
        @PostMapping
        public ResponseEntity<Order> updateOrder(@RequestBody Order order, Authentication authentication) {
            String username = authentication.getName();
            Order updatedOrder = orderService.updateOrder(order, username);
            return ResponseEntity.ok(updatedOrder);
        }

        // Adicionar o end points para criar e gerenciar pedidos
        @PostMapping("/addmyOrder")
        public ResponseEntity<Order> createOrder(@RequestBody Order order, Authentication authentication) {
            String username = authentication.getName();
            Order createdOrder = orderService.createOrder(order, username);
            return ResponseEntity.ok(createdOrder);
        }

        // Cancelar o pedido
        @PostMapping("/cancelmyOrder")
        public ResponseEntity<Order> cancelOrder(@RequestBody Long orderId, Authentication authentication) {
            String username = authentication.getName();
            orderService.cancelOrder(orderId, username);
            return ResponseEntity.ok().build();
        }


}
