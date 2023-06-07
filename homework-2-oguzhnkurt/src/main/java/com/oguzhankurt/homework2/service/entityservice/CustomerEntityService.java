package com.oguzhankurt.homework2.service.entityservice;

import com.oguzhankurt.homework2.repository.CustomerRepository;
import com.oguzhankurt.homework2.dto.customer.CustomerDeleteRequest;
import com.oguzhankurt.homework2.dto.customer.CustomerUpdateRequest;
import com.oguzhankurt.homework2.entity.Customer;
import com.oguzhankurt.homework2.general.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerEntityService extends BaseEntityService<Customer, CustomerRepository> {
    private final CustomerRepository repository;
    public CustomerEntityService(CustomerRepository repository, CustomerRepository repository1) {
        super(repository);
        this.repository = repository1;
    }

    public void delete(CustomerDeleteRequest request){
        Customer customer = repository.findCustomerByUsername(request.username());
        if(Objects.equals(customer.getPhone(), request.phoneNumber()))
            repository.deleteById(customer.getId());
    }

    public Customer findByUsername(String username){
        return repository.findCustomerByUsername(username);
    }

    public Customer update(Long id,CustomerUpdateRequest request){
        Customer customer = repository.findById(id).orElseThrow();
        customer.setEmail(request.email());
        customer.setUsername(request.username());
        customer.setPhone(request.phone());
        repository.save(customer);
        return customer;
    }
}
