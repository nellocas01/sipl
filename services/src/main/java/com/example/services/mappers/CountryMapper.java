package com.example.services.mappers;

import com.example.dao.entities.City;
import com.example.dao.entities.Country;
import com.example.model.CityResource;
import com.example.model.CountryResource;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {
    CountryMapper MAPPER = Mappers.getMapper(CountryMapper.class);

    CountryResource mapToCountryResource(Country country);

    Country mapToCountry(CountryResource countryResource);

    Country update(CountryResource countryResource, @MappingTarget Country country);
}
