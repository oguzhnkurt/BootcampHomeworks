package com.oguzhankurt.homework2.dto.comment;

public record CommentSaveRequest(Long customerId,
                                 Long productId,
                                 String comment,
                                 String title) {

}
