package com.example.OguzhanKurt.PatikaHomework2.mapper;

import com.example.OguzhanKurt.PatikaHomework2.dto.customer.CustomerDTO;
import com.example.OguzhanKurt.PatikaHomework2.dto.customer.CustomerSaveRequestDTO;
import com.example.OguzhanKurt.PatikaHomework2.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CustomerMapper {
    CustomerMapper INSTANCE=Mappers.getMapper(CustomerMapper.class);


    CustomerDTO toCustomerDTO (Customer customer);

    Customer toCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

    List<CustomerDTO> toCustomerDtoList(List<Customer> customerList);


}