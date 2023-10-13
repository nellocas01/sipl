package com.example.services;

import com.example.dao.entities.Sale;
import com.example.dao.repositiories.SaleRepository;
import com.example.model.SaleResource;
import com.example.services.mappers.SaleMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SaleService {
    private final String SALE_NOT_FOUND = "Sale not found";

    private final SaleRepository repository;

    SaleResource createSale(SaleResource resource){
        Sale newSale = repository.save(SaleMapper.MAPPER.mapToSale(resource));
        return SaleMapper.MAPPER.mapToSaleResource(newSale);
    }

    SaleResource getSaleById(String id){
        Optional<Sale> sale = repository.findById(id);
        if (sale.isPresent())
            return SaleMapper.MAPPER.mapToSaleResource(sale.get());
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, SALE_NOT_FOUND);
    }

    void deleteSale(String id){
        repository.deleteById(id);
    }

}
