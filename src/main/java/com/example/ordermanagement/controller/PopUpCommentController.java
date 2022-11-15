package com.example.ordermanagement.controller;

import com.example.ordermanagement.api.PopUpCommentApi;
import com.example.ordermanagement.model.PopUpComment;
import com.example.ordermanagement.model.ProductStatus;
import com.example.ordermanagement.service.PopUpCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PopUpCommentController implements PopUpCommentApi {
    PopUpCommentService popUpCommentService;

    public PopUpCommentController(PopUpCommentService popUpCommentService){
        this.popUpCommentService=popUpCommentService;
    }

    @Override
    public ResponseEntity<Void> saveComment(String orderid,String comment) {
        popUpCommentService.savePopUpComment(orderid,comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PopUpComment>> getComments(String orderid) {
        return new ResponseEntity<>(popUpCommentService.getPopUpCommentByOrderId(orderid),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PopUpComment>> modifyComment(String orderid, ProductStatus.Status
            statusid,String modifiedComment) {
        return new ResponseEntity<>(popUpCommentService.modifyPopUpComment(orderid,statusid,modifiedComment), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteComment(String orderid, ProductStatus.Status statusid) {
        popUpCommentService.deleteComment(orderid,statusid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
