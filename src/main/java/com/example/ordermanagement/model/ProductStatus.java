package com.example.ordermanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStatus {
    @Id
    private String id;
    private String orderId;
    private String buyerId;
    private Status productStatus;

    public enum Status{
        REQUESTED,
        ORDER_CONFIRMED,
        READY_TO_SHIP,
        POD_UPLOADED,
        BUYER_APPROVED,
        PAYMENT_PROCESSED
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime statusUpdatedDate;

    public ProductStatus(String orderId,String buyerId, Status productStatus) {
        this.orderId = orderId;
        this.buyerId=buyerId;
        this.productStatus = productStatus;
        this.statusUpdatedDate=LocalDateTime.now();
    }
}
