package com.example.services;

import com.example.dao.entities.City;
import com.example.dao.entities.Country;
import com.example.dao.repositiories.CityRepository;
import com.example.dao.repositiories.CountryRepository;
import com.example.model.CityResource;
import com.example.model.CountryResource;
import com.example.services.mappers.CityMapper;
import com.example.services.mappers.CountryMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryService {

    private final String COUNTRY_NOT_FOUND = "Country not found";

    private final CountryRepository repository;

    CountryResource createCountry(CountryResource resource){
        Country newCountry = repository.save(CountryMapper.MAPPER.mapToCountry(resource));
        return CountryMapper.MAPPER.mapToCountryResource(newCountry);
    }

    CountryResource getCountryById(Integer id){
        Optional<Country> country = repository.findById(id);
        if (country.isPresent())
            return CountryMapper.MAPPER.mapToCountryResource(country.get());
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, COUNTRY_NOT_FOUND);
    }

    void deleteCity(Integer id){
        repository.deleteById(id);
    }

    /*
    Map<String, Object> getAllCountry(int PageNumber, int pageSize, String sortDirection, String sortBy){
        Sort.Order order = Sort.Ord
    }
     */

}
