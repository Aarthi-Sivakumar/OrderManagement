package com.example.ordermanagement.controller;

import com.example.ordermanagement.api.ProductApi;
import com.example.ordermanagement.model.Product;
import com.example.ordermanagement.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController implements ProductApi {

    ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @Override
    public ResponseEntity<List<Product>> getProduct() {
        return new ResponseEntity<>(productService.displayProducts(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> savePrducts(Product product) {
        productService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
