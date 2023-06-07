package com.example.OguzhanKurt.PatikaHomework2.controller;

import com.example.OguzhanKurt.PatikaHomework2.controller.contract.CustomerControllerContract;
import com.example.OguzhanKurt.PatikaHomework2.dto.customer.CustomerDTO;
import com.example.OguzhanKurt.PatikaHomework2.dto.customer.CustomerSaveRequestDTO;
import com.example.OguzhanKurt.PatikaHomework2.general.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerControllerContract customerControllerContract;

    @Autowired
    public CustomerController(CustomerControllerContract customerControllerContract) {
        this.customerControllerContract = customerControllerContract;
    }

    @PostMapping
    public ResponseEntity<RestResponse<Object>> add(@RequestBody CustomerSaveRequestDTO customerSaveRequest) {
        try {
            customerControllerContract.add(customerSaveRequest);
            return ResponseEntity.ok(RestResponse.emptySuccess("Kullanıcı başarıyla eklendi."));
        } catch (Exception ex) {
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }

    }


    @GetMapping
    public ResponseEntity<RestResponse<List<CustomerDTO>>> findAll() {
        var customerDTOList = customerControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(customerDTOList));
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<Object>> delete(@RequestBody CustomerDTO customerDTO) {
        try {
            customerControllerContract.delete(customerDTO);
            return ResponseEntity.ok(RestResponse.emptySuccess("Kullanıcı silindi"));
        } catch (Exception ex) {
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }

    }
    @GetMapping("/findAllCustomersByNameStartswithC")
    public ResponseEntity<RestResponse<List<CustomerDTO>>> findAllCustomersByNameStartswithC(){
        try {
            List<CustomerDTO> customerDTOS = customerControllerContract.findAllCustomersByNameStartswithC();
            return ResponseEntity.ok(RestResponse.success(customerDTOS,"C harfi ile ismi başalayan müşteriler listelenmiştir."));
        } catch (Exception ex) {
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }
    }

}