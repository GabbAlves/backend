package com.GOATstore.backend.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "categoria")
@Data
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //gerar chave automaticamente
    private Long id;    

    private String nome;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriação;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

}
