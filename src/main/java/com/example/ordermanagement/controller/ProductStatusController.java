package com.example.ordermanagement.controller;

import com.example.ordermanagement.api.ProductStatusApi;
import com.example.ordermanagement.dto.ProductStatusDto;
import com.example.ordermanagement.model.ProductStatus;
import com.example.ordermanagement.service.ProductStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductStatusController implements ProductStatusApi {

    ProductStatusService productStatusService;

    public ProductStatusController(ProductStatusService productStatusService){
        this.productStatusService=productStatusService;
    }

    @Override
    public ResponseEntity<Void> saveProductStatus(ProductStatus productStatus) {
        productStatusService.saveProductStatus(productStatus);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductStatusDto>> displayProductStatus(String orderId) {
        return new ResponseEntity<>(productStatusService.displayProductStatus(orderId)
                                        ,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductStatus>> modifyProductStatus(String orderId) {
        return new ResponseEntity<>(productStatusService.modifyProductStatus(orderId),HttpStatus.OK);
    }
}
