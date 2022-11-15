package com.example.ordermanagement.api;

import com.example.ordermanagement.model.PopUpComment;
import com.example.ordermanagement.model.ProductStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/comment")
public interface PopUpCommentApi {
    @PostMapping(value = "/{orderid}",produces = {MediaType.APPLICATION_JSON_VALUE},consumes =
            {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> saveComment(@PathVariable String orderid,@RequestBody String comment);

    @GetMapping(value = "/{orderid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PopUpComment>> getComments(@PathVariable String orderid);

    @PutMapping(value = "/{orderid}/{statusid}",produces = {MediaType.APPLICATION_JSON_VALUE},
    consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PopUpComment>> modifyComment(@PathVariable String orderid, @PathVariable
    ProductStatus.Status statusid, @RequestBody String modifiedComment);

    @DeleteMapping(value = "/{orderid}/{statusid}")
    public ResponseEntity<String> deleteComment(@PathVariable String orderid,@PathVariable ProductStatus.Status statusid);
}
