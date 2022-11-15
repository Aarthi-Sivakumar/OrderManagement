package com.example.ordermanagement.service;

import com.example.ordermanagement.model.PopUpComment;
import com.example.ordermanagement.model.ProductStatus;

import java.util.List;

public interface PopUpCommentService {
    void savePopUpComment(String orderid,String comment);

    List<PopUpComment> getPopUpCommentByOrderId(String orderid);

    List<PopUpComment> modifyPopUpComment(String orderid, ProductStatus.Status statusid,String modifiedComment);

    void deleteComment(String orderid, ProductStatus.Status statusid);
}
