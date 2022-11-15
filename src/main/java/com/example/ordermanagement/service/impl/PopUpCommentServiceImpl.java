package com.example.ordermanagement.service.impl;

import com.example.ordermanagement.exception.ResourceNotFound;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.model.PopUpComment;
import com.example.ordermanagement.model.ProductStatus;
import com.example.ordermanagement.model.User;
import com.example.ordermanagement.repository.OrderRepository;
import com.example.ordermanagement.repository.PopUpCommentRepository;
import com.example.ordermanagement.service.PopUpCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PopUpCommentServiceImpl implements PopUpCommentService {
    @Autowired
    PopUpCommentRepository popUpCommentRepository;

    public PopUpCommentServiceImpl(PopUpCommentRepository popUpCommentRepository){
        this.popUpCommentRepository=popUpCommentRepository;
    }
    @Autowired
    OrderRepository orderRepository;

    public static final String E404= "not found";

    @Override
    public void savePopUpComment(String orderid, String comment) {
        Optional<Order> orderIdExists = orderRepository.findById(orderid);
        if(!orderIdExists.isPresent()){
            throw new ResourceNotFound(E404);
        }
        PopUpComment popUpComment=new PopUpComment();
        popUpComment.setOrderId(orderid);
        popUpComment.setAddedDate(LocalDateTime.now());
        popUpComment.setAddedBy(User.Category.SELLER);
        popUpComment.setStatusId(orderIdExists.get().getProductStatus());
        popUpComment.setComment(comment);
        popUpCommentRepository.save(popUpComment);
    }

    @Override
    public List<PopUpComment> getPopUpCommentByOrderId(String orderid) {
        List<PopUpComment> getCommentByOrderId = popUpCommentRepository.findByOrderId(orderid);
        return getCommentByOrderId;
    }

    @Override
    public List<PopUpComment> modifyPopUpComment(String orderid, ProductStatus.Status statusid, String modifiedComment) {
        Optional<PopUpComment> popUpCommentByOrderIdAndStatusId = popUpCommentRepository.getPopUpCommentByOrderIdAndStatusId(orderid, statusid);
        popUpCommentByOrderIdAndStatusId.get().setComment(modifiedComment);
        popUpCommentByOrderIdAndStatusId.get().setModifiedBy(User.Category.SELLER);
        popUpCommentByOrderIdAndStatusId.get().setModifiedDate(LocalDateTime.now());
        popUpCommentRepository.save(popUpCommentByOrderIdAndStatusId.get());
        return List.of(popUpCommentByOrderIdAndStatusId.get());
    }

    @Override
    public void deleteComment(String orderid, ProductStatus.Status statusid) {
        Optional<PopUpComment> deleteByOrderIdAndStatusId = popUpCommentRepository.getPopUpCommentByOrderIdAndStatusId(orderid,statusid);
        deleteByOrderIdAndStatusId.get().setComment(null);
        deleteByOrderIdAndStatusId.get().setDeletedBy(User.Category.SELLER);
        deleteByOrderIdAndStatusId.get().setDeletedDate(LocalDateTime.now());
        popUpCommentRepository.save(deleteByOrderIdAndStatusId.get());
    }
}
