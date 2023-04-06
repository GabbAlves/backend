package com.GOATstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GOATstore.backend.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    //JPA vai nos fornecer todos os metodos basicos, excluir, alterar, mostrar todos...


}
