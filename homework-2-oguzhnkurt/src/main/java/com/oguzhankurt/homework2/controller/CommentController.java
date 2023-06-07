package com.oguzhankurt.homework2.controller;

import com.oguzhankurt.homework2.controller.contract.CommentControllerContract;
import com.oguzhankurt.homework2.dto.comment.CommentDTO;
import com.oguzhankurt.homework2.dto.comment.CommentSaveRequest;
import com.oguzhankurt.homework2.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentControllerContract commentControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<CommentDTO>> save(@RequestBody CommentSaveRequest request){
        CommentDTO comment = commentControllerContract.save(request);
        return ResponseEntity.ok(RestResponse.of(comment));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<CommentDTO>>> findAll(){
        List<CommentDTO> comments = commentControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(comments));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<RestResponse<List<CommentDTO>>> findAllByProductId(@PathVariable Long id){
        List<CommentDTO> comments = commentControllerContract.findAllByProductId(id);
        return ResponseEntity.ok(RestResponse.of(comments));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<RestResponse<List<CommentDTO>>> findAll(@PathVariable Long id){
        List<CommentDTO> comments = commentControllerContract.findAllByCustomerId(id);
        return ResponseEntity.ok(RestResponse.of(comments));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id){
        commentControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
