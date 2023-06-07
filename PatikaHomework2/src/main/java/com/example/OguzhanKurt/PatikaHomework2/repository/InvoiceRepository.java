package com.example.OguzhanKurt.PatikaHomework2.repository;

import com.example.OguzhanKurt.PatikaHomework2.entity.Customer;
import com.example.OguzhanKurt.PatikaHomework2.entity.Invoice;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public interface InvoiceRepository {
    Double sumInvoiceSumByJune();
    List<Invoice> findAllInvoiceByAmount();
    Double findAverageInvoiceSumByAmount();
    List<String> findCustomerNameByAmount();
    List<String> findCustomerSectorByAmount();

}