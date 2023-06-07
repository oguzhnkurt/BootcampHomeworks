package com.oguzhankurt.homework2.controller;

import com.oguzhankurt.homework2.controller.contract.CustomerControllerContract;
import com.oguzhankurt.homework2.dto.customer.CustomerDTO;
import com.oguzhankurt.homework2.dto.customer.CustomerDeleteRequest;
import com.oguzhankurt.homework2.dto.customer.CustomerSaveRequest;
import com.oguzhankurt.homework2.dto.customer.CustomerUpdateRequest;
import com.oguzhankurt.homework2.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerControllerContract customerControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<CustomerDTO>> save(@RequestBody CustomerSaveRequest request){
        CustomerDTO customerDTO = customerControllerContract.save(request);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<CustomerDTO>>> findAll(){
        List<CustomerDTO> customerDTOList = customerControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(customerDTOList));
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<Object>> delete(@RequestBody CustomerDeleteRequest request){
        customerControllerContract.delete(request);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> findById(@PathVariable Long id){
        CustomerDTO customer = customerControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(customer));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<RestResponse<CustomerDTO>> findByUsername(@PathVariable String username){
        CustomerDTO customer = customerControllerContract.findByUsername(username);
        return ResponseEntity.ok(RestResponse.of(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> update(@PathVariable Long id, @RequestBody CustomerUpdateRequest request){
        CustomerDTO customer = customerControllerContract.update(id, request);
        return ResponseEntity.ok(RestResponse.of(customer));
    }
}
