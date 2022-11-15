package com.example.ordermanagement.repository;

import com.example.ordermanagement.model.PopUpComment;
import com.example.ordermanagement.model.ProductStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PopUpCommentRepository extends MongoRepository<PopUpComment,String> {
    List<PopUpComment> findByOrderId(String orderId);
    List<PopUpComment> findByStatusId(ProductStatus.Status statusId);
    Optional<PopUpComment> getPopUpCommentByOrderIdAndStatusId(String orderId, ProductStatus.Status statusId);


}
