package com.springboot.E_commerceB2B.Service;

import com.springboot.E_commerceB2B.Entities.Product;
import com.springboot.E_commerceB2B.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

        @Autowired
        private ProductRepository productRepository;

        public List <Product> getAllProducts() {
            return productRepository.findAll();
        }

        public Product addProduct(Product product) {
            productRepository.save(product);
            return product;
        }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());
            productRepository.save(existingProduct);
        }
        return existingProduct;
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        return;
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
}
