package com.example.services.mappers;

import com.example.dao.entities.OrderStatus;
import com.example.dao.entities.Sale;
import com.example.model.OrderStatusResource;
import com.example.model.SaleResource;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SaleMapper {
SaleMapper MAPPER = Mappers.getMapper(SaleMapper.class);

SaleResource mapToSaleResource(Sale sale);

Sale mapToSale(SaleResource saleResource);

    Sale update(SaleResource saleResource, @MappingTarget Sale sale);
}
