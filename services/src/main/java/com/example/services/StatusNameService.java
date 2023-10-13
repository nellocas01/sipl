package com.example.services;

import com.example.dao.entities.StatusName;
import com.example.dao.repositiories.StatusNameRepository;
import com.example.model.StatusNameResource;
import com.example.services.mappers.StatusNameMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StatusNameService {
    private final String STATUS_NAME_NOT_FOUND = "StatusName not found";

    private final StatusNameRepository repository;

    StatusNameResource createStatusName(StatusNameResource resource){
        StatusName newStatusName = repository.save(StatusNameMapper.MAPPER.mapToStatusName(resource));
        return StatusNameMapper.MAPPER.mapToStatusNameResource(newStatusName);
    }

    StatusNameResource getStatusNameById(Integer id){
        Optional<StatusName> statusName = repository.findById(id);
        if (statusName.isPresent())
            return StatusNameMapper.MAPPER.mapToStatusNameResource(statusName.get());
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, STATUS_NAME_NOT_FOUND);

    }

    void deleteStatusName(Integer id){
        repository.deleteById(id);
    }

}
