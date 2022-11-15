package com.example.ordermanagement.service;

import com.example.ordermanagement.dto.ProductStatusDto;
import com.example.ordermanagement.model.ProductStatus;

import java.util.List;

public interface ProductStatusService {
    public void saveProductStatus(ProductStatus productStatus);

    List<ProductStatusDto> displayProductStatus(String orderId);

    List<ProductStatus> modifyProductStatus(String orderId);
}
