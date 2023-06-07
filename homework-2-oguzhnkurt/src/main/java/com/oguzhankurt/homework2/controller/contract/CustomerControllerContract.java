package com.oguzhankurt.homework2.controller.contract;

import com.oguzhankurt.homework2.dto.customer.CustomerDTO;
import com.oguzhankurt.homework2.dto.customer.CustomerDeleteRequest;
import com.oguzhankurt.homework2.dto.customer.CustomerSaveRequest;
import com.oguzhankurt.homework2.dto.customer.CustomerUpdateRequest;

import java.util.List;

public interface CustomerControllerContract {

    CustomerDTO save(CustomerSaveRequest request);

    List<CustomerDTO> findAll();

    CustomerDTO findById(Long id);

    void delete(CustomerDeleteRequest request);
    CustomerDTO findByUsername(String username);
    CustomerDTO update(Long id, CustomerUpdateRequest request);
}
