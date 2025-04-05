package com.springboot.E_commerceB2B.Controller;

import com.springboot.E_commerceB2B.Entities.Product;
import com.springboot.E_commerceB2B.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/product")
public class ProductController {

        @Autowired
        private ProductService productService;


        @GetMapping("/productsList")
        public ResponseEntity<List <Product>> getAllProducts() {
            List<Product> products = productService.getAllProducts();
            return ResponseEntity.ok(products);
        }

        @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/addProduct")
        public ResponseEntity<Product> addProduct(@RequestBody Product product) {
            Product createdProduct = productService.addProduct(product);
            return ResponseEntity.ok(createdProduct);
        }

        @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/updateProduct")
        public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
            Product updatedProduct = productService.updateProduct(product);
            return ResponseEntity.ok(updatedProduct);
        }

        @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/deleteProduct")
        public ResponseEntity<Void> deleteProduct(@RequestBody Long productId) {
            productService.deleteProduct(productId);
            return ResponseEntity.ok().build();
        }

        @GetMapping("/getProductById")
        public ResponseEntity<Product> getProductById(@RequestBody Long productId) {
            Product product = productService.getProductById(productId);
            return ResponseEntity.ok(product);
        }


}
