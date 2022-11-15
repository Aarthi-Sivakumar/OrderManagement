package com.example.ordermanagement.controller;

import com.example.ordermanagement.api.OrderApi;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderApi {

    OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @Override
    public ResponseEntity<Void> saveOrderDetails(Order order) {
        orderService.saveOrderDetails(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
