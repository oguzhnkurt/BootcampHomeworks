package com.example.OguzhanKurt.PatikaHomework2.entity;
import com.example.OguzhanKurt.PatikaHomework2.general.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Product extends BaseEntity {
    private String name;
    private String price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}