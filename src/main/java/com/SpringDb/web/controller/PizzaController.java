package com.SpringDb.web.controller;

import java.util.List;

import jdk.javadoc.doclet.Reporter;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.SpringDb.persitence.entity.PizzaEntity;
import com.SpringDb.service.PizzaService;


@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    @Autowired
    public PizzaController (PizzaService pizzaService){
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaEntity>> getAll() {
        return ResponseEntity.ok(this.pizzaService.getAll());
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> getPizza(@PathVariable int idPizza) {
        return ResponseEntity.ok(this.pizzaService.get(idPizza));
    }

    @PostMapping
    public ResponseEntity<PizzaEntity>add (@RequestBody PizzaEntity pizza){

        if(pizza.getIdPizza() == null || !this.pizzaService.exists(pizza.getIdPizza())){
        return ResponseEntity.ok(this.pizzaService.save(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<PizzaEntity>update (@RequestBody PizzaEntity pizza){

        if(pizza.getIdPizza() != null && this.pizzaService.exists(pizza.getIdPizza())){
        return ResponseEntity.ok(this.pizzaService.save(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

}
