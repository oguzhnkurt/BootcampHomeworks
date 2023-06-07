package com.example.OguzhanKurt.PatikaHomework2.service;

import com.example.OguzhanKurt.PatikaHomework2.entity.Customer;
import com.example.OguzhanKurt.PatikaHomework2.entity.Invoice;
import com.example.OguzhanKurt.PatikaHomework2.general.BaseEntityService;
import com.example.OguzhanKurt.PatikaHomework2.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class InvoiceService extends BaseEntityService<Invoice> implements InvoiceRepository {
    public InvoiceService(List<Invoice> items) {
        super(items);
    }

    @Override
    public Double sumInvoiceSumByJune() {
        List<Invoice> invoices = new ArrayList<>();

        invoices.add(new Invoice(LocalDate.now(), 3L,35.5, 2L,"Banka"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1500.5, 1L,"Kuruyemiş"));
        invoices.add(new Invoice(LocalDate.now(), 1L,300.5, 1L,"Gıda"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1700.0, 1L,"Development"));
        List<Customer> filteredCustomer = new ArrayList<>();
        Double juneTotal = invoices.stream()
                .filter(invoice -> invoice.getDate().getMonth() == LocalDate.of(2023, 6, 1).getMonth())
                .mapToDouble(Invoice::getAmount)
                .sum();
        return juneTotal;
    }
    @Override
    public List<Invoice> findAllInvoiceByAmount() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(LocalDate.now(), 1L,120.5, 1L,"Banka"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1500.5, 1L,"Kuruyemiş"));
        invoices.add(new Invoice(LocalDate.now(), 1L,300.5, 1L,"Gıda"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1700.0, 1L,"Development"));
        List<Invoice> filteredInvoice = new ArrayList<>();
        invoices.stream()
                .filter(invoice -> invoice.getAmount() > 1500)
                .forEach(invoice -> filteredInvoice.add(invoice));
        return filteredInvoice;

    }
    @Override
    public Double findAverageInvoiceSumByAmount() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(LocalDate.now(), 1L,120.5, 1L,"Banka"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1500.5, 1L,"Kuruyemiş"));
        invoices.add(new Invoice(LocalDate.now(), 1L,300.5, 1L,"Gıda"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1700.0, 1L,"Development"));
        List<Customer> filteredCustomer = new ArrayList<>();
        double average = invoices.stream()
                .filter(invoice -> invoice.getAmount() > 1500)
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0);
        return average;
    }
    @Override
    public List<String> findCustomerNameByAmount() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(LocalDate.now(), 1L,120.5, 1L,"Banka"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1500.5, 1L,"Kuruyemiş"));
        invoices.add(new Invoice(LocalDate.now(), 1L,300.5, 1L,"Gıda"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1700.0, 1L,"Development"));

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Akbank", "akbank@gmail.com","05052344600","Banka"));
        customers.add(new Customer("Ceviz" ,"cemalceviz@gmail.com","05322884896","Kuruyemiş"));
        customers.add(new Customer("Ceylin Su", "ceylinsu@gmail.com","05065841234","Gıda"));
        customers.add(new Customer("Patika", "patika@gmail.com","05159848724","Development"));
        List<String> filteredInvoice = new ArrayList<>();
        invoices.stream()
                .filter(invoice -> invoice.getAmount() < 500)
                .map(invoice -> customers.stream()
                        .filter(customer -> customer.getName().equals(invoice.getName()))
                        .findFirst()
                        .orElse(null))
                .filter(Objects::nonNull)
                .forEach(customer -> filteredInvoice.add(customer.getName()));
        return filteredInvoice;

    }
    @Override
    public List<String> findCustomerSectorByAmount() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(LocalDate.now(), 1L,120.5, 1L,"Banka"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1500.5, 1L,"Kuruyemiş"));
        invoices.add(new Invoice(LocalDate.now(), 1L,300.5, 1L,"Gıda"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1700.0, 1L,"Development"));

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Akbank", "akbank@gmail.com","05052344600","Banka"));
        customers.add(new Customer("Ceviz" ,"cemalceviz@gmail.com","05322884896","Kuruyemiş"));
        customers.add(new Customer("Ceylin Su", "ceylinsu@gmail.com","05065841234","Gıda"));
        customers.add(new Customer("Patika", "patika@gmail.com","05159848724","Development"));
        List<String> filteredInvoice = new ArrayList<>();
        customers.stream()
                .filter(customer -> invoices.stream()
                        .filter(invoice -> invoice.getDate().getMonth() == LocalDate.of(2023, 6, 1).getMonth())
                        .mapToDouble(Invoice::getAmount)
                        .average()
                        .orElse(0) < 750)
                .distinct()
                .forEach(customer -> filteredInvoice.add(customer.getName()));
        return filteredInvoice;
    }
}