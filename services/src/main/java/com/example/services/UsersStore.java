package com.example.services;

import com.example.dao.entities.Users;
import com.example.dao.repositiories.UsersRepository;
import com.example.model.UsersResource;
import com.example.services.mappers.UsersMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersStore {
    private final String USERS_NOT_FOUND = "Users not found";

    private final UsersRepository repository;

    UsersResource createUsers(UsersResource resource){
        Users newUsers = repository.save(UsersMapper.MAPPER.mapToUsers(resource));
        return UsersMapper.MAPPER.mapToUsersResource(newUsers);
    }

    UsersResource getUsersById(Integer id){
        Optional<Users> users = repository.findById(id);
        if (users.isPresent())
            return UsersMapper.MAPPER.mapToUsersResource(users.get());
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, USERS_NOT_FOUND);
    }

    void deleteUsers(Integer id){
        repository.deleteById(id);
    }
}
