package com.example.ordermanagement.dto;

import com.example.ordermanagement.model.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStatusDto {
    private String orderId;
    private ProductStatus.Status productStatus;
    private LocalDateTime statusUpdatedDate;
}
