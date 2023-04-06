package com.GOATstore.backend.entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "cidade")
@Data

public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    private String nome;
    @ManyToOne 
    // Muitas cidades para um Estado (n para 1)
    @JoinColumn(name= "idEstado")
    private Estado estado;
    @Temporal(TemporalType.TIME) // informar que vai armazenar data e hr no banco
    private Date dataCriação;
    @Temporal(TemporalType.TIME) // informar que vai armazenar data e hr no banco
    private Date dataAtualização;
    
}