package com.oguzhankurt.homework2.service.entityservice;

import com.oguzhankurt.homework2.repository.ProductRepository;
import com.oguzhankurt.homework2.dto.product.ProductUpdateRequest;
import com.oguzhankurt.homework2.entity.Product;
import com.oguzhankurt.homework2.general.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class ProductEntityService extends BaseEntityService<Product, ProductRepository> {
    private final ProductRepository repository;
    public ProductEntityService(ProductRepository repository, ProductRepository repository1){
        super(repository);
        this.repository = repository1;
    }

    public Product update(Long id, ProductUpdateRequest request){
        Product product = repository.findById(id).orElseThrow();
        product.setPrice(request.price());
        repository.save(product);
        return product;
    }

}
