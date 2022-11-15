package com.example.ordermanagement.model;

import com.example.ordermanagement.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Product {

    @Id
    private String id;
    private int productId;
    private String productName;
    private double price;



}
