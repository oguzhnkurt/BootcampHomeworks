package com.oguzhankurt.homework2.mapper;

import com.oguzhankurt.homework2.dto.comment.CommentDTO;
import com.oguzhankurt.homework2.dto.comment.CommentDTO2;
import com.oguzhankurt.homework2.dto.comment.CommentSaveRequest;
import com.oguzhankurt.homework2.dto.customer.CustomerUpdateRequest;
import com.oguzhankurt.homework2.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment convertToComment(CommentSaveRequest request);
    Comment convertToComment(CustomerUpdateRequest request);
    CommentDTO convertToCommentDTO(Comment comment);
    List<CommentDTO> converToCommentDTOList(List<Comment> commentList);

    CommentDTO2 converToCommentDTO2(Comment comment);
}
