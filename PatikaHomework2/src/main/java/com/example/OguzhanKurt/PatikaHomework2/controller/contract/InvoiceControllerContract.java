package com.example.OguzhanKurt.PatikaHomework2.controller.contract;
import com.example.OguzhanKurt.PatikaHomework2.dto.customer.CustomerDTO;
import com.example.OguzhanKurt.PatikaHomework2.dto.customer.CustomerSaveRequestDTO;
import com.example.OguzhanKurt.PatikaHomework2.dto.invoice.InvoiceDTO;
import com.example.OguzhanKurt.PatikaHomework2.dto.invoice.InvoiceSaveRequestDTO;
import com.example.OguzhanKurt.PatikaHomework2.entity.Invoice;

import java.util.List;

public interface InvoiceControllerContract {
    void add(InvoiceSaveRequestDTO request);
    List<InvoiceDTO> findAll();

    void delete(InvoiceDTO invoiceDTO);

    void delete(InvoiceSaveRequestDTO invoiceSaveRequestDTO);

    Double sumInvoiceSumByJune();
    List<InvoiceDTO> findAllInvoiceByAmount();

    Double findAverageInvoiceSumByAmount();

    List<String> findCustomerNameByAmount();
    List<String> findCustomerSectorByAmount();
}