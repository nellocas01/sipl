package com.example.services;

import com.example.dao.entities.Store;
import com.example.dao.repositiories.StoreRepository;
import com.example.model.StoreResource;
import com.example.services.mappers.StoreMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StoreService {
    private final String STORE_NOT_FOUND = "Store not found";

    private final StoreRepository repository;

    StoreResource createStore(StoreResource resource){
        Store newStore = repository.save(StoreMapper.MAPPER.mapToStore(resource));
        return StoreMapper.MAPPER.mapToStoreResource(newStore);
    }

    StoreResource getStoreById(Integer id){
        Optional<Store> store = repository.findById(id);
        if (store.isPresent())
            return StoreMapper.MAPPER.mapToStoreResource(store.get());
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, STORE_NOT_FOUND);
    }

    void deleteStore(Integer id){
        repository.deleteById(id);
    }
}
