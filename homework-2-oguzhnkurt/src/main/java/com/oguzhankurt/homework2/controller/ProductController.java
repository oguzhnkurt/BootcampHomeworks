package com.oguzhankurt.homework2.controller;


import com.oguzhankurt.homework2.controller.contract.ProductControllerContract;
import com.oguzhankurt.homework2.dto.product.ProductDTO;
import com.oguzhankurt.homework2.dto.product.ProductSaveRequest;
import com.oguzhankurt.homework2.dto.product.ProductUpdateRequest;
import com.oguzhankurt.homework2.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductControllerContract productControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<ProductDTO>> save(@RequestBody ProductSaveRequest request){
        ProductDTO productDTO = productControllerContract.save(request);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<ProductDTO>>> findAll(){
        List<ProductDTO> productDTOList = productControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(productDTOList));
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<Object>> delete(@RequestBody Long id){
        productControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> findById(@PathVariable Long id){
        ProductDTO product = productControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> update(@PathVariable Long id, @RequestBody ProductUpdateRequest request){
        ProductDTO product = productControllerContract.update(id, request);
        return ResponseEntity.ok(RestResponse.of(product));
    }
}
