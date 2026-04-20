package com.SpringDb.service;

import java.util.List;

import com.SpringDb.persitence.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import com.SpringDb.persitence.entity.PizzaEntity;

@Service
public class PizzaService {

    //private final JdbcTemplate jdbcTemplate;

    private  final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository){
        this.pizzaRepository = pizzaRepository;
    }


    /*public List<PizzaEntity> getAll(){
        return this.jdbcTemplate.query("SELECT* FROM pizza", new BeanPropertyRowMapper(PizzaEntity.class));
    }*/

     public List<PizzaEntity> getAll(){
        return this.pizzaRepository.findAll();
    }

    public List<PizzaEntity> getAvailable(){
        return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }

    public List<PizzaEntity> getWhit(String ingrediente){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingrediente);
    }

        public List<PizzaEntity> getWhitout(String ingrediente){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingrediente);
    }




    public PizzaEntity get(int id){
         return this.pizzaRepository.findById(id).orElse(null);
    }

    public PizzaEntity save(PizzaEntity pizza){
         return  this.pizzaRepository.save(pizza);
    }

    public boolean exists(int idPizza){
         return  this.pizzaRepository.existsById(idPizza);
    }

    public void delete(int idPizza)
    {
        this.pizzaRepository.deleteById(idPizza);
    }

    public PizzaEntity getByName(String name){
        return this.pizzaRepository.findAllByAvailableTrueAndNameIgnoreCase(name);
    }



}
