package com.oguzhankurt.homework2.mapper;


import com.oguzhankurt.homework2.dto.customer.CustomerDTO;
import com.oguzhankurt.homework2.dto.customer.CustomerSaveRequest;
import com.oguzhankurt.homework2.dto.customer.CustomerUpdateRequest;
import com.oguzhankurt.homework2.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer convertToCustomer(CustomerSaveRequest request);
    Customer convertToCustomer(CustomerUpdateRequest request);
    CustomerDTO convertToCustomerDTO(Customer customer);
    List<CustomerDTO> convertToCustomerDTOList(List<Customer> customerList);
}
