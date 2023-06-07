package com.example.OguzhanKurt.PatikaHomework2.controller.contract.impl;

import com.example.OguzhanKurt.PatikaHomework2.controller.contract.InvoiceControllerContract;
import com.example.OguzhanKurt.PatikaHomework2.dto.invoice.InvoiceDTO;
import com.example.OguzhanKurt.PatikaHomework2.dto.invoice.InvoiceSaveRequestDTO;
import com.example.OguzhanKurt.PatikaHomework2.entity.Invoice;
import com.example.OguzhanKurt.PatikaHomework2.mapper.InvoiceMapper;
import com.example.OguzhanKurt.PatikaHomework2.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceControllerContractImpl implements InvoiceControllerContract {
    private final InvoiceService invoiceEntityService;


    public InvoiceControllerContractImpl(InvoiceService invoiceEntityService) {
        this.invoiceEntityService = invoiceEntityService;
    }


    @Override
    public void add(InvoiceSaveRequestDTO request) {
        Invoice invoice = InvoiceMapper.INSTANCE.toInvoice(request);
        invoiceEntityService.add(invoice);

    }

    @Override
    public List<InvoiceDTO> findAll() {
        List<InvoiceDTO> invoiceList = InvoiceMapper.INSTANCE.toInvoiceDtoList(invoiceEntityService.getAll());
        return invoiceList;
    }

    @Override
    public void delete(InvoiceDTO invoiceDTO) {

    }

    @Override
    public void delete(InvoiceSaveRequestDTO invoiceSaveRequestDTO) {
        Invoice invoice = InvoiceMapper.INSTANCE.toInvoice(invoiceSaveRequestDTO);
        invoiceEntityService.remove(invoice);
    }

    @Override
    public Double sumInvoiceSumByJune() {
        Double invoiceSumByJune = invoiceEntityService.sumInvoiceSumByJune();
        return invoiceSumByJune;
    }

    @Override
    public List<InvoiceDTO> findAllInvoiceByAmount() {
        List<InvoiceDTO> invoiceList = InvoiceMapper.INSTANCE.toInvoiceDtoList(invoiceEntityService.findAllInvoiceByAmount());
        return invoiceList;

    }

    @Override
    public Double findAverageInvoiceSumByAmount() {
        Double invoiceAverageByAmount = invoiceEntityService.findAverageInvoiceSumByAmount();
        return invoiceAverageByAmount;
    }

    @Override
    public List<String> findCustomerNameByAmount() {
        List<String> invoiceList = invoiceEntityService.findCustomerNameByAmount();
        return invoiceList;
    }

    @Override
    public List<String> findCustomerSectorByAmount() {
        List<String> invoiceList = invoiceEntityService.findCustomerSectorByAmount();
        return invoiceList;
    }
}