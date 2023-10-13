package com.example.services.mappers;

import com.example.dao.entities.OrderStatus;
import com.example.dao.entities.Store;
import com.example.model.OrderStatusResource;
import com.example.model.StoreResource;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoreMapper {
    StoreMapper MAPPER = Mappers.getMapper(StoreMapper.class);

    StoreResource mapToStoreResource(Store store);

    Store mapToStore(StoreResource storeResource);

    Store update(StoreResource storeResource, @MappingTarget Store store);
}
