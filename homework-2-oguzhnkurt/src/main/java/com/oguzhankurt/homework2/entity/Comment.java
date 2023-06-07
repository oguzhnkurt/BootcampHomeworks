package com.oguzhankurt.homework2.entity;


import com.oguzhankurt.homework2.general.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "COMMENT")
@Getter
@Setter
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(generator = "Comment", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Comment", sequenceName = "COMMENT_ID_SEQ")
    private Long id;

    @Column(name = "PRODUCT_ID", length = 100, nullable = false)
    private Long productId;

    @Column(name = "CUSTOMER_ID", length = 100, nullable = false)
    private Long customerId;

    @Column(name = "COMMENT", length = 500, nullable = false)
    private String comment;

    @Column(name = "TITLE", length = 100, nullable = false)
    private String title;
}
