package com.example.OguzhanKurt.PatikaHomework2.dto.invoice;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class InvoiceSaveRequestDTO {
    @Id
    private Long customerId;

    private LocalDate date;
    private Double amount;
    private Long orderId;
    private String name;
}
