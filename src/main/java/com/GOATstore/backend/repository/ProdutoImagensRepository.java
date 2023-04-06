package com.GOATstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GOATstore.backend.entity.ProdutoImagens;

public interface ProdutoImagensRepository extends JpaRepository<ProdutoImagens, Long>{
    
}
