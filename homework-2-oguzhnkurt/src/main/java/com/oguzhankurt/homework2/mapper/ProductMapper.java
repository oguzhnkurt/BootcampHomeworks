package com.oguzhankurt.homework2.mapper;

import com.oguzhankurt.homework2.dto.product.ProductDTO;
import com.oguzhankurt.homework2.dto.product.ProductSaveRequest;
import com.oguzhankurt.homework2.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product convertToProduct(ProductSaveRequest productSaveRequest);

    ProductDTO convertToProductDTO(Product product);

    List<ProductDTO> convertToProductDTOList(List<Product> productList);

}
