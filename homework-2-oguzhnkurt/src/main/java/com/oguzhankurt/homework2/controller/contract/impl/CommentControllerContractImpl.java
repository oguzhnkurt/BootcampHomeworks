package com.oguzhankurt.homework2.controller.contract.impl;

import com.oguzhankurt.homework2.controller.contract.CommentControllerContract;
import com.oguzhankurt.homework2.dto.comment.CommentDTO;
import com.oguzhankurt.homework2.dto.comment.CommentSaveRequest;
import com.oguzhankurt.homework2.entity.Comment;
import com.oguzhankurt.homework2.mapper.CommentMapper;
import com.oguzhankurt.homework2.service.entityservice.CommentEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentControllerContractImpl implements CommentControllerContract {
    private final CommentEntityService service;

    @Override
    public CommentDTO save(CommentSaveRequest request) {
        Comment comment = CommentMapper.INSTANCE.convertToComment(request);
        comment=service.save(comment);
        return CommentMapper.INSTANCE.convertToCommentDTO(comment);
    }

    @Override
    public List<CommentDTO> findAll() {
        return CommentMapper.INSTANCE.converToCommentDTOList(service.findAll());
    }

    @Override
    public CommentDTO findById(Long id) {
        return CommentMapper.INSTANCE.convertToCommentDTO(service.findByIdWithControl(id));
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }

    @Override
    public List<CommentDTO> findAllByProductId(Long id) {
        return CommentMapper.INSTANCE.converToCommentDTOList(service.findAllByProductId(id));
    }

    @Override
    public List<CommentDTO> findAllByCustomerId(Long id) {
        return CommentMapper.INSTANCE.converToCommentDTOList(service.findAllByCustomerId(id));
    }
}
