package com.SpringDb.service;

import java.util.List;

import com.SpringDb.persitence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringDb.persitence.entity.PizzaEntity;

@Service
public class PizzaService {

    //private final JdbcTemplate jdbcTemplate;

    private  final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository){
        this.pizzaRepository = pizzaRepository;
    }


    /*public List<PizzaEntity> getAll(){
        return this.jdbcTemplate.query("SELECT* FROM pizza", new BeanPropertyRowMapper(PizzaEntity.class));
    }*/

     public List<PizzaEntity> getAll(){
        return this.pizzaRepository.findAll();
    }

    public PizzaEntity get(int id){
         return this.pizzaRepository.findById(id).orElse(null);
    }


}
