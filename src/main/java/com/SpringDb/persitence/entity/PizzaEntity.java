package com.SpringDb.persitence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="pitzza" )
@Getter
@Setter
@NoArgsConstructor
public class PizzaEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "idPizza", nullable = false)
    private Integer idPizza;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @Column(nullable = false, length = 150)
    private String description; 

    @Column(nullable = false, columnDefinition = "Decimal(5,2)")
    private Double price;    

    @Column(columnDefinition = "BOOLEAN")
    private Boolean vegetarian;



    @Column(columnDefinition = "BOOLEAN")
    private Boolean vegan;


    @Column(columnDefinition = "BOOLEAN", nullable = false)
    private Boolean avalable;


}
