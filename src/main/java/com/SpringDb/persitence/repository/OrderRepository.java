package com.SpringDb.persitence.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.SpringDb.persitence.entity.OrderEntity;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer>{

}
