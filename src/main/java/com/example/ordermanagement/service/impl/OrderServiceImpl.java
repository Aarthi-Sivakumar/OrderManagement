package com.example.ordermanagement.service.impl;

import com.example.ordermanagement.exception.ResourceNotFound;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.model.Product;
import com.example.ordermanagement.model.User;
import com.example.ordermanagement.repository.OrderRepository;
import com.example.ordermanagement.repository.ProductRepository;
import com.example.ordermanagement.repository.UserRepository;
import com.example.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    public static final String E404= "not found";

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }
    @Override
    public void saveOrderDetails(Order order) {
        Optional<User> buyerExists = userRepository.findById(order.getBuyerId());
        if(!buyerExists.isPresent()){
            throw new ResourceNotFound(E404);
        }
        Optional<Product> product = productRepository.getProductByProductName(order.getProductName());
        if(!product.isPresent()){
            throw new ResourceNotFound(E404);
        }
        order.setProductId(product.get().getProductId());
        order.setPrice((product.get().getPrice() * order.getNoOfProduct()));
        orderRepository.save(order);
    }
}
