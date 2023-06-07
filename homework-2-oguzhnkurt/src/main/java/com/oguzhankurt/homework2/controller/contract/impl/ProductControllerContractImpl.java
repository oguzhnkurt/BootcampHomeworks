package com.oguzhankurt.homework2.controller.contract.impl;

import com.oguzhankurt.homework2.controller.contract.ProductControllerContract;
import com.oguzhankurt.homework2.dto.product.ProductDTO;
import com.oguzhankurt.homework2.dto.product.ProductSaveRequest;
import com.oguzhankurt.homework2.dto.product.ProductUpdateRequest;
import com.oguzhankurt.homework2.entity.Product;
import com.oguzhankurt.homework2.mapper.ProductMapper;
import com.oguzhankurt.homework2.service.entityservice.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductControllerContractImpl implements ProductControllerContract {

    private final ProductEntityService service;

    @Override
    public ProductDTO save(ProductSaveRequest request) {
        Product product = ProductMapper.INSTANCE.convertToProduct(request);
        product=service.save(product);
        return ProductMapper.INSTANCE.convertToProductDTO(product);

    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> productList = service.findAll();
        return ProductMapper.INSTANCE.convertToProductDTOList(productList);
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = service.findByIdWithControl(id);
        return ProductMapper.INSTANCE.convertToProductDTO(product);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }

    @Override
    public ProductDTO update(long id, ProductUpdateRequest request) {
        Product product = service.update(id, request);
        return ProductMapper.INSTANCE.convertToProductDTO(product);
    }
}
