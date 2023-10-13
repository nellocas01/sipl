package com.example.services;

import com.example.dao.entities.OrderStatus;
import com.example.dao.repositiories.OrderStatusRepository;
import com.example.model.OrderStatusResource;
import com.example.services.mappers.OrderStatusMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderStatusService {

    private final String ORDER_STATUS_NOT_FOUND = "OrderStatus not found";

    private  final OrderStatusRepository repository;

    OrderStatusResource createOrderStatus(OrderStatusResource resource){
        OrderStatus newOrderStatus = repository.save(OrderStatusMapper.MAPPER.mapToOrderStatus(resource));
        return OrderStatusMapper.MAPPER.mapToOrderStatusResource(newOrderStatus);
    }

    OrderStatusResource getOrderStatusById(String id){
        Optional<OrderStatus> orderStatus = repository.findById(id);
        if(orderStatus.isPresent())
            return OrderStatusMapper.MAPPER.mapToOrderStatusResource(orderStatus.get());
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, ORDER_STATUS_NOT_FOUND);
    }

    void deleteOrderStatus(String id){
        repository.deleteById(id);
    }
}
