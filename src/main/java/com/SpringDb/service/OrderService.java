package com.SpringDb.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringDb.persitence.entity.OrderEntity;
import com.SpringDb.persitence.repository.OrderRepository;

@Service
public class OrderService {

    
    private final OrderRepository orderRepository;

    public OrderService (OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getAll(){

        return this.orderRepository.findAll();
    }
}
