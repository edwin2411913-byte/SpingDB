package com.SpringDb.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringDb.persitence.entity.PizzaEntity;
import com.SpringDb.service.PizzaService;
import org.springframework.web.bind.annotation.GetMapping;


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
}
