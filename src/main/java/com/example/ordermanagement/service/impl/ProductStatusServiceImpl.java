package com.example.ordermanagement.service.impl;

import com.example.ordermanagement.dto.ProductStatusDto;
import com.example.ordermanagement.exception.ResourceNotFound;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.model.ProductStatus;
import com.example.ordermanagement.repository.OrderRepository;
import com.example.ordermanagement.repository.ProductStatusRepository;
import com.example.ordermanagement.service.ProductStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.ordermanagement.model.ProductStatus.Status.*;

@Service
public class ProductStatusServiceImpl implements ProductStatusService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductStatusRepository productStatusRepository;

    public static final String E404= "not found" ;

    @Override
    public void saveProductStatus(ProductStatus productStatus) {
        Optional<Order> orderIdExists = orderRepository.findById(productStatus.getOrderId());
        if(!orderIdExists.isPresent()){
            throw new ResourceNotFound(E404);
        }
        productStatus.setProductStatus(ProductStatus.Status.REQUESTED);
        productStatus.setStatusUpdatedDate(LocalDateTime.now());
        productStatusRepository.save(productStatus);
    }

    @Override
    public List<ProductStatusDto> displayProductStatus(String orderId) {
        return productStatusRepository.findByOrderId(orderId).stream()
                .map(this::getDetails)
                .collect(Collectors.toList());
    }

    private ProductStatusDto getDetails(ProductStatus productStatus){
        ProductStatusDto productStatusDto = new ProductStatusDto();
        productStatusDto.setOrderId(productStatus.getOrderId());
        productStatusDto.setProductStatus(productStatus.getProductStatus());
        productStatusDto.setStatusUpdatedDate(productStatus.getStatusUpdatedDate());
        return productStatusDto;
    }

    @Override
    public List<ProductStatus> modifyProductStatus(String orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        String buyerId = order.get().getBuyerId();
        switch (order.get().getProductStatus()){
            case REQUESTED :
                productStatusRepository.save(new ProductStatus(orderId, buyerId,ORDER_CONFIRMED));
                order.get().setBuyerId(order.get().getBuyerId());
                order.get().setProductStatus(ORDER_CONFIRMED);
                orderRepository.save(order.get());
                break;
            case ORDER_CONFIRMED:
                productStatusRepository.save(new ProductStatus(orderId,buyerId,ProductStatus.Status.READY_TO_SHIP));
                order.get().setProductStatus(READY_TO_SHIP);
                orderRepository.save(order.get());
                break;
            case READY_TO_SHIP:
                productStatusRepository.save(new ProductStatus(orderId,buyerId,ProductStatus.Status.POD_UPLOADED));
                order.get().setProductStatus(POD_UPLOADED);
                orderRepository.save(order.get());
                break;
            case POD_UPLOADED:
                productStatusRepository.save(new ProductStatus(orderId,buyerId,ProductStatus.Status.BUYER_APPROVED));
                order.get().setProductStatus(BUYER_APPROVED);
                orderRepository.save(order.get());
                break;
            case BUYER_APPROVED:
                productStatusRepository.save(new ProductStatus(orderId,buyerId,ProductStatus.Status.PAYMENT_PROCESSED));
                order.get().setProductStatus(PAYMENT_PROCESSED);
                orderRepository.save(order.get());
                break;
        }
        return null;
    }
}
