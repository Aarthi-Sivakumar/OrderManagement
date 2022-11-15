package com.example.ordermanagement.service;

import com.example.ordermanagement.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    List<Product> displayProducts();

    void saveProduct(Product product);
}
