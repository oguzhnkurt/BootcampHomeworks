package com.example.OguzhanKurt.PatikaHomework2.controller.contract;

import com.example.OguzhanKurt.PatikaHomework2.dto.customer.CustomerDTO;
import com.example.OguzhanKurt.PatikaHomework2.dto.customer.CustomerSaveRequestDTO;

import java.util.List;

public interface CustomerControllerContract {
    void add(CustomerSaveRequestDTO request);
    List<CustomerDTO> findAll();

    void delete(CustomerDTO customerDTO);

    void delete(CustomerSaveRequestDTO customerSaveRequestDTO);

    List<CustomerDTO> findAllCustomersByNameStartswithC();

}