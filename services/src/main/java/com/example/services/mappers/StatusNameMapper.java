package com.example.services.mappers;

import com.example.dao.entities.OrderStatus;
import com.example.dao.entities.StatusName;
import com.example.model.OrderStatusResource;
import com.example.model.StatusNameResource;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StatusNameMapper {
    StatusNameMapper MAPPER = Mappers.getMapper(StatusNameMapper.class);

    StatusNameResource mapToStatusNameResource(StatusName statusName);

    StatusName mapToStatusName(StatusNameResource statusNameResource);

    StatusName update(StatusNameResource statusNameResource, @MappingTarget StatusName statusName);
}
