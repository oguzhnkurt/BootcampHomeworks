package com.example.OguzhanKurt.PatikaHomework2.entity;
import com.example.OguzhanKurt.PatikaHomework2.general.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CUSTOMER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String sectorTitle;
    private String phoneNumber;


    public Customer(String name, String mail, String sectorTitle, String phoneNumber) {
        super();
    }
}