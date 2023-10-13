package com.example.services.mappers;

import com.example.dao.entities.City;
import com.example.dao.entities.OrderStatus;
import com.example.model.CityResource;
import com.example.model.OrderStatusResource;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderStatusMapper {
    OrderStatusMapper MAPPER = Mappers.getMapper(OrderStatusMapper.class);

    OrderStatusResource mapToOrderStatusResource(OrderStatus orderStatus);

    OrderStatus mapToOrderStatus(OrderStatusResource orderStatusResource);

    OrderStatus update(OrderStatusResource orderStatusResource, @MappingTarget OrderStatus OrderStatus);
}
