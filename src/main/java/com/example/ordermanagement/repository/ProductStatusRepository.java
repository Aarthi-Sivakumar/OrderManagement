package com.example.ordermanagement.repository;

import com.example.ordermanagement.model.ProductStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductStatusRepository extends MongoRepository<ProductStatus,String> {
    List<ProductStatus> findByOrderId(String orderId);
}
