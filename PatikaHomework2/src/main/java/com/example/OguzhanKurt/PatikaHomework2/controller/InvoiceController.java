package com.example.OguzhanKurt.PatikaHomework2.controller;

import com.example.OguzhanKurt.PatikaHomework2.controller.contract.InvoiceControllerContract;
import com.example.OguzhanKurt.PatikaHomework2.dto.invoice.InvoiceDTO;
import com.example.OguzhanKurt.PatikaHomework2.dto.invoice.InvoiceSaveRequestDTO;
import com.example.OguzhanKurt.PatikaHomework2.general.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {
    private final InvoiceControllerContract invoiceControllerContract;

    @Autowired
    public InvoiceController(InvoiceControllerContract invoiceControllerContract) {
        this.invoiceControllerContract = invoiceControllerContract;
    }

    @PostMapping
    public ResponseEntity<RestResponse<InvoiceSaveRequestDTO>> add(@RequestBody InvoiceSaveRequestDTO invoiceSaveRequest) {
        try {
            invoiceControllerContract.add(invoiceSaveRequest);
            return ResponseEntity.ok(RestResponse.success(invoiceSaveRequest,"Fatura başarıyla eklendi."));
        } catch (Exception ex) {
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }

    }


    @GetMapping
    public ResponseEntity<RestResponse<List<InvoiceDTO>>> findAll() {
        var invoiceDTOList = invoiceControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(invoiceDTOList));
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<Object>> delete(@RequestBody InvoiceDTO invoiceDTO) {
        try {
            invoiceControllerContract.delete(invoiceDTO);
            return ResponseEntity.ok(RestResponse.emptySuccess("Fatura başarıyla silindi"));
        } catch (Exception ex) {
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }

    }
    //Haziran ayında kayıt olan müşterilerin faturalarının toplam tutarı
    @GetMapping("/sumInvoiceSumByJune")
    public ResponseEntity<RestResponse<Double>> sumInvoiceSumByJune(){
        try {
            Double invoiceSum = invoiceControllerContract.sumInvoiceSumByJune();
            return ResponseEntity.ok(RestResponse.success(invoiceSum,"Haziran ayında kayıt olan müşterilerin faturalarının toplam tutarı : "+invoiceSum));
        } catch (Exception ex) {
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }
    }
    //Sistemdeki 1500TL üstündeki faturalar
    @GetMapping("/findAllInvoiceByAmount")
    public ResponseEntity<RestResponse<List<InvoiceDTO>>> findAllInvoiceByAmount(){
        try {
            List<InvoiceDTO> invoiceList = invoiceControllerContract.findAllInvoiceByAmount();
            return ResponseEntity.ok(RestResponse.success(invoiceList,"Sistemdeki 1500TL üstündeki faturalar listelendi."));
        } catch (Exception ex) {
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }
    }

    //1500TL üstündeki faturaların ortalaması
    @GetMapping("/findAverageInvoiceSumByAmount")
    public ResponseEntity<RestResponse<Double>> findAverageInvoiceSumByAmount(){
        try {
            Double invoiceAverageAmount = invoiceControllerContract.findAverageInvoiceSumByAmount();
            return ResponseEntity.ok(RestResponse.success(invoiceAverageAmount,"1500TL üstündeki faturaların ortalaması: : "+invoiceAverageAmount));
        } catch (Exception ex) {
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }
    }
    //500TL altındaki faturalara sahip müşterilerin isimleri
    @GetMapping("/findCustomerNameByAmount")
    public ResponseEntity<RestResponse<List<String>>> findCustomerNameByAmount(){
        try {
            List<String> invoiceList = invoiceControllerContract.findCustomerNameByAmount();
            return ResponseEntity.ok(RestResponse.success(invoiceList,"500TL altındaki faturalara sahip müşterilerin isimleri listelendi : "));
        } catch (Exception ex) {
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }
    }
    //Haziran ayında faturalarının ortalaması 750 altında olan firmaların sektörleri
    @GetMapping("/findCustomerSectorByAmount")
    public ResponseEntity<RestResponse<List<String>>> findCustomerSectorByAmount(){
        try {
            List<String> invoiceList = invoiceControllerContract.findCustomerSectorByAmount();
            return ResponseEntity.ok(RestResponse.success(invoiceList,"Haziran ayında faturalarının ortalaması 750 altında olan firmaların sektörleri "));
        } catch (Exception ex) {
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }
    }

}