package com.example.ordermanagement.repository;

import com.example.ordermanagement.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product,String> {
    Optional<Product> getProductByProductName(String productName);
}
