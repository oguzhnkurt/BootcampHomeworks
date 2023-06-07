package com.example.OguzhanKurt.PatikaHomework2.controller.contract.impl;

import com.example.OguzhanKurt.PatikaHomework2.controller.contract.CustomerControllerContract;
import com.example.OguzhanKurt.PatikaHomework2.dto.customer.CustomerDTO;
import com.example.OguzhanKurt.PatikaHomework2.dto.customer.CustomerSaveRequestDTO;
import com.example.OguzhanKurt.PatikaHomework2.entity.Customer;
import com.example.OguzhanKurt.PatikaHomework2.mapper.CustomerMapper;
import com.example.OguzhanKurt.PatikaHomework2.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerControllerContractImpl implements CustomerControllerContract {
    private final CustomerService customerService;

    @Override
    public void add(CustomerSaveRequestDTO request) {
        Customer customer = CustomerMapper.INSTANCE.toCustomer(request);
        customerService.add(customer);
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<CustomerDTO> customerList = CustomerMapper.INSTANCE.toCustomerDtoList(customerService.getAll());
        return customerList;
    }

    @Override
    public void delete(CustomerDTO customerDTO) {

    }


    @Override
    public void delete(CustomerSaveRequestDTO customerSaveRequestDTO) {

        Customer customer = CustomerMapper.INSTANCE.toCustomer(customerSaveRequestDTO);
        customerService.remove(customer);
    }

    @Override
    public List<CustomerDTO> findAllCustomersByNameStartswithC() {
        List<CustomerDTO> customerList = CustomerMapper.INSTANCE.toCustomerDtoList(customerService.findAllCustomersByNameStartswithC());

        return customerList;
    }
}