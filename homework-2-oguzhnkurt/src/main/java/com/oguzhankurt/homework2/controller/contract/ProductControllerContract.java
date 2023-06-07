package com.oguzhankurt.homework2.controller.contract;

import com.oguzhankurt.homework2.dto.product.ProductDTO;
import com.oguzhankurt.homework2.dto.product.ProductSaveRequest;
import com.oguzhankurt.homework2.dto.product.ProductUpdateRequest;

import java.util.List;

public interface ProductControllerContract {

    ProductDTO save(ProductSaveRequest request);

    List<ProductDTO> findAll();

    ProductDTO findById(Long id);

    void delete(Long id);

    ProductDTO update(long id, ProductUpdateRequest request);
}
