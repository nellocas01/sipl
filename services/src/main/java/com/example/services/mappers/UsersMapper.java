package com.example.services.mappers;

import com.example.dao.entities.OrderStatus;
import com.example.dao.entities.Users;
import com.example.model.OrderStatusResource;
import com.example.model.UsersResource;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsersMapper {
    UsersMapper MAPPER = Mappers.getMapper(UsersMapper.class);

    UsersResource mapToUsersResource(Users users);

    Users mapToUsers(UsersResource usersResource);

    Users update(UsersResource usersResource, @MappingTarget Users users);
}
