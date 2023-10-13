package com.example.services;

import com.example.dao.entities.City;
import com.example.dao.repositiories.CityRepository;
import com.example.model.CityResource;
import com.example.services.mappers.CityMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityService {
    private final String CITY_NOT_FOUND = "City not found";

    private final CityRepository repository;

    CityResource createCity(CityResource resource){
        City newCity = repository.save(CityMapper.MAPPER.mapToCity(resource));
        return CityMapper.MAPPER.mapToCityResource(newCity);
    }

    CityResource getCityById(Integer id){
        Optional<City> city = repository.findById(id);
        if (city.isPresent())
            return CityMapper.MAPPER.mapToCityResource(city.get());
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, CITY_NOT_FOUND);
    }

    void deleteCity(Integer id){
        repository.deleteById(id);
    }
    /*
    * totalItems
    * currentPage
    * totalPages
    * cities
    *
    Map<String, Object> getAllCity(int pageNumber, int size, String sortDirection, String sortBy){

    }
*/

    Map<String, Object> getAllCity(int pageNumber, int pageSize, String sortDirection, String sortBy) {
        Sort.Order order = Sort.Order.by(sortBy);
        if ("desc".equalsIgnoreCase(sortDirection)) {
            order = Sort.Order.desc(sortBy);
        } else {
            order = Sort.Order.asc(sortBy);
        }

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(order));
        Page<City> cityPage = repository.findAll(pageRequest);

        List<CityResource> cityResource = cityPage.stream().map(CityMapper.MAPPER::mapToCityResource).collect(Collectors.toList());

            Map<String, Object> result = new HashMap<>();
            result.put("totalItems", cityPage.getTotalElements());
            result.put("currentPage", cityPage.getNumber());
            result.put("totalPages", cityPage.getTotalPages());
            result.put("cities", cityResource);

            return result;
        }
    }


