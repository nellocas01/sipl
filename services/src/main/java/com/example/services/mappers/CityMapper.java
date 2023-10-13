package com.example.services.mappers;

import com.example.dao.entities.City;
import com.example.model.CityResource;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {
    CityMapper MAPPER = Mappers.getMapper(CityMapper.class);

    CityResource mapToCityResource(City city);
    City mapToCity(CityResource cityResource);

    City update(CityResource cityResource, @MappingTarget City city);
}
