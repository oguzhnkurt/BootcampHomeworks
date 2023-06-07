package com.example.OguzhanKurt.PatikaHomework2.repository;

import com.example.OguzhanKurt.PatikaHomework2.entity.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public interface CustomerRepository {
    List<Customer> findAllCustomersByNameStartswithC();

}