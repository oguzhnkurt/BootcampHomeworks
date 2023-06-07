package com.oguzhankurt.homework2.repository;

import com.oguzhankurt.homework2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findCustomerByUsername(String username);
}
