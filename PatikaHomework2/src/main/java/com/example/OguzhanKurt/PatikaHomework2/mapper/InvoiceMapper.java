package com.example.OguzhanKurt.PatikaHomework2.mapper;

import com.example.OguzhanKurt.PatikaHomework2.dto.invoice.InvoiceDTO;
import com.example.OguzhanKurt.PatikaHomework2.dto.invoice.InvoiceSaveRequestDTO;
import com.example.OguzhanKurt.PatikaHomework2.entity.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)


public interface InvoiceMapper {
    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);

    List<InvoiceDTO> toInvoiceDtoList(List<Invoice> invoiceList);

    Invoice toInvoice(InvoiceSaveRequestDTO invoiceSaveRequestDto);

    InvoiceDTO toInvoiceDTO(Invoice invoice);

}
