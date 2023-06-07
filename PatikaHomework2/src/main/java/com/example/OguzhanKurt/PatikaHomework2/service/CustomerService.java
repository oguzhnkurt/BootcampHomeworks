package com.example.OguzhanKurt.PatikaHomework2.service;


import com.example.OguzhanKurt.PatikaHomework2.entity.Customer;
import com.example.OguzhanKurt.PatikaHomework2.general.BaseEntityService;
import com.example.OguzhanKurt.PatikaHomework2.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService extends BaseEntityService<Customer> implements CustomerRepository {

    public CustomerService(List<Customer> items) {
        super(items);
    }

    @Override
    public List<Customer> findAllCustomersByNameStartswithC() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Akbank", "akbank@gmail.com","05052344600","Banka"));
        customers.add(new Customer("Ceviz" ,"cemalceviz@gmail.com","05322884896","Kuruyemiş"));
        customers.add(new Customer("Ceylin Su", "ceylinsu@gmail.com","05065841234","Gıda"));
        customers.add(new Customer("Patika", "patika@gmail.com","05159848724","Development"));
        List<Customer> filteredCustomer = new ArrayList<>();
        customers.stream()
                .filter(customer -> customer.getName().contains("C"))
                .forEach(customer -> filteredCustomer.add(customer));
        return filteredCustomer;
    }
}