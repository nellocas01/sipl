package com.example.services.mappers;

import com.example.dao.entities.OrderStatus;
import com.example.dao.entities.Product;
import com.example.model.OrderStatusResource;
import com.example.model.ProductResource;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductResource mapToProductResource(Product product);

    Product mapToProduct(ProductResource productResource);

    Product update(ProductResource productResource, @MappingTarget Product product);
}
