package com.example.ordermanagement.repository;

import com.example.ordermanagement.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order,String> {

}
