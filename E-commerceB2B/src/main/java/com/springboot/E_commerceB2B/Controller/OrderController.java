package com.springboot.E_commerceB2B.Controller;

import com.springboot.E_commerceB2B.Entities.Order;
import com.springboot.E_commerceB2B.Service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

        // Adicionar o end points para criar e gerenciar pedidos
        @PostMapping("/addOrder")
        public ResponseEntity<Order> addOrder(@RequestBody Order order) {
            orderService.addOrder(order);
            return ResponseEntity.ok(order);
        }

        //Cancelar o pedido
        @PostMapping("/cancelOrder")
        public  ResponseEntity<Order> cancelOrder(@RequestBody Long orderId) {
            orderService.cancelOrder(orderId);
            return ResponseEntity.ok().build();
        }

        //Atualizar o pedido
        @PostMapping("/updateOrder")
        public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
            orderService.updateOrder(order);
            return ResponseEntity.ok(order);
        }

        //Listar todos os pedidos de tal usuário
        @GetMapping("/getAllOrders")
        public ResponseEntity<Order> getAllOrders() {
            List<Order> orders = orderService.getAllOrders();
            return ResponseEntity.ok((Order) orders);
        }
}
