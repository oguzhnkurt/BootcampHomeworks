package com.oguzhankurt.homework2.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO2 {
    Long id;
    Long customerId;
    Long productId;
    String comment;
    String title;
}
