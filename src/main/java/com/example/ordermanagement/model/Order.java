package com.example.ordermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    private String orderId;
    private String sellerId;
    private String sellerName;
    private String buyerId;
    private String buyerName;
    private long productId;
    private String productName;
    private int noOfProduct;
    private double price;
    ProductStatus.Status productStatus= ProductStatus.Status.REQUESTED;

}
