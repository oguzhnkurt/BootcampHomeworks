package com.oguzhankurt.homework2.controller.contract.impl;


import com.oguzhankurt.homework2.controller.contract.CustomerControllerContract;
import com.oguzhankurt.homework2.dto.customer.CustomerDTO;
import com.oguzhankurt.homework2.dto.customer.CustomerDeleteRequest;
import com.oguzhankurt.homework2.dto.customer.CustomerSaveRequest;
import com.oguzhankurt.homework2.dto.customer.CustomerUpdateRequest;
import com.oguzhankurt.homework2.entity.Customer;
import com.oguzhankurt.homework2.mapper.CustomerMapper;
import com.oguzhankurt.homework2.service.entityservice.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerControllerContractImpl implements CustomerControllerContract {
    private final CustomerEntityService service;

    @Override
    public CustomerDTO save(CustomerSaveRequest request) {
        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);
        customer=service.save(customer);
        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customers = service.findAll();
        return CustomerMapper.INSTANCE.convertToCustomerDTOList(customers);
    }

    @Override
    public CustomerDTO findById(Long id) {
        Customer customer = service.findByIdWithControl(id);
        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }

    @Override
    public void delete(CustomerDeleteRequest request) {
        service.delete(request);
    }

    @Override
    public CustomerDTO findByUsername(String username) {
        Customer customer = service.findByUsername(username);
        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }

    @Override
    public CustomerDTO update(Long id, CustomerUpdateRequest request) {
        Customer customer = service.update(id, request);
        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }
}
