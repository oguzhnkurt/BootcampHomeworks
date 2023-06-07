package com.example.OguzhanKurt.PatikaHomework2.entity;

import com.example.OguzhanKurt.PatikaHomework2.general.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ORDER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Order extends BaseEntity {
    private Long productId;
    private Long customerId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}


