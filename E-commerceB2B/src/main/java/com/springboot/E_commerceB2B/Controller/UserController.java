package com.springboot.E_commerceB2B.Controller;
import java.util.List;

import com.springboot.E_commerceB2B.Entities.Product;
import com.springboot.E_commerceB2B.Entities.User;
import com.springboot.E_commerceB2B.Service.ProductService;
import com.springboot.E_commerceB2B.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    // End points para criar usuário

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User createdUser = userService.registerUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/Products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }


}
