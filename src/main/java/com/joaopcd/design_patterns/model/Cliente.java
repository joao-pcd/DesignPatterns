package com.joaopcd.design_patterns.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    @ManyToOne
    private Endereco endereco;
}
