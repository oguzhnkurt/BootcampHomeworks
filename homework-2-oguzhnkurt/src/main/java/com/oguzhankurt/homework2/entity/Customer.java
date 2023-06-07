package com.oguzhankurt.homework2.entity;

import com.oguzhankurt.homework2.general.BaseEntity;
import com.oguzhankurt.homework2.enums.EnumStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(generator = "Customer", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Customer", sequenceName = "CUSTOMER_ID_SEQ")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surname;

    @NotBlank
    @Column(name = "USERNAME", length = 50, nullable = false,unique = true)
    private String username;

    @Email
    @Column(name = "EMAIL", length = 50,nullable = false,unique = true)
    private String email;

    @Column(name = "PHONE",length = 50,nullable = false,unique = true)
    private String phone;

    @Column(name = "TYPE",length = 30)
    @Enumerated(EnumType.STRING)
    private EnumStatus type;
}
