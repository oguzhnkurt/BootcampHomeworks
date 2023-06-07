package com.oguzhankurt.homework2.controller.contract;



import com.oguzhankurt.homework2.dto.comment.CommentDTO;
import com.oguzhankurt.homework2.dto.comment.CommentSaveRequest;

import java.util.List;

public interface CommentControllerContract {
    CommentDTO save(CommentSaveRequest request);

    List<CommentDTO> findAll();

    CommentDTO findById(Long id);

    void delete(Long id);

    List<CommentDTO> findAllByProductId(Long id);
    List<CommentDTO> findAllByCustomerId(Long id);
}
