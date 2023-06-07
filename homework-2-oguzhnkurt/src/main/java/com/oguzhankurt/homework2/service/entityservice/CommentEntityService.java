package com.oguzhankurt.homework2.service.entityservice;

import com.oguzhankurt.homework2.repository.CommentRepository;
import com.oguzhankurt.homework2.entity.Comment;
import com.oguzhankurt.homework2.general.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentEntityService extends BaseEntityService<Comment, CommentRepository> {
    private final CommentRepository commentRepository;
    public CommentEntityService(CommentRepository repository, CommentRepository commentRepository) {
        super(repository);
        this.commentRepository = commentRepository;
    }
    public List<Comment> findAllByProductId(Long id){
        return commentRepository.findAllByProductId(id);
    }
    public List<Comment> findAllByCustomerId(Long id){
        return commentRepository.findAllByCustomerId(id);
    }
}

