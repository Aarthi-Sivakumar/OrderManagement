package com.example.ordermanagement.api;

import com.example.ordermanagement.dto.ProductStatusDto;
import com.example.ordermanagement.model.ProductStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/productstatus")

public interface ProductStatusApi {
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> saveProductStatus(@RequestBody ProductStatus productStatus);

    @GetMapping(value = "/{orderId}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductStatusDto>> displayProductStatus(@PathVariable String orderId);

    @PutMapping(value = "/{orderId}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductStatus>> modifyProductStatus(@PathVariable String orderId);
}
