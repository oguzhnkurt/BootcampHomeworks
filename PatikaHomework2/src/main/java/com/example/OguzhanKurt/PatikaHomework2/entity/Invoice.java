package com.example.OguzhanKurt.PatikaHomework2.entity;
import com.example.OguzhanKurt.PatikaHomework2.general.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Invoice")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Invoice extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Long customerId;
    private Double amount;
    private Long orderId;
    private String name;

    public Invoice(LocalDate now, long l, double v, long l1, String banka) {
        super();
    }
}
